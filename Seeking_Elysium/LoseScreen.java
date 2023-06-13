/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Lose Screen for game
 * @author Glen Lin and Leo Yi
 */
import java.awt.*;
import javax.swing.*;

public class LoseScreen extends JPanel{
	/**
	 * constructor for lose screen
	 */
	public LoseScreen() {
        this.setBackground(new Color(33, 33, 33));
        this.setVisible(true);
	}
	/**
	 * Overrides the paintComponent method to draw the game elements on the panel.
	 *
	 * @param g The Graphics object for drawing.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, 0, 60));
		g.drawString("OH NO!", 530, 200);
		g.setFont(new Font(Font.SANS_SERIF, 0, 30));
		g.drawString("You gave in to the temptations and you have become addicted again :(", 150, 350);
		g.drawString("Better luck next time!", 500, 450);
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, 0, 30));
		g.drawString("Press \'n\' to continue", 970, 650);
	}
}
