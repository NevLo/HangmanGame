
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    String in;
    /*
    Printer p = Printer.getInstance();
    p.printBoard();
    p.printWithBlanks("hello world!");
    Game g = new Game();
    g.init("words.txt");
    System.out.println(g.word);
    p.printWithBlanks(g.wordGuess);
    */
    do{
      in = "";
      Game g = new Game();
      try {
    	  g.init("words.txt");
      }catch(FileNotFoundException e) {
    	  System.out.println("File Not Found");
      } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      g.play(System.in);
      Scanner s = new Scanner(System.in);
      System.out.println("would you like to play again?");
      while(!s.hasNext());
      in = s.nextLine();
    }while(in.equals("yes"));
    
    System.out.println("Thanks for playing!");
  }
}