import java.util.ArrayList;

public final class AI 
{
	private ArrayList<Card> hand;
	private ArrayList<Card> playedCards;
	private Card first;
	private boolean played;
	
	//constructor sets hand to point to the ArrayList<Card> in the Game class
	public AI()
	{
		hand = Game.getCompHand();
		playedCards = new ArrayList<Card>();
		played = false;
	}
	
	//Algorithm for the ai to take its turn
	public boolean takeTurn()
	{
		String most, mostSuit = null;
		boolean canPlay = false;
		played = false;
		String e = crazyEights.getEightSuit();
		
		//loops until the computer plays a card.
		while(!played)
		{
			most = findMostValue();

			//this if checks whether the last card that was played is an eight. 
			if(e != null)
			{ 
				//checks whether the computer has any cards that it can play.
				if(hasSuit(e) || hasEight())
					canPlay = true;
				
				if(canPlay)
				{
					//checks if the computer can play its biggest set of same-valued cards. If it can, it plays them. 
					if(hasCard(most + " " + e))
					{ 
						//checks whether the computer has any more same-valued cards to play.
						playCard(findCard(most + " " + e));
						playMultiples(most);	
					}
					//tries to play a card with the suit that the player changed it to.
					else if(hasSuit(e))
					{ 
						//checks whether the computer has any more same-valued cards to play.
						playCard(findSuit(e));
						playMultiples(getTopCard().getValue().toString());
						
					}
					else
					{ 
						//plays an eight and then changes the suit to whichever suit the computer has the most of.
						playCard(findEight());
						mostSuit = findMostSuit();
						crazyEights.eightSuit = mostSuit;
					}
				}
				//draws a card.
				else
				{ 
					Game.drawToComputer();
					System.out.println("The Computer draws a card.");
				}	
			}
			else
			{
				//checks whether the computer has any cards that it can play.
				if(hasSuit(getTopCard().getSuit().toString()) || hasValue(getTopCard().getValue().toString()) || hasEight())
				{
					canPlay = true;
				}
				if(canPlay)
				{
					if(hasCard(most + " " + getTopCard().getSuit()))
					{ 
						//checks if the computer can play its biggest set of same-valued cards. If it can, it plays them. 
						playCard(findCard(most + " " + getTopCard().getSuit()));
						
						//checks whether the computer has any more same-valued cards to play.
						playMultiples(most);
					}
					else if(hasValue(getTopCard().getValue().toString()))
					{   
						//tries to play a card with the value of the top card.
						playCard(findValue(getTopCard().getValue().toString()));
						
						//checks whether the computer has any more same-valued cards to play.
						playMultiples(getTopCard().getValue().toString());		
					}
					else if(hasSuit(getTopCard().getSuit().toString()))
					{   
						//tries to play a card with the suit of the top card.
						playCard(findSuit(getTopCard().getSuit().toString()));
						
						//checks whether the computer has any more same-valued cards to play.
						playMultiples(getTopCard().getValue().toString());
					}
					else
					{ 
						//plays an eight and then changes the suit to whichever suit the computer has the most of.
						playCard(findEight());
						mostSuit = findMostSuit();
						crazyEights.eightSuit = mostSuit;
					}
				}
				else
				{
					//draws a card.
					Game.drawToComputer();
					System.out.println("The Computer draws a card.");
				}
			}
		}
		System.out.print("The Computer played the " + first);
		
		int i = 0;
		for(Card a: playedCards)
		{
			if(++i == playedCards.size())
				System.out.print(" , and the " + a);
			else
				System.out.print(" , the " + a);
		}
		
		System.out.println(".");
		
		if(getTopCard().getValue().equals("8"))
		{
			System.out.println("The Computer changes the suit to " + mostSuit + ".");
		}
		first = null;
		playedCards.clear();
		return hand.isEmpty();
	}
	
	//returns the cardValue that the Computer has the most of in String form. If there is a tie, returns the cardValue of the first occuring largest set.
	private String findMostValue()
	{
		int iHigh = 0;
		int iCurr = 0;
		String sHigh = null;
		String sCurr = null;
		for(Card c: hand)
		{
			//loops through hand, comparing each card to the others in the hand. It counts how many of a value there are
			sCurr = "" + c.getValue();
			iCurr = 0;
			for(Card d: hand)
			{
				if(c.getValue() == d.getValue())
					iCurr++;
			}
			if(iCurr > iHigh){ //if the current card has more occurrences than the current highest, the current card replaces the highest
				iHigh = iCurr;
				sHigh = sCurr;
			}
		}
		return sHigh;
	}
	
	//finds and then returns the name of the suit that the computer has the most of.
	private String findMostSuit()
	{
		int c = 0, s = 0, d = 0, h = 0, largest;
		//loops through hand counting how many of each suit there are.
		for(Card card: hand)
		{ 
			if(card.getSuit().equals("Clubs"))
				c++;
			else if(card.getSuit().equals("Spades"))
				s++;
			else if(card.getSuit().equals("Diamonds"))
				d++;
			else if(card.getSuit().equals("Hearts"))
				h++;
		}
		largest = Math.max(Math.max(c, s), Math.max(d, h)); //finds the suit with the most occurrences
		
		//returns the String related to the most occurring suit
		if(c == largest)
		{
			return "Clubs";
		}
		else if(s == largest)
		{
			return "Spades";
		}
		else if(d == largest)
		{
			return "Diamonds";
		}
		else
		{
			return "Hearts";
		}
	}
	
	//plays the card at the passed in position
	private void playCard(int i)
	{
		Game.getDeck().discard(hand.get(i));
		first = getTopCard();
		hand.remove(hand.get(i));
		played = true;
	}
	
	//takes in a String and plays all of the cards of value "s"
	private void playMultiples(String s)
	{
		while(hasValue(s))
		{
			Game.getDeck().discard(hand.get(findValue(s)));
			playedCards.add(hand.get(findValue(s)));
			hand.remove(hand.get(findValue(s)));
		}
	}
	
	//retrieves and returns the top card of the discard pile
	private Card getTopCard()
	{
		return Game.getDeck().getTopUsed();
	}
	
	//returns true if the cpu's hand contains an eight
	private boolean hasEight()
	{
		for(Card c: hand)
		{
			if(c.getValue().equals("8"))
				return true;
		}
		return false;
	}
	
	//returns true if the cpu's hand contains a card with a suit matching the inputted String
	private boolean hasSuit(String s)
	{
		for(Card c: hand)
		{
			if(c.getSuit().equals(s) && !c.getValue().equals("8"))
				return true;
		}
		return false;
	}
	
	//returns true if the cpu's hand contains a card with a value matching the inputted String
	private boolean hasValue(String s)
	{
		for(Card c: hand)
		{
			if(c.getValue().equals(s) && !c.getValue().equals("8"))
				return true;
		}
		return false;
	}
	
	//returns true if the cpu's hand contains a card that makes the following statement true: (c.toString().equals(s))
	private boolean hasCard(String s)
	{
		for(Card c: hand)
		{
			if(c.equals(s))
				return true;
		}
		return false;
	}
	
	//loops through the cpu's hand and returns the first index of a card whose value is "8"
	private int findEight()
	{
		for(Card c: hand)
		{
			if(c.getValue().equals("8"))
				return hand.indexOf(c);
		}
		return -1;
	}
	
	//loops through the cpu's hand and returns the first index of a card whose suit matches the inputted String
	private int findSuit(String s)
	{
		for(Card c: hand)
		{
			if(c.getSuit().equals(s) && !c.getValue().equals("8"))
				return hand.indexOf(c);
		}
		return -1;
	}
	
	//loops through the cpu's hand and returns the first index of a card whose value matches the inputted String
	private int findValue(String s)
	{
		for(Card c: hand)
		{
			if(c.getValue().equals(s) && !c.getValue().equals("8"))
				return hand.indexOf(c);
		}
		return -1;
	}
	
	//loops through the cpu's hand and returns the first index of the card that makes the following statement true: (c.toString().equals(s))
	private int findCard(String s)
	{
		for(Card c: hand)
		{
			if(c.equals(s))
				return hand.indexOf(c);
		}
		return -1;
	}
}
