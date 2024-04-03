import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class Wall {

    Color color = new Color(13, 21, 252);

    public enum direction {
        horizontal,
        vertical,
        single
    }

    private direction dir;
    private int x, y, newX, newY, width;

    public Wall(int x, int y, int newX, int newY, int width, direction dir) {
        this.x = x;
        this.y = y;
        this.newX = newX;
        this.newY = newY;
        this.width = width;
        this.dir = dir;
    }


    // Mr Myer says look into the Rectangle class and use the intersects method,
    // also just make one rectangel and then draw a lot of rectangles in screens

    public void paint(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(4));

        switch (this.dir) {
            case horizontal:
                g2d.drawLine(x, y, newX, newY);
                g2d.drawLine(x, y+this.width, newX, newY+this.width);
                break;

                
            case vertical:
                g2d.drawLine(x, y, newX, newY);
                g2d.drawLine(x+this.width, y, newX+this.width, newY);
                break;
            case single:
                g2d.drawLine(x, y, newX, newY);
                break;
        }
    }
}
