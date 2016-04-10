package ChildGame;
import java.util.Scanner;
/**
 * this class generates the guess,counts pgiot and bulim,and prints the results to the screen.
 * @author משה
 *
 */
public class Guess 
{
	private Scanner scn = new Scanner(System.in);

	private char[] theGuess;
	private int numberOfColors;
	private char[] colorsArray;
	private int guessSize;
	private int bulim;
	private int pgiot;
	
	public Guess(int n , char[] ca , int gs) 
	{
		numberOfColors = n;
		colorsArray = ca;
		guessSize = gs;

	}
/**
 * this function gets the user's guess.
 */
	public void getUserGuess()
	{
		theGuess =new char[guessSize];
		String tempStringGuess;
		tempStringGuess = scn.next();
		for (int i = 0; i < tempStringGuess.length(); i++) {
			theGuess[i] = tempStringGuess.charAt(i);
		}
	}
	/**
	 * this function counts the amount of "bulim".
	 * @param target
	 * @return 
	 */
	public int countBulim(char[] target)
	{	
		bulim=0;
		for (int i = 0; i < theGuess.length; i++) {
			if (target[i]==theGuess[i]){
				bulim++;;
			}
		}
		return bulim;
	}
	/**
	 * this function counts the amount of "pgiot".
	 * @param target
	 * @return
	 */
	public int countPgiot(char[] target)
	{
		pgiot = 0;
		for (int i = 0; i <guessSize; i++) 
		{
			for (int j = 0; j < guessSize; j++) 
			{
				if (target[i]==theGuess[j] &&   (i!=j)) 
				{
					pgiot++;
				}
			}
		}
		return pgiot;
	}
	/**
	 * this function prints out the sum of bulim and pgiot,
	 * <p>
	 * and if there are 4 "bulim" -  the user wins the game.
	 * @return
	 */
	public boolean printGuess()
	{
		System.out.println("Direct Hit Count ( BULIM): "+bulim+"\n"+"Hit Count (PGIOT): "+pgiot+"\n");
		if (bulim == 4) 
			return true;
		else
			return false;
	}
}
