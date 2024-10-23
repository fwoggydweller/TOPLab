package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;

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
}
