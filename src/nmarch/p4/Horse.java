/**
  Student Name: Nicholas March
  File Name: HorseRace.java
  Assignment number: 4
  
  A Horse and it's properties
*/

package nmarch.p4;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * This creates an Horse that you can use in a threaded race
 * 
 * @author Nicholas March
 */
public class Horse implements Runnable 
{
    long startTime, endTime,elapsedTime;
    Image theImage;
    int xpos, ypos;
    HorseComponent hc;
    Random r = new Random();
    String name;
    private final Lock runLock;
    private static final int DELAY = 100;
    
    /**
     * Constructor for Horse
     * @param h
     */
    public Horse(HorseComponent h)
    {
        hc = h;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        theImage = toolkit.getImage("C:\\Users\\Nick\\Documents\\NetBeansProjects\\nmarch-p4\\src\\nmarch\\p4\\horse.jpg");
        runLock = new ReentrantLock();
    }
    
    /**
     * Sets the Y axis as well as the Horse's name
     * @param y
     * @param name
     */
    public void setY(int y,String name)
    {
        this.ypos = y;
        this.name = name;
    }
    
    /**
     *
     * @return the name of the Horse
     */
    private String getName()
    {
        return this.name;
    }
    
    /**
     * Used for resetting, sets horse to this x position
     * @param x
     */
    public void setX(int x)
    {
        this.xpos = x;
    }

    /*
        This causes the horses to "run"
        changes their x position in a random fashion
    */
    @Override
    public void run()
    {
        StopWatch timer = new StopWatch();
        while(hc.finished != true)
        {
            timer.start();
            runLock.lock(); 
        try
        {
            //Checks if a horse has won
            if(didIWin(xpos))
            {
                timer.stop();
                elapsedTime = timer.getElapsedTime();
                JOptionPane.showMessageDialog(hc,this.getName()+ " wins with a time of " + (double)this.elapsedTime/1000 + "!!!");
                break;
            }
            
            xpos+= r.nextInt(50);
        }
        catch(Exception e)
        {
            System.out.println("Horse Exception");
        }
        finally
        {
            runLock.unlock();
        }
            try 
            {
                pause(1);
            }
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Horse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * This is added to show a pause for better animation
     * @param steps
     * @throws InterruptedException
     */
    private void pause(int steps) throws InterruptedException
    {
        hc.repaint();
        Thread.sleep(steps * DELAY);
        
    }
    
    //Method testing if a horse has reached the end.
    private boolean didIWin(int totalDistance)
    {
        boolean won = false;
        
        if(totalDistance > 1000 )
        {
            won = true;
            hc.finished = true;
        }
        
        return won;
    }
}
