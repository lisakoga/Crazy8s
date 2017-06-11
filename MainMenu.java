import java.util.Scanner;
public class MainMenu 
{
	@SuppressWarnings("static-access")
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner (System.in);
		boolean play = true, quit = false;
		
		while (play)
		{
			System.out.println("****CRAZY EIGHTS****");
			System.out.println("\nWhat would you like to do? Please enter:\nNew Game\nRules\nQuit");
			String option = keyboard.nextLine();
		
			// show rules
			if (option.equalsIgnoreCase("rules"))
			{
				String rules = "\nYou have five cards in your hand to begin, and the goal is to \n"
						+ "get rid of all of them. Each turn, you must play a card onto \n"
						+ "the discard pile. This card must match either the number or the \n"
						+ "suit of the face up card. If you don't have any cards that you \n"
						+ "can play, you must draw cards from the deck until you pick up \n"
						+ "a card that can be played. If the deck runs out, the discard \n"
						+ "pile will be shuffled and you may continue drawing cards. All \n"
						+ "of the eights are wild. This means that you can play an eight \n"
						+ "on top of any card and when you do, you must declare which \n"
						+ "suit you would to change it to. If an eight is face up, you \n"
						+ "must either play a card of the declared suit or play another 8.";
				System.out.println(rules);
			}
			// start a new game
			else if (option.equalsIgnoreCase("new game"))
			{
				crazyEights game = new crazyEights();
				game.getDeck().putFirstCard();
				game.getDeck().setTopUsed(game.getDeck().getOrigincards().get(0));
				
				while (!game.winner() && !quit)
				{
					// a player's turn
					try
					{
						if(game.play())
							game.ai.takeTurn(); // ai's turn
					}
					catch(Exception e)
					{
						quit = true;
					}
					System.out.println(game.ai.takeTurn());
					
					if (game.playerHand.isEmpty())
					{
						System.out.println("You win!");
					}
					if (game.compHand.isEmpty())
					{
						System.out.println("You lose...");
					}
				}
			}
			// quit the game
			else if (option.equalsIgnoreCase("quit"))
			{
				System.out.println("Thank you for playing!");
				play = false;
				keyboard.close();
				System.exit(0);
			}
			// if input was invalid
			else
			{
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
}
