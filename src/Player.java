import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;

public class Player {// Look into arcs instead of images for pacman

    private int x = PacMan.WIDTH / 2 + 3, y = PacMan.HEIGHT / 2 + 55;
    private int size = 40;
    private int speedX = 0, speedY = 0, speed = 5;
    // Variables for opening and closing pacmans mouth
    private int bottomMouth = 360, topMouth = 0;// Mouth fully closed
    private int topMouthMovingRate = 25;
    private int bottomMouthMovingRate = -25;
    private int mouthChangeCounter = 0;
    // Color of Pac-Man
    private Color playerColor = new Color(252, 234, 63);

    public Player() {

    }

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
        moveMouth();
        x += speedX;
        y += speedY;
    }

    public void checkCollisions() {

        for (int i = 0; i < PacMan.blocks.size(); i++) {

            // Block Collisions going to the left
            if (this.x < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()
                    && this.x > PacMan.blocks.get(i).getX() && this.y + this.size > PacMan.blocks.get(i).getY()
                    && this.y < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()) {

                this.x = PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth();
                System.out.println("1");
            }

            // Block collisions going right
            if (this.x + this.size > PacMan.blocks.get(i).getX()
                    && this.x + this.size < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()
                    && this.y + this.size > PacMan.blocks.get(i).getY()
                    && this.y < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()) {

                this.x = PacMan.blocks.get(i).getX() - this.size;
                System.out.println("2");
            }

            // Block Collisions going up
            if (this.y < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight() + this.speed
                    && this.y > PacMan.blocks.get(i).getY()
                    && this.x + this.size > PacMan.blocks.get(i).getX()
                    && this.x < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()) {

                this.y = PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight() + this.speed;
                System.out.println("2");
            }

            // Block collisions going down
            if (this.y + this.size > PacMan.blocks.get(i).getY() - this.speed
                    && this.y + this.size < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()
                    && this.x + this.size > PacMan.blocks.get(i).getX()
                    && this.x < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()) {

                this.y = PacMan.blocks.get(i).getY() - this.size - this.speed;
                System.out.println("4");
            }
        }

        // Looping
        if (x < -size) {
            x = PacMan.WIDTH;
        }

        if (x > PacMan.WIDTH) {
            x = 0;
        }

        if (y < 0) {
            y = 0;
        }

        if (y > PacMan.HEIGHT - size - size / 2) {
            y = PacMan.HEIGHT - size - size / 2;
        }
    }

    // The next four methods are the same just different directions:
    public void setDirectionRight() {
        speedX = speed;// This changes the speed to match direction
        speedY = 0;

        mouthChangeCounter = 0;// Reseting the timer so the animation restarts
        topMouth = 0;// Setting topmouth to the correct direction, in this case 0 is right
        bottomMouth = 360;// Ressetting bottommouth to 360 making pac-man have a closed mouth

        topMouthMovingRate = Math.abs(topMouthMovingRate);// Reseting the rates back to their respective positive and
                                                          // necative order,
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

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        g.setColor(playerColor);
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

    // public int getSpeedX(){
    // return speedX;
    // }

    // public int getSpeedY(){
    // return speedY;
    // }

    public int setX(int a) {
        x = a;
        return x;
    }

    public int setY(int a) {
        y = a;
        return y;
    }
}
