package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRoleFactory;
import tp1.logic.roles.LemmingRoleInterface;
import tp1.view.Messages;
import tp1.exceptions.CommandException;
import tp1.exceptions.ObjectParseException;
import tp1.logic.Direction;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;



public class Lemming extends GameObject{
	private Direction dir;
	private LemmingRoleInterface role;
	private boolean grounded;
	private int force = 3;
	private int currFall = 0;
	private boolean flipped = false;

	public Lemming(int x, int y, Direction dir, GameWorld g, LemmingRoleInterface role, int force) {
		super(x,y,g);
		this.dir = dir;
		this.role = role;
		this.currFall = force;
		this.name = "Lemming";
		solid = false;
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
	public void update() throws CommandException {
		if(isAlive()) {
			this.grounded = false;
			this.checkSurround();
			role.play(this);
		}
	}
	public boolean onExit(ExitDoor exit) {
			game.updateExitLemmings();
			this.exit = true;
			this.setAlive(false);
			return true;

	}
	public boolean GetRole(LemmingRoleInterface role) {
		return role.equals(role);
	}
	@Override
	public boolean setRole(LemmingRoleInterface role) { 
		if(this.role.getName().equals(role.getName())) {
			return false;
		}
		else {
			this.role = role;
			return true;
		}
	}
	public void disableRole() throws CommandException {
		this.role = LemmingRoleFactory.parse("w");
	}
	public int getCurrFall() {
		return currFall;
	}
	public int getForce() {
		return force;
	}
	public boolean getFlip() {
		return flipped;
	}
	public void setFlip(boolean a) {
		this.flipped = a;
	}
	public void setCurrFall(int fall) {
		this.currFall = fall;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public void setAlive(boolean value) {
		this.alive = value;
		if(!this.alive && !this.exit) {
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
	public boolean askInteraction(GameItem other) throws CommandException {
		return other.receiveInteraction(this);
	}
	public GameItem posToObject (Position pos) throws CommandException {
		return game.posToObject(pos);
	}
	public void checkSurround() throws CommandException {
		Position p = new Position(this.pos.getCol() + this.dir.getX(), this.pos.getRow());
		if (posToObject(p) != null) askInteraction(posToObject(p));
		p = new Position(this.pos.getCol(), this.pos.getRow() + 1);
		if (posToObject(p) != null) askInteraction(posToObject(p));
	}
	@Override
	public boolean interactWith(ExitDoor exit) {
		return onExit(exit);
	}
	@Override
	public boolean interactWith(Wall wall) throws CommandException {
		return role.interactWith(wall, this);
	}
	@Override
	public boolean interactWith(MetalWall mWall) {
		return role.interactWith(mWall, this);
	}
	@Override
	public GameObject copy(int x, int y, String name,  Direction dir, GameWorld g, String role, int force) throws CommandException {
		
		if (name.toLowerCase().equals("lemming")) return new Lemming(x, y, dir, g, LemmingRoleFactory.parse(role), force);
		return null;
	}
	@Override
	public String stringify() {
		if(this.dir == Direction.RIGHT) return "(" + this.getPos().getCol() + "," + this.getPos().getRow() + ") " + this.name + " RIGHT " + this.currFall + " " + this.role.getName();
		return "(" + this.getPos().getCol() + "," + this.getPos().getRow() + ") " + this.name + " LEFT " + this.currFall + " " + this.role.getName();

	}
}