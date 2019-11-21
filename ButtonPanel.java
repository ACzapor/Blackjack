package BlackJack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ButtonPanel extends JPanel {

	private JButton takeCardButton = new JButton("Take another card");
	private JButton standButton = new JButton("Stand");
	private final Color bgColor = Color.white;
	
	public ButtonPanel(int w, int h, GamePanel game) {
		setPreferredSize(new Dimension(w, h));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(bgColor);
		
		takeCardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		standButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		takeCardButton.addActionListener(new takeCardAction(game));
		standButton.addActionListener(new standAction(game));
		
		add(takeCardButton);
		add(standButton);
		
	}
	public void disableButtons() {
		takeCardButton.setEnabled(false);
		standButton.setEnabled(false);
	}
}
class takeCardAction implements ActionListener {
	private GamePanel game;
	boolean playerInGame = true;
	public takeCardAction(GamePanel game) {
		this.game = game;
	}
	public void actionPerformed(ActionEvent e) {

		game.getPlayer().addCardtoHand(game.getDeck().takeCard());
		playerInGame = !game.getPlayer().checkPlayer();
		game.getPlayerPanel().setText(game.getPlayer().printHand(true));
		
		if(!playerInGame) {
			game.gameOver();
		}
	}
}
	class standAction implements ActionListener {
		private GamePanel game;
		
		public standAction(GamePanel game) {
			this.game = game;
		}

		public void actionPerformed(ActionEvent e) {
			game.CroupierTurn();
			game.gameOver();
			
		}
		
	}
