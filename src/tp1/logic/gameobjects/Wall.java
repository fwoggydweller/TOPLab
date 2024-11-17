package tp1.logic.gameobjects;
import tp1.view.Messages;
import tp1.logic.Position;
public class Wall extends GameObject{
	public Wall(int x,int y) {
		pos = new Position(x,y);
		alive = true;
	}
	@Override
	public String toString() {
		if (this.isAlive())return Messages.WALL;
		else return Messages.EMPTY;

	}
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}
}