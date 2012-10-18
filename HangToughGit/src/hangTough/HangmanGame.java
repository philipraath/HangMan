package hangTough;
import java.util.*;
/**
 * Write a description of class HangmanGame here.
 * 
 * @Philip Raath in collaboration with Andrew Canastar
 * @version 09.23.12
 */
public class HangmanGame implements HangmanGameInterface
{
	private String targetWord;
	private List<Character> viewList;
	private SortedSet<Character> guessList = new TreeSet<Character>(); 
	private DictionaryInterface dictionary = new Dictionary();
	private int guessesLeft, numBlanks;
	
    public HangmanGame()
    {
    }

    public HangmanGame(String targetWord, int guessesLeft)
    {
    	this.targetWord = targetWord;
    	this.viewList = new ArrayList<Character>(targetWord.length());
    	this.numBlanks = targetWord.length();
    	for(int i = 0; i<numBlanks; i++)
    	{
    		viewList.add('-');
    	}
    	this.guessesLeft = guessesLeft;
    }
    
    public HangmanGame(String targetWord) //for testing purposes
    {
    	this.targetWord = targetWord;
    	this.viewList = new ArrayList<Character>(targetWord.length());
    	this.numBlanks = targetWord.length();
    	for(int i = 0; i<numBlanks; i++)
    	{
    		viewList.add('-');
    	}
    }
    
    public HangmanGame(int guessesLeft) //for testing purposes
    {
    	this.guessesLeft = guessesLeft;
    }
    
    public int getGuessesLeft()
    {
    	return this.guessesLeft;
    }
    
    @Override
    public boolean validateGuess(char guess) throws IllegalArgumentException
    {
    	
    	boolean isValidChar = false; 
    	if(Character.isLetter(guess))
        {
        	isValidChar = true;
        }
        else 
        {
        	throw new IllegalArgumentException("Please enter a letter.");
        }
    return isValidChar;  
    }
    
    public boolean checkAlreadyGuessed(char guess)
    {
    	boolean alreadyGuessed = false;
    	if(guessList.contains(guess))
    	{
    		alreadyGuessed = true;
    	}
    	else
    	{
    		alreadyGuessed = false;
    	}
    	
    	return alreadyGuessed;
    }
    
    public boolean checkCorrectGuess(char guess)
    {
//    	System.out.println("current char = " + guess);
    	boolean correct = false;
    	if(validateGuess(guess))
    	{
    		if(targetWord.indexOf(guess)!=-1)
    		{
    			correct = true;
    		}
    		else
    		{
    			correct = false;
    		}
    	}
		return correct;
    }
    
    /**
     * Should be implemented as static
     */
    @Override
    public String chooseWord( int numLetters )
    {
    	return dictionary.selectWord(dictionary.getWordSet(numLetters));

    }
    
    @Override
    public Set<Character> updateGuessList( char letter )
    {
        guessList.add( letter );
    	return guessList;
    }
    
    @Override
    public int decrementGuessLimit()
    {
    	return --guessesLeft;
    }
    
    public List<Character> updateViewList(char input)
    {
    	
        int targetLength = targetWord.length();
    	for (int index = 0; index<targetLength; index++)
    	{
    		if(targetWord.charAt(index)==input){
    			viewList.set(index, input);
    		}
    	}
    	return viewList;
    }
    
    @Override
    public int decrementBlanks()
    {
    	return --numBlanks;
    }
    
    public int getNumBlanks()
    {
    	return numBlanks;
    }
    
    public Set<Character> getGuessList()
    {
    	return guessList;
    }
    
    public List<Character> getViewList()
    {
    	return viewList;
    }

}
