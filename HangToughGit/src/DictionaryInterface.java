import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public interface DictionaryInterface {

	/**
	 * Iterates through a text file of words, collects all words of
	 * the specified word length into a Set<String> and returns this
	 * Set<String>.
	 * @param wordLength
	 * @return Set<String>
	 */
	Set<String> getWordSet( int wordLength );
	
	/**
	 * Returns a word from a Set<String> of words.
	 * @param validWordSet
	 * @return String
	 */
	String selectWord( Set<String> validWordSet );
	
	/**
	 * Returns the length of the longest word in the current dictionary
	 * @param dictionary - Set<String> list of words
	 * @return int - the length of the longest word
	 */
	int lengthLongestWord( Set<String> dictionary );
	
	ArrayList<String> addWord( String newWord ); 
	
	String generatePattern( char currentGuess, String currentValidWord );
	
	Map<String, ArrayList<String>> initializeHashtable( String pattern, ArrayList<String> wordFromPattern );
	
	Map<String, ArrayList<String>> newKeyValuePair( String pattern, String wordFromPattern );
	
	Map<String, ArrayList<String>> addKeyValuePair( Map<String, ArrayList<String>> patternTable, 
													Map<String, ArrayList<String>> newKeyValuePair );
	
	
	
	
	
	
}
