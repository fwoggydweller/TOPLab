package tp1.logic.gameobjects;
import tp1.exceptions.CommandException;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRoleInterface;

public interface GameItem {
	public boolean receiveInteraction(GameItem other) throws CommandException;

	public boolean interactWith(Lemming lemming);
	public boolean interactWith(Wall wall) throws CommandException;
	public boolean interactWith(MetalWall mWall);
	public boolean interactWith(ExitDoor door);

	public boolean isSolid();
	public boolean isAlive();
	public void setAlive(boolean b);
	public boolean isExit();
	public boolean setRole(LemmingRoleInterface role);
	public boolean isInPosition(Position pos);
	public void update() throws CommandException;
	public String toString();
	public Position getPos();
	
}