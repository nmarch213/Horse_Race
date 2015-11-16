package nmarch.p4;

import java.awt.*;
import java.awt.event.*;
import static java.lang.System.exit;
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
    boolean winner = false;
    
    Horse horse1 = new Horse(this);
    Horse horse2 = new Horse(this);
    Horse horse3 = new Horse(this);
    Horse horse4 = new Horse(this);
    Horse horse5 = new Horse(this);
    Horse horse6 = new Horse(this);   
    JFrame enclosingFrame;
    
    /**
     * This creates the Entire frame as well as the buttons insides
     * This also initializes the Horses used
     * @param f
     */
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
        repaint();
        ActionListener listener = new StartRace();
        runRace.addActionListener(listener);
        resetRace.addActionListener(listener);
        quitRace.addActionListener(listener);
        horse1.setY(000,"Horse1: Pepsi");
        horse2.setY(130,"Horse2: USA");
        horse3.setY(260,"Horse3: Paris");
        horse4.setY(390,"Horse4: Holly");
        horse5.setY(520,"Horse5: Ronda");
        horse6.setY(650,"Horse6: Bob");  
    }
    
    /**
     * This is where each of the threads of horses are began
     * each of the buttons displayed are also coded here showing what
     * each action of a button press will result in.
     * 
     */
    public class StartRace implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            JButton b = (JButton)event.getSource();
            //If the button "Run Race" is click. This executes
            if(b == runRace)
            { 
                runRace.setText("FASTER!!!!");
                finished = false;
                System.out.println("Trumpet Sounds");
                System.out.println("Gun shot!");
                Thread t1 = new Thread(horse1);
                Thread t2 = new Thread(horse2);
                Thread t3 = new Thread(horse3);
                Thread t4 = new Thread(horse4);
                Thread t5 = new Thread(horse5);               
                Thread t6 = new Thread(horse6);              
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                t6.start();
         
            }
            //If "Reset Race" is clicked. This executes
            if(b == resetRace)
            {
                runRace.setText("Run Race");
                System.out.println("Race Resetting!");
                horse1.setX(0);
                horse2.setX(0);
                horse3.setX(0);
                horse4.setX(0);
                horse5.setX(0);
                horse6.setX(0);
                finished = true;  

                repaint();
            }
            //Exits the entire program
            if(b == quitRace)
            {
                exit(1);
            }
        }
    }
    
    
    //This is where the horses are initially drawn
    @Override
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
