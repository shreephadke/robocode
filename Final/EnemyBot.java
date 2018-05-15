package Final;

import robocode.*;


/**
 * Record the state of an enemy bot.
 * 
 * @author TODO Shree Phadke
 * @version 5/8/18
 * 
 * @author Period - 2
 * @author Assignment - EnemyBot
 * 
 * @author Sources - None
 */
public class EnemyBot
{
    private double bearing;

    private double distance;

    private double energy;

    private double heading;

    private double velocity;

    private String name;


    /**
     * resets the robot
     */
    public EnemyBot()
    {
        reset();
    }


    /**
     * 
     * this returns the bearing
     * 
     * @return bearing
     */
    public double getBearing()
    {

        return bearing;
    }


    /**
     * 
     * returns the distance
     * 
     * @return distance
     */
    public double getDistance()
    {

        return distance;
    }


    /**
     * 
     * returns energy
     * 
     * @return energy
     */
    public double getEnergy()
    {
        return energy;
    }


    /**
     * 
     * returns heading
     * 
     * @return heading
     */
    public double getHeading()
    {

        return heading;
    }


    /**
     * 
     * returns velocity
     * 
     * @return velocity
     */
    public double getVelocity()
    {

        return velocity;
    }


    /**
     * 
     * returns name
     * 
     * @return name
     */
    public String getName()
    {

        return name;
    }


    /**
     * @param srEvt
     *            ScannedRobotEvent
     * 
     * 
     * 
     */

    public void update( ScannedRobotEvent srEvt )
    {
        bearing = srEvt.getBearing();
        distance = srEvt.getDistance();
        energy = srEvt.getEnergy();
        heading = srEvt.getHeading();
        velocity = srEvt.getVelocity();
        name = srEvt.getName();

    }


    /**
     * 
     * resets all values
     * 
     */
    public void reset()
    {
        bearing = 0;
        distance = 0;
        energy = 0;
        heading = 0;
        velocity = 0;
        name = "";

    }


    /**
     * 
     * returns the length of 0
     * 
     * @return for none
     */

    public boolean none()
    {
        return name.length() == 0;
    }
}