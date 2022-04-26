
import java.util.ArrayList;
public class Printer{
  private static Printer inst;

  private Printer(){}

  public static Printer getInstance(){
    if(inst == null){
      inst = new Printer();
    }
    return inst;
  }

  public String printWithBlanks(String str){
	    StringBuilder s = new StringBuilder();
	    for(int i = 0; i < str.length(); i++){
	      s.append((str.charAt(i) == '|' ? "_" : str.charAt(i)) + " ");
	    }
	    return s.toString();
	  }
  
  public String printBoard(Game g){
	    StringBuilder letters = new StringBuilder(" _ _ _ _ _ _ ");
	    String incorrect = letsFromArrayList(g.guessLetters);
	    int numInc = incorrect.length();
	    for(int i = 0, j = 1; i < numInc; i++, j+=2){
	      letters.setCharAt(j, incorrect.charAt(i));
	    }
	    //System.out.println(incorrect);

	    Body b = g.jerry;
	    StringBuilder board = new StringBuilder();
	    board.append("+-----+-+      [-=-=-=-=-=-=-=-=-=-=-]\n");
	    board.append("|     |        [letters used:        ]\n");
	    board.append("|     " + b.head + "        [    " + letters + "    ]\n");
	    board.append("|    " + b.leftArm + b.body + b.rightArm + "       [                     ]\n");
	    board.append("|    "+ b.leftLeg +" " + b.rightLeg + "       [-=-=-=-=-=-=-=-=-=-=-]\n");
	    board.append("|\n");
	    board.append("+----------+\n");
	    board.append("|          |\n");
	    board.append("|          +---+\n");
	    board.append("|              |\n");
	    board.append("+--------------+\n");
	    return board.toString();
	  }
  public String letsFromArrayList(ArrayList<Character> s){
     StringBuilder str = new StringBuilder(s.size());
    for(Character c : s){
      str.append(c);
    }
    return str.toString();
  }
}