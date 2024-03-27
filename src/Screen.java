import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.security.cert.PKIXReason;

public class Screen extends JPanel{

    public Screen(Color backgroundColor){
        this.setBackground(backgroundColor);
    }

    public void setUpBlocks(){

        PacMan.blocks.add(new Block(500, 500, 60, 60));
    }

    public void setUpWalls(){

        //Center Box
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 - 80, PacMan.HEIGHT / 2 - 58, PacMan.WIDTH / 2 - 10, PacMan.HEIGHT / 2 - 58, 8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 - 10, PacMan.HEIGHT / 2 - 58, PacMan.WIDTH / 2 - 10, PacMan.HEIGHT / 2 - 50, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 - 80, PacMan.HEIGHT / 2 - 58, PacMan.WIDTH / 2 - 90, PacMan.HEIGHT / 2 - 58, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 - 90, PacMan.HEIGHT / 2 - 58, PacMan.WIDTH / 2 - 90, PacMan.HEIGHT / 2 - 50, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 - 90, PacMan.HEIGHT / 2 - 50, PacMan.WIDTH / 2 - 90, PacMan.HEIGHT / 2 + 38,  8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 - 90, PacMan.HEIGHT / 2 + 38, PacMan.WIDTH / 2 - 90, PacMan.HEIGHT / 2 + 48,  8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 - 90, PacMan.HEIGHT / 2 + 50, PacMan.WIDTH / 2 - 82, PacMan.HEIGHT / 2 + 50,  8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 - 82, PacMan.HEIGHT / 2 + 42, PacMan.WIDTH / 2 + 110, PacMan.HEIGHT / 2 + 42,  8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 110, PacMan.HEIGHT / 2 + 50, PacMan.WIDTH / 2 + 120, PacMan.HEIGHT / 2 + 50, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 120, PacMan.HEIGHT / 2  + 50, PacMan.WIDTH / 2 + 120, PacMan.HEIGHT / 2  + 42, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 112, PacMan.HEIGHT / 2  + 42, PacMan.WIDTH / 2 + 112, PacMan.HEIGHT / 2  - 48, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 120, PacMan.HEIGHT / 2  - 48, PacMan.WIDTH / 2 + 120, PacMan.HEIGHT / 2  - 58, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 120, PacMan.HEIGHT / 2  - 58, PacMan.WIDTH / 2 + 112, PacMan.HEIGHT / 2  - 58, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 112, PacMan.HEIGHT / 2  - 58, PacMan.WIDTH / 2 + 50, PacMan.HEIGHT / 2  - 58, 8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 50, PacMan.HEIGHT / 2  - 58, PacMan.WIDTH / 2 + 50, PacMan.HEIGHT / 2  - 50, 8, Walls.direction.single));

        //Top Left outside wall
        //Chords for entrence to left side of the screen, still apart of Top left wall
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT / 2 - 30, 188, PacMan.HEIGHT / 2 - 30, 8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(188, PacMan.HEIGHT / 2 - 22, 198, PacMan.HEIGHT / 2 - 22, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(198, PacMan.HEIGHT / 2 - 22, 198, PacMan.HEIGHT / 2 - 30, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(190, PacMan.HEIGHT / 2 - 130, 190, PacMan.HEIGHT / 2 - 30, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(198, PacMan.HEIGHT / 2 - 130, 198, PacMan.HEIGHT / 2 - 138, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(198, PacMan.HEIGHT / 2 - 140, 190, PacMan.HEIGHT / 2 - 140, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(190, PacMan.HEIGHT / 2 - 140, 18, PacMan.HEIGHT / 2 - 140, 8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(18, PacMan.HEIGHT / 2 - 132, 8, PacMan.HEIGHT / 2 - 132, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT / 2 - 132, 8, PacMan.HEIGHT / 2 - 140, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT / 2 - 140, 8, 18, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(8, 18, 8, 8, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(8, 8, 16, 8, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(16, 8, PacMan.WIDTH / 2 + 10, 8, 8, Walls.direction.horizontal));

        //Top Center Wall
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 10, 8, PacMan.WIDTH / 2 + 35, 8, 120, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 10, 18, PacMan.WIDTH / 2 + 10, 128, 25, Walls.direction.vertical));

        //Top Right Outside wall
        PacMan.wall.add(new Walls(PacMan.WIDTH / 2 + 35, 8, PacMan.WIDTH - 16, 8, 8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 16, 8, PacMan.WIDTH - 8, 8, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 8, 8, PacMan.WIDTH - 8, 18, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 16, 18, PacMan.WIDTH - 16, PacMan.HEIGHT / 2 - 138, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 8, PacMan.HEIGHT / 2 - 138, PacMan.WIDTH - 8, PacMan.HEIGHT / 2 - 130, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 8, PacMan.HEIGHT / 2 - 130, PacMan.WIDTH - 16, PacMan.HEIGHT / 2 - 130, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 16, PacMan.HEIGHT / 2 - 138, PacMan.WIDTH - 196, PacMan.HEIGHT / 2 - 138, 8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 196, PacMan.HEIGHT / 2 - 138, PacMan.WIDTH - 206, PacMan.HEIGHT / 2 - 138, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 206, PacMan.HEIGHT / 2 - 138, PacMan.WIDTH - 206, PacMan.HEIGHT / 2 - 130, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 206, PacMan.HEIGHT / 2 - 130, PacMan.WIDTH - 206, PacMan.HEIGHT / 2 - 30, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 206, PacMan.HEIGHT / 2 - 30, PacMan.WIDTH - 206, PacMan.HEIGHT / 2 - 22, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 206, PacMan.HEIGHT / 2 - 22, PacMan.WIDTH - 198, PacMan.HEIGHT / 2 - 22, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 198, PacMan.HEIGHT / 2 - 30, PacMan.WIDTH - 8, PacMan.HEIGHT / 2 - 30, 8, Walls.direction.horizontal));

        //Bottom Left Outside wall
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT / 2 + 35, 188, PacMan.HEIGHT / 2 + 35, 8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(188, PacMan.HEIGHT / 2 + 35,  196, PacMan.HEIGHT / 2 + 35,8, Walls.direction.single));
        PacMan.wall.add(new Walls(196, PacMan.HEIGHT / 2 + 35, 196, PacMan.HEIGHT / 2 + 45, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(188, PacMan.HEIGHT / 2 + 45, 188, PacMan.HEIGHT / 2 + 145, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(196, PacMan.HEIGHT / 2 + 145, 196, PacMan.HEIGHT / 2 + 153, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(196, PacMan.HEIGHT / 2 + 155, 188, PacMan.HEIGHT / 2 + 155, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(18, PacMan.HEIGHT / 2 + 147, 188, PacMan.HEIGHT / 2 + 147, 8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(18, PacMan.HEIGHT / 2 + 147, 8, PacMan.HEIGHT / 2 + 147, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT / 2 + 147, 8, PacMan.HEIGHT / 2 + 155, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT / 2 + 155, 8, PacMan.HEIGHT / 2 + 225, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT / 2 + 225, 8, PacMan.HEIGHT / 2 + 245, 75, Walls.direction.vertical));
        PacMan.wall.add(new Walls(16, PacMan.HEIGHT / 2 + 225, 83, PacMan.HEIGHT / 2 + 225, 20, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT / 2 + 245, 8, PacMan.HEIGHT - 48, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT - 48, 8, PacMan.HEIGHT - 40, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(8, PacMan.HEIGHT - 40, 16, PacMan.HEIGHT - 40, 8, Walls.direction.single));

        //Bottom Outside Wall
        PacMan.wall.add(new Walls(16, PacMan.HEIGHT - 48, PacMan.WIDTH - 16, PacMan.HEIGHT - 48, 8, Walls.direction.horizontal));

        //Bottom Right Outside wall
        PacMan.wall.add(new Walls(PacMan.WIDTH - 16, PacMan.HEIGHT - 40, PacMan.WIDTH - 8, PacMan.HEIGHT - 40, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 8, PacMan.HEIGHT - 40, PacMan.WIDTH - 8, PacMan.HEIGHT - 48, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 16, PacMan.HEIGHT - 48, PacMan.WIDTH - 16, PacMan.HEIGHT / 2 + 245, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 83, PacMan.HEIGHT / 2 + 225, PacMan.WIDTH - 83, PacMan.HEIGHT / 2 + 245, 75, Walls.direction.vertical));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 16, PacMan.HEIGHT / 2 + 225, PacMan.WIDTH - 83, PacMan.HEIGHT / 2 + 225, 20, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 16, PacMan.HEIGHT / 2 + 225, PacMan.WIDTH - 16, PacMan.HEIGHT / 2 + 155, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 8, PacMan.HEIGHT / 2 + 155, PacMan.WIDTH - 8, PacMan.HEIGHT / 2 + 147, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 8, PacMan.HEIGHT / 2 + 147, PacMan.WIDTH - 16, PacMan.HEIGHT / 2 + 147, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 16, PacMan.HEIGHT / 2 + 147, PacMan.WIDTH - 198, PacMan.HEIGHT / 2 + 147, 8, Walls.direction.horizontal));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 198, PacMan.HEIGHT / 2 + 155, PacMan.WIDTH - 206, PacMan.HEIGHT / 2 + 155, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 206, PacMan.HEIGHT / 2 + 155, PacMan.WIDTH - 206, PacMan.HEIGHT / 2 + 147, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 206, PacMan.HEIGHT / 2 + 147, PacMan.WIDTH - 206, PacMan.HEIGHT / 2 + 55, 8, Walls.direction.vertical));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 206, PacMan.HEIGHT / 2 + 55, PacMan.WIDTH - 206, PacMan.HEIGHT / 2 + 47, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 206, PacMan.HEIGHT / 2 + 47, PacMan.WIDTH - 198, PacMan.HEIGHT / 2 + 47, 8, Walls.direction.single));
        PacMan.wall.add(new Walls(PacMan.WIDTH - 198, PacMan.HEIGHT / 2 + 47, PacMan.WIDTH - 8, PacMan.HEIGHT / 2 + 47, 8, Walls.direction.horizontal));


    }

    @Override
    public void paintComponent(Graphics g){//When I don't paint walls in screen pac-man doesnt caussually die, idk why though
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;

        Path2D.Double whiteLine = new Path2D.Double();
        g2d.setStroke(new BasicStroke(6));
        g.setColor(new Color(245, 135, 135));//Pink Redish, this is the only color in pacman walls that isn't blue
        whiteLine.moveTo(PacMan.WIDTH / 2 - 5, PacMan.HEIGHT / 2 - 54);
        whiteLine.lineTo(PacMan.WIDTH / 2 + 45, PacMan.HEIGHT / 2 - 54);
        g2d.draw(whiteLine);

        //Map out in a bunch of red rectangles then set the color to black and run the collitions method through those
        for(int i = 0; i < PacMan.blocks.size(); i++){
            PacMan.blocks.get(i).paint(g);
        }

        for(int i = 0; i < PacMan.wall.size(); i++){
            PacMan.wall.get(i).paint(g);
        }

        // g.setColor(Color.RED);
        // g.fillRect(8, PacMan.HEIGHT / 2 - 30, PacMan.WIDTH, 10);

        
    
        PacMan.player.paint(g2d);
        

    }
}
