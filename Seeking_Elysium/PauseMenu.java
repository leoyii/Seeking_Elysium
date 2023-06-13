/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Pause menu for game
 * @author Glen Lin and Leo Yi
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PauseMenu extends JPanel{
	
	private int clickX;
	private int clickY;
	private int hoverX;
	private int hoverY;
	boolean controls = false;
	MouseHandler mouseListener = new MouseHandler();

	/**
	 * constructor for pause meny
	 */
	public PauseMenu() {
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
	}
	
	class MouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			clickX = e.getX();
			clickY = e.getY();
			if (clickX > 420 && clickX < 820 && clickY > 350 && clickY < 400) {
				controls = true;
			}
		}
		
		public void mouseMoved(MouseEvent e) {
			hoverX = e.getX();
			hoverY = e.getY();
		}
	}
	/**
	 * Overrides the paintComponent method to draw the game elements on the panel.
	 *
	 * @param g The Graphics object for drawing.
	 */
	public void paintComponent(Graphics g) {
		//shader
		g.setColor(new Color(255, 255, 255, 30));
		g.fillRect(0, 0, 2000, 1000);
		//background rect
		g.setColor(Color.WHITE);
		g.fillRoundRect(325, 140, 600, 400, 30, 30);
		//pause text
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.SANS_SERIF, 0, 50));
		g.drawString("PAUSE", 540, 210);
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.SANS_SERIF, 0, 30));
		g.drawString("Press any key key to return to game.", 400, 285);
		g.setFont(new Font(Font.SANS_SERIF, 0, 20));
		g.drawString("Arrow keys to move", 540, 360);
		g.drawString("\'e\' to interact", 555, 380);
		g.drawString("\'space\' to use certain objects", 495, 400);
		g.drawString("\'esc\' to pause the game", 520, 420);
	}
}
