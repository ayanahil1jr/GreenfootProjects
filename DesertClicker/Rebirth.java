import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rebirth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rebirth extends Actor
{
    public static double price = 1000000;
    public static int rebirthAmount = 0;
    /**
     * Act - do whatever the Rebirth wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //sets image to null so it doesnt show up at the main area of the game
    public Rebirth()
    {
        setImage((GreenfootImage) null);
    }
    public void act()
    {
        buyRebirth();
    }
    /**
     * method to initiate the rebirth process. When you click this button and have enough tumbleweeds, you will rebirth. Rebirthing will play the rebirth sound,
     * increase your rebirth amount, and reset your tumbleweeds. it also sets the tumbleweed multiplier to 5 to the power of your rebirth amount (1 = 5, 2 = 25, etc.). it then resets
     * the upgrade prices and sets the price of rebirth to x1000 of itself.
     */
    public void buyRebirth()
    {
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mousePressed(this) && TumbleWeed.tumbleWeedAmount >= price)
        {
            Greenfoot.playSound("reb.mp3");
            rebirthAmount++;
            TumbleWeed.multiplier = Math.pow(5, rebirthAmount);
            TumbleWeed.tumbleWeedAmount = 0;
            world.upgrade1.price = 25;
            world.upgrade2.price = 250;
            price *= 1000;
            GreenfootImage score = new GreenfootImage(130, 50);
                        score.setFont(new Font("Arial", 18));
                        score.setColor(Color.BLACK);
                        int lineHeight = 20;
                        score.drawString("TumbleWeed:", 0, lineHeight);
                        score.drawString(TumbleWeed.tumbleWeedAmount + "", 0, lineHeight * 2);

                        world.scoreboard.setImage(score);
        }
    }
}
