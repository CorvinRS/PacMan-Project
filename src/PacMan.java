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
    private Screen screen = new Screen(backgroundColor);
    Blocks_Walls blocks_walls = new Blocks_Walls();
    public static Player player = new Player();
    public static ArrayList<Wall> walls = new ArrayList<>();
    public static ArrayList<Block> blocks = new ArrayList<>();
    public static ArrayList<Integer> direction = new ArrayList<>();

    /*
     *1 = right
     *2 = right
     *3 = up
     *4 = down
     */

    public void setup() {

        // Walls
        blocks_walls.setUpBlocks();
        blocks_walls.setUpWalls();

        for(int i = 0; i < XGRID.length; i++){
            XGRID[i] = GAMEUNIT*i;
        }

        for(int i = 0; i < YGRID.length; i++){
            YGRID[i] = GAMEUNIT*i;
        }
    }

    public void move() {
        player.move();
    }

    public void checkCollisions() {
        player.checkCollisions();
    }

    public void run() {
        while (true) {
            move();
            checkCollisions();
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

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(direction.size() <= 2){
                direction.add(1);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(direction.size() <= 2){
                direction.add(2);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(direction.size() <= 2){
                direction.add(3);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(direction.size() <= 2){
                direction.add(4);
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