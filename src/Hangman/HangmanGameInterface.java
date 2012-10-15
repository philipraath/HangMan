package Hangman;

import java.util.*;
/**
 * Write a description of interface HangmanGame here.
 * 
 * @Philip Raath in collaboration with Andrew Canastar
 * @version 09.23.12
 */
public interface HangmanGameInterface
{
    boolean validateGuess(char guess);
    /**
     * Should be implemented as static
     */
    String chooseWord( int numLetters );
    
    Set<Character> updateGuessList( char letter );
    
    int decrementGuessLimit();
    
    List<Character> updateViewList(char input);
    
    int decrementBlanks();
    
    int getGuessesLeft();
    
    Set<Character> getGuessList();
    
    List<Character> getViewList();
	
    boolean checkCorrectGuess(char currentGuess);
    
    boolean checkAlreadyGuessed(char guess);
    
    int getNumBlanks();
    
}
