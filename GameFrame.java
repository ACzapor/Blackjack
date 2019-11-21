package BlackJack;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	public GameFrame() {
		
		setTitle("Black Jack");
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel gamePanel = new GamePanel();
		getContentPane().add(gamePanel);
		
		setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("Images/black-jack-icon.png"));
		
		setJMenuBar(new Menu(this));
		
		pack();
		setVisible(true);
		gamePanel.runGame();
	}
}
