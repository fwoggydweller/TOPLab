package tp1.logic.roles;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;

public interface LemmingRoleInterface {
	public void play(Lemming lem);
	public boolean interactWith(Wall wall, Lemming lem);
	public boolean interactWith(MetalWall mWall, Lemming lem);
	
	
}
