package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public class Hand {
	// The cards in your hand
	private List<Card> cards = new ArrayList<>();
	
	public void handValue() {
		
	}
	
	public boolean isBlackjack() {
		int total = 0;
		for (Card card : cards) {
		// Iterating through the array, (adding cards to determine if = 21
			total += card.getValue();
		}
		// if total = 21 returning true, then else
		if (total == 21) {
			System.out.println("Blackjack!");
			return true;
		}
		else {
			return false;	
		}
	}
	
	public boolean isBust() {
		int total = 0;
		for (Card card : cards) {
			total += card.getValue();
		}
		if (total > 21) {
			System.out.println("Bust!");
			return true;
		}
		else {
			return false;
		}
	}
		
		public boolean dealerDraw(Dealer david, Player dealerPlayer) {
			int total = 0;
			for (Card card : cards) {
				total += card.getValue();
			}
			if (total < 17) {
				david.dealCard(dealerPlayer);
				dealerPlayer.setPlayerHand(dealerPlayer.getPlayerHand());
				return true;
			}
			else {
				System.out.println("David's total hand value is greater than 17, David keeps his position.");
				System.out.println(dealerPlayer.getName() + "visible cards are still: " + dealerPlayer.getPlayerHand());
				return false;
			}
		}
	
	
	
	public void addCard(Card card) {
		cards.add(card);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(cards);
		return builder.toString();
	}
	
	
}
