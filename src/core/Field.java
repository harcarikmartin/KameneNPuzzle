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

	public void moveTileUp() {
		
		
	}

	public void moveTileDown() {
		
		
	}

	public void moveTileLeft() {
		
		
	}

	public void moveTileRight() {
		
		
	}

	

	


	

}
