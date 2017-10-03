import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;
import java.awt.Point; 
import java.awt.Polygon; 

/**
 * Write a description of class Clouds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cloud extends JPanel
{
    // instance variables - replace the example below with your own
    private int xPos;
    private int yPos;
    private int seconds;
    private int grayScale = 255;
    private Color cloudColor = new Color(grayScale, grayScale, grayScale);
    private Random rand = new Random();
    int[] cloudComponent;
    private int cloudSpeed;

    /**
     * Constructor for objects of class Clouds
     */
    public Cloud() 
    {
        cloudSpeed = rand.nextInt(50);
        xPos = rand.nextInt(800);
        cloudComponent = new int[8];
        for(int i = 0; i < 8; i++)
        {
            if(i % 2 == 1)
            {
                cloudComponent[i] = 2*(rand.nextInt(10) + 10);
            }
            else
            {
                cloudComponent[i] = 2*(rand.nextInt(30) + 10);
            }
        }
        yPos = rand.nextInt(400);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void paintComponent(Graphics g)
    { 

        if(seconds < 36 && grayScale > 0)
        {
            grayScale -= 3;
        }
        cloudColor = new Color(grayScale, grayScale, grayScale);   
        g.setColor(cloudColor);
        g.fillOval(xPos, yPos, cloudComponent[0], cloudComponent[1]);
        g.fillOval(xPos-5, yPos-5, cloudComponent[2], cloudComponent[3]);
        g.fillOval(xPos+5, yPos-5, cloudComponent[4], cloudComponent[5]);
        g.fillOval(xPos+5, yPos+5, cloudComponent[6], cloudComponent[7]);
 
            
    }
    public void updateXY()
    {
        xPos += cloudSpeed + 1;
        if(xPos > 800)
        {
            xPos = 0;
        }
    }
}
