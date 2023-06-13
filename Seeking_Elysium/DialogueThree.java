/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Dialogue for level 2
 * @author Glen Lin and Leo Yi
 */
import java.awt.*;
import javax.swing.*;

public class DialogueThree extends JPanel{
	
	public DialogueThree() {
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
		g.drawString("At the end of the maze, you come face to face", 320, 100);
		g.drawString("with your addiction. After finding way out of maze, ", 290, 200);
		g.drawString("You must now overcome your final obstacle.", 330, 300);
		g.drawString("You have avoided it for far too long.", 385, 400);
		g.drawString("It is finally time to face your worst fear head on ", 310, 500);
		g.drawString("Press \'n\' to continue", 970, 650);
		
		if (Game.paused) {
			Game.pause.paintComponent(g);
			repaint();
		} else {
			repaint();
		}
	}
}
