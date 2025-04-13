import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Axe class represents a key in the piano that plays an axe chopping sound.
 * When pressed, it changes its image and plays a sound.
 */
public class Axe extends Actor
{
    // Images for the key in up and down states
    public GreenfootImage upKey;
    public GreenfootImage downKey;
    
    // The keyboard key associated with this axe key
    private String keyboard;
    // The sound effect that plays when the key is pressed
    private String soundAffect;
    
    // Boolean to check if the key is currently pressed
    private boolean isDown;
    
    /**
     * Constructor for the Axe key.
     * the parameter keyNote is used for keyboard key assigned to this axe.
     * the parameter soundFile is used for sound file played when the key is pressed.
     * the parameter upImage is used for image displayed when the key is not pressed.
     * the parameter downImage is used for image displayed when the key is pressed.
     */
    public Axe(String keyNote, String soundFile, String upImage, String downImage)
    {
        // Load the images for up and down states
        upKey = new greenfoot.GreenfootImage(upImage);   
        downKey = new greenfoot.GreenfootImage(downImage);
        
        // Assign values to the keyboard key and sound effect
        keyboard = keyNote;
        soundAffect = soundFile;
        
        // Set the initial image to the up state
        setImage(upKey);
    }

    public void act()
    {
        upDownMechanic();
    }
    
    /**
     * The first if statement checks if the key is pressed and if it isn't already being held down. it then plays the sound effect, sets the image
     * to downimage, and sets isDown to true so the sound isnt spammed. the second if statement checks if the key is not being pressed and if isDown is true, meaning it
     * got released. it sets the image back to normal and sets isDown to false.
     */
    public void upDownMechanic()
    {
        if (Greenfoot.isKeyDown(keyboard) && !isDown)
        {
            Greenfoot.playSound(soundAffect);
            setImage(downKey);
            isDown = true;
        }
        if (!Greenfoot.isKeyDown(keyboard) && isDown)
        {
            setImage(upKey);
            isDown = false;
        }
    }
    
}
