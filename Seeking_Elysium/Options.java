import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Options {
	
	public Options() {
		
	}
	
	class mouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			
		}
		
		public void mouseDragged(MouseEvent e) {
			
		}
		
		public void mousePressed(MouseEvent e) {
			
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void mouseMoved(MouseEvent e) {
			
		}
	}
	
	public void draw(Graphics g) {
		//shader
		g.setColor(new Color(0, 0, 0, 50));
		g.fillRect(0, 0, 2000, 1000);
		//background rect
		g.setColor(Color.WHITE);
		g.fillRoundRect(225, 90, 800, 500, 30, 30);
		//buttons
		g.setColor(Color.BLACK);
		g.drawRoundRect(0, 0, 200, 50, 30, 30);
	}
}