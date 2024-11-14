package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRole;
import tp1.logic.Direction;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;



public class Lemming extends GameObject{
	private Direction dir;
	private LemmingRole role;
	private boolean alive;
	private boolean exit;
	private boolean grounded;
	private int force = 3;
	private int currFall = 0;

	public Lemming(int x, int y, LemmingRole role, Game g) {
		pos = new Position(x, y);
		dir = Direction.RIGHT;
		this.role = role;
		alive = true;
		solid = false;
		game = g;
	}
	
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
	public void Fall(int n) { //We need to call a Role method that manages this
		if(n== 1) {
			currFall++;
		}
		else if(n==0) {
			currFall = 0;
		}
	}
	/*
	public void Move() {
		if(!IsVoid()) {
			if(IsGrounded()) { //If the Lemming is touching the ground, then it can move normally
				if(currFall >= force) {
					alive = false;
				}
				else {
					currFall = 0;
					if(game.searchWall(pos.getCol() + dir.getX(), pos.getRow()) || pos.getCol() + dir.getX() >= game.DIM_X  || pos.getCol() + dir.getX() < 0) { //if lemming encounters wall next to it 
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
			}
		}
		else {
			alive = false;
			game.updateDeadLemmings();
		}
	}
*/
	public boolean IsGrounded() { //This must check if there's a wall below the lemming
		/*if(game.searchWall(this.pos.getCol(), this.pos.getRow() + 1)) {
			return true;
		}*/	
		return this.grounded;
	}
	public void setGrounded(boolean a) {
		this.grounded = a;
	}
	public boolean getGrounded() {
		return this.grounded;
	}
	
	public boolean IsVoid() { //returns if lemming is falling off the board
		boolean is = false;
		
		if (this.pos.getRow() >= game.DIM_Y - 1) {
			is = true;
		}
		return is;
	}
	@Override
	public boolean isAlive() {
		return alive;
	}
	public String toString() {
		return role.getIcon(this);
	}
	public void update() {
		if(isAlive()) {
			this.grounded = false;
			this.checkSurround();
			role.play(this);
		}
	}
	public boolean isThisExit(ExitDoor exit) { // checks if it is in exit
		if(exit.isInPosition(this.pos)) {
			game.numLemmingsExit();
			return true;
		}
		return false;
	}
	public boolean GetRole(LemmingRole role) {
		return role.equals(role);
	}
	@Override
	public boolean setRole(LemmingRole role) { 
		if(role.equals(this.role)) {
			return false;
		}
		else {
			this.role = role;
			return true;
		}
	}
	public void disableRole() {
		
	}
	public int getCurrFall() {
		return currFall;
	}
	public int getForce() {
		return force;
	}
	public void setCurrFall(int fall) {
		this.currFall = fall;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public void setAlive(boolean value) {
		this.alive = value;
		if(!this.alive) {
			this.alive = false;
			onDeath();
		}
	}
	@Override
	public void onExit() {
		// call remove function
		game.updateExitLemmings();
	}
	@Override
	public void onDeath() {
		// call remove function
		game.updateDeadLemmings();
	}
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}
	public boolean askInteraction(GameItem other) {
		return other.receiveInteraction(this);
	}
	public GameObject posToObject (Position pos) {
		return game.posToObject(pos);
	}
	public void checkSurround() {
		Position p = new Position(this.pos.getCol() + this.dir.getX(), this.pos.getRow());
		if (posToObject(p) != null) askInteraction(posToObject(p));
		p = new Position(this.pos.getCol(), this.pos.getRow() + 1);
		if (posToObject(p) != null) askInteraction(posToObject(p));
		askInteraction(posToObject(this.pos)); // if the lemming is found before exitdoor it may never exit (could make sure exitdoor is always at beggining of gameobject array)
	}
	@Override
	public boolean interactWith(ExitDoor exit) {
		return isThisExit(exit);
	}
	@Override
	public boolean interactWith(Wall wall) {
		return role.interactWith(wall, this);
	}
	@Override
	public boolean interactWith(MetalWall mWall) {
		return role.interactWith(mWall, this);
	}
}
