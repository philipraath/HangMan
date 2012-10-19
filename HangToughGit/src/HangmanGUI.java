import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;


public class HangmanGUI implements HangmanUIInterface {
	
	public static void main(String[] args){
		HangmanGUI hanggui = new HangmanGUI();
		hanggui.displayWelcome();
		hanggui.askGuessLimit();
		hanggui.askWordLength();
		hanggui.askGuess();
		Set<Character> state = new TreeSet<Character>();
		ArrayList<Character> previous = new ArrayList<Character>();
		state.add('a');
		previous.add('a');
		hanggui.displayCurrentState(2, state, previous);
		hanggui.displayCorrectGuess('a');
		hanggui.displayIncorrectGuess('a');
	}
	@Override
	public void displayWelcome() {
		JOptionPane.showMessageDialog(null, "Welcome to Hangman!!!");
	}

	@Override
	public char askGuess() {
		String response = JOptionPane.showInputDialog("Please enter a guess: ");
		char guess = response.charAt(0);
		return guess;
	}

	@Override
	public int askGuessLimit() {
		String response = JOptionPane.showInputDialog("Please enter the number of guesses allowed: ");
		char limit = response.charAt(0);
		int guessLimit = (int) limit - 48;
		return guessLimit;
	}

	@Override
	public int askWordLength() {
		String response = JOptionPane.showInputDialog("Please enter the desired length of word: ");
		char length = response.charAt(0);
		int wordLength = (int) length - 48;
		while(wordLength<2 || wordLength>20) {
	  		JOptionPane.showMessageDialog(null, "Please be sure to choose a length between 2 and 20 or be faced with this message again!");
	  		askWordLength();
		}
		return wordLength;
	}

	@Override
	public void displayCurrentState(int numberOfGuessesRemaining,
			Set<Character> previousGuesses, ArrayList<Character> currentPattern) {
		JOptionPane displayState = new JOptionPane();
//		JOptionPane.showMessageDialog(displayState, "Guesses remaining: " + numberOfGuessesRemaining);
//		displayState.setMessage("Guesses remaining: " + numberOfGuessesRemaining);
//		System.out.println("Guesses remaining: " + numberOfGuessesRemaining);
//	  	System.out.println("Previous guesses:" + previousGuesses.toString());
//	  	System.out.println("Current: " + currentPattern.toString() );
		JOptionPane.showInputDialog(null, "test");
		
		//TRICKY!!!!

	}

	@Override
	public void displayCorrectGuess(char currentGuess) {
		JOptionPane.showMessageDialog(null, "You have chosen wisely!!! There is at least one " + currentGuess + ".");

	}

	@Override
	public void displayIncorrectGuess(char currentGuess) {
		JOptionPane.showMessageDialog(null, "You have chosen poorly!!! There are no " + currentGuess + "'s.");
	}

	@Override
	public void displayAnswer(String correctAnswer) {
		JOptionPane.showMessageDialog(null, "The correct answer was: " + correctAnswer + ".");
	}

	@Override
	public void displayWinMessage() {
		JOptionPane.showMessageDialog(null, "Congragulations! You win!");
	}

	@Override
	public void displayLossMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayAlreadyGuess(char previouslyGuessed) {
		JOptionPane.showMessageDialog(null, "You. Lose. So. Sorry. Stop. Crying.");
	}

	@Override
	public boolean askNewGame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void displayGoodbyeMessage() {
		JOptionPane.showMessageDialog(null, "Goodbye!");
		
	}

}
