import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;


public class HangmanTUI extends AbstractHangmanUI {

//  protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
  private static Scanner scanner = new Scanner(System.in);
  /**
   * Constructor for objects of class HangmanUI
   */
  public HangmanTUI(){
      
  }
  
  public static void main (String[] args)
  {
  	HangmanUIInterface UI = new HangmanTUI();

  }

  @Override
  /**
   * Displays welcome message.
   */
  public void displayWelcome(){
  	System.out.println("Welcome to Hangman!!!***Exciting!!!***Exclamation marks!!!!");
  }
  
  @Override
  /**
   * Request user input for current guess.
   * @return  char
   */
  public char askGuess() 
  {
  	InputStreamReader reader = new InputStreamReader(System.in);
      System.out.println("Please enter a guess: ");
      char[] charArray = new char[1];
      try {
		reader.read(charArray);
      } 
      catch (IOException e) 
      {
		e.printStackTrace();
      }       
      return charArray[0];
  }
  
  @Override
  /**
   * Request user input for the number of guesses allowed.
   * @return  int
   */
  public int askGuessLimit()
  {
      System.out.println("Please enter the number of guesses allowed: ");
      int guessLimit = scanner.nextInt();
      return guessLimit;
  }
  
  
  @Override
  /**
   * Request length of word.
   * @return  int
   */
  public int askWordLength()
  {
  	int wordLength = 0;
  	System.out.println("Please enter the desired length of word: ");
  	wordLength = scanner.nextInt();
  	while(wordLength<2 || wordLength>20) {
  		System.out.println("Please be sure to choose a length between 2 and 20 or be faced with this message again!");
  		askWordLength();
  	}
      return wordLength;
  }
  
  @Override
  /**
   * Display current state of game consisting of guesses left, array of previously guess letters,
   * and current pattern of blanks and correct guesses.
   * 
   * @param int numberOfGuessesRemaining
   * @param Set previousGuesses a set that contains all previous guesses with no duplicate values
   * @param ArrayList<Character> currentPattern contains a pattern of letters and blanks
   */
  public void displayCurrentState(int numberOfGuessesRemaining, Set<Character> previousGuesses, ArrayList<Character> currentPattern)
  {
  	System.out.println("Guesses remaining: " + numberOfGuessesRemaining);
  	System.out.println("Previous guesses:" + previousGuesses.toString());
  	System.out.println("Current: " + currentPattern.toString() );
  }
  
  @Override
  /**
   * Report that current guess is correct.
   * @param char currentGuess
   */
  public void displayCorrectGuess(char currentGuess)
  {
  	System.out.println("You have chosen wisely!!! There is at least one " + currentGuess + ".");
  }
  
  @Override
  /**
   * Report that current guess is incorrect.
   * @param char currentGuess
   */
  public void displayIncorrectGuess(char currentGuess)
  {
  	System.out.println("You have chosen poorly!!! There are no " + currentGuess + "'s.");
  }
  
  @Override
  /**
   * Display correct answer.
   * @param String correctAnswer
   */
  public void displayAnswer(String correctAnswer)
  {
  	System.out.println("The correct answer was: " + correctAnswer + ".");
  }
  
  @Override
  /**
   Display win message.
   */
  public void displayWinMessage()
  {
  	System.out.println("Congragulations! You win!");
  }
  
  @Override
  /**
   Display loss message.
   */
  public void displayLossMessage()
  {
  	System.out.println("You. Lose. So. Sorry. Stop. Crying.");
  }
  
  public void displayAlreadyGuess(char previouslyGuessed)
  {
  	System.out.println("You have already guessed " + previouslyGuessed + ".");
  }
  
  @Override
  /**
   Ask user if they wish to play another game.
   * @return  boolean true if user requests a new game; false otherwise
   */
  public boolean askNewGame()
  {
  	InputStreamReader reader = new InputStreamReader(System.in);
      System.out.println("Would you like to play another game? (Y or N)?: ");
      char[] charArray = new char[1];
      try {
		reader.read(charArray);
      } 
      catch (IOException e) 
      {
		e.printStackTrace();
      }     
      while(charArray[0]!='y' && charArray[0]!='Y' && charArray[0]!='n' && charArray[0]!='N')
      {
      	System.out.println("Please restrict your response to 'y' for yes or 'n' for no!");
      	askNewGame();
      }
      if(charArray[0]=='y' || charArray[0]=='Y')
      {
      	return true;
      }
      else
      {
      	return false;
      }
  }
}
