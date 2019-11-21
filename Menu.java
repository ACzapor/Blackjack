package BlackJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menu extends JMenuBar {
	
	JFrame frame;
	JMenu menu;
	JMenuItem newGame;
	JMenuItem exitGame;
	
	public Menu(JFrame jframe) {
		frame = jframe;
		
		menu = new JMenu("Menu");
		add(menu);
		
		newGame = new JMenuItem("New game");
		newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newGame.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				new GameFrame();
				
			}
		});
		menu.add(newGame);
		
		exitGame = new JMenuItem("Exit game");
		exitGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		exitGame.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(exitGame);
	}

}
