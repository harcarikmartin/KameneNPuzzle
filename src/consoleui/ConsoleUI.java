package consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.Field;
import core.GameState;
import kamene.UserInterface;

public class ConsoleUI implements UserInterface{
	private static Pattern PATTERN = Pattern.compile("(new)|(exit)|(w|up)|(s|down)|(a|left)|(d|right)");
	
	private Field field;
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public void newGameStarted(Field field) {
		this.field = field;
		printField();
		shuffle();
		
//		do {
//			update();
//			if (field.getState().equals(GameState.SOLVED)) {
//				System.out.println("You WON");
//				System.exit(0);
//			}
			processInput();
//		} while (true);
		
	}

	private void shuffle() {
		Collections.shuffle(field.getTiles());
		printField();
	}

	private void processInput() {
		System.out.printf("Please enter your selection <new> NEW GAME, <exit> EXIT, <w/up> UP, "
				+ "<s/down> DOWN, <a/left> LEFT, <d/right> RIGHT: ");
		String input = readLine();
		try {
			handleInput(input);
		} catch (WrongFormatException e) {
			
			e.printStackTrace();
		}
	}
	
	private String readLine() {
		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private void handleInput(String input) throws WrongFormatException {
		Matcher matcher = PATTERN.matcher(input);
		
		if(matcher.matches()) {
			String newGame = matcher.group(1);
			String exit = matcher.group(2);
			String up = matcher.group(3);
			String down = matcher.group(4);
			String left = matcher.group(5);
			String right = matcher.group(6);
			
			for (int i = 0; i <= matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
			if(newGame != null) {
				
			}
			if(exit == null) {
				exit = "";
			}
			if(exit != null) {
				System.out.println("Exit");
				System.exit(0);
			}
			if(up != null) {
				field.moveTileUp();
			}
			if(down != null) {
				field.moveTileDown();
			}
			if(left != null) {
				field.moveTileLeft();
			}
			if(right != null) {
				field.moveTileRight();
			}
		}
		else {
			throw new WrongFormatException("Wrong format of input, try again.");
		}
	}

	@Override
	public void printField() {
		for (int i = 0; i < field.getRowCount(); i++) {
			for (int j = 0; j < field.getColumnCount(); j++) {
				System.out.printf("%4d", field.getTiles().get(field.getColumnCount() * i + j));
			}
			System.out.println();
		}
		System.out.println();
	}

}
