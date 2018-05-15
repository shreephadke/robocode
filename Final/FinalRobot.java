package Final;

import robocode.*;
import robocode.util.Utils;

import java.awt.geom.Point2D;
import java.util.*;

import Final.AdvancedEnemyBot;


public class FinalRobot extends Movement
{

    private AdvancedEnemyBot enemy = new AdvancedEnemyBot();

    
    public void run() {
        this.setAdjustRadarForGunTurn( true );
        super.run();
    }

    public void onScannedRobot( ScannedRobotEvent e )
    {

        super.onScannedRobot( e ); // references Movement - everything in
                                   // Movement's onScannedRobot happens

        if ( e.getName().equals( this.move ) )
        {
            // get our coordinates
            double myX = this.getX();
            double myY = this.getY();

            double bulletPower = 3;

            double absBearing = e.getBearingRadians()
                + this.getHeadingRadians();

            // how far away enemy is
            double enemyX = myX + e.getDistance() * Math.sin( absBearing );
            double enemyY = myY + e.getDistance() * Math.cos( absBearing );

            // where it will be in the future, how fast
            double enemyHeading = e.getHeadingRadians();
            double enemyVelo = e.getVelocity();

            double timePassed = 0;

            // predicted coordinates
            double predX = enemyX;
            double predY = enemyY;

            while ( ( ( timePassed++ )
                * ( 20 - 3.0 * bulletPower ) ) < ( Point2D.Double
                    .distance( myX, myY, predX, predY ) ) )
            {

                predX += Math.sin( enemyHeading ) * enemyVelo;
                predY += Math.cos( enemyHeading ) * enemyVelo;

                // exit the loop if predicted (x,y) are too small or too big.
                // break;
            }

            double theta = Utils
                .normalAbsoluteAngle( Math.atan2( predX - myX, predY - myY ) );
            this.setTurnGunRightRadians( Utils
                .normalRelativeAngle( theta - this.getGunHeadingRadians() ) );
            this.setFire( bulletPower );

        }

    }

}
