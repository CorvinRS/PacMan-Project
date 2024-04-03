import java.awt.Graphics2D;
import java.awt.Color;
public class Block {
    

    private int x, y, width, height;

    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics2D g2d){
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, width, height);
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
}
