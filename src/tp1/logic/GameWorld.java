package tp1.logic;

public interface GameWorld {
	public int getCycle();
	public boolean searchWall(int col, int row);
	public boolean searchExit(int col, int row);
}
