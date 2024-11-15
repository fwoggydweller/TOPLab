package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRole;

public class GameObject implements GameItem{
	protected GameWorld game;
	protected Position pos;
	protected boolean solid;
	//Global set position for each class that extends GameObjects
	public void setPosition(Position p) {
		this.pos = p;
	}
	public Position getPos() {
		return this.pos;
	}
	
	public boolean receiveInteraction(GameItem other) {
		return false;
	}


	public boolean interactWith(Lemming lemming) {
		return false;
	}


	public boolean interactWith(Wall wall) {
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
		return false;
	}


	public boolean isExit() { // esto debe comprobar si el objeto ha salido?
		return false;
	}


	public boolean isInPosition(Position pos) {
		return this.pos.Equals(pos.getCol(), pos.getRow());
	}
	
	public boolean setRole(LemmingRole role) {
		return false;
	}
	public void update() {
		
	}
	public void onExit() { // in lemming?
		
	}
	public void onDeath() { // in lemming?
		
	}
}
