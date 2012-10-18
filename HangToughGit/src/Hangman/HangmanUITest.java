package Hangman;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Boolean;

/**
 * The test class HangmanUITest.
 *
 * @Philip Raath in collaboration with Andrew Canastar
 * @version 09.23.12
 */
public class HangmanUITest
{
    /**
     * Default constructor for test class HangmanUITest
     */
    public HangmanUITest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Tests if the char returned by askGuess() is a letter.
     */
    @Test
    public void askGuessTest()
    {
        HangmanUI hangUI = new HangmanUI();   
        System.out.println("For this test, please enter a lowercase letter from A to Z.");
        char testValue = hangUI.askGuess();
        assertTrue(Character.isLetter(testValue));
        System.out.println("For this test, please enter a word.");
        testValue = hangUI.askGuess();
        assertTrue(Character.isLetter(testValue));
    }
    
    /**
     * Tests if the value returned by askGuessLimit() is a positive value.
     */
    @Test
    public void askGuessLimitTest()
    {
        HangmanUI hangUI = new HangmanUI();
        int testValue = hangUI.askGuessLimit();
        assertTrue(testValue>0);
    }
    
    /**
     * Tests if the value returned by askWordLength() is a positive value.
     */
    @Test
    public void askWordLengthTest()
    {
    	HangmanUI hangUI = new HangmanUI();
        int testValue = hangUI.askWordLength();
        assertTrue(testValue>0);
    }
    
    /**
     * For now, tests if the value returned by askNewGame() is true or false,
     * and fails if it is false.
     * I would like to change this test to check if a boolean is being returned.
     */
    @Test
    public void askNewGameTest()
    {
        HangmanUI hangUI = new HangmanUI();
        //my hope is that the following test will verify that we are recieving a
        //boolean. if the final test fails, we don't know if the reason is a false
        //value or a non boolean value
        assert(Boolean.valueOf(hangUI.askNewGame()) instanceof Boolean);
        assertEquals(true, hangUI.askNewGame());
    }

}

