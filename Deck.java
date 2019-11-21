package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
private ArrayList<Card> cards;

public Deck() {
	cards = new ArrayList<>();
	
	for(int suit = 0; suit < 4; suit++) {
		for(int value = 0; value < 13; value++) {
			
			cards.add(new Card(Suit.values()[suit], Value.values()[value]));
		}
	}
}
public void shuffle() {
	Collections.shuffle(cards);
}
public Card takeCard() {
	return cards.remove(0);
}
}



