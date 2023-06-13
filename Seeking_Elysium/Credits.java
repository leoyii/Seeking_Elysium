/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Credits for game
 * @author Glen Lin and Leo Yi
 */
import java.awt.*;
import javax.swing.*;

public class Credits extends JPanel {
	/**
	 * Constructor for the Credits class.
	 * Sets the background color and visibility of the credits menu.
	 */
	public Credits() {
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
		g.drawString("Thank you for playing!", 490, 200);
		g.drawString("Credits:", 580, 350);
		g.drawString("Made By: Glen Lin and Leo Yi", 420, 450);
		g.drawString("from Rito Games", 520, 500);
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, 0, 30));
		g.drawString("Press \'n\' to continue", 970, 650);
	}
}
