public class Blocks_Walls {
    
    //This class sets up both blocks and walls, prepare your eyes for many, many magic numbers
    public void setUpBlocks(){

        //Center Block
        PacMan.blocks.add(new Block(PacMan.WIDTH/2 - PacMan.GAMEUNIT*3 + PacMan.GAMEUNIT/2, PacMan.HEIGHT/2 - PacMan.GAMEUNIT*2, PacMan.GAMEUNIT*5, PacMan.GAMEUNIT*3));

        //Top Left Wall
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT/4, PacMan.HEIGHT/2 - PacMan.GAMEUNIT - 10, PacMan.GAMEUNIT*5 + PacMan.GAMEUNIT/2, 10));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT*6 - 10, PacMan.HEIGHT/2 - PacMan.GAMEUNIT*4, 10, PacMan.GAMEUNIT*3));
        PacMan.blocks.add(new Block(PacMan.GAMEUNIT - 10, PacMan.HEIGHT/2 - PacMan.GAMEUNIT*4, PacMan.GAMEUNIT*5 + 10, 10));
    }

    public void setUpWalls(){

    }
}
