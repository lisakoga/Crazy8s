import java.util.ArrayList;
public class Game 
{
    private static Deck deck;
    protected ArrayList<Card> playerHand;
    protected static ArrayList<Card> compHand;

    public Game() 
    {
        playerHand = new ArrayList<Card>();
        compHand = new ArrayList<Card>();
        deck = new Deck();
    }

    public static ArrayList<Card> getCompHand() 
    {
        return compHand;
    }

    public ArrayList<Card> getHand() 
    {
        return playerHand;
    }
    public void drawToPlayer()
    {
        playerHand.add(deck.DrawValueofCard());
    }
    public static void drawToComputer()
    {
        compHand.add(deck.DrawValueofCard());
    }
    public Card getTop()
    {
        return deck.getTopUsed();
    }
    public static Deck getDeck() 
    {
        return deck;
    }

    public void deal(int n) 
    {
        for (int i = 0; i < n; i++) 
        {
            playerHand.add(deck.DrawValueofCard());
            compHand.add(deck.DrawValueofCard());
        }
    }
}
