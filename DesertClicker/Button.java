import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    public int buttonNumb;
    public Boolean isShop = false;
    public Boolean isRebirth;
    ScoreBoard scoreboard;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /** the constructer. This is to create the specific type of button by taking the button number.
     * 1 = shop, 2 = rebirth
     * This number is then used to set the image of the button and will be used to identify which button will do what.
     */
    public Button(int buttonNumber)
    {
        buttonNumb = buttonNumber;
        setImage("button" + buttonNumber + "" + ".png");
    }
    //act method, runs the methods
    public void act()
    {
        shopMechanic();
        rebirthMechanic();
    }
    /**
     * This method is used for the shop button. it checks to see if it's clicked on an the buttonNumb is 1. It then checks if the shop is currently open (isShop) or closed (!isShop).
     * based on what it is, it would open the shop, set the background to the shop background, remove the tumbleweed, add the upgrade buttons, and set isShop to true. 
     * Or if it was open already, the button would change the background back to normal, remove the buttons, add back the tumbleweed, and set isShop to false.
     * It would also change the color of the text to white while in the shop just to make it easier to read.
     */
    public void shopMechanic()
    {
        MyWorld world = (MyWorld) getWorld();
        scoreboard = (ScoreBoard) getWorld().getObjects(ScoreBoard.class).get(0);
        if(Greenfoot.mousePressed(this))
        {
            if(buttonNumb == 1)
                {
                    if(isShop)
                    {
                        world.upgrade1.setImage((GreenfootImage) null); 
                        world.upgrade2.setImage((GreenfootImage) null);
                        //scoreboard.score = new GreenfootImage("Score: " + TumbleWeed.tumbleWeedAmount + "", 25, Color.BLACK, null);  
                        //scoreboard.setImage(scoreboard.score);
                        isShop = false;
                        world.button2.setImage("button2.png");
                        world.button1.setImage("button1.png");
                        world.tumble.setImage("tumbleweed.png");
                        world.setBackground("background.png");
                        GreenfootImage score = new GreenfootImage(130, 50);
                        score.setFont(new Font("Arial", 12));
                        score.setColor(Color.BLACK);
                        int lineHeight = 20;
                        score.drawString("TumbleWeed:", 0, lineHeight);
                        score.drawString(TumbleWeed.tumbleWeedAmount + "", 0, lineHeight * 2);
                        world.scoreboard.setImage(score);

                    }
                    else
                    {
                    world.tumble.setImage((GreenfootImage) null);
                    //scoreboard.setImage((GreenfootImage) null);
                    isShop = true;
                    world.upgrade1.updateImage();
                    world.upgrade2.updateImage();
                    world.button1.setImage("leave.png");
                    world.button2.setImage((GreenfootImage) null);
                    world.setBackground("shopbackground.png");
                    GreenfootImage score = new GreenfootImage(130, 50);
                        score.setFont(new Font("Arial", 12));
                        score.setColor(Color.WHITE);
                        int lineHeight = 20;
                        score.drawString("TumbleWeed:", 0, lineHeight);
                        score.drawString(TumbleWeed.tumbleWeedAmount + "", 0, lineHeight * 2);
                        world.scoreboard.setImage(score);

                    }
                }
        }
    }
    /**
     * The rebirthMechanic method checks to see if it was pressed and the buttonNumber of this button is 2 (rebirth button number). 
     * it then checks to see if the shop was already open or if it was closed. if it was closed, it would remove the tumbleweed, set the score to white (to
     * make it easier to read), and change the background to rebirth menu background. It would laos add text explaining what rebirthing does
     * and adds the rebirth button so you can rebirth. in the top right corner, it also adds the golden tumbleweed amount showing how
     * many you have, which affects the click gain.
     */
    public void rebirthMechanic()
    {
        MyWorld world = (MyWorld) getWorld();
        scoreboard = (ScoreBoard) getWorld().getObjects(ScoreBoard.class).get(0);
        
        if(Greenfoot.mousePressed(this) && buttonNumb == 2)
        {
            if(isShop)
            {
                isShop = false;
                world.button1.setImage("button1.png");
                world.button2.setImage("button2.png");
                world.tumble.setImage("tumbleweed.png");
                world.setBackground("background.png");
                world.rebirth.setImage((GreenfootImage) null);
                world.gold.setImage((GreenfootImage) null);
                GreenfootImage score = new GreenfootImage(130, 50);
                    score.setFont(new Font("Arial", 12));
                    score.setColor(Color.BLACK);
                    int lineHeight = 20;
                    score.drawString("TumbleWeed:", 0, lineHeight);
                    score.drawString(TumbleWeed.tumbleWeedAmount + "", 0, lineHeight * 2);

                    world.scoreboard.setImage(score);
            }
            else
            {
                world.tumble.setImage((GreenfootImage) null);
                world.gold.setImage("gold-tumbleweed.png");
                isShop = true;
                world.button2.setImage("leave2.png");
                world.button1.setImage((GreenfootImage) null);
                world.setBackground("rebirthbackground.png");
                world.rebirth.setImage("rebirthbutton!!!.png");
                world.getBackground().drawString("Rebirth to gain 1 Golden Tumbleweed", 94, 300);
                world.getBackground().drawString("Each Golden Tumbleweeds boosts clicks by 5x", 76, 320);
                world.getBackground().drawString("Cost: " + Rebirth.price + "", 155, 350);
                world.getBackground().drawString(Rebirth.rebirthAmount + "", 305, 37);
                GreenfootImage score = new GreenfootImage(130, 50);
                    score.setFont(new Font("Arial", 12));
                    score.setColor(Color.WHITE);
                    int lineHeight = 20;
                    score.drawString("TumbleWeed:", 0, lineHeight);
                    score.drawString(TumbleWeed.tumbleWeedAmount + "", 0, lineHeight * 2);

                    world.scoreboard.setImage(score);   
            }
        }
    }
}
