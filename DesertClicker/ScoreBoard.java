import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    MyWorld world = (MyWorld) getWorld();
    public GreenfootImage score;
    public GreenfootImage background = getImage();
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /**
     * scoreboard constructer. this clears the image (so its a transparent background) and adds a text in its place that says 
     *"TumbleWeed: " followed by the amount of your tumbleweeds.
     */
    public ScoreBoard()
    {
        background.clear();
        GreenfootImage score = new GreenfootImage(130, 50);
        score.setFont(new Font("Arial", 12));

        int lineHeight = 20;
        score.drawString("TumbleWeed:", 0, lineHeight);
        score.drawString(TumbleWeed.tumbleWeedAmount + "", 0, lineHeight * 2);

        setImage(score);

    }
    /**
     * this method is used to update the image whenever the tumbleweed is clicked. it sets the font to arial with a size
     * of 12, and makes the height between the 2 lines 20. it then sets the image to the text we have set up.
     */
    public void updateImage()
    {
        GreenfootImage score = new GreenfootImage(130, 50);
        score.setFont(new Font("Arial", 12));

        int lineHeight = 20;
        score.drawString("TumbleWeed:", 0, lineHeight);
        score.drawString(TumbleWeed.tumbleWeedAmount + "", 0, lineHeight * 2);

        setImage(score);

    }
    
}
