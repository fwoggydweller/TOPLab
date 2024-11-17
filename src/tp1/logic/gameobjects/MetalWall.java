package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class MetalWall extends GameObject{
	public MetalWall(int x,int y) {
		pos = new Position(x,y);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
	@Override
	public String toString() {
		return Messages.METAL_WALL;
	}
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}
}
