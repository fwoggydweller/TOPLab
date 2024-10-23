package tp1.logic.gameobjects;

import tp1.logic.Position;

public class MetalWall extends GameObject{
	public MetalWall(int x,int y) {
		pos = new Position(x,y);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
}
