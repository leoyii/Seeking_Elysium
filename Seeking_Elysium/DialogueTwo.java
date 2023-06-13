/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Dialogue for level 3
 * @author Glen Lin and Leo Yi
 */
import java.awt.*;
import javax.swing.*;

public class DialogueTwo extends JPanel{

	public DialogueTwo() {
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
		g.drawString("Once you leave your room, you enter another room.", 300, 100);
		g.drawString("You become trapped in this dark maze.", 350, 200);
		g.drawString("You realize that you are trapped by your addiction temptations.", 240, 300);
		g.drawString("You must find 3 clues hidden in the maze.", 350, 400);
		g.drawString("These clues will help you figure out the code for the lock, ", 275, 500);
		g.drawString("which will allow you to escape.", 440, 600);
		g.drawString("Press \'n\' to continue", 970, 650);
		
		if (Game.paused) {
			Game.pause.paintComponent(g);
			repaint();
		} else {
			repaint();
		}
	}
}
