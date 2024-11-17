package tp1.logic.gameobjects;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRole;

public interface GameItem {
	public boolean receiveInteraction(GameItem other);

	public boolean interactWith(Lemming lemming);
	public boolean interactWith(Wall wall);
	public boolean interactWith(MetalWall mWall);
	public boolean interactWith(ExitDoor door);

	public boolean isSolid();
	public boolean isAlive();
	public void setAlive(boolean b);
	public boolean isExit();
	public boolean setRole(LemmingRole role); // capaz toca cambiarlo pero necesito poder ejecutar
	public boolean isInPosition(Position pos);
	public void update();
	public String toString();
	public Position getPos();
	
}