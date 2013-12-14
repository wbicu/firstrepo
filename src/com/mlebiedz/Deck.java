package com.mlebiedz;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck;
	
	public Deck(){
		deck = new ArrayList<Card>();
		for(Rank r : Rank.values())
			for(Suit s: Suit.values()) deck.add(new Card(r, s));
		
		Collections.shuffle(deck);
	}
	public ArrayList<Card> getDeck(){
		return deck;
	}
	
	
}
