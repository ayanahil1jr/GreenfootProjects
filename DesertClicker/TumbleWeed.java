import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TumbleWeed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TumbleWeed extends Actor
{
    public static double multiplier = 1;
    public static double tumbleWeedAmount;
    /**
     * Act - do whatever the TumbleWeed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        addScore();
    }
    /**
     * this method is used to add tumbleweeds to your total amount. whenever you click the tumbleweed, it would play the sound of you clicked
     * and increase the amount of tumbleweeds you have by your multiplier. it also updates the scoreboard image so it displays
     * the correct amount.
     */
    public void addScore()
    {
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.playSound("click.mp3");
        tumbleWeedAmount = tumbleWeedAmount + multiplier;
        world.scoreboard.updateImage();
        }
    }
}
