package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.Deck;

public class BlackJackApplication {
	
	public BlackJackApplication() {
	}

	public static void main(String[] args) {
		BlackJackApplication blackJackApp = new BlackJackApplication();
		// Dealers gets a new deck of cards
		Deck deck = new Deck();
		Dealer david = new Dealer(deck, "David"); //giving deck to dealer
		// Dealer shuffles the deck
		david.shuffle();
		// Greet player
		System.out.println("Welcome to Blackjack!");
		// Dealer deals a visible card to the player face down
		System.out.println();
		System.out.println("Dealer David is now dealing two cards to you, and two cards to himself.");
		Player player = new Player();
		player.setName("Your ");
		Player dealerPlayer = new Player();
		dealerPlayer.setName("David's ");
		david.dealCard(player);
		david.dealCard(dealerPlayer);
		dealerPlayer.setPlayerHand(dealerPlayer.getPlayerHand());
		david.dealCard(player);
		//david.dealCard(dealerPlayer); un-comment and move after player can see 2nd dealer card
		player.setPlayerHand(player.getPlayerHand());
		System.out.println();
		blackJackApp.hitOrStay(player, dealerPlayer, david);
	}
	
	public void hitOrStay(Player player, Player dealerPlayer, Dealer david) {
		Scanner kb = new Scanner(System.in);
		boolean keepGoing;
		keepGoing = true;
		while(keepGoing) {
		System.out.println("Would you like to hit or stay? ");
		System.out.println(player.getName() + "hand holds these cards: " + player.getPlayerHand());
		if (player.getPlayerHand().isBlackjack()) {
			System.out.println("You drew Blackjack immediately! Now let's see if David has as well.");
			david.dealCard(dealerPlayer);
			dealerPlayer.setPlayerHand(dealerPlayer.getPlayerHand());
			if (dealerPlayer.getPlayerHand().isBlackjack()) {
				System.out.println("David drew blackjack immediately as well, you've tied!");
		}
		System.out.println("David does not have Blackjack, you won!");
		System.exit(1);
		}
		System.out.println(dealerPlayer.getName() + "visible hand is: " + dealerPlayer.getPlayerHand());
		System.out.println("\"1: \"hit");
		System.out.println("\"2: \"stay");
		
		int switcher = 0;
		
		try {
			switcher = kb.nextInt();
		} catch (InputMismatchException e) {
			System.out.println();
			System.err.println("You need to input either a \"1\" or \"2\"");
		}
		switch(switcher) {
		case 1:
			System.out.println("David is dealing you another card...");
			david.dealCard(player);
			player.setPlayerHand(player.getPlayerHand());
			System.out.println(player.getName() + "hand holds these cards: " + player.getPlayerHand());
			if (player.getPlayerHand().isBlackjack()) {
				System.out.println("You got blackjack! Now let's see if David does as well...");
				dealerPlayer.setPlayerHand(dealerPlayer.getPlayerHand());
				if (dealerPlayer.getPlayerHand().isBlackjack()) {
					System.out.println("David has Blackjack as well, you've tied!");
				}
				System.out.println("David does not have Blackjack, you've won!");
					keepGoing = false;
				}
			
			if (player.getPlayerHand().isBust()) {
				System.out.println("Sorry, David wins!");
				keepGoing = false;
			}
			break;
		case 2:
			david.dealCard(dealerPlayer);
			dealerPlayer.setPlayerHand(dealerPlayer.getPlayerHand());
			System.out.println(dealerPlayer.getName() + "visible hand is: " + dealerPlayer.getPlayerHand());
			if (dealerPlayer.getPlayerHand().isBlackjack()) {
				System.out.println("David wins with blackJack!");
			keepGoing = false;
			}
			if (dealerPlayer.getPlayerHand().dealerDraw(david, dealerPlayer)) {
				System.out.println("Davis's total hand value is less than 17, David deals himself another card.");
				System.out.println(dealerPlayer.getName() + "visible hand is: " + dealerPlayer.getPlayerHand());
			}
			if (dealerPlayer.getPlayerHand().isBlackjack()) {
				System.out.println("David wins with Blackjack!");
				keepGoing = false;
			}
			if (dealerPlayer.getPlayerHand().isBust()) {
				System.out.println("You win, David bust!");
				keepGoing = false;
			}
			break;
		}
		}
		keepGoing = false;
		kb.close();
	}
	
	
}
	
