import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;
import java.awt.Point; 
import java.awt.Polygon; 

/**
 * Write a description of class Building here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Building extends JPanel
{
    // instance variables
    private Random rand = new Random();
    
    private boolean windows;
    private int windowStyle;
    private int windowHelper;
    private Color windowColor;
    
    private int xPos;
    private int yPos;
    private int height;
    private int width;
 
    private Polygon poly;
    private boolean point = rand.nextBoolean();
    private int pointHeight;
    private int[] xPosPoint = new int[3];
    private int[] yPosPoint = new int[3];
    
    int middle = 400;
    int distanceFromMiddleAdj;
    
    
    //variables to give each building a slightly different shade
    private Color buildingColor;
    float r = rand.nextFloat() / 2f;
    float g = rand.nextFloat() / 2f;
    float b = rand.nextFloat();


    /**
     * Constructors for objects of class Building
     */
    public Building()
    { 
        width = rand.nextInt(50) + 30;
        xPos = rand.nextInt(800);
        distanceFromMiddleAdj = Math.abs(xPos - 400);  
        height = (rand.nextInt(400) + 150) - distanceFromMiddleAdj;
        yPos = 600 - (int)(height/2);
      
        xPosPoint[0] = xPos+width;
        yPosPoint[0] = yPos;
        xPosPoint[1] = xPos + width/2;
        yPosPoint[1] = yPos - rand.nextInt(40);
        xPosPoint[2] = xPos;
        yPosPoint[2] = yPos;
        
        poly = new Polygon(xPosPoint, yPosPoint, 3);
        
        windows = rand.nextBoolean();
        
        
        windowHelper = rand.nextInt(36);
        if(windowHelper <= 18){
            windowStyle = 1;
        }
        else if(windowHelper > 18 && windowHelper <= 27){
            windowStyle = 2;
        }
        else if(windowHelper > 27 && windowHelper < 36){
            windowStyle = 3;
        }
            

        buildingColor = new Color(r, g, b);
        r = rand.nextFloat() / 3f;
        g = rand.nextFloat();
        b = rand.nextFloat() / 2f;
        windowColor = new Color(r, g, b);
        
    }

    public void paintComponent(Graphics g) 
    {
       super.paintComponent(g);
       g.setColor(buildingColor);
       g.fillRect(xPos, yPos, width, height);
       
       if(point && height > 250)
       {
           g.fillPolygon(poly); 
       }
       
       g.setColor(windowColor);
       switch(windowStyle)
       {
           //grid-style windows
           case 1: gridWindows(g);
           break;
           //vertical rectangles
           case 2: vertWindows(g);
           break;
           //horizontal rectangles
           case 3: horizWindows(g);
           break;

       }
     }
    public void gridWindows(Graphics g)
    {
        for(int i = xPos + width - 9; i > xPos + width/2 - 12; i-=12)
        {
            for(int j = yPos + 6; j < yPos + height; j+=10)
            {
                g.fillRect(i,j,6,6);
            }
        }
    }
    public void vertWindows(Graphics g)
    {  
        for(int j = yPos + 6; j < yPos + height; j+=10)
        {
            g.fillRect(xPos + 6,j,width - 12,3);
        }
    }
    public void horizWindows(Graphics g)
    {
        for(int i = xPos + width/2 - 4; i < xPos + width - 4; i+=12)
        {
            g.fillRect(i,yPos + 4,6,height - 20);
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
