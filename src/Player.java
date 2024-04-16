import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

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
    // private boolean right, left, up, down;
    private int directionTimer = 0;

    public enum TypeCollisions {
        Blocks,
        Pelets,
    }

    public TypeCollisions whatCollisions;

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
        //The idea with the direction timer is if the direction isn't met in a certain amount of time it's taken off the que:
        //Stops players from getting stuck in walls
        if (PacMan.direction.size() > 0) {
            if (checkGrid() && checkBlock(PacMan.blocks, PacMan.direction.get(0))) {
                setDirection(PacMan.direction.get(0));
                PacMan.direction.remove(0);
                directionTimer = 0;
            }
            if(directionTimer > 25){
                PacMan.direction.remove(0);
                directionTimer = 0;
            }
            directionTimer++;
        }

        // Adding speed to player
        x += speedX;
        y += speedY;
    }

    public void setDirection(int setValue) {
        if (setValue == 0) {
            setDirectionRight();
        }
        if (setValue == 1) {
            setDirectionLeft();
        }
        if (setValue == 2) {
            setDirectionUp();
        }
        if (setValue == 3) {
            setDirectionDown();
        }
    }

    public boolean checkGrid() {

        if (x % PacMan.GAMEUNIT == 0 && y % PacMan.GAMEUNIT == 0) {
            return true;
        }
        return false;
    }

    public void peletEaten(){
        PacMan.setScore(PacMan.getScore() + 10);
        if(PacMan.getScore() > PacMan.getHighScore()){
            PacMan.setHighScore(PacMan.getScore());
        }
    }

    public boolean checkBlock(ArrayList<StationaryObjects> block, int dirct) {

        //Right
        if (dirct == 0) {
            for (int i = 0; i < block.size(); i++) {
                if (this.x + this.size + this.speed > block.get(i).getX()
                        && this.x + this.size < block.get(i).getX() + block.get(i).getWidth()
                        && this.y + this.size > block.get(i).getY()
                        && this.y < block.get(i).getY() + block.get(i).getHeight()) {
                    return false;
                }
            }
        }

        //Left
        if (dirct == 1) {
            for (int i = 0; i < block.size(); i++) {
                if (this.x - this.speed < block.get(i).getX() + block.get(i).getWidth()
                        && this.x > block.get(i).getX()
                        && this.y + this.size > block.get(i).getY()
                        && this.y < block.get(i).getY() + block.get(i).getHeight()) {
                    return false;
                }
            }
        }

        //Up
        if (dirct == 2) {
            for (int i = 0; i < block.size(); i++) {
                if (this.y - this.speed < block.get(i).getY() + block.get(i).getHeight()
                        && this.y > block.get(i).getY()
                        && this.x + this.size > block.get(i).getX()
                        && this.x < block.get(i).getX() + block.get(i).getWidth()) {
                    return false;
                }
            }
        }

        //Down
        if(dirct == 3){
            for (int i = 0; i < block.size(); i++) {
                if (this.y + this.size + this.speed > block.get(i).getY()
                        && this.y + this.size < block.get(i).getY() + block.get(i).getHeight()
                        && this.x + this.size > block.get(i).getX()
                        && this.x < block.get(i).getX() + block.get(i).getWidth()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean[] checkCollisions(ArrayList<StationaryObjects> Objects, TypeCollisions whatCollision) {

        boolean[] directionsB = new boolean[4];

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

        for (int i = Objects.size() - 1; i > 0; i--) {

            // Block collisions going right
            if (this.x + this.size + this.speed > Objects.get(i).getX()
                    && this.x + this.size < Objects.get(i).getX() + Objects.get(i).getWidth()
                    && this.y + this.size > Objects.get(i).getY()
                    && this.y < Objects.get(i).getY() + Objects.get(i).getHeight()) {

                switch (whatCollision) {
                    case Blocks:
                        this.speedX = ((this.x + this.size) - Objects.get(i).getX());
                        break;
                    case Pelets:
                        peletEaten();
                        PacMan.pelets.remove(i);
                        break;
                }
                directionsB[0] = false;
            } else
                directionsB[0] = true;

            // Block Collisions going to the left
            if (this.x - this.speed < Objects.get(i).getX() + Objects.get(i).getWidth()
                    && this.x > Objects.get(i).getX()
                    && this.y + this.size > Objects.get(i).getY()
                    && this.y < Objects.get(i).getY() + Objects.get(i).getHeight()) {

                directionsB[1] = false;
                switch (whatCollision) {

                    case Blocks:
                        this.speedX = ((Objects.get(i).getX() + Objects.get(i).getWidth()) - this.x);
                        break;
                    case Pelets:
                        peletEaten();
                        PacMan.pelets.remove(i);
                        break;
                }
            } else
                directionsB[1] = true;

            // Block Collisions going up
            if (this.y - this.speed < Objects.get(i).getY() + Objects.get(i).getHeight()
                    && this.y > Objects.get(i).getY()
                    && this.x + this.size > Objects.get(i).getX()
                    && this.x < Objects.get(i).getX() + Objects.get(i).getWidth()) {

                directionsB[2] = false;
                switch (whatCollision) {

                    case Blocks:
                        this.speedY = ((Objects.get(i).getY() + Objects.get(i).getHeight()) - this.y);
                        break;
                    case Pelets:
                        peletEaten();
                        PacMan.pelets.remove(i);
                        break;
                }
            } else
                directionsB[2] = true;

            // Block collisions going down
            if (this.y + this.size + this.speed > Objects.get(i).getY()
                    && this.y + this.size < Objects.get(i).getY() + Objects.get(i).getHeight()
                    && this.x + this.size > Objects.get(i).getX()
                    && this.x < Objects.get(i).getX() + Objects.get(i).getWidth()) {

                directionsB[3] = false;
                switch (whatCollision) {
                    case Blocks:
                        this.speedY = (Objects.get(i).getY() - (this.y + this.size));
                        break;
                    case Pelets:
                        peletEaten();
                        PacMan.pelets.remove(i);
                        break;
                }
            } else
                directionsB[3] = true;
        }
        return directionsB;
    }

    // The next four methods are the same just different directions:
    public void setDirectionRight() {
        
        speedX = speed;// This changes the speed to match direction
        speedY = 0;
        

        mouthChangeCounter = 0;// Reseting the timer so the animation restarts
        topMouth = 0;// Setting topmouth to the correct direction, in this case 0 is right
        bottomMouth = 360;// Ressetting bottommouth to 360 making pac-man have a closed mouth

        topMouthMovingRate = Math.abs(topMouthMovingRate);// Reseting the rates back to their respective
                                                          // positive
                                                          // and
                                                          // negative order,
        if (bottomMouthMovingRate > 0) {// This prevents any wack looking anamation when changing direction
            bottomMouthMovingRate *= -1;
        }
    }

    public void setDirectionLeft() {
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

    public void setDirectionUp() {
        
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

    public void setDirectionDown() {
        
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

    public void paint(Graphics2D g2d) {
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        g2d.setColor(playerColor);
        g2d.fillArc(x, y, size, size, topMouth, bottomMouth);
    }

    public void setSpeedX(int b) {
        this.speedX = b;
    }

    public void setSpeedY(int b) {
        this.speedY = b;
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
