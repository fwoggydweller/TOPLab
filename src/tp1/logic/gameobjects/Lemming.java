package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;
import tp1.logic.Direction;


public class Lemming {
	private Position pos;
	private Direction dir;
	private WalkerRole w;
	private GameObjectContainer contRef;
	boolean alive;
	boolean solid;
	int force = 3;
	int currFall = 0;
	//TODO fill your code
	public Lemming(int x, int y, WalkerRole role, GameObjectContainer cont) {
		pos = new Position(x, y);
		dir = Direction.NONE;
		w = role;
		alive = true;
		solid = false;
		contRef = cont;
	}
	public void setDir(int x, int y) {
		dir.setX(x);
		dir.setY(y);
	}
	public Position getPos() {
		return pos; //I don't know if I should create a new position with pos's col and row values or if this is fine
	}
	public void Move() {
		if(IsGrounded()) { //If the Lemming is touching the ground, then it can move normally
			if(currFall>= force) {
				alive = false;
			}
			else {
				currFall = 0;
				if(contRef.searchWall(pos.getCol() + dir.getX(), pos.getRow())) { //if lemming encounters wall next to it 
					this.dir.setX(dir.getX() * -1);
				}
				else{
					Position p = new Position (pos.getCol()+1, pos.getRow());
					this.pos = p;
				}
			}
			
		}
		else { //If it's falling down, then the row position will be updated
			Position p = new Position (pos.getCol(), pos.getRow()+1);
			this.pos = p;
			currFall++;
		}
	}
	private boolean IsGrounded() { //This must check if there's a wall below the lemming
		return true;
	}
	public boolean isAlive() {
		return alive;
	}
	public void update() {
		if(isAlive()) {
			w.advance(this);
		}
	}
}
