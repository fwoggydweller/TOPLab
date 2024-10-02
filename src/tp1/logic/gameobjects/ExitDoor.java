package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;

public class ExitDoor {
	private Position pos;
	private GameObjectContainer cont;
	
	public ExitDoor(int x, int y) { //costructor
		this.pos = new Position(x,y);
		cont.registerDoor(this);
	}
	
	public Position getPos() {
		return this.pos;
	}

	public void setPos(Position pos) { // takes in a position (new pos if it is changing)
		this.pos = pos;
	}

}
