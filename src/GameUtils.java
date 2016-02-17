import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class GameUtils {
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public ArrayList<String> getWords(String fileName){
		//Defining an array of words
		ArrayList<String> words = new ArrayList();
		//Looping through the file
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			//Adding each word from file to an array
			stream.forEach(w->words.add(w));
		} catch (IOException e) {
			//Catching exception if file doesnt exist
			e.printStackTrace();
		}
		//Returning the array
		return words;
	}
	
	//TODO: Create a method that returns the string and takes in a string
	public String updateWord(String word, ArrayList<String> letters){
		StringBuilder sb = new StringBuilder();
		//For each character of word, add string underscore to sb
		for(char character : word.toCharArray()){
			//first set exists to false
			boolean exists = false;
			//a for loop for all of the letters within the word
			for(String letter : letters){
				//if guessed letter is correct, append letter instead of underscore and set exists to true
				if(letter.charAt(0) == character){
					sb.append(letter);
					exists = true;
				}
			}
			//if exists is not true (because guess was wrong), append underscore
			if(!exists){
				sb.append("_ ");
			}
		}
		return sb.toString();
	}
	
	//TODO: Return a char with no input
	public String guessLetter(){
		Scanner scanner = new Scanner(System.in);
		String letter = scanner.nextLine();
		return String.valueOf(letter.charAt(0));
	}
	
	//TODO: method that returns boolean, takes in a string and a char
	public boolean feedback(String word, String letter){
		return word.contains(letter);
	}
	
	

}
