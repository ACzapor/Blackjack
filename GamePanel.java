package BlackJack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private Deck deck;
	private Player player;
	private Player croupier;
	
	private final Dimension panelSize = new Dimension(600, 400);
	private final Color bgColor = Color.white;
	
	private PlayerPanel playerPanel;
	private PlayerPanel croupierPanel;
	private ButtonPanel buttonPanel;
	
	
	public GamePanel() {
		deck = new Deck();
		deck.shuffle();
		player = new Player("Me");
		croupier = new Player("Croupier");
		
		setPreferredSize(panelSize);
		setBackground(bgColor);
		setLayout(new BorderLayout());
		
		playerPanel = new PlayerPanel(300, 150);
		croupierPanel = new PlayerPanel(300, 150);
		buttonPanel = new ButtonPanel(600, 50, this);
		
		add(playerPanel, BorderLayout.WEST);
		add(croupierPanel, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	public void runGame() {
		player.addCardtoHand(deck.takeCard());
		croupier.addCardtoHand(deck.takeCard());
		
		player.addCardtoHand(deck.takeCard());
		croupier.addCardtoHand(deck.takeCard());
		
		playerPanel.setText(player.printHand(true));
		croupierPanel.setText(croupier.printHand(false));
	}
	
	public void CroupierTurn() {
		boolean croupierInGame = true;
		
		while(croupierInGame) {
			if(croupier.getPointsSum() < 17) {
				
				croupier.addCardtoHand(deck.takeCard());
				croupierInGame = !croupier.checkPlayer();
				croupierPanel.setText(croupier.printHand(false));
			}
			else {
				croupierInGame = false;
			}
		}
	}
	public void gameOver() {
		
		buttonPanel.disableButtons();
		
		int playerPoints = player.getPointsSum();
		int croupierPoints = croupier.getPointsSum();
		
		if(playerPoints > croupierPoints && playerPoints <= 21 || croupierPoints > 21) {
			playerPanel.setWinnerLabelText("<html> <b> You won! </b> </html>");
		}
		else {
			croupierPanel.setWinnerLabelText("<html> <b> Croupier won! </b> </html>");
		}
		playerPanel.setText(player.printHand(true));
		croupierPanel.setText(croupier.printHand(true));
		
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Player getCroupier() {
		return croupier;
	}
	public void setCroupier(Player croupier) {
		this.croupier = croupier;
	}
	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}
	public void setPlayerPanel(PlayerPanel playerPanel) {
		this.playerPanel = playerPanel;
	}
	public PlayerPanel getCroupierPanel() {
		return croupierPanel;
	}
	public void setCroupierPanel(PlayerPanel croupierPanel) {
		this.croupierPanel = croupierPanel;
	}
	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}
	public void setButtonPanel(ButtonPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}
}
