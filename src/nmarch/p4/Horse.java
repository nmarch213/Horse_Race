package nmarch.p4;

import java.awt.*;
import java.util.Random;

/**
 *
 * @author Nick
 */
public class Horse implements Runnable 
{
    Image theImage;
    int xpos, ypos;
    HorseComponent hc;
    Random r = new Random();
    String name;
    
    public Horse(HorseComponent h)
    {
        hc = h;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        theImage = toolkit.getImage("C:\\Users\\Nick\\Documents\\NetBeansProjects\\nmarch-p4\\src\\nmarch\\p4\\horse.jpg");
    }
    
    public void setY(int y,String name)
    {
        this.ypos = y;
        this.name = name;
    }
    
    public void setX(int x)
    {
        this.xpos = x;
    }

    
    public void run()
    {
        while(hc.finished != true)
        {
            //hc.runLock.lock();
            
            xpos+= r.nextInt(50);
            if(xpos > 950)
            {
                System.out.println(name + " Wins!");
                hc.finished = true;      
            }
            hc.repaint();
            try{
                Thread.sleep(75);
            }
            catch(Exception e)
            {
                System.out.println("Horse Exception");
            }
            finally
            {
                
            }
        }
        
        System.out.println("Race Complete");
    }
}
