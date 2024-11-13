package tp1.logic;

public interface GameModel {
	public void update();
	public void reset();
	public boolean playerWins();
	public boolean playerLoses();
	public boolean isFinished();
	public boolean getExit();
}
