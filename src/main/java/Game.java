
import java.io.*;
import java.util.Scanner;
import java.nio.file.*;
import java.util.ArrayList;
public class Game{
	String word;
	String wordGuess;
	ArrayList<Character> guessLetters;
	Body jerry;
	Game(){
		word = "";
		wordGuess = "";
		guessLetters = new ArrayList<Character>();
		jerry = new Body();
	}
	public Game(String string) {
		word = string;
		wordGuess = initGuessWord(word);
		guessLetters = new ArrayList<Character>();
		jerry = new Body();
	}
	public void init(String file) throws FileNotFoundException, IOException{
		
			Scanner s = new Scanner(new FileReader(file));
			long numLines = Files.lines(Paths.get(file)).count();
			int r = (int)Math.floor(Math.random() * numLines);
			for(int i = 0; i < r; i++){
				s.nextLine();
			}
			word = s.nextLine().toUpperCase();
			s.close();

		wordGuess = initGuessWord(word);
	}
	public boolean play(InputStream iost){
		//System.out.println(word);
		Scanner s = new Scanner(iost);
		System.out.println(Printer.getInstance().printBoard(this));
		System.out.println(Printer.getInstance().printWithBlanks(wordGuess));
		do{
			System.out.println("Please input a letter: ");
			char let = s.nextLine().toUpperCase().charAt(0);
			if(isInWord(let, word)){
				//System.out.println("we in the word baby");
				for(int i = 0; i < word.length(); i++){
					if(let == word.charAt(i)){
						StringBuilder str = new StringBuilder(wordGuess);
						str.setCharAt(i, let);
						wordGuess = str.toString();
					}
				}
			}else{
				guessLetters.add(let);
				jerry.incrementLives();
			}
			try{
				if (System.getProperty("os.name").contains("Windows")) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				}
				else {
					System.out.print("\033\143");
				}
			}catch (Exception e){}
			System.out.println(Printer.getInstance().printBoard(this));
			System.out.println(Printer.getInstance().printWithBlanks(wordGuess));
			if(guessLetters.size() == 6){
				System.out.println("YOU LOSE!!!");
				System.out.println("The word was: " + word);
				return false;
			}
		}while(!word.equals(wordGuess));
		System.out.println("You Win!");
		return true;
	}

	public boolean isInWord(char s, String word){
		return word.indexOf(s) != -1;
	}
	public String initGuessWord(String word2) {
		StringBuilder wor = new StringBuilder();
		for(int i = 0; i < word2.length(); i++){
			wor.append("|");
		}
		//System.out.println(wor.toString());
		return wor.toString();
	}
}