 package core; 

import java.util.ArrayList;
import java.util.List;

public class Field {
	private final int rowCount;
	private final int columnCount;
	private GameState state = GameState.PLAYING;
	private final List<Integer> tiles;
	
	public Field(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		tiles = new ArrayList<>();
		generate();
	}
	
	public GameState getState() {
		return state;
	}


	public int getRowCount() {
		return rowCount;
	}


	public int getColumnCount() {
		return columnCount;
	}
	
	public void setState(GameState state) {
		this.state = state;
	}
	
	public List<Integer> getTiles() {
		return tiles;
	}
	
	private void generate() {
		for (int i = 0; i < rowCount * columnCount - 1; i++) {
			tiles.add((Integer)(i + 1));
		}
		tiles.add(0);
	}

	public void moveTile(int deltaR, int deltaC) {
		Integer index0 = tiles.indexOf(new Integer(0));
		Integer indexUp = (index0 - columnCount);
		Integer help = tiles.get(index0);
		if(index0 >= columnCount) {
			tiles.set(index0, tiles.get(indexUp));
			tiles.set(indexUp, help);
		}
		else {
			System.out.println("Can't move, try again");
		}
	}
	
	public void moveTileUp() {
		Integer index0 = tiles.indexOf(new Integer(0));
		Integer indexUp = (index0 - columnCount);
		Integer help = tiles.get(index0);
		if(index0 >= columnCount) {
			tiles.set(index0, tiles.get(indexUp));
			tiles.set(indexUp, help);
		}
		else {
			System.out.println("Can't move, try again");
		}
	}

	public void moveTileDown() {
		Integer index0 = tiles.indexOf(new Integer(0));
		Integer indexUp = (index0 + columnCount);
		Integer help = tiles.get(index0);
		if(index0 < columnCount * rowCount - columnCount) {
			tiles.set(index0, tiles.get(indexUp));
			tiles.set(indexUp, help);
		}
		else {
			System.out.println("Can't move, try again");
		}
		
	}

	public void moveTileLeft() {
		Integer index0 = tiles.indexOf(new Integer(0));
		Integer indexUp = (index0 - 1);
		Integer help = tiles.get(index0);
		if((index0 % columnCount) != 0) {
			tiles.set(index0, tiles.get(indexUp));
			tiles.set(indexUp, help);
		}
		else {
			System.out.println("Can't move, try again");
		}
		
	}

	public void moveTileRight() {
		Integer index0 = tiles.indexOf(new Integer(0));
		Integer indexUp = (index0 + 1);
		Integer help = tiles.get(index0);
		if(index0 % columnCount != columnCount - 1) {
			tiles.set(index0, tiles.get(indexUp));
			tiles.set(indexUp, help);
		}
		else {
			System.out.println("Can't move, try again");
		}
		
	}
	
	public boolean isSolved() {
		List<Integer> checker = new ArrayList<>();
		for (int i = 0; i < tiles.size() - 1; i++) {
			checker.add(i + 1);
		}
		checker.add(0);
		
		if (tiles.equals(checker)) {
			return true;
		} else {
			return false;
		}
	}
}
