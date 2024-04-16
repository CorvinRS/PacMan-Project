import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends StationaryObjects{
    

    public Block(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    @Override
    public void paint(Graphics2D g2d){
       g2d.setColor(Color.RED);
       super.paint(g2d);
    }

    
}
