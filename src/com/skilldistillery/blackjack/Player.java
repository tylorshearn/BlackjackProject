package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public class Player {
	private String name;
	private Hand playerHand;
	// every time dealer deals a card need method, pulls card from array list, pass card to player, player then inserts that card into their playerhand
	public Player() {
	playerHand = new Hand();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hand getPlayerHand() {
		return playerHand;
	}
	
	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}
	
	public void takeCard(Card card) {
	playerHand.addCard(card);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [name=").append(name).append(", playerHand=").append(playerHand).append(", getName()=")
				.append(getName()).append(", getPlayerHand()=").append(getPlayerHand()).append("]");
		return builder.toString();
	}
	
	
}