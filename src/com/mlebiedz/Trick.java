package com.mlebiedz;

import java.util.ArrayList;

public class Trick {
	private ArrayList<Card> trick;
	int player = Game.activePlayer;
	
	public Trick(){
		trick = new ArrayList<Card>();
	}
	
	public ArrayList<Card> getTrick() {
		return trick;
	}

	public void setTrick(ArrayList<Card> trick) {
		this.trick = trick;
	}
	public int whoWon(){
		int highest = 12;
		int winner = 0;
		for (Card c : trick){
			if (c.getRank().ordinal() <= highest){
				highest = c.getRank().ordinal();
				winner = trick.indexOf(c);
			}
		}
		
		return (player + winner)%4;
	}
	public void highestCards(){
		int highest = 12;		// enums in Rank in descending order 
		for (Card c : trick){
			if (c.getRank().ordinal() <= highest){
				highest = c.getRank().ordinal();
			}
		}
		for (Card c : trick){
			if (c.getRank().ordinal() == highest){
				System.out.println("Gracz " + (c.getInHand()+1) + " przegral!");
			}
		}
		
	}
	
	
	
}
