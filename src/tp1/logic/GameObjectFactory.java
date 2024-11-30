package tp1.logic;

import java.util.Arrays;

import java.util.List;

import tp1.exceptions.CommandException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.gameobjects.*;
import tp1.logic.roles.LemmingRoleInterface;


public class GameObjectFactory {
	private static final List<GameObject> AVAILABLE_OBJ = Arrays.asList(
			new Lemming(0, 0, Direction.NONE, null, null),
			new Wall(0,0,null),
			new MetalWall(0,0,null)
	        // ...
	    );
	

	public GameObject parse(String line, GameWorld game) throws CommandException { // GameObject or gameItem
		String delimiters = ")|(|,| "; // can be wrong
		String[] sLine = line.split(delimiters);
		
		if(sLine.length < 3 || sLine.length > 5) throw new ObjectParseException();
		if(sLine.length == 4) throw new ObjectParseException();
		
		int x = Integer.parseInt(sLine[0]);
		int y = Integer.parseInt(sLine[1]);
		if(x < 0 || y < 0 || x > Game.DIM_X || y > Game.DIM_Y) throw new OffBoardException();
		
		Direction dir = null;
		if(sLine.length == 5) {
			dir = strToDir(sLine[3]);
		}	
		GameObject obj = null;
		for(int i = 0; i < AVAILABLE_OBJ.size() && obj == null; i++){
    		obj = AVAILABLE_OBJ.get(i).copy(x, y, sLine[2], dir, game, sLine[4]); // actually input the things
    	}
		if (obj == null) throw new ObjectParseException();
		return obj;
	}
	public Direction strToDir(String in) { // exception?
		if(in.toUpperCase() == "RIGHT")
			return Direction.RIGHT;
		else if(in.toUpperCase() == "LEFT")
			return Direction.LEFT;
		else if(in.toUpperCase() == "NONE")
			return Direction.NONE;
		
		return null;
	}
	
}
