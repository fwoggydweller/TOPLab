package tp1.logic.gameobjects;

import tp1.logic.Game;
//import tp1.logic.GameObjectContainer;
import tp1.logic.Position;
import tp1.logic.gameobjects.roles.WalkerRole;
import tp1.logic.Direction;


public class Lemming {
	private Game game;
	private Position pos;
	private Direction dir;
	private WalkerRole w;
	boolean alive;
	boolean solid;
	boolean exit;
	int force = 3;
	int currFall = 0;
	//TODO fill your code
	public Lemming(int x, int y, WalkerRole role, Game g) {
		pos = new Position(x, y);
		dir = Direction.RIGHT;
		w = role;
		alive = true;
		solid = false;
		game = g;
	}
	//LEFT(-1,0), RIGHT(1,0), DOWN(0,1), UP(0,-1), NONE(0,0);
	public void setDir(int x, int y) {
		if(x == 0 && y == 0) {
			dir = Direction.NONE;
		}
		else if(x == 0 && y == 1) {
			dir = Direction.DOWN;
		}
		else if(x == -1 && y == 0) {
			dir = Direction.LEFT;
		}
		else if(x == 1 && y == 1) {
			dir = Direction.RIGHT;
		}
		else{
			dir = Direction.UP;
		}
	}
	public Direction getDir() {
		return dir;
	}
	public Position getPos() {
		return pos;
	}
	public void Move() {
		if(!IsVoid()) {
			if(IsGrounded()) { //If the Lemming is touching the ground, then it can move normally
				if(currFall >= force) {
					alive = false;
				}
				else {
					currFall = 0;
					if(game.searchWall(pos.getCol() + dir.getX(), pos.getRow())) { //if lemming encounters wall next to it 
						if(this.dir.equals(Direction.LEFT)) {
							this.dir = Direction.RIGHT;
						}
						else if(this.dir.equals(Direction.RIGHT)) {
							this.dir = Direction.LEFT;
						}
						
					}
					else{
						Position p = new Position (pos.getCol() + dir.getX(), pos.getRow());
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
		else {
			alive = false;
		}
	}
	private boolean IsGrounded() { //This must check if there's a wall below the lemming
		if(game.searchWall(this.pos.getCol(), this.pos.getRow() + 1)) {
			return true;
		}	
		return false;
	}
	private boolean IsVoid() { //returns if lemming is falling off the board
		boolean is = false;
		
		if (this.pos.getRow() >= 11) {
			is = true;
		}	
		return is;
	}
	public boolean isAlive() {
		return alive;
	}
	public String toString() {
		return w.getIcon(this);
	}
	public void update() {
		if(isAlive()) {
			w.advance(this);
		}
	}
	public boolean isExit() { // checks if it is in exit
		if(game.searchExit(this.pos.getCol(), this.pos.getRow())) {
			return true;
		}
		return false;
	}
}
