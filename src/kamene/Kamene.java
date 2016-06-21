package kamene;

import consoleui.ConsoleUI;
import core.Field;

public class Kamene {
	private long startMillis = System.currentTimeMillis();
	private static Kamene instance;
	private UserInterface userInterface;
	
	public Kamene() {
		instance = this;
		userInterface = new ConsoleUI();
		Field field = new Field(4, 4);
		userInterface.newGameStarted(field);
	}
	
	public long getPlayingSeconds() {
		return (System.currentTimeMillis() - startMillis) / 1000;
	}
	
	public static void main(String[] args) {	
		new Kamene();
	}

	public static Kamene getInstance() {
		return instance;
	}

}
