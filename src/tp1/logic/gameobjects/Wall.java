package tp1.logic.gameobjects;
import tp1.view.Messages;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRoleFactory;
import tp1.exceptions.CommandException;
import tp1.logic.Direction;
import tp1.logic.GameWorld;
public class Wall extends GameObject{
	public Wall(int x,int y, GameWorld g) {
		super(x,y,g);
		this.name = "Wall";
	}
	@Override
	public String toString() {
		if (this.isAlive())return Messages.WALL;
		else return Messages.EMPTY;

	}
	@Override
	public boolean receiveInteraction(GameItem other) throws CommandException {
		return other.interactWith(this);
	}
	@Override
	public GameObject copy(int x, int y, String name,  Direction dir, GameWorld g, String role, int force) throws CommandException {
		
		if (name.toLowerCase().equals("wall")) return new Wall(x, y, g);
		return null;
	}
}