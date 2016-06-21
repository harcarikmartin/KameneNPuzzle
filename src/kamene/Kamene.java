package kamene;

import consoleui.ConsoleUI;
import core.Field;

public class Kamene {
	
	private UserInterface userInterface;
	
	private Kamene() {
		userInterface = new ConsoleUI();
		Field field = new Field(4, 4);
		userInterface.newGameStarted(field);
	}
	
	public static void main(String[] args) {
		new Kamene();

	}

}
