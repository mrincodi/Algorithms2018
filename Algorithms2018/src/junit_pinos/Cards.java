package junit_pinos;

import java.util.ArrayList;

enum Suit {
	Hearts, Diamonds, Clubs, Spades;
}

enum Status {
	UP, DOWN;
}

enum Face {
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

	// TODO:
	// Assign default values to cards. ACE should be valued  one, TWO has value 2, etc.
	// Getter for this method.
}



class Card implements Comparable <Card>{
	ArrayList < Integer > values;
	Face face;
	Suit suit;
	Status status;

	@Override
	public int compareTo(Card o) {
		// TODO Add method for comparing.
		return 0;
	}
	
	Card ( Face face, Suit suit){
		// this.value = value;	// TODO : Call method for assigning value here.
		this.face = face;
		this.suit = suit;
		this.status = Status.DOWN;	
	}
}

class Deck {
	ArrayList <Card> deck = new ArrayList <Card>();

	// TODO: Add 
	Deck (){
		for ( Suit suit : Suit.values()){
			for ( Face face : Face.values()){
				Card c = new Card ( face, suit);	
			}
		}
	}
}















public class Cards {






	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
