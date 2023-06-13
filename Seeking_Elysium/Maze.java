/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Maze Level for game
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
import javax.imageio.ImageIO;
import javax.swing.*;

public class Maze extends JPanel{
	MouseHandler mouseListener = new MouseHandler();
	String pass;
	String password;
	int clickX, clickY;
	int posX, posY;
	int playerX = 1, playerY = 7, pressState = 0, gameState = 0;

	char[][] maze = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
			{'-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
			{'-', ' ', '-', '-', '-', '-', '-', '-', '-', ' ', '-', ' ', '-', '-', '-', '-', '-', ' ', '-'},
			{'-', ' ', '-', ' ', '-', ' ', ' ', '*', '-', ' ', ' ', ' ', '-', '*', ' ', ' ', ' ', ' ', '-'},
			{'-', ' ', '-', ' ', '-', ' ', '-', '-', '-', ' ', '-', ' ', '-', ' ', '-', '-', '-', ' ', '-'},
			{'-', ' ', ' ', ' ', '-', ' ', '-', ' ', ' ', ' ', '-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
			{'-', '-', '-', ' ', '-', ' ', '-', '-', '-', ' ', '-', '-', '-', '-', '-', ' ', '-', '-', '-'},
			{'d', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
			{'-', '-', '-', ' ', '-', ' ', '-', '-', '-', ' ', '-', ' ', '-', ' ', '-', '-', '-', ' ', '-'},
			{'-', ' ', ' ', ' ', '-', ' ', '-', ' ', ' ', ' ', ' ', ' ', '-', ' ', ' ', ' ', ' ', ' ', '-'},
			{'-', ' ', '-', '-', '-', '-', '-', ' ', '-', ' ', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
			{'-', '*', '-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
			{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

	String[] passwords = {"drugs", "phone", "games", "gambling"};
	String[][] clues = {{"Substances", "Poison", "Overdose"},
			{"Technology", "Device", "Texting"},
			{"Computer", "Console", "Arcade"},
			{"Luck", "Winning", "Casino"}};

	/**
	 * constructor for maze
	 */
	public Maze() {
		pass = passwords[(int)((Math.random()*4))];
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
		this.setVisible(true);
	}
	class MouseHandler extends MouseAdapter {
		/**
		 * simulates buttons
		 *
		 * @param e the event to be processed
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			clickX = e.getX();
			clickY = e.getY();
			if (clickX > 300 && clickX < 600 && clickY > 300 && clickY < 350) {
				password = passwords[0];
			} else if (clickX > 650 && clickX < 950 && clickY > 300 && clickY < 350) {
				password = passwords[1];
			} else if (clickX > 300 && clickX < 650 && clickY > 400 && clickY < 450) {
				password = passwords[2];
			} else if (clickX > 650 && clickX < 950 && clickY > 400 && clickY < 450) {
				password = passwords[3];
			}
			repaint();
		}

		/**
		 * mouseMoved method
		 * when the mouse is moved, the x and y coordinates are stored in a variable
		 * drawing is repainted
		 */
		@Override
		public void mouseMoved(MouseEvent e) {

		}
	}
	/**
	 * Overrides the paintComponent method to draw the game elements on the panel.
	 *
	 * @param g The Graphics object for drawing.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(50, 50, 50));
		g.fillRect(-1000,-1000,3000,3000);
		for (int row = 0; row < 13; row++) {
			for (int col = 0; col < 19; col++) {
				int x = (col - playerX) * 150 + 565;
				int y = (row - playerY) * 150 + 285;
				if (maze[row][col] != '-') {
					g.setColor(Color.BLACK);
					g.fillRect(x + 1, y + 1, 148, 148);
					g.setColor(new Color(50, 50, 50));
					g.drawRect(x, y, 150, 150);
				} else if (maze[row][col] == '-') {
					g.setColor(new Color(50, 50, 50));
					g.fillRect(x, y, 150, 150);
				}
			}
		}
		BufferedImage note = resize(loadImage("note.png"),104, 79);
		BufferedImage noted = resize(loadImage("noted.png"),106, 82);

		BufferedImage lock = resize(loadImage("lock.png"),100, 100);
		g.drawImage(lock, (0 - playerX) * 150 + 588, (7 - playerY) * 150 + 305, null);
		BufferedImage guy = resize(loadImage("omori_m.png"), 81, 123);
		g.drawImage(guy, 598, 300, null);

		g.drawImage(note, (13 - playerX) * 150 + 588, (3 - playerY) * 150 + 320, null);
		g.drawImage(note, (7 - playerX) * 150 + 588, (3 - playerY) * 150 + 320, null);
		g.drawImage(note, (1 - playerX) * 150 + 588, (11 - playerY) * 150 + 320, null);
		if (playerX == 13 && playerY == 3) {
			if (gameState == 0) {
				g.drawImage(noted, (13 - playerX) * 150 + 588, (3 - playerY) * 150 + 320, null);
				g.drawImage(guy, 598, 300, null);
				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
				g.setColor(Color.WHITE);
				g.drawString("Press 'E' to use", 1000, 650);
			}
			else if (gameState == 3) {
				g.setColor(new Color(0, 0, 0, 150));
				g.fillRect(0, 0, 1280, 720);
				g.setColor(Color.WHITE);
				g.fillRect(100, 100, 1080, 520);
				g.setColor(Color.BLACK);
				g.fillRect(110, 110, 1060, 500);
				String hint = "";
				for (int i = 0; i < 4; i++) {
					if (pass.equals(passwords[i])) {
						hint = "Your hint is: " + clues[i][0];
					}
				}
				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 45));
				g.setColor(Color.WHITE);
				g.drawString(hint, 435, 400);

				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
				g.setColor(Color.WHITE);
				g.drawString("Press 'E' to Quit", 1000, 650);
			}
		} else if (playerX == 7 && playerY == 3) {
			if (gameState == 0) {
				g.drawImage(noted, (7 - playerX) * 150 + 588, (3 - playerY) * 150 + 320, null);
				g.drawImage(guy, 598, 300, null);
				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
				g.setColor(Color.WHITE);
				g.drawString("Press 'E' to use", 1000, 650);
			}
			else if (gameState == 2) {
				g.setColor(new Color(0, 0, 0, 150));
				g.fillRect(0, 0, 1280, 720);
				g.setColor(Color.WHITE);
				g.fillRect(100, 100, 1080, 520);
				g.setColor(Color.BLACK);
				g.fillRect(110, 110, 1060, 500);
				String hint = "";
				for (int i = 0; i < 4; i++) {
					if (pass.equals(passwords[i])) {
						hint = "Your hint is: " + clues[i][1];
					}
				}
				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 45));
				g.setColor(Color.WHITE);
				g.drawString(hint, 435, 400);

				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
				g.setColor(Color.WHITE);
				g.drawString("Press 'E' to Quit", 1000, 650);
			}
		} else if (playerX == 1 && playerY == 11) {
			if (gameState == 0) {
				g.drawImage(noted, (1 - playerX) * 150 + 588, (11 - playerY) * 150 + 320, null);
				g.drawImage(guy, 598, 300, null);
				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
				g.setColor(Color.WHITE);
				g.drawString("Press 'E' to use", 1000, 650);
			}
			else if (gameState == 4) {
				g.setColor(new Color(0, 0, 0, 150));
				g.fillRect(0, 0, 1280, 720);
				g.setColor(Color.WHITE);
				g.fillRect(100, 100, 1080, 520);
				g.setColor(Color.BLACK);
				g.fillRect(110, 110, 1060, 500);
				String hint = "";
				for (int i = 0; i < 4; i++) {
					if (pass.equals(passwords[i])) {
						hint = "Your hint is: " + clues[i][2];
					}
				}
				System.out.println(hint);
				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 45));
				g.setColor(Color.WHITE);
				g.drawString(hint, 435, 400);

				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
				g.setColor(Color.WHITE);
				g.drawString("Press 'E' to Quit", 1000, 650);
			}
		}

		if (playerX == 1 && playerY == 7) {
			BufferedImage lock_close = resize(loadImage("lock_close.png"),100, 100);
			if (gameState == 0) {
				g.drawImage(lock_close, (0 - playerX) * 150 + 588, (7 - playerY) * 150 + 305, null);
				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
				g.setColor(Color.WHITE);
				g.drawString("Press 'E' to use", 1000, 650);
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
				g.drawString("Choose a Password", 435, 200);

				g.fillRoundRect(300, 300, 300, 50, 40, 40);
				g.fillRoundRect(650, 300, 300, 50, 40, 40);
				g.fillRoundRect(300, 400, 300, 50, 40, 40);
				g.fillRoundRect(650, 400, 300, 50, 40, 40);

				g.setColor(Color.BLACK);
				g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
				g.drawString(passwords[0], 400, 335);
				g.drawString(passwords[1], 750, 335);
				g.drawString(passwords[2], 400, 435);
				g.drawString(passwords[3], 750, 435);

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

		if (password == pass) {
			Game.slideCount = 6;
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
