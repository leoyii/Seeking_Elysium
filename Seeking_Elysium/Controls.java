/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Controls Menu for game
 * @author Glen Lin and Leo Yi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controls extends JPanel{

	/**
	 * Constructor for the Controls class.
	 * Sets the background color and visibility of the controls menu.
	 */
	public Controls() {
		this.setBackground(new Color(33, 33, 33));
		this.setVisible(true);
	}

	/**
	 * Overrides the paintComponent method to draw the controls menu.
	 * Displays information about the controls using graphical elements.
	 * Repaints the panel if the game is paused.
	 * @param g The Graphics object used for painting.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, 0, 30));
		g.drawString("Arrow keys to move", 520, 150);
		g.drawString("\'e\' to interact", 550, 250);
		g.drawString("\'space\' to use certain objects", 460, 350);
		g.drawString("\'esc\' to pause the game", 500, 450);
		g.drawString("Press \'e\' to continue", 970, 650);

		if (Game.paused) {
			Game.pause.paintComponent(g);
			repaint();
		} else {
			repaint();
		}
	}
}