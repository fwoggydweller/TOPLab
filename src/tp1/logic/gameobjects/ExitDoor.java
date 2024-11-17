package tp1.logic.gameobjects;


import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject{
	public ExitDoor(int x, int y) { //costructor
		this.pos = new Position(x,y);
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
}
