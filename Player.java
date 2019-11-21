package BlackJack;

import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Card> hand;
	
	public Player(String playerName) {
		hand = new ArrayList<>();
		name = playerName;
	}
	public String getName() {
		return name;
	}
	
	public void addCardtoHand(Card newCard) {
		hand.add(newCard);
	}
	
	public int getPointsSum() {
		int sumOfPoints = 0;
		int cardPoints;
		int aces = 0;
		
		for(int i = 0; i < hand.size(); i++) {
			
			cardPoints = hand.get(i).getCardValue().getValue();
			
			if(cardPoints == 11) {
				aces++;
				sumOfPoints += 11;
			}
			else {
				sumOfPoints += cardPoints;
			}
		}
		while(sumOfPoints > 21 && aces > 0) {
			sumOfPoints -= 10;
			aces--;
		}
		return sumOfPoints;
	}
	
	public String printHand(boolean showFirstCard) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append(name + ":<br>");
		sb.append(getCardText(showFirstCard) + "<br>");
		
		if (showFirstCard) {
			sb.append("Points: [" + getPointsSum() + "] <br>");
		} else {
			sb.append("Points: [?] <br>");
		}
		
		sb.append("</html>");
		return sb.toString();
	}
	public String getCardText(boolean showFirstCard) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < hand.size(); i++) {
			if(i == 0 && !showFirstCard) {
				sb.append("<br>[Hidden]");
			}
			else {
				sb.append("<br>" + hand.get(i).toString());
			}
		}
		return sb.toString();
	}
	public boolean checkPlayer() {
		if(getPointsSum() > 21) {
			return true;
		}
		else {
			return false;
		}
	}
}


