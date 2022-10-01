package naeemFarzaanBlackjackGame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private String[] names = {"Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two"};
	private String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	
	public Deck() {
		int value = 11;
		for(int i=0; i<names.length; i++) {
			for(int j=0; j<suits.length; j++) {
				deck.add(new Card(names[i], suits[j], value));
			}
			if(names[i].equals("King") || names[i].equals("Queen") || names[i].equals("Jack")) {
				value = 10;
			} else {
				value--;
			}
		}
		//This functions shuffles the deck for us each time
		Collections.shuffle(deck);
		
	}
	
	//This draws a card from the top of the deck
	public Card draw() {
		return deck.remove(0);
	}
	
	public String toString() {
		String output= "";
		for(Card c : deck) {
			output += "| " + c + " |";
		}
		return output;
	}
	

}
