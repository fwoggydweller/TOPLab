package tp1.logic;

public interface GameStatus {
	public int numLemmingsInBoard();
	public int numLemmingsDead();
	public int numLemmingsExit();
	public int numLemmingsToWin();
	public String positionToString(int col, int row);
}
