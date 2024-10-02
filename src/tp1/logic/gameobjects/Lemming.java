package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;
import tp1.logic.Direction;

public class Lemming {
	Position pos;
	Direction dir;
	GameObjectContainer cont;
	boolean solid = false;
	int force = 3;
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
	public Position getPos() {
		return pos; //I don't know if I should create a new position with pos's col and row values or if this is fine
	}
	private void register() {
		cont.counterOfLemmings(this);
	}
	private boolean IsGrounded() {
		return cont.searchWall(pos.getCol(), pos.getRow() + 1); // +1?
	}
	private void move() {
		if(IsGrounded()) { //If the Lemming is touching the ground, then it can move normally
			if(cont.searchWall(pos.getCol() + dir.getX(), pos.getRow())) { //if lemming encounters wall next to it 
				this.dir.setX(dir.getX() * -1);
			}
			else{
				this.pos.setCol(pos.getCol() + 1);
			}
		}
		else { //If it's falling down, then the row position will be updated
			pos.setRow(pos.getRow() + 1); //It´s a +1 because in terms of the console, going don is adding one to the x
		}
	}
	/**
	 *  Implements the automatic update	
	 */
	public void update() {
		//TODO fill your code
	}
}
