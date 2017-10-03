import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class CityscapeComponent extends JComponent
{
    // define the objects in your Cityscape as instance variables
    // ...
    List<Building> buildings = new ArrayList<Building>();
    List<Cloud> clouds = new ArrayList<Cloud>();
    int numClouds = 25;
    boolean cloudsMade = false;

    int numBuildings = 100;
    boolean buildingsMade = false;

    Building building = new Building();
   
  
    //Sun sun = new Sun();
    Cloud cloud = new Cloud();
    Random rand = new Random();
    
    // define the CityscapeComponent contructor and intiailize all instance variables
    // ...
    
    public void makeBuildings()
    {
        for(int i = 0; i < numBuildings; i++)
        {
           buildings.add(new Building()); 
        }  
    }
    public void makeClouds()
    {
        for(int i = 0; i < numClouds; i++)
        {
            clouds.add(new Cloud());
        }
    }

    
    
    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     */
    public void paintComponent(Graphics g)
    {
       Graphics2D g2 = (Graphics2D) g;
       //sun.paintComponent(g);
       if(!cloudsMade)
       {
           makeClouds();
           cloudsMade = true;
       }
       for(int i = 0; i < clouds.size(); i++)
       {
           clouds.get(i).paintComponent(g);
       }
       if(!buildingsMade)
       {
          makeBuildings();
          buildingsMade = true;
       }
       for(int i = 0; i < buildings.size(); i++)
       {
           buildings.get(i).paintComponent(g);
       }
    }
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when they are next drawn.
     *
     */
    public void nextFrame()
    {
        //sun.updateXY();
        for(int i = 0; i < clouds.size(); i++)
        {
            clouds.get(i).updateXY();
        }
        repaint();
    }

}
