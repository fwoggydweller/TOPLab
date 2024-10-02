package tp1.logic;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private final int col;
	private final int row;
	
	public Position(int x, int y) {
		this.col=x;
		this.row=y;
	}
	public boolean Equals(int x, int y) {
		return this.col == x && this.row == y;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}
