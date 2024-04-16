import javax.swing.JPanel;
import java.awt.Font;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Screen extends JPanel{

    public Screen(Color backgroundColor){
        this.setBackground(backgroundColor);
    }

    @Override
    public void paintComponent(Graphics g){//When I don't paint walls in screen pac-man doesnt caussually die, idk why though
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(6));
        g2d.setColor(new Color(245, 135, 135));//Pink Redish, this is the only color in pacman walls that isn't blue
        g2d.drawLine(PacMan.WIDTH / 2 - 25, PacMan.HEIGHT / 2 - 54, PacMan.WIDTH / 2 + 25, PacMan.HEIGHT / 2 - 54);

        //Single line for center Box
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.GREEN);

        //Grid
        for(int i = 0; i < PacMan.WIDTH/PacMan.GAMEUNIT; i++){
            g2d.drawLine(i*PacMan.GAMEUNIT, 0, i*PacMan.GAMEUNIT, PacMan.HEIGHT);
            g2d.drawLine(0, i*PacMan.GAMEUNIT, PacMan.WIDTH, i*PacMan.GAMEUNIT);
        }
        
        //Map out in a bunch of red rectangles then set the color to black and run the collitions method through those
        for(int i = 0; i < PacMan.blocks.size(); i++){
            PacMan.blocks.get(i).paint(g2d);
        }
        
        //Actual Blue Walls
        for(int i = 0; i < PacMan.walls.size(); i++){
            PacMan.walls.get(i).paint(g2d);
        }
        
        //For pelets
        for(int i = 0; i < PacMan.pelets.size(); i++){
            PacMan.pelets.get(i).paint(g2d);
        }
        
        PacMan.player.paint(g2d);

        //Text stuff
        g2d.setFont(new Font("Serif", Font.BOLD, 30));
        g2d.setColor(Color.WHITE);
        g2d.drawString("Score: " + PacMan.getScore(), 38, 280);
    }
}
