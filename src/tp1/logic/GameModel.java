package tp1.logic;

import tp1.logic.roles.LemmingRoleInterface;

public interface GameModel {
	public void update();
	public void reset(int n);
	public void playerExits();
	public boolean isFinished();
	public boolean getExit();
	public String help();
	public boolean setRole(LemmingRoleInterface r, Position pos);
}
