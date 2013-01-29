package robotics;

import robotics.champions.HellenKeller;
import robotics.components.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

public class Main {

    private static JFrame frame;
    private static Toolkit toolKit;
    private static GamePanel gamePanel;
    private static Thread drawThread;
    private static Game game;

    public static void main(String... args) {
        toolKit = Toolkit.getDefaultToolkit();
        frame = new JFrame();
        gamePanel = new GamePanel();
        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("hello");
                int x1 = (int) Game.champion1.getX();
                int y1 = (int) Game.champion1.getY();
                System.out.println("tried to change position to: " + x1 + ", " + y1);
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    Game.champion1.put(x1, y1 - 1);
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    Game.champion1.put(x1 - 1, y1);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    Game.champion1.put(x1, y1 + 1);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    Game.champion1.put(x1 + 1, y1);

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds((int) toolKit.getScreenSize().getWidth() / 2 - 400, (int) toolKit.getScreenSize().getHeight() / 2 - 350, 800, 700);
        frame.add(gamePanel);
        Game.champion1 = new HellenKeller("http://www2.lhric.org/pocantico/womenenc/keller3.jpg",4,4, new Point(0,0));

        frame.setVisible(true);
        drawThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                gamePanel.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        drawThread.start();
    }

    public static Game getGame() {
        return game;
    }


}
