package Hangman;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
/**
 * Write a description of class HangmanController here.
 * 
 * @Philip Raath in collaboration with Andrew Canastar
 * @version 09.23.12
 */
public class HangmanController implements HangmanControllerInterface
{
    /**
     * Constructor for objects of class HangmanController
     */
	private int guessLimit;
	private int wordLength;
	private String word;
	private DictionaryInterface dictionary;
	private HangmanGameInterface hangGame;
	private HangmanUIInterface userInterface;
	private char currentGuess;
    
	public HangmanController()
    {
    	userInterface = new HangmanUI();
    	dictionary = new Dictionary();
    }
    
    @Override
    /**
     * Instantiates a user interface.
     */
    public void startUserInterface(){
    	userInterface.displayWelcome();
    	guessLimit = userInterface.askGuessLimit();
    	wordLength = userInterface.askWordLength();  
    }
    
    @Override
    /**
     * Obtains a word of the correct length from a Dictionary.
     * 
     * @param int wordLength
     * @return String
     */
    public String getWord( int wordLength )
    {
        Set<String> wordSet = dictionary.getWordSet(wordLength);
        word = dictionary.selectWord(wordSet);
//        correctAnswer = word;
        return word;
    }
    
    @Override
    /**
     * Instantiates a new Hangman game.
     * 
     * @param String word ; the word guessed against in the Hangman game
     * @param int guessLimit ; the maximum number of incorrect guesses in the game
     */
    public void startGame()
    {
    	this.hangGame = new HangmanGame(getWord(wordLength), guessLimit);
    }
    
    @Override
    /**
     * Plays through a single round of the game
     */
    public void playRound()
    {
    	userInterface.displayCurrentState(hangGame.getGuessesLeft(), hangGame.getGuessList(), (ArrayList<Character>) hangGame.getViewList());
//    	hangGame.validateGuess(userInterface.askGuess());
    	currentGuess = userInterface.askGuess();
    	currentGuess = Character.toLowerCase(currentGuess);
    	if(hangGame.checkAlreadyGuessed(currentGuess))
    	{
    		userInterface.displayAlreadyGuess(currentGuess);
    	}
    	else if(hangGame.checkCorrectGuess(currentGuess)){
    		userInterface.displayCorrectGuess(currentGuess);
    		hangGame.updateViewList(currentGuess);
    		hangGame.decrementBlanks();
    	}
    	else
    	{
    		userInterface.displayIncorrectGuess(currentGuess);
    		hangGame.decrementGuessLimit();
    	}
    	hangGame.updateGuessList(currentGuess);
    	
    	if(hangGame.getGuessesLeft()!=0 && hangGame.getNumBlanks()!=0)
    	{
    		playRound();
    	}
    	else if(hangGame.getGuessesLeft()==0 && hangGame.getNumBlanks()!=0)
    	{
    		userInterface.displayLossMessage();
    		userInterface.displayAnswer(word);
    	}
    	else if(hangGame.getGuessesLeft()!=0 && hangGame.getNumBlanks()==0)
    	{
    		userInterface.displayWinMessage();
    	}
    	else if(hangGame.getGuessesLeft()==0 && hangGame.getNumBlanks()==0)
    	{
    		userInterface.displayWinMessage();
    	}
    	endGame();
    }
    
    @Override
    /**
     * Cycles playRound() and ends the game when the user either wins or loses
     */
    public void endGame()
    {
    	if( userInterface.askNewGame() )
    	{
    		StartHangman startHanging = new StartHangman();
    		startHanging.run();
    	}
    	else
    	{
    		System.out.println("Ok. Goodbye.");
    		System.exit(0);
    	}
    }
    
    
    
    

}
