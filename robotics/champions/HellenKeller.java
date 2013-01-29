package robotics.champions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class HellenKeller extends Champion {

    public HellenKeller(String image, int health, int max, Point point) {
        super(health, max, point);
        try {
            this.image = ImageIO.read(new URL(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
