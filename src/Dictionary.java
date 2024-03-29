import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Dictionary extends AbstractDictionary {

	Set<String> dictionary = new TreeSet<String>();
	Set<String> validWordSet = new TreeSet<String>();
	
	public Dictionary(){
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("dictionary.txt");
		Reader reader = new InputStreamReader(inputStream);
		LineNumberReader lineReader = new LineNumberReader(reader);
		
		try
		{
			String line = null;
			while (( line = lineReader.readLine()) != null){
				dictionary.add(line);
			}
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args){
		Dictionary testDictionary = new Dictionary();
		Iterator<String> iterator = testDictionary.dictionary.iterator();
		int maxLength = 0;
		while(iterator.hasNext()){
			if(iterator.next().length()>maxLength)
			{
				maxLength = iterator.next().length();
			}
		}
		
	}
	@Override
	public Set<String> getWordSet(int wordLength) throws IllegalArgumentException 
	{
		int longestWord = lengthLongestWord(dictionary);
		if(wordLength>0 && wordLength<longestWord )
		{
			validWordSet = new TreeSet<String>();
			Iterator<String> iterator = dictionary.iterator();
			String word = null;
			while(iterator.hasNext()){
				word = iterator.next();
				if(word.length()==wordLength){
					validWordSet.add(word);
					
				}
			}
			return validWordSet;
		}
		else
		{
			throw new IllegalArgumentException("Please enter a word length between 0 and " + longestWord);
		}
	}

	@Override
	public String selectWord(Set<String> validWordSet) {
		int randomNumber = generateRandomNumber(validWordSet);
		String selectedWord = (String) validWordSet.toArray()[randomNumber];
		return selectedWord;
	}
	
	@Override
	public int lengthLongestWord( Set<String> dictionary ) {
		int maxWordLength = 0;
		Iterator<String> iterator = dictionary.iterator();
		while( iterator.hasNext() ) {
			int currLength = iterator.next().length();
			if ( currLength > maxWordLength ) {
				maxWordLength = currLength;
			}
		}
		return maxWordLength;
	}
	
	public int generateRandomNumber(Set<String> validWordSet){
		double randomNumberDouble = Math.random();
		int randomNumber = (int) (randomNumberDouble * (validWordSet.size()-1));
		return randomNumber;
	}
	
	public void setDictionary(Set<String> dictionary){
		this.dictionary = dictionary;
	}
	
	public Set<String> getDictionary(){
		return dictionary;
	}

	@Override
	public Set<String> getLongestList(Set<String> validWordSet, char targetChar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> addWord(String newWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generatePattern(char currentGuess, String currentValidWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ArrayList<String>> initializeHashtable(String pattern,
			ArrayList<String> wordFromPattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ArrayList<String>> newKeyValuePair(String pattern,
			String wordFromPattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ArrayList<String>> addKeyValuePair(
			Map<String, ArrayList<String>> patternTable,
			Map<String, ArrayList<String>> newKeyValuePair) {
		// TODO Auto-generated method stub
		return null;
	}

}
