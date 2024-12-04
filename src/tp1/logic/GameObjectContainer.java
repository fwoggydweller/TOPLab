package tp1.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import tp1.exceptions.CommandException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.RoleParseException;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;

import tp1.view.Messages;
public class GameObjectContainer {
	//TODO fill your code
	private GameItem[] gO;
	private int objCount = 0;
	
	
	public GameObjectContainer (int listSize) {
		gO = new GameItem[listSize];
	}
	
	public void add(GameObject go) {
		if(objCount < gO.length) {
			gO[objCount] = go;
			objCount++;
		}
	}
	
	public String whatInPos(int col, int row) {
		String name = Messages.EMPTY;
		int pos = 0;
		//Make a loop for searching the gO of the given pos
		while(pos < gO.length && name == Messages.EMPTY) {
			if(gO[pos].isInPosition(new Position(col,row))) {
				name = gO[pos].toString(); //All of the game objects must have an overwritten toString method
				}
			pos++;
			}
		
		return name;
	}
	public void update() throws CommandException {
		for(int i = 0; i < gO.length; i++) {
			gO[i].update();
		}
	}
	
	public void reset() {
		objCount = 0;
	}

	public GameItem posToObject (Position pos) throws ObjectParseException {
		for(int i = 0; i<objCount; i++) {
			if(gO[i].getPos().getCol() == pos.getCol() && gO[i].getPos().getRow() == pos.getRow()) {
				 return gO[i];
				}
			}
		return null;
	}
	public String stringify(String fileName) {
		String ret = "";
		for(GameItem g: gO) {
			ret += System.lineSeparator() + g.stringify();
		}
		return ret;
	}
}

