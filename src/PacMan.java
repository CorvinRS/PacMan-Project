//Corvett...

//imports:
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.util.ArrayList;

public class PacMan implements Runnable, KeyListener {

    public static int WIDTH = 1000, HEIGHT = 800;
    private Color backgroundColor = new Color(0, 0, 0);
    private Screen screen = new Screen(backgroundColor);
    public static Player player = new Player();
    public static ArrayList<Walls> wall = new ArrayList<>();
    public static ArrayList<Block> blocks = new ArrayList<>();
    // public static Walls walls = new Walls();

    public void setup() {

        // Walls
        screen.setUpBlocks();
        screen.setUpWalls();

    }

    public void move() {
        player.move();
    }

    public void checkCollisions() {

        player.checkCollisions();
    }

    public void run() {

        while (true) {
            screen.repaint();
            move();
            checkCollisions();

            try {
                Thread.sleep(1000 / 30);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void start() {
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
        // new Timer(1000/60, new ActionListener() {
        // public void actionPerformed(ActionEvent e){

        // screen.repaint();
        // move();
        // checkCollisions();

        // }
        // }).start();
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setDirectionRight();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setDirectionLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.setDirectionUp();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setDirectionDown();
        }
    }

    // Prolly won't use these rn
    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args) {
        PacMan PacMan = new PacMan();
        PacMan.start();
    }
}