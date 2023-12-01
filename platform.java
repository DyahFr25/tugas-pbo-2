import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class platform extends Actor
{
    int groupId = 0;
    int speed = 1;
    
    public platform(int groupId)
    {
        this.groupId = groupId;
    }
    
    public void act()
    {
        this.setLocation(this.getX()-speed,this.getY());
    }
}
