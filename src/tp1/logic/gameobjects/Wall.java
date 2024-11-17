package tp1.logic.gameobjects;
import tp1.logic.Game;
import tp1.view.Messages;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;
import tp1.logic.roles.WalkerRole;
public class Wall extends GameObject{
	WalkerRole w;
	public Wall(int x,int y) {
		pos = new Position(x,y);
		alive = true;
	}
	@Override
	public boolean interactWith(Lemming lem) {
		return lem.GetRole(w);
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