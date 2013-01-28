package robotics.components;

import robotics.Game;
import robotics.Main;
import robotics.champions.Champion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GamePanel extends JPanel implements KeyListener {
    private static ArrayList<Champion> champions = new ArrayList<Champion>();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Game.champion1.getImage(), (int) Game.champion1.getX(), (int) Game.champion1.getY(), null);
}

    public static ArrayList<Champion> getChampions() {
        return champions;
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x1 = (int) Game.champion1.getX();
        int y1 = (int) Game.champion1.getY();
        int speed = Game.champion1.getSpeed();
        System.out.println(e.getKeyCode() + "  " + e.getKeyChar());
        if (e.getKeyCode() == KeyEvent.VK_W) {
            Game.champion1.put(x1, y1 - speed);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            Game.champion1.put(x1 - speed, y1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            Game.champion1.put(x1, y1 + speed);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            Game.champion1.put(x1 + speed, y1);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
