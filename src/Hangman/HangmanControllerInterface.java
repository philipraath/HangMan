package Hangman;

import java.util.Set;
/**
 * Write a description of interface HangmanControllerInterface here.
 * 
 * @Philip Raath in collaboration with Andrew Canastar
 * @version 09.23.12
 */
public interface HangmanControllerInterface
{
    /**
     * Instantiates a user interface.
     */
    void startUserInterface();
    
    /**
     * Obtains a word of the correct length from a Dictionary.
     * 
     * @param int wordLength
     * @return String
     */
    String getWord( int wordLength );
    
    /**
     * Instantiates a new Hangman game.
     * 
     * @param String word ; the word guessed against in the Hangman game
     * @param int guessLimit ; the maximum number of incorrect guesses in the game
     */
    void startGame();
    
    /**
     * Plays through a single round of the game
     */
    void playRound();
    
    /**
     * Cycles playRound() and ends the game when the user either wins or loses
     */
    void endGame();
}
