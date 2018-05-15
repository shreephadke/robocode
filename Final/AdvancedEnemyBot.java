package Final;

import robocode.*;


/**
 * Record the advanced state of an enemy bot.
 * 
 * @author TODO Shree Phadke
 * @version 5/11/18
 * 
 * @author Period - 7
 * @author Assignment - AdvancedEnemyBot
 * 
 * @author Sources - None
 */
public class AdvancedEnemyBot extends EnemyBot
{
    private double x;

    private double y;


    /**
     * resets the robot
     */
    public AdvancedEnemyBot()
    {
        reset();
    }


    /**
     * 
     * this returns the x value
     * 
     * @return x
     */
    public double getX()
    {
        return x;
    }


    /**
     * 
     * this returns the y value
     * 
     * @return y
     */

    public double getY()
    {
        return y;
    }


    /**
     * 
     * this calculates x and y values
     * 
     * @param e
     *            ScannedRobotEvent e
     * @param robot
     *            Robot robot
     */
    public void update( ScannedRobotEvent e, Robot robot )
    {
        super.update( e );
        double absBearingDeg = ( robot.getHeading() + e.getBearing() );
        if ( absBearingDeg < 0 )
        {
            absBearingDeg += 360;
        }

        x = robot.getX()
            + Math.sin( Math.toRadians( absBearingDeg ) ) * e.getDistance();
        y = robot.getY()
            + Math.cos( Math.toRadians( absBearingDeg ) ) * e.getDistance();

    }


    /**
     * 
     * this returns x
     * 
     * @param when
     *            long when
     * @return x
     */

    public double getFutureX( long when )
    {
        return x
            + Math.sin( Math.toRadians( getHeading() ) ) * getVelocity() * when;
    }


    /**
     * 
     * this returns y
     * 
     * @param when
     *            long when
     * @return y
     */
    public double getFutureY( long when )
    {
        return y
            + Math.cos( Math.toRadians( getHeading() ) ) * getVelocity() * when;
    }


    /**
     * 
     * this resets bot
     */
    public void reset()
    {
        super.reset();
        x = 0;
        y = 0;
    }

}