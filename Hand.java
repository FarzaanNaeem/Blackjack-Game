package naeemFarzaanBlackjackGame;

import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Hand(boolean isPlayersHand, Deck d) {
		//if it is the players hand, then we draw 2 cards for the player
		//if is players hand is false, then we draw 2 cards for the dealer
		if(isPlayersHand) {
			hand.add(d.draw());
			hand.add(d.draw());
		} else {
			hand.add(d.draw());
			hand.add(d.draw());
			hand.get(1).flip();
		}
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	//This function checks to see if the player has an ace
	//This is important for when the player has a sum that is above 21 but has an ace as the value changes for the ace at that point
	public boolean hasAnAce() {
		for(int i=0; i<hand.size(); i++) {
			if(hand.get(i).isFacingUp() && hand.get(i).getValue() == 11) {
				return true;
			}
		}
		return false;
	}
	
	//This simply computes the sum of the current for either the player or the dealer
	public int getSum() {
		int sum = 0;
		for(int i=0; i<hand.size(); i++) {
			if(hand.get(i).isFacingUp()) {
				sum += hand.get(i).getValue();
			}
		}
		return sum;
	}
	
	public String toString() {
		String sentence = "|";
		for(int i=0; i<hand.size(); i++) {
			if(!hand.get(i).isFacingUp()) {
				sentence += " XXXXXXXXX |";
			} else {
				sentence += " " + hand.get(i) + " |";
			}
		}
		return sentence;
	}

}
