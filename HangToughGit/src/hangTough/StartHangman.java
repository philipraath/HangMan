package hangTough;
// always check length of word choice, it may not exist
// change dictionary interface to return set of words
// 
public class StartHangman {
	/**
	 * @param args
	 */
	public StartHangman() {}
	
	public void run()
	{
		HangmanControllerInterface hangController = new HangmanController();
		hangController.startUserInterface();
		hangController.startGame();
		hangController.playRound();
	}
	
	public static void main(String[] args) 
	{
		StartHangman startHanging = new StartHangman();
		startHanging.run();
	}

}
