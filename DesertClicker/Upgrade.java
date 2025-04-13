import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Upgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Upgrade extends Actor
{
    public double price;
    public double multiplier;
    public double costmulti;
    /**
     * Act - do whatever the Upgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /**
     * constructer for the upgrade. the 3 parameters it takes is the original cost, the multiplier boost, and the increment of the cost.
     * It also sets the image to null so it isnt shown on the main screen.
     */
    public Upgrade(double originalCost, double boost, double costMultiplier)
    {
        price = originalCost;
        multiplier = boost;
        costmulti = costMultiplier;
        setImage((GreenfootImage) null);
    }
    public void act()
    {
        upgradeInitiate();
    }
    /**
     * method to initiate the upgrade. when you press the upgrade and you have enough tumbleweeds, it would play the sound for buying the upgrade,
     * and take away the amount it cost. it then would change the price to be the previous price multiplied by the multiplier for the cost.
     * it also changes the tumbleweed multiplier to be multiplied by the boost of the button. it then runs the updateImage() method and
     * changes the scoreboard to display the correct number of tumbleweeds after bought.
     */
    public void upgradeInitiate()
    {
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mousePressed(this) && TumbleWeed.tumbleWeedAmount >= price)
        {
            Greenfoot.playSound("coin.mp3");
            TumbleWeed.tumbleWeedAmount -= price;
            price = price * costmulti;
            TumbleWeed.multiplier *= multiplier;
            updateImage();
            GreenfootImage score = new GreenfootImage(200, 50);
                        score.setFont(new Font("Arial", 12));
                        score.setColor(Color.WHITE);
                        int lineHeight = 20;
                        score.drawString("TumbleWeed:", 0, lineHeight);
                        score.drawString(TumbleWeed.tumbleWeedAmount + "", 0, lineHeight * 2);

                        world.scoreboard.setImage(score);
        }
    }
    /**
     * this method is used to update the text displayed on the button. it sets the background to the button image, and adds 2 texts that read
     * the multiplier and the price. it then draws the image on to the background and sets the image to that background.
     */
    public void updateImage()
    {
        GreenfootImage background = new GreenfootImage("button.png");
        GreenfootImage boostText = new GreenfootImage(multiplier + "" + "x TumbleWeeds", 15, Color.BLACK, null);
        GreenfootImage boostPrice = new GreenfootImage(price + "" + " TumbleWeeds", 15, Color.BLACK, null);
        background.drawImage(boostText, 33, 10);
        background.drawImage(boostPrice, 30, 25);
        setImage(background);
    }
    
}
