import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    TumbleWeed tumble = new TumbleWeed();
    Upgrade upgrade1 = new Upgrade(25, 2, 3);
    Upgrade upgrade2 = new Upgrade(250, 3, 10);
    ScoreBoard scoreboard = new ScoreBoard();
    Button button1 = new Button(1);
    Button button2 = new Button(2);
    private boolean start = true;
    Rebirth rebirth = new Rebirth();
    GoldTumble gold = new GoldTumble();
    public int x;
    /**
     * The Constructer sets the world size, sets the background to titlescreen, and resets the tumbleweed amount
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        setBackground("titlescreen.png");
        tumble.tumbleWeedAmount = 0;
    }
    //the act method runs the methods
    public void act()
    {
        titleScreen();
        music();
    }
    
    /** the title screen method. This checks to see if the titlescreen is still on the screen and if the user has clicked the A key.
     * Once the user clicks A, it adds the necessary game elements, sets the background to the normal background, and starts playing the music.
     * It also sets start to false which is used to make sure the person cant spam the A key to spawn more game elements and is used to
     * start the music playing method.
     */
    public void titleScreen()
    {
        if(start == true && Greenfoot.isKeyDown("a"))
        {
            
            addObject(scoreboard, 70, 30);
            addObject(tumble, 200, 300);
            addObject(upgrade1, 111, 190);
            addObject(upgrade2, 279, 190);
            addObject(button1, 108, 545);
            addObject(button2, 285, 545);
            addObject(gold, 362, 38);
            setBackground("background.png");
            start = false;
            addObject(rebirth, 200, 450);
            Greenfoot.playSound("music.mp3");
        }
    }
    /** This method increments the x value. after 1560 ticks (about the length of the music) and if start is false
     * (the person has left the title screen), the music plays and sets x back to 0.
     */
    public void music()
    {
            x++;
            if(x > 1560 && start == false)
            {
            Greenfoot.playSound("music.mp3");
            x = 0;
            }
    }
}
