package tp1.logic;

import tp1.exceptions.CommandException;
import tp1.logic.gameobjects.GameItem;

public interface GameWorld {
	public GameItem posToObject (Position pos) throws CommandException;
	public int numLemmingsExit();
	public void updateDeadLemmings();
	public void updateExitLemmings();
}
