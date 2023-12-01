import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    int _idleImageNum= 2;
    int _walksImageNum= 5;
    int _jumpImageNum = 6;
    
    String state = "idle";
    public String getState()
    {
        return this.state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }

    public player(){
        this.setImage(new GreenfootImage("/player/idle/1.png"));
    }
    int _animationDelay = 10;
    int _animationTimer = 0;
    int _lastSpriteNo = 0;
    Boolean moveFoward = true;
    void animate()
    {
        if(_animationTimer<_animationDelay)
        {
            _animationTimer++;
            return;
        }
        _animationTimer = 0;
        String path = "";
        switch(this.state)
        {
            case "idle": {path = "/player/idle/"+_lastSpriteNo%_idleImageNum+".png"; break;}
            case "walks": {path = "/player/walks/"+_lastSpriteNo%_walksImageNum+".png"; break;}
            case "jump": {path = "/player/jump/"+_lastSpriteNo% _jumpImageNum + ".png"; break;}
            default: {path = "/player/idle/0.png"; break;}
        }
        _lastSpriteNo++;
        GreenfootImage img= new GreenfootImage(path);
        if(moveFoward)
        {
            this.setImage(img);
            return;
        }
        img.mirrorHorizontally();
        this.setImage(img);
    }
    
    void controlPlayer()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            this.moveFoward = true;
            this.state = "walks";
            this.setLocation(this.getX()+2, this.getY());
            return;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            this.moveFoward = false;
            this.state = "walks";
            this.setLocation(this.getX()-2, this.getY());
            return;
        }
        if (Greenfoot.isKeyDown("space") && !isJumping) {
            this.state = "jump";
            jump();
        }
        this.state = "idle";
    }
    private static final int JUMP_HEIGHT = 150;
    private static final int JUMP_DURATION = 60;
    private int jumpCounter = 0;
    private boolean isJumping = false;
    private boolean canMove = true;
        void jump() {
        if(!isJumping && canMove) {
            isJumping = true;
            jumpCounter = 0;
            canMove = false;
        }
    }
    
    public void act()
    {
        animate();
        controlPlayer();
        
        // Check if the player is currently jumping
        if (isJumping) {
            if (jumpCounter < JUMP_DURATION / 2) {
                // Perform the ascending part of the jump
                setLocation(getX(), getY() - (JUMP_HEIGHT / (JUMP_DURATION / 2)));
            } else if (jumpCounter < JUMP_DURATION) {
                // Perform the descending part of the jump
                setLocation(getX(), getY() + (JUMP_HEIGHT / (JUMP_DURATION / 2)));
            } else {
                // End the jump
                isJumping = false;
                canMove = true; // Setel kembali ke true saat pemain mendarat
            }
            jumpCounter++;
        }
    }
}