/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Dialogue for level 1
 * @author Glen Lin and Leo Yi
 */
import java.awt.*;
import javax.swing.*;

public class DialogueOne extends JPanel{
	
	public DialogueOne() {
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
		g.drawString("You wake up in your room. You look around but for some reason,", 200, 150);
		g.drawString("You are unfamiliar with your surroundings.", 330, 220);
		g.drawString("Take a look around your room to recollect your thoughts.", 250, 290);
		g.drawString("There are 5 objects that you can interact with.", 300, 360);
		g.drawString("Once you are done, leave the room through the door in the bottom right", 140, 430);
		g.drawString("of the screen, which leads you to the next level.", 310, 500);
		g.drawString("Press \'n\' to continue", 970, 650);
		
		if (Game.paused) {
			Game.pause.paintComponent(g);
			repaint();
		} else {
			repaint();
		}
	}
}
