
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class tests extends TestCase{

	@Test
	public void testPrinterGetting() {
		Printer P = Printer.getInstance();
		assertNotNull(P);
	}
	@Test
	public void testPrintWithBlanksPass() {
		Printer P = Printer.getInstance();
		String S = P.printWithBlanks("Test");
		assertEquals(S, "T e s t ");
	}
	@Test
	public void testPrintWithBlanksFail() {
		Printer P = Printer.getInstance();
		String S = P.printWithBlanks("Test");
		assertNotSame(S, "F A I L");
	}
	@Test
	public void testLetsFromArrayList() {
		Printer P = Printer.getInstance();
		ArrayList<Character> chars = new ArrayList<Character>();
		chars.add('T');
		chars.add('E');
		chars.add('S');
		chars.add('T');
		String s = P.letsFromArrayList(chars);
		assertEquals(s, "TEST");
	}
	
	@Test
	public void testBodyIncrement() {
		Body b = new Body();
		b.incrementLives();
		assertEquals(b.lives, 1);
	}
	@Test
	public void testBodyPartOne() {
		Body b = new Body();
		b.incrementLives();
		b.incrementLives();
		assertEquals(b.head, '0');
	}
	@Test
	public void testBodyPartTwo() {
		Body b = new Body();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		assertEquals(b.leftArm, '/');
	}
	@Test
	public void testBodyPartThree() {
		Body b = new Body();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		assertEquals(b.body, '|');
	}
	@Test
	public void testBodyPartFour() {
		Body b = new Body();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		assertEquals(b.rightArm, '\\');
	}
	@Test
	public void testBodyPartFive() {
		Body b = new Body();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		assertEquals(b.leftLeg, '/');
	}
	@Test
	public void testBodyPartSix() {
		Body b = new Body();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		b.incrementLives();
		assertEquals(b.rightLeg, '\\');
	}

	
	//INTEGRATION TEST, PRINTER - GAME
	@Test
	public void testPrinterPrintBoard() {
		Printer p = Printer.getInstance();
		String s = p.printBoard(new Game("Word"));
		assertNotNull(s);
	}
	
	@Test
	public void testGameInitGuess() {
		Game g = new Game();
		String s = g.initGuessWord("test");
		//System.out.println(s);
		assertEquals(s, "||||");
	}
	
	@Test
	public void testGameIsInWord() {
		Game g = new Game();
		boolean t = g.isInWord('a', "char");
		assertEquals(t, true);
	}
	//INTEGRATION TEST, GAME - FILE IO
	@Test
	public void testGameInitFileNotFound() {
		Game g = new Game();
		try {
			g.init("nothing.txt");
		}catch(FileNotFoundException e) {
			assert(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//INTEGRATION TEST, GAME - FILE IO
	@Test
	public void testGameInit() {
		Game g = new Game();
		try {
			g.init("words.txt");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotSame(g.word, "");
	}
	//INTEGRATION TEST, Game - FILE IO
	public void testGameInitGuessWord() {
		Game g = new Game();
		try {
			g.init("words.txt");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotSame(g.wordGuess, "");
	}
	//INTEGRATION TEST, GAME - CONSOLE
	@Test
	public void testGamePlay() {
		Game g = new Game();
		try {
			g.init("words.txt");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = g.word;
		System.out.println(s);
		if(g.play(System.in)) {
			assert(true);
		} 
	}
	@Test
	public void test() {
		assertEquals(1,2); 
	}
}

