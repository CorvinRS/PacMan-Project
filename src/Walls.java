import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

public class Walls {

    Color color = new Color(13, 21, 252);
    Path2D.Double p = new Path2D.Double();

    public enum direction {
        horizontal,
        vertical,
        single
    }

    private direction dir;
    private int x, y, newX, newY, width;

    public Walls(int x, int y, int newX, int newY, int width, direction dir) {
        this.x = x;
        this.y = y;
        this.newX = newX;
        this.newY = newY;
        this.width = width;
        this.dir = dir;
    }

    public void checkCollisions() {

        
    }

    // Mr Myer says look into the Rectangle class and use the intersects method,
    // also just make one rectangel and then draw a lot of rectangles in screens

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(color);
        g2d.setStroke(new BasicStroke(4));

        switch (this.dir) {
            case horizontal:
                p.moveTo(x, y);
                p.lineTo(newX, newY);
                p.moveTo(x, y + this.width);
                p.lineTo(newX, newY + this.width);
                g2d.draw(p);
                break;

            case vertical:
                p.moveTo(x, y);
                p.lineTo(newX, newY);
                p.moveTo(x + this.width, y);
                p.lineTo(newX + this.width, newY);
                g2d.draw(p);
                break;
            case single:
                p.moveTo(x, y);
                p.lineTo(newX, newY);
                g2d.draw(p);
                break;
        }
    }
}
