/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Splash Screen for game
 * @author Glen Lin and Leo Yi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;

import java.io.*;;
import javax.imageio.*;
public class SplashScreen extends JComponent{
    private static int currentAlpha = 254;
    private static boolean done = false;

    /**
     * constructor for splash screen
     */
    public SplashScreen() {
    }
    /**
     * Overrides the paintComponent method to draw the game elements on the panel.
     *
     * @param g The Graphics object for drawing.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(46, 200, 198));
        g.fillRect(0, 0, 1280, 720);
        g.setColor(new Color(33, 33, 33));
        Font customFont = loadCustomFont("font.otf");
        BufferedImage image = loadImage("image.png");
        customFont = customFont.deriveFont(250f);
        g.setFont(customFont);
        g.drawString("Rito", 550, 315);
        g.drawString("Games", 550, 515);
        g.drawImage(image, 100, 80, null);

        g.setColor(new Color(0, 0, 0, currentAlpha));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * runs animation for splash screen
     */
    public void startFadeOutAnimation() {
        Thread animationThread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 255; i++) {
                    currentAlpha--;

                    repaint();
                    Thread.sleep(500 / 60);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread animationThread2 = new Thread(() -> {
            try {
                Thread.sleep(4000);
                for (int i = 0; i < 255; i++) {
                    currentAlpha++;
                    repaint();
                    Thread.sleep(500 / 60);
                }
                done = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        animationThread1.start();
        animationThread2.start();
    }
    private static Font loadCustomFont(String path) {
        try {
            File fontFile = new File(path);
            return Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, 12);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, 12);
        }
    }
    private static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
