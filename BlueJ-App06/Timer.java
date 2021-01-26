
/**
 * This class handles in-game Timers
 * Timer - the current value of the timers
 * Update - what to change the update time with
 * low - when to return the timer when it is low
 * 
 * @author (Tyronne)
 * @version (26/01/2021)
 */

public class Timer
{
    private int timer;
    private int update;
    private int low;
    
    public Timer(int defaultTime, int defaultUpdate, int defaultLow)
    {
        timer = defaultTime;
        update = defaultUpdate;
        low = defaultLow;
    }
    
    /**
     * prints out timer
     */
     public String toString() 
     {
        return Integer.toString(timer);
    }
    
    /**
     * updates timer data
     */
     public void updateTimer() 
    {
        timer += update;
    }
    
    /**
     * alter timer data
     */
    public void setTime(int time) 
    {
        timer = time;
    }
    
    public void setUpdate(int update) 
    {
        this.update = update;
    }
    
    public void setLow(int low) 
    {
        this.low = low;
    }
    
    /**
     * check if the timer is low
     */
    public boolean isLow() {
        if (timer <= low) {
            return true;
        }
        return false;
    }
    
    /**
     * check if the timer reached zero
     */
    public boolean hasExpired() {
        if (timer <= 0) {
            return true;
        }
        return false;
    }
}
