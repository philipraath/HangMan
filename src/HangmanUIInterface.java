

import java.util.*;
/**
 * Write a description of interface HangmanUI here.
 * 
 * @Philip Raath in collaboration with Andrew Canastar
 * @version 09.23.12
 */
public interface HangmanUIInterface
{
    /**
     * Displays welcome message.
     */
    public void displayWelcome();
    
    /**
     * Request user input for current guess.
     * @return  char
     */
    public char askGuess();
    
    /**
     * Request user input for the number of guesses allowed.
     * @return  int
     */
    public int askGuessLimit();
    
    /**
     * Request length of word.
     * @return  int
     */
    public int askWordLength();
    
    /**
     * Display current state of game consisting of guesses left, array of previously guess letters,
     * and current pattern of blanks and correct guesses.
     * 
     * @param int numberOfGuessesRemaining
     * @param Set previousGuesses a set that contains all previous guesses with no duplicate values
     * @param ArrayList<Character> currentPattern contains a pattern of letters and blanks
     */
    public void displayCurrentState(int numberOfGuessesRemaining, Set<Character> previousGuesses, ArrayList<Character> currentPattern);
    
    /**
     * Report that current guess is correct.
     * @param char currentGuess
     */
    public void displayCorrectGuess(char currentGuess);
    
    /**
     * Report that current guess is incorrect.
     * @param char currentGuess
     */
    public void displayIncorrectGuess(char currentGuess);
    
    /**
     * Display correct answer.
     * @param String correctAnswer
     */
    public void displayAnswer(String correctAnswer);
    
    /**
     Display win message.
     */
    public void displayWinMessage();
    
    /**
     Display loss message.
     */
    public void displayLossMessage();
    
    
    /**
     * Display previously guessed message
     * @param previouslyGuessed char that has already been guessed
     */
    public void displayAlreadyGuess(char previouslyGuessed);
    
    /**
     Ask user if they wish to play another game.
     * @return  boolean true if user requests a new game; false otherwise
     */
    public boolean askNewGame();
    
}
