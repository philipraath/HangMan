package Hangman;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {
	
	private Set<String> validWordSet;
	private Set<String> longestWordSet;
	
	@Before
	public void setUp(){
		validWordSet = new TreeSet<String>();
		validWordSet.add("three");
		validWordSet.add("trust");
		validWordSet.add("steal");
		validWordSet.add("fired");
		validWordSet.add("chair");
		validWordSet.add("locus");
		
		longestWordSet = new TreeSet<String>();
		longestWordSet.add("a");
		longestWordSet.add("aa");
		longestWordSet.add("aaa");
		longestWordSet.add("aaaa");
		longestWordSet.add("aaaaa");
		longestWordSet.add("aaaaaa");
		longestWordSet.add("aaaaaaa");
		longestWordSet.add("aaaaaaaa");
		longestWordSet.add("aaaaaaaaa");
		longestWordSet.add("aaaaaaaaaa");
		longestWordSet.add("aaaaaaaaaaa");
		longestWordSet.add("aaaaaaaaaaaa");
	}
	
	@Test
	public void lengthLongestWordTest()
	{
		Dictionary testDictionary = new Dictionary();	
		int length = testDictionary.lengthLongestWord(longestWordSet);
		assertEquals(12, length);
	}
	
	@Test
	public void getWordSetTest()
	{
		// Testing: Set<String> getWordSet( int wordLength );
		
		// Are all words in the set of the correct length (compared to the param)?
		
		// Should cases of zero be handled by this method or beforehand?
		
		// All words in the set are of the correct length
		
		// When the int is too large it will return an empty set...a method should be called to
		// handle the empty set.
		int wordLength = 3;
		Dictionary testDictionary = new Dictionary();
		assertNotNull(testDictionary);
		Set<String> validWords = testDictionary.getWordSet(wordLength);
		assertNotNull(validWords);
		Iterator<String> iterator = validWords.iterator();
		for (int i = 0; i<validWords.size(); i++)
		{
			assertEquals(wordLength, iterator.next().length());
		}
		
		try{												
			testDictionary.getWordSet(-1); //test that negative value throws error
			fail("No illegal argument exception thrown");
			}
		catch (IllegalArgumentException e)
	       {
	    	   assertTrue(true);
	       }
	    catch (Exception e)
	       {
	    	   fail ("checkGuess() threw improper exception for out of range value.");
	       }
		
		try{												
			testDictionary.getWordSet(0); //test that value 0 throws error
			fail("No illegal argument exception thrown");
			}
		catch (IllegalArgumentException e)
	       {
	    	   assertTrue(true);
	       }
	    catch (Exception e)
	       {
	    	   fail ("checkGuess() threw improper exception for out of range value.");
	       }
		
		try{
			testDictionary.getWordSet(46); //test that value greater than 45 throws error
			fail("No illegal argument exception thrown");
			}
		catch (IllegalArgumentException e)
	       {
	    	   assertTrue(true);
	       }
	    catch (Exception e)
	       {
	    	   fail ("checkGuess() threw improper exception for out of range value.");
	       }
	}
	
	@Test
	public void selectWordTest()
	{		
		// Returns a String randomly selected from the Set	
		Dictionary testDictionary = new Dictionary();
		assertNotNull(testDictionary);
		assertTrue(validWordSet.contains(testDictionary.selectWord(validWordSet)));
	}
	
	@Test
	public void generateRandomNumberTest()
	{
		Dictionary testDictionary = new Dictionary();
		assertNotNull(testDictionary);
		int testValue = testDictionary.generateRandomNumber(validWordSet);
		assertTrue(testValue >-1 && testValue < validWordSet.size());
	}
	
}
