/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Level 1 for game
 * @author Glen Lin and Leo Yi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Level1 extends JPanel{

    private int hoverX;
    private int hoverY;
    private int clickX;
    private int clickY;
    int playerX = 600;
    int playerY = 300;
    boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false;
    int playerSprite = 2;
    int gameState = 0;
    int pressState = 0;
    /**
     * Constructor for Level1 object.
     */
    public Level1() {
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                updateMouseLocation(e.getX(), e.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                updateMouseLocation(e.getX(), e.getY());
            }
        });
    }
    /**
     * Checks the current mouse location.
     *
     * @param x The X-coordinate of the mouse location.
     * @param y The Y-coordinate of the mouse location.
     */
    private void updateMouseLocation(int x, int y) {
        String location = "Mouse Location: X=" + x + ", Y=" + y;
        //System.out.println(location);
    }
    /**
     * Moves the player based on the state of the arrow key booleans.
     */
    private void movePlayer() {
        // Move the player based on the state of the boolean variables
        System.out.println("hi");
        if (upPressed) {
            playerY -= 20;
            playerSprite = 1;
            playerY = Math.max(playerY, 36);
            if (playerX > 108 && playerX < 762) {
                playerY = Math.max(playerY, 96);
            }
            if (playerX > 900 && playerY > 268) {
                playerY = Math.max(playerY, 288);
            }
            if (playerX > 1002  && playerY > 288) {
                playerY = Math.max(playerY, 390);
            }
        }
        if (downPressed) {
            playerY += 20;
            playerSprite = 2;
            if (playerX < 190) {
                playerY = Math.min(playerY, 140);
            }
            if (playerX > 900 && playerY < 200) {
                playerY = Math.min(playerY, 138);
            }
            playerY = Math.min(playerY, 456);
        }
        if (leftPressed) {
            playerX -= 20;
            playerSprite = 3;
            if (playerY > 140) {
                playerX = Math.max(playerX, 190);
            }
            if (playerY < 96 && playerX > 300) {
                playerX = Math.max(playerX, 762);
            }
            playerX = Math.max(playerX, -20);
        }
        if (rightPressed) {
            playerX += 20;
            playerSprite = 4;
            if (playerY < 96 && playerX < 300) {
                playerX = Math.min(playerX, 108);
            }
            if (playerY >= 288 && playerY < 390) {
                playerX = Math.min(playerX, 1002);
            }
            if (playerY < 288 && playerY > 138) {
                playerX = Math.min(playerX, 900);
            }
            playerX = Math.min(playerX, 1134);
        }
        repaint();
    }
    /**
     * Overrides the paintComponent method to draw the game elements on the panel.
     *
     * @param g The Graphics object for drawing.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage bg = loadImage("level1.png");
        g.drawImage(bg, 0, 0, null);
        g.drawImage(resize(loadImage("pc.png"), 100, 100), 460, 5, null);
        g.drawImage(resize(loadImage("pill.png"), 80, 50), 1170, 430, null);
        g.drawImage(resize(loadImage("chat.png"), 70, 70), 150, 50, null);
        g.drawImage(resize(loadImage("medkit.png"), 90, 75), 600, 600, null);
        g.setColor(Color.BLACK);
        if (playerY >= 372  && playerX >= 462 && playerX <= 672) {
            g.drawImage(resize(loadImage("medkit_close.png"), 90, 75), 600, 600, null);
        }
        if (playerY <= 72 && playerX >= 24 && playerX < 150) {
            g.drawImage(resize(loadImage("chart_close.png"), 70, 70), 150, 50, null);
        }
        if (playerY < 400 && playerY > 300 && playerX >= 990) {
            g.drawImage(resize(loadImage("pill_close.png"), 80, 50), 1170, 430, null);
        }
        BufferedImage image;
        if (playerSprite == 1) {
            image = loadImage("omori_mu.png");
            image = resize(image, 150, 225);
            g.drawImage(image, 0 + playerX, 0+playerY, null);
        }
        if (playerSprite == 2) {
            image = loadImage("omori_md.png");
            image = resize(image, 150, 225);
            g.drawImage(image, 0 + playerX, 0+playerY, null);
        }
        if (playerSprite == 3) {
            image = loadImage("omori_ml.png");
            image = resize(image, 150, 225);
            g.drawImage(image, 0 + playerX, 0+playerY, null);
        }
        if (playerSprite == 4) {
            image = loadImage("omori_mr.png");
            image = resize(image, 150, 225);
            g.drawImage(image, 0 + playerX, 0+playerY, null);
        }
        System.out.println(playerX + ", " + playerY);
        if (gameState == 0) {
            movePlayer();
        }
        if (playerY <= 140) {
            BufferedImage bed = loadImage("bed.png");
            bed = resize(bed, 249, 465);
            g.drawImage(bed, 378 - 400, 247, null);
        }
        if (playerY <= 138) {
            BufferedImage desk = loadImage("desk.png");
            g.drawImage(desk,519, 39, null);
            g.drawImage(resize(loadImage("pill.png"), 80, 50), 1170, 430, null);
        }
        g.drawImage(resize(loadImage("not.png"), 117, 64), 47, 500, null);
        g.drawImage(resize(flipImageHorizontal(loadImage("door.png")), 112, 100), 1210, 570, null);
        if (playerY >= 408  && playerX >= 1110) {
            g.drawImage(resize(flipImageHorizontal(loadImage("door_close.png")), 112, 100), 1210, 570, null);
            if (gameState == 0) {
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Open Door", 900, 650);
            }
            else if (gameState == 6) {
                Game.slideCount = 4;
            }
        }
        if (playerY >= 372  && playerX >= 462 && playerX <= 672) {
            if (gameState == 0) {
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Use", 1000, 650);
            }
            else if (gameState == 5) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, 1280, 720);
                g.setColor(Color.WHITE);
                g.fillRect(100, 100, 1080, 520);
                g.setColor(Color.BLACK);
                g.fillRect(110, 110, 1060, 500);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 45));
                g.setColor(Color.WHITE);
                g.drawString("Treatments of Addiction", 120, 155);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
                g.drawString("The treatment of addiction typically involves a combination of approaches. Some common", 120, 205);
                g.drawString("methods include detoxification, therapy and medication In cases of substance addiction, ", 120, 230);
                g.drawString("the initial step is often a medically supervised detoxification process to help manage", 120, 255);
                g.drawString("withdrawal symptoms and safely remove the addictive substance from the body.", 120, 280);
                g.drawString("Various evidence-based behavioral therapies are used to address addiction. Examples are:", 120, 305);
                g.drawString("Cognitive-Behavioral Therapy (CBT): Helps individuals recognize and change patterns of", 120, 330);
                g.drawString("thinking and behavior related to addiction.", 120, 355);
                g.drawString("Motivational Interviewing (MI): A person-centered approach that explores and strengthens an", 120, 405);
                g.drawString("individual's motivation and commitment to change.", 120, 430);
                g.drawString("Contingency Management: Provides incentives or rewards for positive behaviors and", 120, 480);
                g.drawString("abstinence from substance use.", 120, 505);
                g.drawString("Medications can be used to manage withdrawal symptoms, reduce cravings and support long-", 120, 555);
                g.drawString("term recovery", 120, 580);
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Quit", 1000, 650);
            }
        }
        if (playerY <= 72 && playerX >= 24 && playerX < 150) {
            if (gameState == 0) {
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Use", 1000, 650);
            }
            else if (gameState == 4) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, 1280, 720);
                g.setColor(Color.WHITE);
                g.fillRect(100, 100, 1080, 520);
                g.setColor(Color.BLACK);
                g.fillRect(110, 110, 1060, 500);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 45));
                g.setColor(Color.WHITE);
                g.drawString("What is Addiction", 120, 155);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
                g.drawString("Addiction refers to a complex and chronic condition characterized by compulsive and", 120, 205);
                g.drawString("repetitive engagement in a behavior or use of a substance despite harmful consequences.", 120, 230);
                g.drawString("It is often associated with a loss of control and an intense craving for the substance or", 120, 255);
                g.drawString("behavior. Addiction can manifest in various forms, including substance addiction and", 120, 280);
                g.drawString("behavioral addictions. Addiction is influenced by a combination of genetic, environmental,", 120, 305);
                g.drawString("and psychological factors. It is a chronic condition that often requires ongoing", 120, 330);
                g.drawString("management and support for long-term recovery.", 120, 355);
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Quit", 1000, 650);
            }
        }
        if (playerY < 400 && playerY > 300 && playerX >= 990) {
            if (gameState == 0) {
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Use", 1000, 650);
            }
            else if (gameState == 3) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, 1280, 720);
                g.setColor(Color.WHITE);
                g.fillRect(100, 100, 1080, 520);
                g.setColor(Color.BLACK);
                g.fillRect(110, 110, 1060, 500);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 45));
                g.setColor(Color.WHITE);
                g.drawString("Drug Addiction", 120, 155);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
                g.drawString("Drug addiction is a complex and chronic condition characterized by compulsive drug-seeking", 120, 205);
                g.drawString("and drug use despite the negative consequences it has on an individual's physical, mental", 120, 230);
                g.drawString("and social well-being. It is considered a brain disorder that affects the brain's reward system,", 120, 255);
                g.drawString("leading to changes in behavior, cognition, and physiological functioning. Drug addiction", 120, 280);
                g.drawString("can stem from various factors, including genetic predisposition, environmental influences,", 120, 305);
                g.drawString("mental health conditions, and social factors. Some individuals may turn to drugs as a", 120, 330);
                g.drawString("means of coping with stress, trauma, or emotional pain.", 120, 355);
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Quit", 1000, 650);
            }
        }
        if (playerX < 200 && playerY > 350) {
            g.drawImage(resize(loadImage("note_close.png"), 117, 64), 47, 500, null);
            if (gameState == 0) {
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Use", 1000, 650);
            }
            else if (gameState == 2) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, 1280, 720);
                g.setColor(Color.WHITE);
                g.fillRect(100, 100, 1080, 520);
                g.setColor(Color.BLACK);
                g.fillRect(110, 110, 1060, 500);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 45));
                g.setColor(Color.WHITE);
                g.drawString("Signs Of Addiction", 120, 155);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
                g.drawString("There are many sign's that show that somone has an addiction. An example guideline is the", 120, 205);
                g.drawString("4 C's, representing Craving, Control Loss, Compulsion and Consequences. Craving refers", 120, 230);
                g.drawString("to the intense desire or urge to engage in the addictive substance or behavior, often driving", 120, 255);
                g.drawString("individuals towards seeking fulfillment through the addiction. Control loss signifies the", 120, 280);
                g.drawString("inability to maintain control or set limits on the addictive behavior despite efforts to do so.", 120, 305);
                g.drawString("Compulsion involves the feeling of being driven or compelled to engage in the addictive", 120, 330);
                g.drawString("behavior, often resulting in a loss of autonomy and the inability to resist the urges. Finally,", 120, 355);
                g.drawString("consequences represent the negative outcomes and impacts that addiction has on an", 120, 380);
                g.drawString("individual's life such as health problems, strained relationships and emotional distress", 120, 405);
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Quit", 1000, 650);
            }
        }
        if (playerX > 350 && playerX < 530 && playerY < 150) {
            g.drawImage(resize(loadImage("pc_close.png"), 100, 100), 460, 5, null);
            if (gameState == 0) {
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Use", 1000, 650);
            }
            else if (gameState == 1) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, 1280, 720);
                g.setColor(Color.WHITE);
                g.fillRect(100, 100, 1080, 520);
                g.setColor(Color.BLACK);
                g.fillRect(110, 110, 1060, 500);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 45));
                g.setColor(Color.WHITE);
                g.drawString("Internet Addiction", 120, 155);

                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
                g.drawString("Internet addiction refers to the compulsive and excessive use of the internet, leading to ", 120, 205);
                g.drawString("negative consequences on an individual's physical, mental, and social well-being. It has ", 120, 230);
                g.drawString("become a prevalent issue in today's digital age. There are several causes that contribute ", 120, 255);
                g.drawString("to internet addiction. Firstly, the easy accessibility and availability of the internet make ", 120, 280);
                g.drawString("it tempting to spend a significant amount of time online. Additionally, factors like social", 120, 305);
                g.drawString("isolation, loneliness, underlying mental health issues, and the desire for constant stimulation", 120, 330);
                g.drawString("and gratification can contribute to the development of internet addiction.", 120, 355);
                g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                g.setColor(Color.WHITE);
                g.drawString("Press 'E' to Quit", 1000, 650);
            }
        }
        if (Game.paused) {
            Game.pause.paintComponent(g);
            repaint();
        } else {
            repaint();
        }
    }

    /**
     * Resizes an image to the specified dimensions.
     *
     * @param originalImage The image to resize.
     * @param newHeight The desired width of the image.
     * @param newWidth The desired height of the image.
     * @return The resized image.
     */
    public static BufferedImage resize(BufferedImage originalImage, int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        return resizedImage;
    }
    /**
     * Flips an image horizontally.
     *
     * @param originalImage The image to flip.
     * @return The flipped image.
     */
    public static BufferedImage flipImageHorizontal(BufferedImage originalImage) {
        AffineTransform flip = AffineTransform.getScaleInstance(-1, 1);
        flip.translate(-originalImage.getWidth(), 0);
        AffineTransformOp flipOperation = new AffineTransformOp(flip, AffineTransformOp.TYPE_BILINEAR);
        return flipOperation.filter(originalImage, null);
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
