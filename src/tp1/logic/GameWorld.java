package tp1.logic;

import tp1.logic.gameobjects.GameItem;

public interface GameWorld {
	public GameItem posToObject (Position pos);
	public int numLemmingsExit();
	public void updateDeadLemmings();
	public void updateExitLemmings();
}
