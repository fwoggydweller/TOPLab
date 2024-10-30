package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRole;

public class GameObject implements GameItem{
	protected Game game;
	protected Position pos;
	protected boolean solid;
	//Global set position for each class that extends GameObjects
	public void setPosition(Position p) {
		this.pos = p;
	}
	public Position getPos() {
		return this.pos;
	}
	@Override
	public boolean receiveInteraction(GameItem other) {
		return false;
	}

	@Override
	public boolean interactWith(Lemming lemming) {
		return false;
	}

	@Override
	public boolean interactWith(Wall wall) {
		return false;
	}

	@Override
	public boolean interactWith(ExitDoor door) {
		return false;
	}

	@Override
	public boolean isSolid() {
		return solid;
	}

	@Override
	public boolean isAlive() {
		return false;
	}

	@Override
	public boolean isExit() {
		return false;
	}

	@Override
	public boolean isInPosition(Position pos) {
		return this.pos.Equals(pos.getCol(), pos.getRow());
	}
	
	public boolean setRole(LemmingRole role) {
		//ERROR: SetRoleCommand error (Incorrect position or no object in that position admits that role)
		//ERROR: Unknown Role
		return false;
	}
	public void update() {
		
	}
}
