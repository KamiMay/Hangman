import java.util.ArrayList;
import java.util.Random;

public class Game {

	public void startGame(){
		GameUtils gu = new GameUtils();
		GameStats gs = new GameStats();

		ArrayList<String> allWords = gu.getWords("dict.txt");
		int index = new Random().nextInt(allWords.size());
		String word = allWords.get(index);
		System.out.println(gu.updateWord(word, gs.getGuessedLetters()));
		
		while (gs.getWrongGuess() > 0){
			String letter = gu.guessLetter();
			//If the letter has not been guessed...
			if(!gs.letterExists(letter)){
				
				//If letter does not exist in the word, subtract from current number of wrong guesses
				if(!gu.feedback(word, letter)){
					gs.setWrongGuess();
				}
				gs.setGuessedLetters(letter);
			} else {
				System.out.println("You already tried that.");
			}
			String hash = gu.updateWord(word, gs.getGuessedLetters());
			System.out.println(hash);
			
			if(hash.contains("_")){
				System.out.println(gs.getGuessedLetters().toString() + " You have left: " + gs.getWrongGuess());
			} else {
				System.out.println("You are winner");
				break;
			}
	
		}
		System.out.println("The word was: " + word);
	}
}
