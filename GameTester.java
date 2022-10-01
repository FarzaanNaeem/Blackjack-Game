package naeemFarzaanBlackjackGame;

import java.util.Scanner;

public class GameTester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Pre-Condition: Have to use int values of 1 or 0 for the program to work
		Deck deck = new Deck();
//		System.out.println(deck); (used to see if deck was being populated correctly)
		System.out.print("Hit 1 to play Blackjack! ");
		int input = scan.nextInt();
		
		
		while(input == 1) {
			Hand playersHand = new Hand(true, deck);
			Hand dealersHand = new Hand(false, deck);
			int playersSum = playersHand.getSum();
			int dealersSum = dealersHand.getSum();
			if(playersSum == 21 && dealersSum != 21) {
				System.out.println("You got blackjack!");
			} else {
				//This is where the player will decide whether or not to hit or stand
				while(playersSum <= 21) {
					//These print statements show the player his hand and the sum they equal to as well as the dearler's first cared
					System.out.println("This is your current Hand:\n" + playersHand);
					System.out.println("This is your current sum: " + playersSum);
					System.out.println();
					System.out.println("This is the dealer's current hand:\n" + dealersHand);
					System.out.println();
					System.out.print("Put 1 to hit or 0 to stand: ");
					//If the player presses 1, then they will draw another card
					input = scan.nextInt();
					if(input == 1) {
						playersHand.getHand().add(deck.draw());
						playersSum = playersHand.getSum();
					} else {
						break;
					}
					if(playersSum > 21 && playersHand.hasAnAce()) {
						playersSum = playersHand.getSum() - 10;
//						System.out.println(playersSum); (Seeing if sum was being subtracted correctly)
					} else if(playersSum > 21) { // if the player goes above 21, then it is an automatic loss and the game is over
//						System.out.println(playersHand); (Used for debugging)
//						System.out.println(playersSum); (Seeing whether or not sum was actually greater than 21)
						System.out.println("You went above 21! You busted!");
						break;
					}
				}
			} 
			// Dealer is drawing cards here
			if(input == 0) {
				while (dealersSum <= playersSum) {
					for (int i = 0; i < dealersHand.getHand().size(); i++) { // This for loop ensures that the dealer's cards are always facing up
						if (!dealersHand.getHand().get(i).isFacingUp()) { //This ensures every card is face up to calculate the sum
							dealersHand.getHand().get(i).flip();
						}
					}
					dealersHand.getHand().add(deck.draw()); //This is the dealer drawing a new card
//					System.out.println(dealersHand);
					dealersSum = dealersHand.getSum(); //This calculates the new sum every time he draws a new card
//					System.out.println(dealersSum); (Used for debugging)
					if (dealersSum > 21 && dealersHand.hasAnAce()) {
						dealersSum -= 10;
					}
					// These last 3 if statements determine who won or if it was a tie
					if (dealersSum == 21 && playersSum == 21) { // a tie is called a push in blackjack
						System.out.println("It's a push!");
						break;
					} else if (dealersSum > playersSum && dealersSum <= 21) { // Dealer just needs to get a higher number than player to win
						System.out.println("The dealer wins with a sum of " + dealersSum + "!");
						break;
					} else if (dealersSum > 21) { //If dealer busts, the player wins
						System.out.println("You win!");
					}
				}
			}
			System.out.println("Do you want to play again? If so, press 1");
			input = scan.nextInt();
	}
	System.out.println("Thanks for playing!");
		
		
		
	}

}
