import java.util.ArrayList;
import java.util.Set;


public class HangmanGUI implements HangmanUIInterface {

	@Override
	public void displayWelcome() {
		// TODO Auto-generated method stub

	}

	@Override
	public char askGuess() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int askGuessLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int askWordLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void displayCurrentState(int numberOfGuessesRemaining,
			Set<Character> previousGuesses, ArrayList<Character> currentPattern) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayCorrectGuess(char currentGuess) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayIncorrectGuess(char currentGuess) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayAnswer(String correctAnswer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayWinMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayLossMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayAlreadyGuess(char previouslyGuessed) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean askNewGame() {
		// TODO Auto-generated method stub
		return false;
	}

}
