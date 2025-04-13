import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main world where the axe and pickaxe keys are displayed.
 * Players can press keys to simulate a piano-like experience with chopping and mining sounds.
 */
public class MyWorld extends World
{
    // Arrays storing keys and corresponding sound files for axe and pickaxe
    private String[] axeNote =
    {"a","s","d","f","g","h","j","k"};
    private String[] axeSound =
    {"axe1","axe2","axe3","axe4","axe5","axe6","axe7","axe8"};
    private String[] pickaxeNote =
    {"q", "w", "e", "r", "t", "y", "u", "i"};
    private String[] pickaxeSound =
    {"pick1", "pick2", "pick4", "pick5", "pick6", "pick7", "pick8", "pick10"};
    
    // Image file names for the axe and pickaxe in up and down states
    private String axeUpImage = "axe.jpg";
    private String axeDownImage = "axe-down.jpg";
    private String pickaxeUpImage = "pickaxe.jpg";
    private String pickaxeDownImage = "pickaxe-down.jpg";
    
    /**
     * Constructor for MyWorld.
     * Initializes the world and adds the piano keys.
     */
    public MyWorld()
    {    
        // Create a new world with 800x260 pixels, cell size of 1x1
        super(800, 260, 1); 
        
        // Create and add axe keys
        makeAxeKey();
        
        // Create and add pickaxe keys
        makePickaxeKey();
        
        // Display a welcome message
        showText("Welcome to my piano, Have Fun!", 400, 240);
    }
    
    /**
     * This method creates the axe keys. it uses a while loop to add 8 of the keys. the parameters for the addObject are
     * new Axe(parameters), x value, and y value. the x value changes based on the i variable, spacing them out evenly.
     * the 4 paremeters are the note, meaning the key you have to press to play the note, the sound the key makes, and the up and down images (to differentiate the axe and pickaxe keys)
     */
    public void makeAxeKey()
    {
        int i = 0;
        while(i<8)
        {
            addObject(new Axe(axeNote[i], axeSound[i] + ".wav", axeUpImage, axeDownImage), 140 + i * 76, 111);
            i++;
        }
        
    }
    
    /**
     * This method creates the pickaxe keys. it uses a for loop to add 5 of the keys. the parameters for the addObject are
     * new Axe(parameters), x value, and y value. the x value changes based on the i variable, spacing them out evenly.
     * the 4 paremeters are the note, meaning the key you have to press to play the note, the sound the key makes, and the up and down images (to differentiate the axe and pickaxe keys)
     * some of the keys are skipped because on a normal piano theres spacing between a few of the black keys, hence the extra if statement.
     */
    public void makePickaxeKey()
    {
                
        for(int i = 0; i < 8; i++)
        {
                if(i != 0 && i != 3 && i != 5)
            {
                addObject(new Axe(pickaxeNote[i], pickaxeSound[i] + ".wav", pickaxeUpImage, pickaxeDownImage), 102 + i * 76, 73);
            }    
        }
    }
}