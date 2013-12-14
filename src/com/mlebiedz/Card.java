package com.mlebiedz;

public class Card {
	private Rank rank;
	private Suit suit;
	private int inHand;
	private boolean played;
	
	
	public Card(Rank rank, Suit suit){
		this.suit = suit;
		this.rank = rank;
		setPlayed(false);
	}
	
	public Rank getRank(){
		return rank;
	}
	public Suit getSuit(){
		return suit;
	}
	public void print(){
		if (isPlayed()==true){
			System.out.println(rank + " of " + suit + " X");
		} else
		System.out.println(rank + " of " + suit);
	}
	public boolean isPlayed() {
		return played;
	}
	public void setPlayed(boolean played) {
		this.played = played;
	}

	public int getInHand() {
		return inHand;
	}

	public void setInHand(int inHand) {
		this.inHand = inHand;
	}
	
}
