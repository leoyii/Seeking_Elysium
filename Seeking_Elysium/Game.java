/**
 * Date: Jun 9/23
 * ICS4U0 with Krasteva V.
 * Description: Driver class for game
 * @author Glen Lin and Leo Yi
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Game extends JFrame{
	KeyInput keyListener = new KeyInput();

	public static PauseMenu pause = new PauseMenu();

	SplashScreen ss = new SplashScreen();
	MainMenu mm = new MainMenu();
	Controls c2 = new Controls();
	DialogueOne d1 = new DialogueOne();
	DialogueTwo d2 = new DialogueTwo();
	DialogueThree d3 = new DialogueThree();
	Level1 l1 = new Level1();
	Maze m = new Maze();
	Boss b1 = new Boss();
	LoseScreen ls = new LoseScreen();
	WinScreen ws = new WinScreen();
	Credits c3 = new Credits();
	Bibliography b2 = new Bibliography();
	public static boolean paused;
	public static boolean isMale;
	public static int slideCount = 0;
	/**
	 * Constructs a new Game object.
	 * Sets up the initial properties of the game window and starts the game loop.
	 */
	public Game() {
		this.setSize(1280, 720);
		this.addKeyListener(keyListener);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().add(ss);
		ss.startFadeOutAnimation();
		Runnable r = () -> {
			try {
				Thread.sleep(8000);
				while (true) {
					update();
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		r.run();
	}
	/**
	 * Resets the game to its initial state.
	 */
	public void reset() {
		paused = false;
		isMale = false;
		l1.playerX = 600;
		l1.playerY = 300;
		l1.playerSprite = 2;
		l1.gameState = 0;
		l1.pressState = 0;
		l1.upPressed = false;
		l1.downPressed = false;
		l1.leftPressed = false;
		l1.rightPressed = false;
	}
	/**
	 * Updates the game state based on the current slide count.
	 */
	public void update() {
		if (slideCount == 0) {
			this.getContentPane().remove(0);
			this.getContentPane().add(mm);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 1) {
			this.getContentPane().remove(0);
			this.getContentPane().add(c2);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 2) {
			this.getContentPane().remove(0);
			this.getContentPane().add(d1);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 3) {
			this.getContentPane().remove(0);
			this.getContentPane().add(l1);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 4) {
			this.getContentPane().remove(0);
			this.getContentPane().add(d2);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 5) {
			this.getContentPane().remove(0);
			this.getContentPane().add(m);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 6) {
			this.getContentPane().remove(0);
			this.getContentPane().add(d3);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 7) {
			this.getContentPane().remove(0);
			this.getContentPane().add(b1);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 8) {
			this.getContentPane().remove(0);
			this.getContentPane().add(ls);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 9) {
			this.getContentPane().remove(0);
			this.getContentPane().add(ws);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 10) {
			this.getContentPane().remove(0);
			this.getContentPane().add(c3);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		} else if (slideCount == 11) {
			this.getContentPane().remove(0);
			this.getContentPane().add(b2);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		}
	}
	/**
	 * Key listener for handling keyboard input events.
	 */
	class KeyInput implements KeyListener{
		/**
		 * Invoked when a key is typed.
		 *
		 * @param e the KeyEvent object containing the details of the key event
		 */
		@Override
		public void keyTyped(KeyEvent e) {

		}
		/**
		 * Invoked when a key is pressed.
		 *
		 * @param e the KeyEvent object containing the details of the key event
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == 'e' && slideCount == 1) {
				slideCount = 2;
			} else if (e.getKeyChar() == 'n' && slideCount == 2) {
				slideCount = 3;
			} else if (slideCount == 3) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP && !paused) {
					l1.upPressed = true;
					System.out.println(l1.upPressed);
					repaint();
				} else if (keyCode == KeyEvent.VK_DOWN && !paused) {
					l1.downPressed = true;
					System.out.println(l1.downPressed);
					repaint();
				} else if (keyCode == KeyEvent.VK_LEFT && !paused) {
					l1.leftPressed = true;
					System.out.println(l1.leftPressed);
					repaint();
				} else if (keyCode == KeyEvent.VK_RIGHT && !paused) {
					l1.rightPressed = true;
					System.out.println(l1.rightPressed);
					repaint();
				}
				if (keyCode == KeyEvent.VK_E && !paused) {
					if (l1.playerX > 350 && l1.playerX < 530 && l1.playerY < 150) {
						if (l1.pressState == 0) {
							if (l1.gameState == 0) {
								l1.gameState = 1;
							} else {
								l1.gameState = 0;
							}
							repaint();
						}
					}
					else if (l1.playerX < 200 && l1.playerY > 350) {
						if (l1.pressState == 0) {
							if (l1.gameState == 0) {
								l1.gameState = 2;
							} else {
								l1.gameState = 0;
							}
							repaint();
						}
					}
					else if (l1.playerY < 400 && l1.playerY > 300 && l1.playerX >= 990) {
						if (l1.pressState == 0) {
							if (l1.gameState == 0) {
								l1.gameState = 3;
							} else {
								l1.gameState = 0;
							}
							repaint();
						}
					}
					else if (l1.playerY <= 72 && l1.playerX >= 24 && l1.playerX < 150) {
						if (l1.pressState == 0) {
							if (l1.gameState == 0) {
								l1.gameState = 4;
							} else {
								l1.gameState = 0;
							}
							repaint();
						}
					}
					else
					if (l1.playerY >= 372  && l1.playerX >= 462 && l1.playerX <= 672) {
						if (l1.pressState == 0) {
							if (l1.gameState == 0) {
								l1.gameState = 5;
							} else {
								l1.gameState = 0;
							}
							repaint();
						}
					}
					if (l1.playerY >= 408  && l1.playerX >= 1110) {
						if (l1.pressState == 0) {
							l1.gameState = 6;
							repaint();
						}
					}
					l1.pressState = 1;
				}
			} else if (slideCount == 4) {
				if (e.getKeyChar() == 'n') {
					slideCount++;
				}

			} else if (slideCount == 5) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_E && !paused) {
					if (m.pressState == 0 && m.playerX == 1 && m.playerY == 7) {
						if (m.gameState == 0) {
							m.gameState = 1;
						}
						else {
							m.gameState = 0;
						}
					}
					else if (m.pressState == 0 && m.playerX == 7 && m.playerY == 3) {
						if (m.gameState == 0) {
							m.gameState = 2;
						}
						else {
							m.gameState = 0;
						}
					}
					else if (m.pressState == 0 && m.playerX == 13 && m.playerY == 3) {
						if (m.gameState == 0) {
							m.gameState = 3;
						}
						else {
							m.gameState = 0;
						}
					}
					else if (m.pressState == 0 && m.playerX == 1 && m.playerY == 11) {
						if (m.gameState == 0) {
							m.gameState = 4;
						}
						else {
							m.gameState = 0;
						}
					}
					m.pressState = 1;
				}
				if (keyCode == KeyEvent.VK_UP && m.gameState == 0 && !paused) {
					if (m.pressState == 0) {
						m.playerY--;
						if (m.maze[m.playerY][m.playerX] == '-') {
							m.playerY++;
						}
						m.playerY = Math.max(0, m.playerY);
					}
					m.pressState = 1;
				}
				if (keyCode == KeyEvent.VK_LEFT && m.gameState == 0 && !paused) {
					if (m.pressState == 0) {
						m.playerX--;
						if (m.maze[m.playerY][m.playerX] == '-' || m.maze[m.playerY][m.playerX] == 'd') {
							m.playerX++;
						}
						m.playerX = Math.max(0, m.playerX);
					}
					m.pressState = 1;
				}
				if (keyCode == KeyEvent.VK_DOWN && m.gameState == 0 && !paused) {
					if (m.pressState == 0) {
						m.playerY++;
						if (m.maze[m.playerY][m.playerX] == '-') {
							m.playerY--;
						}
						m.playerY = Math.min(12, m.playerY);
					}
					m.pressState = 1;
				}
				if (keyCode == KeyEvent.VK_RIGHT && m.gameState == 0 && !paused) {
					if (m.pressState == 0) {
						m.playerX++;
						if (m.maze[m.playerY][m.playerX] == '-') {
							m.playerX--;
						}
						m.playerX = Math.min(18, m.playerX);
					}
					m.pressState = 1;
				}
				repaint();
			}
			else if (slideCount == 6) {
				if (e.getKeyChar() == 'n') {
					slideCount++;
				}
			}
			else if (slideCount == 8) {
				if (e.getKeyChar() == 'n') {
					slideCount = 10;
				}
			}
			else if (slideCount == 9) {
				if (e.getKeyChar() == 'n') {
					slideCount = 10;
				}
			}
			else if (slideCount == 10) {
				if (e.getKeyChar() == 'n') {
					slideCount = 11;
				}
			}
			else if (slideCount == 11) {
				if (e.getKeyChar() == 'n') {
					System.exit(0);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE && !paused) {
				paused = true;
				repaint();
			} else {
				paused = false;
				repaint();
			}
			/*if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				l1.playerX = 300;
				l1.playerY = 300;
				m.playerX = 1;
				m.playerY = 7;
				b1.questions.clear();
				b1.options.clear();
				b1.answers.clear();
				mm.hoverX = 0;
				mm.hoverY = 0;
				mm.clickX = 0;
				mm.clickY = 0;
				mm.uwu = 0;
				b1.hoverX = 0;
				b1.hoverY = 0;
				b1.clickX = 0;
				b1.clickY = 0;
				slideCount = 0;
				b1.questions.add("Which of the following is NOT a way to treat addiction?");
				b1.options.add("a) Therapy");
				b1.options.add("b) Eating");
				b1.options.add("c) Medication");
				b1.options.add("d) Supervised Detoxification");
				b1.answers.add("b) Eating");
				b1.questions.add("Which of the following is one of the 4 Cs for signs and symptoms of addiction?");
				b1.options.add("a) craving");
				b1.options.add("b) cancer");
				b1.options.add("c) constraint");
				b1.options.add("d) clever");
				b1.answers.add("a) craving");
				b1.questions.add("Fill in the blank: Addiction refers to the problematic use of _______.");
				b1.options.add("a) power");
				b1.options.add("b) hands");
				b1.options.add("c) substances");
				b1.options.add("d) guns");
				b1.answers.add("c) substances");
				b1.questions.add("What type of addiction has become a prevalent in today's DIGITAL age.");
				b1.options.add("a) Eating");
				b1.options.add("b) Gambling");
				b1.options.add("c) Internet");
				b1.options.add("d) Drug");
				b1.answers.add("c) Internet");
				b1.questions.add("What does CBT stand for?");
				b1.options.add("a) Computer Based Tutorial");
				b1.options.add("b) Cabbage Bacon Tomato");
				b1.options.add("c) Creative Brain Thinking");
				b1.options.add("d) Cognative-Behavorial Therapy");
				b1.answers.add("d) Cognative-Behavorial Therapy");
				b1.questions.add("Which of the following means: A person-centered approach that explores and strengthens an individual's motivation and commitment to change.");
				b1.options.add("a) Motivational Interviewing");
				b1.options.add("b) Self Love");
				b1.options.add("c) Narcissism");
				b1.options.add("d) Culminative Exploration");
				b1.answers.add("a) Motivational Interviewing");
				b1.questions.add("_______ Management provides incentives or rewards for positive behaviors and abstinence from substance use.");
				b1.options.add("a) Product");
				b1.options.add("b) Waste");
				b1.options.add("c) Contingency");
				b1.options.add("d) Time");
				b1.answers.add("c) Contingency");
				b1.questions.add("Addction is influenced by a combination of 3 factors, which is NOT a factor?");
				b1.options.add("a) Environmental");
				b1.options.add("b) Lack of Sleep");
				b1.options.add("c) Hereditary");
				b1.options.add("d) Psychological");
				b1.answers.add("b) Lack of Sleep");
				paused = false;
				repaint();
			}*/
		}
		/**
		 * Invoked when a key is released.
		 *
		 * @param e the KeyEvent object containing the details of the key event
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			if (slideCount == 3) {
				int keyCode = e.getKeyCode();

				// Set the corresponding boolean variable to false when a key is released
				if (keyCode == KeyEvent.VK_UP && !paused) {
					l1.upPressed = false;
				} else if (keyCode == KeyEvent.VK_DOWN && !paused) {
					l1.downPressed = false;
				} else if (keyCode == KeyEvent.VK_LEFT && !paused) {
					l1.leftPressed = false;
				} else if (keyCode == KeyEvent.VK_RIGHT && !paused) {
					l1.rightPressed = false;
				}

				if (keyCode == KeyEvent.VK_E && !paused) {
					l1.pressState = 0;
				}
			} else if (slideCount == 5) {
				int keyCode = e.getKeyCode();
				m.pressState = 0;
			}
		}
	}

	/**
	 * main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		new Game();
	}

}
