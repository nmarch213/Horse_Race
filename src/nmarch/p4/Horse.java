package nmarch.p4;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nick
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
    
    public Horse(HorseComponent h)
    {
        hc = h;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        theImage = toolkit.getImage("C:\\Users\\Nick\\Documents\\NetBeansProjects\\nmarch-p4\\src\\nmarch\\p4\\horse.jpg");
        runLock = new ReentrantLock();
    }
    
    public void setY(int y,String name)
    {
        this.ypos = y;
        this.name = name;
    }
    
    public double getElapsedTime()
    {
        return (double)elapsedTime/1000;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setX(int x)
    {
        this.xpos = x;
    }

    
    public void run()
    {
        StopWatch timer = new StopWatch();
        while(hc.finished != true)
        {
            timer.start();
            runLock.lock();
   
        try
        {
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
            try {
                pause(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Horse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //timer.stop();
       // elapsedTime = timer.getElapsedTime();
        //System.out.println(name + " finished with a time of: " + (double)elapsedTime/1000 + "s");
    }
    
    public void pause(int steps) throws InterruptedException
    {
        hc.repaint();
        Thread.sleep(steps * DELAY);
        
    }
    
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
