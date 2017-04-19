import java.util.Scanner;
public class MainMenu 
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("****CRAZY EIGHTS****");
		System.out.println("\nWhat would you like to do? Please enter:\nNew Game\nRules\nQuit");
		String option = keyboard.nextLine();
		
		while (!option.equalsIgnoreCase("quit"))
		{
			if (option.equalsIgnoreCase("rules"))
			{
				String rules = "You have five cards in your hand to begin, and you want to get rid of all of those cards."
						+ "\nEach turn, the you must place a legal card onto the discard pile."
						+ "\nIf you don't have a leagl card, you must draw cards from the stock until you pick up a card that can be played."
						+ "\nIf the stock runs out, shuffle the discard pile and continue drawing cards."
						+ "\nIf the top card on the discard pile is not an 8, you can play any card that matches the number or suit of the card."
						+ "\nAll of the eights are the wild. If you put an 8 down, you must declare what suit you want to change it to."
						+ "\nThe next player must either play a card of the declared suit or play another 8.";
				System.out.println(rules);
			}
			else if (option.equalsIgnoreCase("new game"))
			{
				// ***I have still been working on this section***
				
				//Game newGame = new Game();
				crazyEights crazyEight = new crazyEights();
				crazyEight.play();
			}
			else
			{
				System.out.println("Invalid input");
			}
			System.out.println("\nWhat would you like to do? Please enter:\nNew Game\nRules\nQuit");
			option = keyboard.nextLine();
		}
		if (option.equalsIgnoreCase("quit"))
		{
			System.out.println("Thank you for playing!");
		}
	}
	
}
