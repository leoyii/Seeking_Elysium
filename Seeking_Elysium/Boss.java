/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Boss level for game
 * @author Glen Lin and Leo Yi
 */
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Boss extends JPanel{

	MouseHandler mouseListener = new MouseHandler();
	int bossHP = 100, playerHP = 100;
	int count = 0;
	int clickX, clickY, hoverX, hoverY;
	BufferedImage bossImg;
	boolean isAttacking;
	boolean bossAttacking;
	boolean isGivingUp;
	boolean win;
	String answer;
	String attackMessage;

	ArrayList<String> questions = new ArrayList<String>();
	ArrayList<String> options = new ArrayList<String>();
	ArrayList<String> answers = new ArrayList<String>();
	/**
	 * Constructor for the Boss class.
	 * Initializes the boss battle and sets up the questions, options, and answers.
	 */
	public Boss() {
		this.setBackground(new Color(33, 33, 33));
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
		questions.clear();
		options.clear();
		answers.clear();
		questions.add("Which of the following is NOT a way to treat addiction?");
		options.add("a) Therapy");
		options.add("b) Eating");
		options.add("c) Medication");
		options.add("d) Supervised Detoxification");
		answers.add("b) Eating");
		questions.add("Which of the following is one of the 4 Cs for signs and symptoms of addiction?");
		options.add("a) craving");
		options.add("b) cancer");
		options.add("c) constraint");
		options.add("d) clever");
		answers.add("a) craving");
		questions.add("Fill in the blank: Addiction refers to the problematic use of _______.");
		options.add("a) power");
		options.add("b) hands");
		options.add("c) substances");
		options.add("d) guns");
		answers.add("c) substances");
		questions.add("What type of addiction has become a prevalent in today's DIGITAL age.");
		options.add("a) Eating");
		options.add("b) Gambling");
		options.add("c) Internet");
		options.add("d) Drug");
		answers.add("c) Internet");
		questions.add("What does CBT stand for?");
		options.add("a) Computer Based Tutorial");
		options.add("b) Cabbage Bacon Tomato");
		options.add("c) Creative Brain Thinking");
		options.add("d) Cognative-Behavorial Therapy");
		answers.add("d) Cognative-Behavorial Therapy");
		questions.add("Which of the following means: A person-centered approach that explores and strengthens an individual's motivation and commitment to change.");
		options.add("a) Motivational Interviewing");
		options.add("b) Self Love");
		options.add("c) Narcissism");
		options.add("d) Culminative Exploration");
		answers.add("a) Motivational Interviewing");
		questions.add("_______ Management provides incentives or rewards for positive behaviors and abstinence from substance use.");
		options.add("a) Product");
		options.add("b) Waste");
		options.add("c) Contingency");
		options.add("d) Time");
		answers.add("c) Contingency");
		questions.add("Addction is influenced by a combination of 3 factors, which is NOT a factor?");
		options.add("a) Environmental");
		options.add("b) Lack of Sleep");
		options.add("c) Hereditary");
		options.add("d) Psychological");
		answers.add("b) Lack of Sleep");
	}
	/**
	 * Checks if the player or the boss has won the battle.
	 * Updates the win status and stops the attack animations if necessary.
	 */
	public void win() {
		if (playerHP < 0) {
			playerHP = 0;
			repaint();
		}
		if (bossHP < 0) {
			bossHP = 0;
			repaint();
		}
		if (bossHP == 0) {
			win = true;
			isAttacking = false;
			bossAttacking = false;
		} else if (playerHP == 0) {
			win = false;
			isAttacking = false;
			bossAttacking = false;
		}
	}
	/**
	 * Handles mouse events for the boss battle.
	 */
	class MouseHandler extends MouseAdapter {
		/**
		 * Handles the mouseClicked event.
		 * Retrieves the x and y coordinates of the mouse click.
		 * Repaints the panel.
         * @param e The MouseEvent object containing information about the event.
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            clickX = e.getX();
            clickY = e.getY();
            repaint();
        }

		/**
		 * Handles the mouseMoved event.
		 * Retrieves the x and y coordinates of the mouse movement.
		 * Repaints the panel.
		 * @param e The MouseEvent object containing information about the event.
		 */
        @Override
        public void mouseMoved(MouseEvent e) {
            hoverX = e.getX();
            hoverY = e.getY();
			System.out.println(hoverX + ", " + hoverY);
            repaint();
        }
    }
	/**
	 * Overrides the paintComponent method to draw the boss battle elements.
	 * @param g The Graphics object used for painting.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bossHP > 50) {
			bossImg = resize(loadImage("boss_1.png"), 240, 384);
		} else {
			bossImg = resize(loadImage("boss_2.png"), 360, 360);
		}
		g.drawImage(bossImg, 850, 25, null);
		BufferedImage image = loadImage("omori_mu.png");
		image = resize(image, 150, 225);
		g.drawImage(image, 200, 200, null);
		//moves box
		g.setColor(Color.WHITE);
		g.fillRoundRect(900, 450, 320, 200, 60, 60);
		//moves buttons
		g.setColor(Color.BLACK);
		g.fillRoundRect(945, 490, 230, 30, 10, 10);
		g.fillRoundRect(945, 580, 230, 30, 10, 10);
		g.setColor(Color.WHITE);

		//questions box
		g.fillRoundRect(50, 450, 800, 200, 60, 60);
		//health bar borders
		g.setColor(Color.BLACK);
		g.fillRoundRect(50, 50, 400, 50, 20, 20);
		g.fillRoundRect(800, 350, 400, 50, 20, 20);
		//moving health bar
		g.setColor(Color.RED);
		g.fillRoundRect(55, 55, (int)((playerHP/100.0) * 390), 40, 20, 20);
		g.fillRoundRect(805, 355, (int)((bossHP/100.0) * 390), 40, 20, 20);
		//text
		g.setColor(Color.WHITE);
		g.drawString("???'s Health: " + bossHP + "/" + "100", 950, 380);
		g.drawString("Your Health: " + playerHP + "/" + "100", 200, 80);

		g.drawString("ATTACK", 1035, 510);
		g.drawString("GIVE UP", 1035, 600);

		if (clickX > 945 && clickX < 1175 && clickY > 490 && clickY < 520) {
			isAttacking = true;
		}
		if (clickX > 945 && clickX < 1175 && clickY >= 580 && clickY <= 610) {
			Game.slideCount = 8;
		}

		if(isAttacking) {
			if (clickX > 180 && clickX < 380 && clickY > 530 && clickY < 560) {
				answer = options.get(0);
			}
			if (clickX > 580 && clickX < 780 && clickY > 530 && clickY < 560) {
				answer = options.get(1);
			}
			if (clickX > 180 && clickX < 380 && clickY > 580 && clickY < 610) {
				answer = options.get(2);
			}
			if (clickX > 580 && clickX < 780 && clickY > 580 && clickY < 610) {
				answer = options.get(3);
			}

			g.setColor(Color.BLACK);
			g.drawString(questions.get(0), 165, 500);
			g.fillRoundRect(180, 530, 200, 30, 10, 10);
			g.fillRoundRect(580, 530, 200, 30, 10, 10);
			g.fillRoundRect(180, 580, 200, 30, 10, 10);
			g.fillRoundRect(580, 580, 200, 30, 10, 10);
			g.setColor(Color.WHITE);
			g.drawString(options.get(0), 200, 550);
			g.drawString(options.get(1), 600, 550);
			g.drawString(options.get(2), 200, 600);
			g.drawString(options.get(3), 600, 600);

			if (answer == answers.get(0)) {
				if (((int)(Math.random() * 5) + 1) == 1) {
					bossHP -= 40;
					attackMessage = "YOU ANSWERED CORRECTLY! CRITICAL HIT! YOU DEAL 40 DAMAGE.";
				} else {
					bossHP -= 20;
					attackMessage = "YOU ANSWERED CORRECTLY! YOU DEAL 20 DAMAGE.";
				}
				isAttacking = false;
				bossAttacking = true;
				answer = null;
				questions.remove(0);
				options.remove(0);
				options.remove(0);
				options.remove(0);
				options.remove(0);
				answers.remove(0);
				repaint();
				g.setColor(Color.BLACK);
				g.drawString(attackMessage, 165, 500);
				g.drawString("CLICK ON THE ENEMY TO ATTACK HIM", 165, 520);
				if (clickX >= 860 && clickX <= 1160 && clickY >= 45 && clickY <= 350) {

				}
			} else {
				if (answer != null) {
					attackMessage = "YOU ANSWERED INCORRECTLY! YOU MISSED YOUR ATTACK.";
					isAttacking = false;
					answer = null;
					questions.remove(0);
					options.remove(0);
					options.remove(0);
					options.remove(0);
					options.remove(0);
					answers.remove(0);
					repaint();
					bossAttacking = true;
				}
			}
			win();
		}

		if (bossAttacking) {
			if (bossHP > 50) {
				playerHP -= (Math.random() * 6) + 10;
				bossAttacking = false;
			} else if (bossHP <=50 && bossHP > 0){
				playerHP -= (Math.random() * 6) + 15;
				bossAttacking = false;
			}
			win();
		}

		if (win && bossHP == 0) {
			Game.slideCount++;
		} else if (playerHP == 0) {
			Game.slideCount+=2;
			System.out.println(Game.slideCount);
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
	 * Loads an image from a file.
	 * @param path The path to the image file.
	 * @return The loaded BufferedImage.
	 * @throws IOException if an error occurs while loading the image.
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