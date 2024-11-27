package tp1.logic.gameobjects;
import tp1.view.Messages;
import tp1.logic.Position;
import tp1.exceptions.CommandException;
import tp1.logic.GameWorld;
public class Wall extends GameObject{
	public Wall(int x,int y, GameWorld g) {
		super(x,y,g);
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
}