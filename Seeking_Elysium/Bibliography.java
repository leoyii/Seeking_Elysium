/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Bibliography for game
 * @author Glen Lin and Leo Yi
 */
import java.awt.*;
import javax.swing.*;

public class Bibliography extends JPanel {

	/**
	 * Constructs a new instance of the Bibliography panel.
	 * Sets the background color and visibility of the panel.
	 */
	public Bibliography() {
		this.setBackground(new Color(33, 33, 33));
		this.setVisible(true);
	}

	/**
	 * Overrides the paintComponent method to customize the painting of the panel.
	 *
	 * @param g the Graphics object used for drawing on the panel
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, 0, 30));
		g.drawString("Bibliography:", 100, 100);
		g.drawString("https://www.camh.ca/en/health-info/mental-illness-and-addiction-index/addiction", 100, 200);
		g.drawString("https://www.healthline.com/health/types-of-addiction", 100, 250);
		g.drawString("https://www.crossrivertherapy.com/research/cell-phone-addiction-statistics", 100, 300);

		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, 0, 30));
		g.drawString("Press 'n' to Quit", 800, 650);
	}
}