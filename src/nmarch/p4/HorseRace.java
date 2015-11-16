/**
  Student Name: Nicholas March
  File Name: HorseRace.java
  Assignment number: 4
  
  Contains Main method of HorseRace
*/
package nmarch.p4;

import javax.swing.JFrame;

/**
 *
 * @author Nick
 */
public class HorseRace {
    final int FRAME_WIDTH = 1200, FRAME_HEIGHT = 800;

    /**
     * Constructor of a Horse Race, and the window.
     */
    public HorseRace()
    {
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Horse Race");
	frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HorseComponent component = new HorseComponent(frame);
        frame.add(component);
        frame.setVisible(true);
        frame.repaint();
    }
    /**
     * main function to run a horse race
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HorseRace();
    }
    
}
