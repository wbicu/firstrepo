package com.mlebiedz;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;
	private int handNum;
	static final int CARDS_PER_HAND = 6;
	public Hand(ArrayList<Card> deck, int num){
		hand = new ArrayList<Card>();
		setHandNum(num);
		for (int i=CARDS_PER_HAND*num; i<CARDS_PER_HAND + CARDS_PER_HAND*num; i++){
			hand.add(deck.get(i));
			deck.get(i).setInHand(handNum);
		}
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	public Card getCard(int index){
		return hand.get(index);
	}

	public int getHandNum() {
		return handNum;
	}

	public void setHandNum(int handNum) {
		this.handNum = handNum;
	}

	
}
