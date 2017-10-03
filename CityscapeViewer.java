import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class CityscapeViewer 
{
    // the cityscape will be animated for 60 seconds
    static final int ANIMATION_TIME_IN_SECONDS = 60;
    private static int seconds;
   
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        // create and configure the frame (window) for the program
        JFrame frame = new JFrame();
    
        frame.setSize(800 /* x */, 600 /* y */);
        frame.setTitle("Cityscape");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  
        
        // a frame contains a single component; create the Cityscape component and add it to the frame
        CityscapeComponent component = new CityscapeComponent();
        frame.add(component);
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);

        
        int r = 30; //->253
        int g = 144; //->94
        int b = 255; //->83
        // animate the cityscape
        for(seconds = 0; seconds < ANIMATION_TIME_IN_SECONDS; seconds++ )
        {
            if(seconds < 28)
            {
                r+=8;
                g-=2;
                b-=6;
            }
            else if((seconds >= 28 && seconds < 36) && (r > 32 && b > 11 && g > 7))
            {
                r-= 32;
                g-=11;
                b-=7;
            }
            else
            {
                r = 0;
                g = 0;
                b = 0;
            }
            frame.getContentPane().setBackground(new Color(r, g, b));
            component.nextFrame();
            Thread.sleep( 1000 );
        }
        
    }
    public int getSeconds()
    {
        return seconds;
    }
 

}
