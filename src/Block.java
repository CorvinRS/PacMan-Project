import java.awt.Graphics;
import java.awt.Color;
public class Block {
    

    private int x, y, width, height;

    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    // public void checkCollisions(int eX, int eY, int size){

    //     //Block collisions going left
    //     if (eX < this.x + this.width && eX > this.x && eY + size > this.y && eY < this.y + this.height) {
    //         PacMan.player.setX(this.x + this.width);
    //         System.out.println("1");
    //     }

    //     //Block collisions going right
    //     if(eX + size > this.x && eX + size < this.x + this.width && eY + size > this.y && eY < this.y + this.height){
    //         PacMan.player.setX(this.x - size);
    //         System.out.println("2");
    //     }

    //     //Block Collisions going up
    //     if (eY < this.y + this.height && eY > this.y && eX + size > this.x && eX < this.x + this.width) {
    //         PacMan.player.setY(this.y + this.width);
    //         System.out.println("3");
    //     }

    //     //Horizontal walls to the bottom
    //     if(eY + size > this.y && eY + size < this.y + this.height && eX + size > this.x && eX < this.width){
    //         PacMan.player.setY(this.y - size);
    //         System.out.println("4");
    //     }
    // }
}
