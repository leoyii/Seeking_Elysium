/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Main Menu for game
 * @author Glen Lin and Leo Yi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class MainMenu extends JPanel{
    MouseHandler mouseListener = new MouseHandler();
    int hoverX;
    int hoverY;
    int clickX;
    int clickY;
    int uwu = 0;

    /**
     * constructor for main menu
     */
    public MainMenu() {
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.setVisible(true);
    }

    class MouseHandler extends MouseAdapter {
        /**
         * Simulates main menu buttons
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseMoved(MouseEvent e) {
            hoverX = e.getX();
            hoverY = e.getY();
            if (hoverX > 120 && hoverX < 440 && hoverY > 545 && hoverY < 605) {
                repaint();
            } else if (hoverX > 470 && hoverX < 790 && hoverY > 545 && hoverY < 605) {
                repaint();
            } else if (hoverX > 820 && hoverX < 1140 && hoverY > 545 && hoverY < 605) {
                repaint();
            } else {
                repaint();
            }
        }

        /**
         * Simulates main menu buttons
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            clickX = e.getX();
            clickY = e.getY();
            if (clickX > 120 && clickX < 440 && clickY > 545 && clickY < 605) {
                Game.slideCount = 2;
                System.out.println(uwu);

            } else if (clickX > 470 && clickX < 790 && clickY > 545 && clickY < 605) {
                System.exit(0);
            } else if (clickX > 820 && clickX < 1140 && clickY > 545 && clickY < 605) {
                Game.slideCount = 1;
            }
            repaint();
        }
    }
    /**
     * Overrides the paintComponent method to draw the game elements on the panel.
     *
     * @param g The Graphics object for drawing.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1280, 720);
        g.setColor(Color.WHITE);
        g.fillRoundRect(65, 60, 1130, 570, 50, 50);
        g.setColor(new Color(173, 173, 173));
        g.fillRect(120, 545, 320, 60);
        g.fillRect(470, 545, 320, 60);
        g.fillRect(820, 545, 320, 60);
        g.setColor(new Color(33, 33, 33));
        g.fillRect(620, 60, 20, 200);
        g.fillRect(600, 260, 60, 40);
        g.fillRect(130, 555, 300, 40);
        g.fillRect(480, 555, 300, 40);
        g.fillRect(830, 555, 300, 40);
        g.setColor(new Color(236, 228, 85));
        g.fillRect(610, 300, 40, 40);
        g.fillOval(600, 310, 60, 60);
        Font customFont = loadCustomFont("Handodle.ttf");
        customFont = customFont.deriveFont(100f);
        g.setColor(Color.BLACK);
        g.setFont(customFont);
        g.drawString("Seeking", 240, 335);
        g.drawString("Elysium", 740, 335);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        g.drawString("Quit Game", 560, 585);
        g.drawString("New Game", 200, 585);
        g.drawString("Controls", 920, 585);

        if (hoverX > 120 && hoverX < 440 && hoverY > 545 && hoverY < 605) {
            g.setColor(new Color(33, 33, 33));
            g.fillRect(120, 545, 320, 60);
            g.setColor(new Color(173, 173, 173));
            g.fillRect(130, 555, 300, 40);
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
            g.drawString("New Game", 200, 585);
        } else if (hoverX > 470 && hoverX < 790 && hoverY > 545 && hoverY < 605) {
            g.setColor(new Color(33, 33, 33));
            g.fillRect(470, 545, 320, 60);
            g.setColor(new Color(173, 173, 173));
            g.fillRect(480, 555, 300, 40);
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
            g.drawString("Quit Game", 560, 585);
        } else if (hoverX > 820 && hoverX < 1140 && hoverY > 545 && hoverY < 605) {
            g.setColor(new Color(33, 33, 33));
            g.fillRect(820, 545, 320, 60);
            g.setColor(new Color(173, 173, 173));
            g.fillRect(830, 555, 300, 40);
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
            g.drawString("Controls", 920, 585);
        }
    }
    /**
     * Loads a custom font from the specified file path.
     *
     * @param path The file path of the custom font.
     * @return The loaded custom font if successful, or a fallback font (Arial, plain, size 12) if loading fails.
     */
    private static Font loadCustomFont(String path) {
        try {
            File fontFile = new File(path);
            return Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, 12);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            // Return a fallback font if loading fails
            return new Font("Arial", Font.PLAIN, 12);
        }
    }
    /**
     * Loads an image from a file.
     *
     * @param path The name of the image file.
     * @return The loaded image.
     */
    private static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
