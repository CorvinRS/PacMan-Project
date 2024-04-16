import java.awt.Color;

import java.awt.Graphics2D;

public class Pelet extends StationaryObjects{
    
    
    private int x, y, size;
    private Color color;

    public Pelet(int x, int y, int size, Color color){
        super(x, y, size, size);
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void paint(Graphics2D g2d){
        g2d.setColor(this.color);
        g2d.fillOval(this.x, this.y, this.size, this.size);
    }


    //The method that checks if the pelets are in the wrong area
    public boolean checkPeletsLocation(){

        if(this.x < PacMan.GAMEUNIT || this.x > PacMan.WIDTH - PacMan.GAMEUNIT){
            return true;
        }

        if(this.y < PacMan.GAMEUNIT || this.y > PacMan.HEIGHT - PacMan.GAMEUNIT*2){
            return true;
        }

        if((this.x < PacMan.GAMEUNIT*5) 
            &&this.y > PacMan.GAMEUNIT*6 
            && this.y < PacMan.GAMEUNIT*13){
                return true;
        }

        if((this.x > PacMan.GAMEUNIT*20) 
            &&this.y > PacMan.GAMEUNIT*6 
            && this.y < PacMan.GAMEUNIT*13){
                return true;
        }

        for(int i = 0; i < PacMan.blocks.size(); i++){
            if(this.x + this.size > PacMan.blocks.get(i).getX() 
                && this.x < PacMan.blocks.get(i).getX() + PacMan.blocks.get(i).getWidth()
                && this.y + this.size > PacMan.blocks.get(i).getY()
                && this.y < PacMan.blocks.get(i).getY() + PacMan.blocks.get(i).getHeight()){
                return true;
            }
        }
        return false;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getSize(){
        return this.size;
    }
}
