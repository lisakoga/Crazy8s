import java.util.ArrayList;
import java.util.Scanner;
public class crazyEights extends Game
{
	private static final Exception Exception = null;
	private Scanner kb;
	public AI ai = new AI();
	public static String eightSuit = null;
	
    public crazyEights()
    {
        super();
        super.deal(5);
        kb = new Scanner(System.in);
    }
    
    public static String getEightSuit()
    {
    	return eightSuit;
    }
    public boolean winner()
    {
        return (playerHand.isEmpty() || compHand.isEmpty());
    }

    public boolean validPlay(Card m)
    {
    	if(eightSuit != null)
    	{
    		if(m.getValue().equals(super.getDeck().getTopUsed().getValue()) || m.getSuit().equals(eightSuit) || m.getValue().equals("8"))
            	return true;
            return false;
    	}
    	else
    	{
            if(m.getValue().equals(super.getDeck().getTopUsed().getValue()) || m.getSuit().equals(super.getDeck().getTopUsed().getSuit()) || m.getValue().equals("8"))
            	return true;
            return false;
    	}
    }

    public boolean play() throws java.lang.Exception
    {
    	boolean hasPlayed = false;
        while(!hasPlayed)
        {
            System.out.println("Select a card to play, type \"draw\" to draw the card, or type \"quit\" to quit.\nYour current hand contains " + super.getHand());
            if(eightSuit != null)
            {
            	System.out.println("The top card on the discard pile is the " + super.getTop().getValue() + " but the suit has been changed to " + eightSuit);
            }
            else
            	System.out.println("The top card on the discard pile is " + super.getTop());
            String s = kb.nextLine().trim();
            if(s.equalsIgnoreCase("quit"))
            	throw Exception;
            if(s.equalsIgnoreCase("draw"))
            {
                super.drawToPlayer();
                System.out.println("You drew " + playerHand.get(playerHand.size()-1));
            }
            else
            {
            	if(playerHasCard(s))
            	{
                	if(validPlay(playerHand.get(playerFindCard(s))))
                	{
                		if(s.charAt(0) == '8')
                			eight();
                		else
                			eightSuit = null;
                		
                		System.out.println("test");
                		super.getDeck().discard(playerHand.get(playerFindCard(s)));
                		playerHand.remove(playerHand.get(playerFindCard(s)));
                		hasPlayed = true;
                		
                		boolean wantsToPlay = true;
                		while(wantsToPlay && playerFindValue(super.getDeck().getTopUsed().getValue().toString()) != -1)
                		{
                			if(playerFindValue(super.getDeck().getTopUsed().getValue().toString()) != -1)
                			{
                				boolean valid = false;
                				while(!valid)
                				{
                					System.out.print("You may play another card of the same value. Would you like to?(Yes/No)");
                					String yn = kb.nextLine();
                					if(yn.equalsIgnoreCase("yes"))
                					{
                						System.out.println("Select a card to play.\nYour current hand contains " + super.getHand());
                						s = kb.nextLine().trim();
                						if(playerHasCard(s))
                						{
                		                	if(playerHand.get(playerFindCard(s)).getValue().equals(Game.getDeck().getTopUsed().getValue()))
                		                	{
                		                		if(s.charAt(0) == '8')
                		                			eight();
                		                		else
                		                			eightSuit = null;
                		                		
                		                		super.getDeck().discard(playerHand.get(playerFindCard(s)));
                		                		playerHand.remove(playerHand.get(playerFindCard(s)));
                		                		valid = true;
                		                	}
                						}
                						else
                							System.out.println("Invalid choice. Please try again.");
                					}
                					else if(yn.equalsIgnoreCase("no")){
                						valid = true;
                						wantsToPlay = false;
                					}
                					else
                						System.out.println("Invalid choice. Please try again.");
                				}
                			}
                		}
                	}
                }
            	else
                	System.out.println("Invalid choice. Please try again.");
            }
        }
        return playerHand.isEmpty();
    }

    public void eight()
    {
    	System.out.print("Select a suit and be case sensitive(Clubs, Spades, Diamonds, Hearts): ");
    	String s = kb.nextLine();
    	while (!s.equals("Clubs") && !s.equals("Spades") && !s.equals("Hearts") && !s.equals("Diamonds")) {
    		System.out.print("Select a suit and be case sensitive(Clubs, Spades, Diamonds, Hearts): ");
    		s = kb.nextLine();
    	}
    	eightSuit = s;
    }
    
    public boolean hasWon(ArrayList<Card> h)
    {
    	return h.isEmpty();
    }
    
    //returns true if the cpu's hand contains a card that makes the following statement true: (c.toString().equals(s))
    private boolean playerHasCard(String s)
    {
		for(Card c: playerHand)
		{
			if(c.equals(s))
				return true;
		}
		return false;
	}
    
	//loops through the cpu's hand and returns the first index of the card that makes the following statement true: (c.toString().equals(s))
	private int playerFindCard(String s)
	{
		for(Card c: playerHand)
		{
			if(c.equals(s))
				return playerHand.indexOf(c);
		}
		return -1;
	}
	
	//loops through the cpu's hand and returns the first index of a card whose value matches the inputted String
	private int playerFindValue(String s)
	{
		for(Card c: playerHand)
		{
			if(c.getValue().equals(s) && !c.getValue().equals("8"))
				return playerHand.indexOf(c);
		}
		return -1;
	}
}
