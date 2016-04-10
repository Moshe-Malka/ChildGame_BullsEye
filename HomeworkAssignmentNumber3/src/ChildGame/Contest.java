package ChildGame;
import java.util.Scanner;
/**
 * this class gets the name of the players,mixes them,and begins a new game.
 * @author משה
 *
 */
public class Contest 
{
	final static int MAX_COLORS = 10;
	final static int MAX_GUESS_SIZE = 8;
	final static int MAX_PLAYERS = 5;
	private String players[] ;

	private Scanner scn = new Scanner(System.in);

	public Contest()
	{
		getPlayers();
		mixPlayers();
		beginGame();
	}
	/**
	 * this function get's the players from the user.
	 */
	private void getPlayers()
	{
		System.out.println("Please enter the number of players who are playnig: ");
		int numPlayers = scn.nextInt();

		players = new String[numPlayers];

		System.out.println("Please enter the names of the players with a SPACE between them: ");

		for (int i = 0; i < numPlayers; i++)
		{
			players[i] = scn.next();
		}
	}
	/**
	 * this function mix's the list of players and output's a new list of random names from the original list.
	 */
	private void mixPlayers()
	{
		String[] tempArr = new String[players.length];
		int randNumber;
		boolean[] check = new boolean[players.length];
		for (int i = 0; i < check.length; i++) 
		{
			check[i] = false;
		}
		for (int i = 0; i < tempArr.length; i++) 
		{
			randNumber = (int) (Math.random() * (players.length));
			if (check[randNumber] == false) 
			{
				tempArr[i] = players[randNumber];
				check[randNumber] = true;
			}
			else 
			{
				i--;
			}
		}
		players = tempArr;
		System.out.println("the new order of play is: ");
		for (int i = 0; i < tempArr.length; i++) 
		{
			System.out.println(tempArr[i]);
		}
	}
	/**
	 * this function ask's a user if he want's to define a game or to get the default. 
	 */
	private void beginGame()
	{
		System.out.println("type 'TRUE' if you want to define a game, "
				+ "type 'FALSE' if you would like to use the default settings: ");
		boolean tempBool = scn.nextBoolean();
		int numOfColorsChoice;
		int guessSize = 0;
		String tmpColorsChosen;
		char[] colorsChosen = new char[guessSize];
		int numOfTries;
		if(tempBool == false) 
		{
			Game g = new Game(players);
		}
		else 
		{
			System.out.println("how many colors would you like? ");
			numOfColorsChoice = scn.nextInt();
			colorsChosen = new char[numOfColorsChoice];

			System.out.println("please type how many guesses would you like");
			guessSize = scn.nextInt();

			System.out.println("please type the "+colorsChosen.length+" colors you want (R/G/B/O/P/Y) ");
			tmpColorsChosen = scn.next();
			for (int i = 0; i < colorsChosen.length; i++) 
			{
				colorsChosen[i] = tmpColorsChosen.charAt(i);
			}
			System.out.println("how many tries would you like? ");
			numOfTries = scn.nextInt();

			Game g1 = new Game(players,colorsChosen,guessSize, numOfTries);
		}
	}
}