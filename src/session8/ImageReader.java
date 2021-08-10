package session8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ImageReader {

    public static void displayImage(String path) throws IOException {
        final BufferedImage image = ImageIO.read(new File(path));
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        JFrame frame = new JFrame("IMAGE DISPLAY");
        frame.add(label);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        String path = "D:/image.jfif";
        try {
            displayImage(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
