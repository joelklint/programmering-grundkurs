package lab7;

import se.lth.cs.ptdc.cardGames.Card;

public class Patians {
	public static void main(String[] args) {
		
		double times = 0;
		double success = 0;		
		
		while (times <= 1000000) {
			times = times + 1;
			CardDeck deck = new CardDeck();
			deck.shuffle();
			for (int i = 1; deck.moreCards(); i++) {
				Card c = deck.getCard();
				
				if(c.getRank() == i)
					break;
				
				if (i == 3) 
					i = 0;
				
				if(!(deck.moreCards()))
					success = success + 1;
			}
		}		
		System.out.println("Sannolikheten att patiansen går ut är " + success/times);
	}
}
