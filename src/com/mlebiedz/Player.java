package com.mlebiedz;


public class Player {
	private int number;
	private Hand hand;
	public Player(int number, Hand hand){
		this.setNumber(number);
		this.setHand(hand);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Hand getHand() {
		return hand;
	}
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	public Card playCard(int index){
		getHand().getCard(index).setPlayed(true);
		return getHand().getCard(index);
	}
	
}
