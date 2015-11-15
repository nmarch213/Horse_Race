/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nmarch.p4;

import javax.swing.JFrame;

/**
 *
 * @author Nick
 */
public class HorseRace {
    final int FRAME_WIDTH = 1200, FRAME_HEIGHT = 800;

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
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HorseRace();
    }
    
}
