package com.example;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Drawer {
    public static void main(String[] args) throws IOException {

        int width = 1000;
        int height = width;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.BLACK);
        for (int multi = 1; multi < 700;) {
            multi = multi +5;
            for (int x = 1; x <= width; x++) {

                int y = (int) (Math.sin(x+multi) * multi);
                y = width / 2 - y;
                g2d.fillOval(x, y, 5, 5);
            }
        }
        File file = new File("myimage.jpg");
        ImageIO.write(bufferedImage, "jpg", file);
    }
}
