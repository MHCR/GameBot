package robotics.champions;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Champion {
    private int health;
    private int maxHealth;
    private Point point;
    protected BufferedImage image;

    public Champion(int health, int max, Point point) {
        this.point = point;
        this.health = health;
        this.maxHealth = max;
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

}
