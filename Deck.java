import java.util.ArrayList;
import java.util.Collections;
public class Deck {
	private ArrayList <Card>Origincards;
	private ArrayList <Card>Used;
	private Card topUsed;
//	private ArrayList User; (in other class not deck)
//	private ArrayList AI;
		
	public Deck() {
		Origincards = new ArrayList<>(); //cards for original deck players are picking from
		Used = new ArrayList<>();

		for (Suit c : Suit.values()) {  //looping through the card value & card to make a new card and add it to origin card 
			for (CardValue i : CardValue.values()) {
				Card a = new Card(c, i);
				Origincards.add(a); // create new card c, is a parameter & int
			}
		}
		shuffle();
	}
	
	public Card DrawValueofCard() {   //takes the first value of the card and removes it from the deck and returns it
		if(Origincards.isEmpty())
			startOver();
		return Origincards.remove(0);
	}
	public void discard(Card c){
		Used.add(c);
		topUsed = c;
	}

	public Card getTopUsed() {
		return topUsed;
	}

	public void setTopUsed(Card topUsed) {
		this.topUsed = topUsed;
	}
	public void shuffle() {  //shuffles the deck
		Collections.shuffle(Origincards);
	}

	public void startOver() {
		topUsed = Used.remove(Used.size()-1);
		Origincards.addAll(Used);
		Used.clear();
		Used.add(topUsed);
		shuffle();
	}
	public void discard(){
	    Used.add(DrawValueofCard());
	}
	public ArrayList<Card> getOrigincards() {
		return Origincards;
	}

	public ArrayList<Card> getUsed() {
		return Used;
	}
}