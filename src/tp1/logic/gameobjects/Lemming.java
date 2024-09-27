package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;
import tp1.logic.Direction;

public class Lemming {
	Position pos;
	Direction dir;
	GameObjectContainer cont;
	//TODO fill your code
	public Lemming(int x, int y) {
		pos.setCol(x);
		pos.setRow(y);
		register();
	}
	public void setDir(int x, int y) {
		dir.setX(x);
		dir.setY(y);
	}
	private void register() {
		cont.counterOfLemmings(this);
	}
	/**
	 *  Implements the automatic update	
	 */
	public void update() {
		//TODO fill your code
	}
}
