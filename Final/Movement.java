package Final;

import robocode.*;
import java.util.*;


public class Movement extends AdvancedRobot
{

    // instance variables

    public String move = "NULL";

    public int timeSinceScan = 10;

    public boolean x = true;

    public boolean y = false;


    public void run()
    {
        while ( x )
        {
            if ( timeSinceScan > 5 )
            {
                this.setTurnRadarRight( 5 );
            }
            this.setAhead( 4 );
            this.execute();
            timeSinceScan++;
        }
    }


    public void onScannedRobot( ScannedRobotEvent e )
    {

        if ( this.move.equals( "NULL" ) ) // this is the first robot scanned
        {

            this.move = e.getName();

        }

        if ( this.move.equals( e.getName() ) ) // keep the robot locked on to
                                               // enemy
        {

            timeSinceScan = 0;
            // turn radar to point at robot
            double currentRadarAngle = this.getRadarHeading();
            double enemyBearing = e.getBearing();
            double myHeading = this.getHeading();

            this.setTurnRadarRight(
                myHeading + enemyBearing - currentRadarAngle );

            // turn our bot's direction toward enemy
            this.setTurnRight( enemyBearing );
        }

    }

}
