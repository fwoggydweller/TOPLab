package tp1.logic;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private int col;
	private int row;
	
	public Position(int x, int y) {
		this.col=x;
		this.row=y;
	}
	//TODO fill your code
	public void setCol(int x) {
		col = x;
	}
	public void setRow(int y) {
		row = y;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}
