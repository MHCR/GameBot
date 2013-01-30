package robotics.champions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Champion {
    protected int health;
    protected int maxHealth;
    private Point point;
    protected BufferedImage image;
    protected int speed;

    public Champion(String image, int speed, int health, int max, Point point) {
        new File(image);
        try {
            this.image = ImageIO.read(this.getClass().getResource(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.speed = speed * 3;
        this.point = point;
        this.health = health;
        this.maxHealth = max;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHpPercent() {
        return health / maxHealth;
    }

    public void put(int x, int y) {
        put(new Point(x, y));
    }

    public double getX() {
        return point.getX();
    }

    public double getY() {
        return point.getY();
    }

    public void put(Point point) {
        this.point = point;
    }

    public BufferedImage getImage() {
        return image;
    }


    public int getSpeed() {
        return speed;
    }
}
