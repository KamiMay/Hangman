import java.util.ArrayList;

public class GameStats {
	
	private int wrongGuesses;
	private ArrayList<String> guessedLetters = new ArrayList<>();
	
	//Instance for setting how many times you can get wrong
	public GameStats(){
		this.wrongGuesses = 7;
	}	
	
	//get number of wrongGuesses
	public int getWrongGuess(){
		return wrongGuesses;
	}
	
	//get an array of guessed letters 
	public ArrayList<String> getGuessedLetters(){
		return guessedLetters;
	}
	
	//when called, subtract 1 from current wrongGuesses
	public void setWrongGuess(){
		wrongGuesses--;
	}
	
	//in the guessedLetters array, add the guessed letter
	public void setGuessedLetters(String letter){
		guessedLetters.add(letter);
	}
	
	//TODO: returns boolean, takes in a string (letter) and an array of letters to compare letter to
	public boolean letterExists(String letter){
		return guessedLetters.contains(letter);
	}
}
