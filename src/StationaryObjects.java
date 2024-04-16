import java.awt.Color;
import java.awt.Graphics2D;

public class StationaryObjects {
    
    private int x, y;
    private int width, height;

    public StationaryObjects(int x, int y, int width, int height){

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics2D g2d){
        g2d.fillRect(this.x, this.y, this.width, this.height);
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
