package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Deck;

public class Dealer extends Player{
	private Deck deck;
	
	public Dealer() {
		
	}
	
	public void shuffle() {
		deck.shuffle(); //calling shuffle method from Deck class
	}
	
	public Dealer(Deck deck, String name) { // Put deck because dealer needs the deck
		// Dealer can shuffle the cards
		this.deck = deck; // Dealer is holding the deck which was passed in on line 9
		// draw cards from the deck
		// card is dealt to the player
	}
	
	public void dealCard(Player player) { // public Card because we are returning a card, and it's going to the player
		player.takeCard(deck.dealCard());
		
		
	}

}
