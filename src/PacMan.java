//Corvett...

//imports:
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.util.ArrayList;

public class PacMan implements Runnable, KeyListener {

    public static int WIDTH = 1000, HEIGHT = 800, GAMEUNIT = 40;
    public static int[] XGRID = new int[WIDTH/GAMEUNIT], YGRID = new int[HEIGHT/GAMEUNIT];
    //public boolean keyThread;
    private Color backgroundColor = new Color(0, 0, 0);
    private Color peletColor = new Color(255, 134, 64);
    private Screen screen = new Screen(backgroundColor);
    Blocks_Walls blocks_walls = new Blocks_Walls();
    public static Player player = new Player();
    public static ArrayList<Wall> walls = new ArrayList<>();
    public static ArrayList<StationaryObjects> blocks = new ArrayList<>();
    public static ArrayList<Integer> direction = new ArrayList<>();
    private int directionQueSize = 2;
    public static ArrayList<StationaryObjects> pelets = new ArrayList<>();
    private static int score = 0, highScore = 0, numPelet;


    /*
     *0 = right
     *1 = left
     *2 = up
     *3 = down
     */

    public void setup() {

        // Walls
        blocks_walls.setUpBlocks();
        blocks_walls.setUpWalls();

        //Making vertical lines along the x axis
        for(int i = 0; i < XGRID.length; i++){
            XGRID[i] = GAMEUNIT*i;
        }

        //Making horizontal lines along the y axis and setting up all of the pelets
        for(int i = 0; i < YGRID.length; i++){
            YGRID[i] = GAMEUNIT*i;
            for(int k = 0; k < WIDTH; k++){
                pelets.add(new Pelet(k*GAMEUNIT + GAMEUNIT/2 - 5, i*GAMEUNIT + GAMEUNIT/2 - 5, 10, peletColor));  
            }
        }
        
        //Removing any pelets that are in the wrong place
        for(int i = pelets.size() - 1; i >= 0; i--){
            if(((Pelet) pelets.get(i)).checkPeletsLocation()){
                pelets.remove(i);
            }
        }

        numPelet = pelets.size() - 1;
        System.out.println(numPelet);
        System.out.println(pelets.get(200).getX());
        System.out.println(pelets.get(200).getY());
    }


    public void move() {
        player.move();
        
    }

    public void checkCollisions() {
        player.checkCollisions(blocks, player.whatCollisions.Blocks);
        player.checkCollisions(pelets, player.whatCollisions.Pelets);
    }

    public void run() {
        while (true) {
            checkCollisions();
            move();
            screen.repaint();

            try {
                Thread.sleep(1000/30);
            } catch (InterruptedException e) {}
        }
    }

    public void Load() {
        setup();
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);
        frame.add(screen);
        frame.setFocusable(true);
        frame.setVisible(true);

        Thread t = new Thread(this);
        t.start();
    }

    public static void setScore(int b){
        score = b;
    }

    public static int getScore(){
        return score;
    }

    public static void setHighScore(int b){
        highScore = b;
    }

    public static int getHighScore(){
        return highScore;
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(direction.size() <= directionQueSize){
                direction.add(0);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(direction.size() <= directionQueSize){
                direction.add(1);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(direction.size() <= directionQueSize){
                direction.add(2);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(direction.size() <= directionQueSize){
                direction.add(3);
            }
        }
    }

    // Prolly won't use these rn
    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args) {
        PacMan PacMan = new PacMan();
        PacMan.Load();
    }
}