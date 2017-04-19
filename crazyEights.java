import java.util.ArrayList;
import java.util.Scanner;
public class crazyEights extends Game{
	private Scanner kb;
//	public AI ai = new AI(compHand);
	public static String eightSuit = null;
	
    public crazyEights(){
        super();
        super.deal(5);
        //super.discard();
        kb = new Scanner(System.in);
    }
    
    public static String getEightSuit(){
    	return eightSuit;
    }
    public boolean winner(){
        return (playerHand.isEmpty() || compHand.isEmpty());
    }

    public boolean validPlay(Card m){
        if(m.getValue().equals(super.getDeck().getTopUsed().getValue()) || m.getSuit().equals(super.getDeck().getTopUsed().getSuit()) || m.getValue().equals("eight") || super.getDeck().getTopUsed().getValue().equals("eight"))
            return true;
        return false;
    }

    public boolean play(){
    	boolean hasPlayed = false;
        while(!hasPlayed)
        {
            System.out.println("Select a card to play, or type draw to draw the card.\nYour current hand contains " + super.getHand());
            System.out.println("The top card on the deck is " + super.getTop());
            String s = kb.next();
            if(s.equalsIgnoreCase("draw"))
            {
                super.drawToHand();
            }
            else
            {
                if(super.getHand().contains(s) && validPlay(super.getHand().get(super.getHand().indexOf(s))))
                {
                	if(s.charAt(0) == '8')
                	{
                		eight();
                	}
                	else
                	{
                		eightSuit = null;
                	}
                	super.getDeck().discard(super.getHand().get(super.getHand().indexOf(s)));
                }
            }
        }
        return playerHand.isEmpty();
    }

    public void eight()
    {
    	System.out.print("Select a suit (clubs, spades, diamonds, hearts): ");
    	String s = kb.next();
    	while (!s.equals("clubs") && !s.equals("spades") && !s.equals("hearts") && !s.equals("diamonds")) {
    		System.out.print("Select a suit (clubs, spades, diamonds, hearts): ");
    		s = kb.next();
    	}
    	eightSuit = s;
    }
    
    public boolean hasWon(ArrayList<Card> h){
    	return h.isEmpty();
    }
}