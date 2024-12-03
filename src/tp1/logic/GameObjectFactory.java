package tp1.logic;

import java.util.Arrays;

import java.util.List;

import tp1.exceptions.CommandException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;


public class GameObjectFactory {
	private static final List<GameObject> AVAILABLE_OBJ = Arrays.asList(
			new Lemming(0, 0, Direction.NONE, null, null,0),
			new Wall(0,0,null),
			new MetalWall(0,0,null),
			new ExitDoor(0,0,null)
	        // ...
	    );
	

	public GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException { // GameObject or gameItem
		try {
		String[] sLine = line.split("[(,) ]+");
		if(sLine.length < 4 || sLine.length > 7) throw new ObjectParseException(Messages.UNKNOWN_OBJECT.formatted(line));
		if(sLine.length == 5) throw new ObjectParseException(Messages.UNKNOWN_OBJECT.formatted(line));
		int x = Integer.parseInt(sLine[1]);
		int y = Integer.parseInt(sLine[2]);
		if(x < 0 || y < 0 || x > Game.DIM_X || y > Game.DIM_Y) throw new OffBoardException(Messages.OBJECT_POSITION_OFF_BOARD.formatted(line));
		
		Direction dir = null;
		String role = null;
		int force = 0;
		if(sLine.length == 7) {
			dir = strToDir(sLine[4]);
			if(dir==null) {
				throw new ObjectParseException(Messages.UNKNOWN_OBJECT_DIRECTION.formatted(line));
			}
			else if( dir.isEqual(Direction.UP) || dir.isEqual(Direction.DOWN)|| dir.isEqual(Direction.NONE)) {
				throw new ObjectParseException(Messages.INVALID_LEMMING_DIRECTION.formatted(line));
			}
			force = Integer.parseInt(sLine[5]);
			role = sLine[6];
		}	
		GameObject obj = null;
			for(int i = 0; i < AVAILABLE_OBJ.size() && obj == null; i++){
	    		obj = AVAILABLE_OBJ.get(i).copy(x, y, sLine[3], dir, game, role, force); // actually input the things
	    	}
			if(obj == null) throw new ObjectParseException(Messages.UNKNOWN_OBJECT.formatted(line));
			
			return obj;
		}
		catch(NumberFormatException e) {
			throw new ObjectParseException(Messages.INVALID_OBJECT_POSITION.formatted(line));
		}
		catch(CommandException c) {
			throw new ObjectParseException(c.getMessage());
		}
		
	}
	public Direction strToDir(String in) {
		if(in.toUpperCase().equals("RIGHT"))
			return Direction.RIGHT;
		else if(in.toUpperCase().equals("LEFT"))
			return Direction.LEFT;
		else if(in.toUpperCase().equals("NONE"))
			return Direction.NONE;
		else if(in.toUpperCase().equals("UP"))
			return Direction.UP;
		else if(in.toUpperCase().equals("DOWN"))
			return Direction.DOWN;
		else
			return null;
	}
	
}
