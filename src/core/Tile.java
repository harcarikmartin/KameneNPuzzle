package core;

public class Tile {
	
	public enum State {
		EMPTY,
		FILLED
	}
	
	private State state = State.EMPTY;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
