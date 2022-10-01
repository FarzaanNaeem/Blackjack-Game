package naeemFarzaanBlackjackGame;

public class Card {

	private int cardValue;
	private boolean isFacingUp = true;
	private String name;
	private String suit;
	
	public Card(String name, String suit, int cardValue) {
		this.name = name;
		this.suit = suit;
		this.cardValue = cardValue;
	}
	
	public Integer getValue() {
		if(isFacingUp) {
			return cardValue;
		}
		return null;
	}
	
	public boolean isFacingUp() {
		return isFacingUp;
	}
	
	public void flip() {
		isFacingUp = !isFacingUp;
	}
	
	public String toString() {
		return name + " of " + suit;
	}
	
}
