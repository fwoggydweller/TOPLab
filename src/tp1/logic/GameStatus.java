package tp1.logic;

public interface GameStatus {
	public int numLemmingsInBoard();
	public int numLemmingsDead();
	public int numLemmingsExit();
	public int numLemmingsToWin();
	public boolean playerWins();
	public boolean playerLoses();
	public int getCycle();
	public String positionToString(int col, int row);
}
