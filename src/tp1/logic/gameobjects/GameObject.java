package tp1.logic.gameobjects;


import tp1.exceptions.CommandException;
import tp1.logic.Direction;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRoleInterface;

public class GameObject implements GameItem{
	protected GameWorld game;
	protected Position pos;
	protected boolean alive;
	protected boolean exit;
	protected boolean solid;
	protected String name;
	//Global set position for each class that extends GameObjects
	
	public GameObject(int x, int y, GameWorld g) {
		pos = new Position(x, y);
		alive = true;
		game = g;
	}
	
	public void setPosition(Position p) {
		this.pos = p;
	}
	public Position getPos() {
		return this.pos;
	}
	
	public boolean receiveInteraction(GameItem other) throws CommandException {
		return false;
	}

	public boolean interactWith(Lemming lemming) {
		return false;
	}


	public boolean interactWith(Wall wall) throws CommandException {
		return false;
	}
	
	public boolean interactWith(MetalWall mWall) {
		return true;
	}


	public boolean interactWith(ExitDoor door) {
		return false;
	}


	public boolean isSolid() {
		return solid;
	}


	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean b) {
		this.alive = b;
	}


	public boolean isExit() { // esto debe comprobar si el objeto ha salido?
		return false;
	}


	public boolean isInPosition(Position pos) {
		return this.pos.Equals(pos.getCol(), pos.getRow());
	}
	
	public boolean setRole(LemmingRoleInterface role) throws CommandException {
		return false;
	}
	public void update() throws CommandException {
		
	}
	public void onExit() { // in lemming?
		
	}
	public void onDeath() { // in lemming?
		
	}
	public String toString() {
		return null;
	}
	public  GameObject copy(int x, int y, String name, Direction dir, GameWorld g, String role, int force) throws CommandException {
		return null;
	}
	public String stringify() {
		return "(" + this.getPos().getCol() + "," + this.getPos().getRow() + ") " + this.name;
	}
}