package nmarch.p4;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 *
 * @author Nick
 */
public class HorseComponent extends JPanel 
{
    JButton runRace;
    JButton resetRace;
    JButton quitRace;
    HorseComponent h1,h2,h3,h4,h5,h6;
    boolean finished = false;
    
    Horse horse1 = new Horse(this);
    Horse horse2 = new Horse(this);
    Horse horse3 = new Horse(this);
    Horse horse4 = new Horse(this);
    Horse horse5 = new Horse(this);
    Horse horse6 = new Horse(this);
    
    
    JFrame enclosingFrame;
    
    public HorseComponent(JFrame f)
    {
        runRace = new JButton("Run Race");
        resetRace = new JButton("Reset Race");
        quitRace = new JButton("Quit Race");
        
        enclosingFrame = f;
        
        int x = 10;
        int y = 50;
        
        add(runRace);
        add(resetRace);
        add(quitRace);
        
        ActionListener listener = new StartRace();
        runRace.addActionListener(listener);
    }
    
    public class StartRace implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JButton b = (JButton)event.getSource();
            if(b == runRace)
            {
                System.out.println("Trumpet Sounds");
                System.out.println("Gun shot!");
                Thread t1 = new Thread(horse1);
                horse1.setY(0,"Pepsi");
                Thread t2 = new Thread(horse2);
                horse2.setY(130,"USA");
                Thread t3 = new Thread(horse3);
                horse3.setY(260,"Paris");
                Thread t4 = new Thread(horse4);
                horse4.setY(390,"Holly");
                Thread t5 = new Thread(horse5);
                horse5.setY(520,"Ronda");
                Thread t6 = new Thread(horse6);
                horse6.setY(650,"Bob");
                repaint();
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                t6.start();

            }
        }
    }
    
    public void paintComponent(Graphics g)
    {
        g.clearRect(0, 0,enclosingFrame.getWidth(),enclosingFrame.getHeight() );
        g.drawImage(horse1.theImage, horse1.xpos, horse1.ypos, this);
        g.drawImage(horse2.theImage, horse2.xpos, horse2.ypos, this);
        g.drawImage(horse3.theImage, horse3.xpos, horse3.ypos, this);
        g.drawImage(horse4.theImage, horse4.xpos, horse4.ypos, this);
        g.drawImage(horse5.theImage, horse5.xpos, horse5.ypos, this);
        g.drawImage(horse6.theImage, horse6.xpos, horse6.ypos, this);
    }
}
