public class Card 
{
	private Suit suit;
	private CardValue value;

	public Card(Suit m, CardValue a) 
	{
		suit = m;
		value = a;
	}

	public Suit getSuit() 
	{
		return suit;
	}

	public void setSuit(Suit suit) 
	{
		this.suit = suit;
	}

	public CardValue getValue() 
	{
		return value;
	}

	public void setValue(CardValue value) 
	{
		this.value = value;
	}
	
	public boolean equals(String s)
	{
		if(toString().equals(s))
			return true;
		return false;
	}

	public String toString() 
	{
		return "" + value + " " + suit;
	}
}

enum Suit 
{ 
	// will define the suits
	Clubs("Clubs"), Diamonds("Diamonds"), Hearts("Hearts"), Spades("Spades");
	private String value;
	
	private Suit(String v)
	{
		value = v;
	}
	
	public boolean equals(String s)
	{
		if(value.equals(s))
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return value;
	}
}

enum CardValue 
{ 
	// all possible cards
	ace("A"), two("2"), three("3"), four("4"), five("5"), six("6"), seven("7"), eight("8"), nine("9"), ten("10"), jack("J"), queen("Q"), king("K");
	private String value;
	
	private CardValue(String v)
	{
		value = v;
	}
	
	public boolean equals(String s)
	{
		if(value.equals(s))
		{
			return true;
		}
		return false;
	}
	public String toString()
	{
		return value;
	}
}
