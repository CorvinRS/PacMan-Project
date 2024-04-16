

public class Blocks_Walls {
    
    //This class sets up both blocks and walls, prepare your eyes for many, many magic numbers
    public void setUpBlocks(){

        //Center Block
        PacMan.blocks.add(new Block(PacMan.WIDTH/2 - PacMan.GAMEUNIT*5 + PacMan.GAMEUNIT/2, PacMan.HEIGHT/2 - PacMan.GAMEUNIT*2, PacMan.GAMEUNIT*9, PacMan.GAMEUNIT*3));

        //Top Left Wall
        PacMan.blocks.add(new Block(-PacMan.GAMEUNIT, PacMan.HEIGHT/2 - PacMan.GAMEUNIT - 10, PacMan.GAMEUNIT*6, 10));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*5 - 10, PacMan.HEIGHT/2 - PacMan.GAMEUNIT*4, 10, PacMan.GAMEUNIT*3));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT - 10, PacMan.HEIGHT/2 - PacMan.GAMEUNIT*4, PacMan.GAMEUNIT*4 + 10, 10));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT - 10, PacMan.GAMEUNIT - 10, 10, PacMan.GAMEUNIT*5 + 10));

        //Top Wall
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT - 10, PacMan.GAMEUNIT - 10, PacMan.WIDTH - PacMan.GAMEUNIT - 20, 10));
        PacMan.blocks.add(new Block(PacMan.WIDTH/2 - PacMan.GAMEUNIT/2, PacMan.GAMEUNIT, PacMan.GAMEUNIT, PacMan.GAMEUNIT*2));

        //Top Right Wall
        PacMan.blocks.add(new Block(PacMan.WIDTH - PacMan.GAMEUNIT, PacMan.GAMEUNIT, 10, PacMan.GAMEUNIT*5 + 10));
        PacMan.blocks.add(new Block(PacMan.WIDTH - PacMan.GAMEUNIT*5, PacMan.GAMEUNIT*6, PacMan.GAMEUNIT*4, 10));
        PacMan.blocks.add(new Block(PacMan.WIDTH - PacMan.GAMEUNIT*5, PacMan.GAMEUNIT*6, 10, PacMan.GAMEUNIT*3));
        PacMan.blocks.add(new Block(PacMan.WIDTH - PacMan.GAMEUNIT*5, PacMan.HEIGHT/2 - PacMan.GAMEUNIT - 10, PacMan.GAMEUNIT*7, 10));

        //Bottom Left Wall
        PacMan.blocks.add(new Block(-PacMan.GAMEUNIT, PacMan.HEIGHT/2, PacMan.GAMEUNIT*6, 10));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*4 + PacMan.GAMEUNIT/2 + 10, PacMan.HEIGHT/2, 10, PacMan.GAMEUNIT*3));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT - 10, PacMan.HEIGHT/2 + PacMan.GAMEUNIT*3 - 10, PacMan.GAMEUNIT*4, 10));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT - 10, PacMan.HEIGHT/2 + PacMan.GAMEUNIT*3 - 10, 10, PacMan.GAMEUNIT*5 + 20));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT , PacMan.HEIGHT/2 + (PacMan.GAMEUNIT*12)/2, PacMan.GAMEUNIT*2, PacMan.GAMEUNIT));

        //Bottom Line
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT - 10, PacMan.HEIGHT - PacMan.GAMEUNIT*2, PacMan.WIDTH - PacMan.GAMEUNIT - 20, 10));

        //Bottom Right wall
        PacMan.blocks.add(new Block(PacMan.WIDTH - PacMan.GAMEUNIT, PacMan.HEIGHT/2 + PacMan.GAMEUNIT*3 - 10, 10, PacMan.GAMEUNIT*5 + 20));
        PacMan.blocks.add(new Block(PacMan.WIDTH - PacMan.GAMEUNIT*3, PacMan.HEIGHT - PacMan.GAMEUNIT*4, PacMan.GAMEUNIT*2, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.WIDTH - PacMan.GAMEUNIT*5, PacMan.HEIGHT/2 + PacMan.GAMEUNIT*3 - 10, PacMan.GAMEUNIT*4, 10));
        PacMan.blocks.add(new Block(PacMan.WIDTH - PacMan.GAMEUNIT*5, PacMan.HEIGHT/2, 10, PacMan.GAMEUNIT*3));
        PacMan.blocks.add(new Block(PacMan.WIDTH - PacMan.GAMEUNIT*5, PacMan.HEIGHT/2, PacMan.GAMEUNIT*7, 10));

        //Top Row of obsticals
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*2, PacMan.GAMEUNIT*2, PacMan.GAMEUNIT*3, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*6, PacMan.GAMEUNIT*2, PacMan.GAMEUNIT*5, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.WIDTH/2 + PacMan.GAMEUNIT*2 - 20, PacMan.GAMEUNIT*2, PacMan.GAMEUNIT*5, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.WIDTH/2 + PacMan.GAMEUNIT*8 - 20, PacMan.GAMEUNIT*2, PacMan.GAMEUNIT*3, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*2, PacMan.GAMEUNIT*4, PacMan.GAMEUNIT*3, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.WIDTH/2 + PacMan.GAMEUNIT*8 - 20, PacMan.GAMEUNIT*4, PacMan.GAMEUNIT*3, PacMan.GAMEUNIT));

        //MidTop Row of obsticals
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*6, PacMan.GAMEUNIT*4, PacMan.GAMEUNIT, PacMan.GAMEUNIT*5));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*7, PacMan.GAMEUNIT*6, PacMan.GAMEUNIT*4, PacMan.GAMEUNIT));

        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*8, PacMan.GAMEUNIT*4, PacMan.GAMEUNIT*9, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*12, PacMan.GAMEUNIT*5, PacMan.GAMEUNIT, PacMan.GAMEUNIT*2));

        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*18, PacMan.GAMEUNIT*4, PacMan.GAMEUNIT, PacMan.GAMEUNIT*5));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*14, PacMan.GAMEUNIT*6, PacMan.GAMEUNIT*5, PacMan.GAMEUNIT));

        //Bottom Middle Row of Obsticals
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*6, PacMan.GAMEUNIT*10, PacMan.GAMEUNIT, PacMan.GAMEUNIT*3));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*18, PacMan.GAMEUNIT*10, PacMan.GAMEUNIT, PacMan.GAMEUNIT*3));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*8, PacMan.GAMEUNIT*12, PacMan.GAMEUNIT*9, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*12, PacMan.GAMEUNIT*13, PacMan.GAMEUNIT, PacMan.GAMEUNIT*2));

        //Bottom Row of Obsticals
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*2, PacMan.GAMEUNIT*14, PacMan.GAMEUNIT*3, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*4, PacMan.GAMEUNIT*15, PacMan.GAMEUNIT, PacMan.GAMEUNIT*2));

        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*6, PacMan.GAMEUNIT*14, PacMan.GAMEUNIT*5, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*14, PacMan.GAMEUNIT*14, PacMan.GAMEUNIT*5, PacMan.GAMEUNIT));

        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*20, PacMan.GAMEUNIT*14, PacMan.GAMEUNIT*3, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*20, PacMan.GAMEUNIT*15, PacMan.GAMEUNIT, PacMan.GAMEUNIT*2));

        //Bottom Line of Obsticals
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*6, PacMan.GAMEUNIT*16, PacMan.GAMEUNIT, PacMan.GAMEUNIT*2));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*8, PacMan.GAMEUNIT*16, PacMan.GAMEUNIT*9, PacMan.GAMEUNIT));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*18, PacMan.GAMEUNIT*16, PacMan.GAMEUNIT, PacMan.GAMEUNIT*2));
    }

    public void setUpWalls(){

    }
}
