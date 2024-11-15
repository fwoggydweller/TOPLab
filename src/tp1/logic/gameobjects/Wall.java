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
	}
	@Override
	public boolean interactWith(Lemming lem) {
		return lem.GetRole(w);
	}
	public String toString() {
			return Messages.WALL;
	}
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}
}