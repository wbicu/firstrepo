package com.mlebiedz;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Deck deck;
	ArrayList<Hand> hands;
	ArrayList<Player> players;
	ArrayList<Trick> tricks;
	static int activePlayer;
	static final int NUMBER_OF_TRICKS = 5;
	
	public void init(){
		deck = new Deck();
		hands = new ArrayList<Hand>();
		players = new ArrayList<Player>();
		tricks = new ArrayList<Trick>();
		activePlayer = 0;
		
		initHands();
		initPlayers();
		printHands();

		

		go();
	}
	
	
	private void initHands() {
		for (int i=0; i<4; i++) hands.add(new Hand(deck.getDeck(), i));
	}
	private void initPlayers() {
		for(int i=0; i<4; i++){
			players.add(new Player(i, hands.get(i)));
		}
	}
	private void go() {
		int k=0;
		while(k<NUMBER_OF_TRICKS){
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner( System.in );
			System.out.println("Lewa " + (k+1) + ".");
			tricks.add(new Trick());
			for (int i=0; i<4; i++){
				int cardNumber;
				while(true){
					System.out.println("Graczu " + (1 + (activePlayer)%4) + ", podaj numer karty do zagrania");
			        cardNumber = scanner.nextInt();
			        if(!players.get(activePlayer%4).getHand().getCard(cardNumber-1).isPlayed()) break;
				}
		        
		        System.out.print("Zagrano ");
		        tricks.get(k).getTrick().add(players.get(activePlayer%4).getHand().getCard(cardNumber-1));
		        players.get(activePlayer%4).getHand().getCard(cardNumber-1).print();
		        players.get(activePlayer%4).playCard(cardNumber-1);
		        activePlayer++;
			}
			printHands();
			activePlayer = tricks.get(k).whoWon();
			System.out.println("Gracz " + (activePlayer+1) + " wzial lewe.");
			k++;
		}
		tricks.add(new Trick());//DOROBIÆ SPRAWDZANIE KTO PRZEGRAL
		for (Hand h : hands)
			for (Card c : h.getHand()){
				if (!c.isPlayed()) tricks.get(k).getTrick().add(c);
			}
		
		tricks.get(k).highestCards();
	}
	public void printHands(){
		int n = 1;
		for(Hand h : hands){
			int i=1;
			System.out.println("--- Hand number " + n++ +" ---");
			for (Card c : h.getHand()){
				System.out.print(i++ + ". ");
				c.print();
			}
			System.out.println();
		}
	}
}
