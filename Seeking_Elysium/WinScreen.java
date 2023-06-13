/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Win Screen for game
 * @author Glen Lin and Leo Yi
 */
import java.awt.*;
import javax.swing.*;

public class WinScreen extends JPanel{
	/**
	 * constructor for win screen
	 */
	public WinScreen() {
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
		g.drawString("CONGRATULATIONS!", 330, 200);
		g.setFont(new Font(Font.SANS_SERIF, 0, 30));
		g.drawString("You have defeated the embodiment of addiction. You then receive proper therapy", 80, 350);
		g.drawString("and any other necessary treatment and no longer suffer from addiction!", 150, 450);
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, 0, 30));
		g.drawString("Press \'n\' to continue", 970, 650);
	}
}
