package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRole;
import tp1.view.Messages;
import tp1.logic.Direction;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;



public class Lemming extends GameObject{
	private Direction dir;
	private LemmingRole role;
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
	public boolean IsGrounded() {
		return this.grounded;
	}
	public void setGrounded(boolean a) {
		this.grounded = a;
	}
	public boolean IsVoid() { //returns if lemming is falling off the board
		boolean is = false;
		
		if (this.pos.getRow() >= Game.DIM_Y - 1) {
			is = true;
		}
		return is;
	}
	@Override
	public String toString() {
		if(this.alive) return role.getIcon(this);
		else return Messages.EMPTY;
	}
	public void update() {
		if(isAlive()) {
			this.grounded = false;
			this.checkSurround();
			role.play(this);
		}
	}
	public boolean isThisExit(ExitDoor exit) {
		
			game.numLemmingsExit();
			return true;

	}
	public boolean GetRole(LemmingRole role) {
		return role.equals(role);
	}
	@Override
	public boolean setRole(LemmingRole role) { 
		if(role == null) {
			return false;
		}
		else if(role.equals(this.role)) {
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
	public GameItem posToObject (Position pos) {
		return game.posToObject(pos);
	}
	public void checkSurround() {
		Position p = new Position(this.pos.getCol() + this.dir.getX(), this.pos.getRow());
		if (posToObject(p) != null) askInteraction(posToObject(p));
		p = new Position(this.pos.getCol(), this.pos.getRow() + 1);
		if (posToObject(p) != null) askInteraction(posToObject(p));
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
