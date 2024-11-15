package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject{
	public ExitDoor(int x, int y) { //costructor
		this.pos = new Position(x,y);
	}
	
	public Position getPos() {
		return this.pos;
	}
	@Override
	public boolean isExit(){
		return true;
	}
	@Override
	public boolean interactWith(Lemming lem){ //TODO
		return false;
	}
	public String toString() {
		return Messages.EXIT_DOOR;
	}
}
