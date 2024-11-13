package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class MetalWall extends GameObject{
	Messages m;
	public MetalWall(int x,int y) {
		pos = new Position(x,y);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
	public String toString() {
		return m.METAL_WALL;
	}
}
