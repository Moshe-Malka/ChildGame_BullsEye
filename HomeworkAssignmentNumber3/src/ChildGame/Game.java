package ChildGame;
import java.util.Scanner;
/**
 * this class defines the game the user choose to play and execute it.
 * @author משה
 *
 */
public class Game 
{
	private Scanner scn = new Scanner(System.in);

	private String[] gamePlayers;
	private char[] colorsArray = {'R','G','B','O','P','Y'};
	private int numberOfPlayers;
	private int numberOfColors;
	private char[] theTarget;
	private int guessSize;
	private int tries;

	public Game(String[] players)
	{
		numberOfColors =6;
		guessSize = 4;
		tries = 20;
		theTarget = new char[numberOfColors];
		String temp = "RGBOPY";
		for (int i = 0; i < numberOfColors; i++) 
		{
			theTarget[i] = temp.charAt(i);
		}
		gamePlayers = players;
		executeGame(false);
		beginGuesses();
	}

	public Game(String[]players,char[] colors,int guessS,int tries2){
		gamePlayers = players;
		colorsArray = colors;
		guessSize = guessS;
		tries = tries2;
		boolean isSinglePlayer = false;
		if(gamePlayers.length==1){
			isSinglePlayer=true;
		}
		executeGame(isSinglePlayer);
		beginGuesses();
	}
	/**
	 * executeGame check's by a boolean value if the game should create a random target ,
	 * <p>
	 * or get one from the user.
	 * @param isSinglePlayer
	 */
	private void executeGame(boolean isSinglePlayer){
		if (isSinglePlayer == true)
		{
			createRandomTarget();
		}
		else 
		{
			getUserTarget();
		}
	}
	/**
	 * this function creates the random target using the Math.random library.
	 */
	private void createRandomTarget()
	{
		char randTarget[] = null;
		boolean[] check = new boolean[colorsArray.length];
		for (int i = 0; i < check.length; i++) 
		{
			check[i] = false;
		}
		int i = 0;
		while ( i < colorsArray.length) {
			if (check[i] == false) 
			{
				randTarget[i] = colorsArray[( (int)(Math.random()*10) % colorsArray.length)];
			}
			else
				i--;
		}	
		theTarget = randTarget;
	}
	/**
	 * this function gets the target from the user.
	 */
	private void getUserTarget()
	{
		theTarget = new char[guessSize];
		Scanner scan = new Scanner(System.in);
		System.out.println("enter your guess chose  "+guessSize+":  B/G/R/Y/O/P");
		String s=null;
		s=scan.nextLine();
		s=s.toUpperCase();
		for (int i = 0; i < theTarget.length; i++) 
		{
			theTarget[i]=(s.charAt(i));
		}
		/*
		String tempUserTarget;
		System.out.println("Hello "+gamePlayers[0]+" Please enter the sequence of colors you'd like (in CAPITAL letters): " );
		boolean errorFlag = false;
		do
		{
			tempUserTarget = scn.next();
			int i;
			for (i = 0; i < guessSize; i++) 
			{
				if (checkColor(tempUserTarget.charAt(i)) && checkNoReps(tempUserTarget.charAt(i),i))
				{
					theTarget[i] = tempUserTarget.charAt(i);
				}
				else
				{
					System.out.println("wrong color in sequence !!! try again ");
					errorFlag=true;
					break;
				}
			}
		}while(errorFlag);
		 */
	}

	//	private boolean checkNoReps(char c, int i) {
	//		// gives true if there are no reps
	//		boolean reps = true; 
	//		for (int j = 0; j < i; j++) {
	//			if (theTarget[j]==c)
	//				reps=false;
	//		}
	//		return reps;
	//	}
	//
	//	private boolean checkColor(char c) {
	//		boolean checkTmp = false;
	//		for (int i = 0; i < colorsArray.length; i++) {
	//			if (c == colorsArray[i])
	//				checkTmp = true;
	//		}
	//		return checkTmp;
	//	}
	/**
	 * this function starts by calling each player,
	 * <p>
	 * asking for his guess,and calling for functions in the Guess class.  
	 */
	private void beginGuesses()
	{
		String []  newGamePlayers=new String [(gamePlayers.length-1)];
		for (int k = 0; k <( (gamePlayers.length)-1); k++) 
		{
			newGamePlayers[k] = gamePlayers[k+1];
		}
		int k=0;
		for (int i = 0; i < tries; i++) 
		{
			System.out.println(newGamePlayers[(k%newGamePlayers.length)]+" please enter your guess");
			k++;
			Guess g = new Guess(numberOfColors, theTarget, guessSize);
			g.getUserGuess();//contains the scanner
			g.countBulim(theTarget);
			g.countPgiot(theTarget);
			if (g.printGuess()==true)
			{
				System.out.println("<---------- YOU WIN !!! ---------->");
				break;
			}
		}
	}	
}
