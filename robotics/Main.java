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
        gamePanel.setFocusable(true);
        gamePanel.addKeyListener(gamePanel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds((int) toolKit.getScreenSize().getWidth() / 2 - 400, (int) toolKit.getScreenSize().getHeight() / 2 - 350, 800, 700);
        frame.add(gamePanel);
        Game.champion1 = new HellenKeller("images\\hellendefaul.jpg",1 ,4, 4, new Point(0,0));

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
