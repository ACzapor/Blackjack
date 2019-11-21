package BlackJack;

import java.util.Scanner;

public class Game {

	Scanner scanner;
	Deck deck;
	Player player;
	Player croupier;
	
	public Game() {
		
		scanner = new Scanner(System.in);
		deck = new Deck();
		deck.shuffle();
		
		player = new Player("Me");
		croupier = new Player("Croupier");
	}
	
	public void runGame() {
		
		
		
		player.addCardtoHand(deck.takeCard());
		croupier.addCardtoHand(deck.takeCard());
		
		player.addCardtoHand(deck.takeCard());
		croupier.addCardtoHand(deck.takeCard());
		
		
		
;
		
		boolean playerInGame = true;
		boolean croupierInGame = true;
		String answer;
		
		while(playerInGame || croupierInGame) {
			
			if(playerInGame) {
				
			
				answer = scanner.next();
				
				if(answer.compareToIgnoreCase("Y") == 0) {
					
					
					player.addCardtoHand(deck.takeCard());
					playerInGame = !player.checkPlayer();

				}
				else {
				
					playerInGame = false;
				}
			}
			
			if(croupierInGame) {
				
				if(croupier.getPointsSum() < 17) {
					
					
					croupier.addCardtoHand(deck.takeCard());
					croupierInGame = !croupier.checkPlayer();
					
				}
				else {
				
					croupierInGame = false;
				}
			}
		}
		scanner.close();
		
		
		
		
		int playerPoints = player.getPointsSum();
		int croupierPoints = croupier.getPointsSum();
		
		if(playerPoints > croupierPoints && playerPoints <= 21 || croupierPoints > 21) {
		
		}
		else {
			
		}
	}
}


