package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;
import tp1.exceptions.CommandException;
import tp1.logic.Direction;
import tp1.logic.GameWorld;

public class MetalWall extends GameObject{
	public MetalWall(int x,int y,GameWorld g) {
		super(x,y,g);
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
	@Override
	public GameObject copy(int x, int y, String name,  Direction dir, GameWorld g, String role, int force) throws CommandException {
		
		if (name.toLowerCase().equals("metalwall")) return new MetalWall(x, y, g);
		return null;
	}
}
