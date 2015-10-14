package lab7;


import java.util.Random;

import se.lth.cs.ptdc.cardGames.Card;

/**
 * En kortlek med Card-objekt. OBSERVERA: bara skelett, du ska själv skriva
 * denna klass.
 */
public class CardDeck {

	private Card[] cards;
	private int current = -1;
	private static Random rand = new Random();

	/** Skapar en kortlek som inte är blandad. */
	public CardDeck() {
		cards = new Card[52];
		int counter = 0;
		for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
			for(int rank = 1; rank <=13; rank++)	{
				cards[counter] = new Card(suit, rank);
				counter++;
			}
		}
	}

	/**
	 * Blandar kortleken.
	 */
	public void shuffle() {
		Card temp = new Card(0, 0);
		for (int i = 51; i >= 1; i--) {
			int nbr = rand.nextInt(i + 1);
			temp = cards[i];
			cards[i] = cards[nbr];
			cards[nbr] = temp;
		}
	}

	/**
	 * Undersöker om det finns fler kort i kortleken.
	 * 
	 * @return true om det finns fler kort, false annars
	 */
	public boolean moreCards() {
		return current < 51;
	}

	/**
	 * Drar det översta kortet i leken. Fungerar bara om moreCards är true.
	 * 
	 * @return det översta kortet i leken
	 */
	public Card getCard() {
		current = current + 1;
		return cards[current];
	}
}
