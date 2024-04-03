import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Player {// Look into arcs instead of images for pacman

    private int x = PacMan.WIDTH / 2 - 20, y = PacMan.HEIGHT / 2 + 40;
    private int size = PacMan.GAMEUNIT;
    private int speedX = 0, speedY = 0, speed = PacMan.GAMEUNIT / 5;
    // Variables for opening and closing pacmans mouth
    private int bottomMouth = 360, topMouth = 0;// Mouth fully closed
    private int topMouthMovingRate = 25;
    private int bottomMouthMovingRate = -25;
    private int mouthChangeCounter = 0;
    // Color of Pac-Man
    private Color playerColor = new Color(252, 234, 63);

    public void moveMouth() {

        if (mouthChangeCounter > 1) {

            mouthChangeCounter = 0;
            topMouthMovingRate *= -1;
            bottomMouthMovingRate *= -1;
        }

        mouthChangeCounter += 1;
        topMouth += topMouthMovingRate;
        bottomMouth += bottomMouthMovingRate * 2;// Have to multiply by 2 to make up for the difference in the arc
    }

    public void move() {
        // Moving mouth
        moveMouth();

        // Making sure Player stays on grid
        if (PacMan.direction.size() > 0) {
            if (checkGrid()) {
                setDirection(PacMan.direction.get(0));
                PacMan.direction.remove(0);
            }
        }

        // Adding speed to player
        x += speedX;
        y += speedY;
    }

    public void setDirection(int setValue) {
        if (setValue == 1) {
            setDirectionRight();
        }
        if (setValue == 2) {
            setDirectionLeft();
        }
        if (setValue == 3) {
            setDirectionUp();
        }
        if (setValue == 4) {
            setDirectionDown();
        }
    }

    public boolean checkGrid() {

        if (x % PacMan.GAMEUNIT == 0 && y % PacMan.GAMEUNIT == 0) {
            return true;
        }
        return false;
    }

    // Checks if blocks are in the direction player may turn
    //This one checks blocks to the left of player
    public boolean checkXLBlocks() {

        for (int i = 0; i < PacMan.blocks.size(); i++) {

            if (this.x - PacMan.GAMEUNIT / 2 < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()
                    + this.speed
                    && this.x > PacMan.blocks.get(i).getX() && this.y + this.size > PacMan.blocks.get(i).getY()
                    && this.y < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()) {

                return false;
            }
        }
        return true;
    }

    //Checks blocks going to the right
    public boolean checkXRBlocks() {

        for (int i = 0; i < PacMan.blocks.size(); i++) {

            if (this.x + this.size + PacMan.GAMEUNIT / 2 > PacMan.blocks.get(i).getX() - this.speed
                    && this.x + this.size < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()
                    && this.y + this.size > PacMan.blocks.get(i).getY()
                    && this.y < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()) {

                return false;
            }
        }
        return true;
    }

    //Checks blocks going up
    public boolean checkYUBlocks() {

        for(int i = 0; i < PacMan.blocks.size(); i++){

            if (this.y - PacMan.GAMEUNIT / 2 < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight() + this.speed
                    && this.y > PacMan.blocks.get(i).getY()
                    && this.x + this.size > PacMan.blocks.get(i).getX()
                    && this.x < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()) {
    
                return false;
            }
        }
        return true;
    }

    //Checks blocks going down
    public boolean checkYDBlocks() {

        for(int i = 0; i < PacMan.blocks.size(); i++){

            if (this.y + this.size + PacMan.GAMEUNIT / 2 > PacMan.blocks.get(i).getY() - this.speed
                    && this.y + this.size < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()
                    && this.x + this.size > PacMan.blocks.get(i).getX()
                    && this.x < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()) {
    
                return false;
            }
        }

        return true;
    }

    public void checkCollisions() {

        for (int i = 0; i < PacMan.blocks.size(); i++) {

            // Block Collisions going to the left
            if (this.x < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth() + this.speed
                    && this.x > PacMan.blocks.get(i).getX() && this.y + this.size > PacMan.blocks.get(i).getY()
                    && this.y < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()) {

                this.speedX = 0;
            }

            // Block collisions going right
            if (this.x + this.size > PacMan.blocks.get(i).getX() - this.speed
                    && this.x + this.size < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()
                    && this.y + this.size > PacMan.blocks.get(i).getY()
                    && this.y < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()) {

                this.speedX = 0;
            }

            // Block Collisions going up
            if (this.y < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight() + this.speed
                    && this.y > PacMan.blocks.get(i).getY()
                    && this.x + this.size > PacMan.blocks.get(i).getX()
                    && this.x < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()) {

                this.speedY = 0;
            }

            // Block collisions going down
            if (this.y + this.size > PacMan.blocks.get(i).getY() - this.speed
                    && this.y + this.size < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()
                    && this.x + this.size > PacMan.blocks.get(i).getX()
                    && this.x < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()) {

                this.speedY = 0;
            }
        }

        // Checking collisons with side walls
        if (x < -size) {
            x = PacMan.WIDTH;
        }

        if (x > PacMan.WIDTH) {
            x = -size;
        }

        // Checking collisions with Vertical walls
        if (y < 0) {
            y = 0;
        }

        if (y > PacMan.HEIGHT - size - size / 2) {
            y = PacMan.HEIGHT - size - size / 2;
        }
    }

    // The next four methods are the same just different directions:
    public void setDirectionRight() {

        //The if statment is checking a block is next to it
        //If false then the code that checks if player is on grid will remove this direction from the arraylist direction
        //So the else statements just adds the direction back so that the player will still turn in the original direction they
        //chose after they're past the block
        if(checkXRBlocks()){
            speedX = speed;// This changes the speed to match direction
            speedY = 0;
    
            mouthChangeCounter = 0;// Reseting the timer so the animation restarts
            topMouth = 0;// Setting topmouth to the correct direction, in this case 0 is right
            bottomMouth = 360;// Ressetting bottommouth to 360 making pac-man have a closed mouth
    
            topMouthMovingRate = Math.abs(topMouthMovingRate);// Reseting the rates back to their respective positive and
                                                              // negative order,
            if (bottomMouthMovingRate > 0) {// This prevents any wack looking anamation when changing direction
                bottomMouthMovingRate *= -1;
            }
        }
        else PacMan.direction.add(1);
    }

    public void setDirectionLeft() {

        if(checkXLBlocks()){
            speedX = speed * -1;
            speedY = 0;
    
            mouthChangeCounter = 0;
            topMouth = 180;
            bottomMouth = 360;
    
            topMouthMovingRate = Math.abs(topMouthMovingRate);
            if (bottomMouthMovingRate > 0) {
                bottomMouthMovingRate *= -1;
            }
        }
        else PacMan.direction.add(2);
    }

    public void setDirectionUp() {

        if(checkYUBlocks()){
            speedY = speed * -1;
            speedX = 0;
    
            mouthChangeCounter = 0;
            topMouth = 90;
            bottomMouth = 360;
    
            topMouthMovingRate = Math.abs(topMouthMovingRate);
            if (bottomMouthMovingRate > 0) {
                bottomMouthMovingRate *= -1;
            }
        }
        else PacMan.direction.add(3);
    }

    public void setDirectionDown() {

        if(checkYDBlocks()){
            speedY = speed;
            speedX = 0;
    
            mouthChangeCounter = 0;
            topMouth = 270;
            bottomMouth = 360;
    
            topMouthMovingRate = Math.abs(topMouthMovingRate);
            if (bottomMouthMovingRate > 0) {
                bottomMouthMovingRate *= -1;
            }
        }
        else PacMan.direction.add(4);
    }

    public void paint(Graphics2D g2d) {
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        g2d.setColor(playerColor);
        g2d.fillArc(x, y, size, size, topMouth, bottomMouth);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int setX(int a) {
        x = a;
        return x;
    }

    public int setY(int a) {
        y = a;
        return y;
    }
}
