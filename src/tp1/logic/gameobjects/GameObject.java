package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.roles.LemmingRole;

public class GameObject implements GameItem{

	@Override
	public boolean receiveInteraction(GameItem other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean interactWith(Lemming lemming) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean interactWith(Wall wall) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean interactWith(ExitDoor door) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSolid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInPosition(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean setRole(LemmingRole role) {
		//ERROR: SetRoleCommand error (Incorrect position or no object in that position admits that role)
		//ERROR: Unknown Role
		return false;
	}

}
