package tp1.logic.gameobjects;


import tp1.logic.Position;
import tp1.view.Messages;
import tp1.exceptions.CommandException;
import tp1.logic.Direction;
import tp1.logic.GameWorld;

public class ExitDoor extends GameObject{
	public ExitDoor(int x, int y, GameWorld g) { //costructor
		super(x,y,g);
		this.name = "ExitDoor";
	}
	
	public Position getPos() {
		return this.pos;
	}
	@Override
	public boolean isExit(){
		return true;
	}
	@Override
	public boolean interactWith(Lemming lem){ //TODO
		return false;
	}
	@Override
	public String toString() {
		return Messages.EXIT_DOOR;
	}
	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.interactWith(this);
	}
	@Override
	public GameObject copy(int x, int y, String name,  Direction dir, GameWorld g, String role, int force){
		
		if (name.toLowerCase().equals("exitdoor")) return new ExitDoor(x, y, g);
		return null;
	}
}
