import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stage extends World
{
    public stage()
    {    
        super(1200, 600, 1); 
        this.setBackground(new GreenfootImage("background3.png"));
        
    }
    private void prepare()
    {
        player player = new player();
        addObject(player,116,503);
    }
    
    
    
    public void act()
    {
        
    }
}
