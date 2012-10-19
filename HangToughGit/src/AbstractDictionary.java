import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractDictionary implements DictionaryInterface {
	
	/**
	 * Iterates through a text file of words, collects all words of
	 * the specified word length into a Set<String> and returns this
	 * Set<String>.
	 * @param wordLength
	 * @return Set<String>
	 */
	@Override
	public abstract Set<String> getWordSet( int wordLength );
	
	/**
	 * Returns a word from a Set<String> of words.
	 * @param validWordSet
	 * @return String
	 */
	@Override
	public abstract String selectWord( Set<String> validWordSet );
	
	/**
	 * Returns the length of the longest word in the current dictionary
	 * @param dictionary - Set<String> list of words
	 * @return int - the length of the longest word
	 */
	@Override
	public abstract int lengthLongestWord( Set<String> dictionary );
	
	/**
	 * Returns the longest Set of words sorted on the presence and position
	 * of the target char.
	 * @param validWordSet - current list of valid words
	 * @param targetChar - used to sort the current list of valid words into a new list
	 * @return Set<String> new list of valid words
	 */
	public abstract Set<String> getLongestList(Set<String> validWordSet, char targetChar);
	
	/** 
	* Instantiates the Map<String, Set<String>> patternTable with a single key, value pair 
	* where the key = String underscores that is the same length as the user-specified  
	* word length; the value = an empty Set<String>. 
	* @param pattern - a String of underscores 
	* @param wordFromPattern - an empty Set<String> 
	* @return Map<String, Set<String>> patternTable   
	*/
	public abstract Map<String, Set<String>> initializeHashtable( String pattern, Set<String> wordFromPattern );

	
	
}
