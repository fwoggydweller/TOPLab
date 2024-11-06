package tp1.logic;

import tp1.logic.gameobjects.GameObject;

public interface GameWorld {
	public int getCycle();
	public boolean searchWall(int col, int row);
	public boolean searchExit(int col, int row);
	public GameObject posToObject (Position pos);
}
