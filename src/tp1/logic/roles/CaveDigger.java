package tp1.logic.roles;

import tp1.logic.Direction;
import tp1.logic.Position;

import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;
import tp1.logic.gameobjects.Wall;

public class CaveDigger extends LemmingRole{
	private static final String NAME = Messages.ROLE_DIGGER_NAME;
	private static final String SHORTCUT = Messages.ROLE_DIGGER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_DIGGER_DETAILS;
	private static final String HELP = Messages.ROLE_DIGGER_HELP;
	public CaveDigger() {
		this.name = NAME;
		this.shortcut = SHORTCUT;
		this.details = DETAILS;
		this.help = HELP;
	}
	@Override
	public String getIcon(Lemming lemming) {
		 String icon;
		 
	    	if(lemming.getDir() == Direction.LEFT) { //if it's going left, print left
	    		icon = Messages.DIGGER_LEFT;
	    	}
	    	else { //if it goes right, print right
	    		icon = Messages.DIGGER_RIGHT;
	    	}	
	    
		return icon;
	}
	@Override 
    public boolean interactWith(Wall wall, Lemming lem) {
	  	
    	if(wall.isInPosition(new Position (lem.getPos().getCol() + lem.getDir().getX(), lem.getPos().getRow()))) {
    	 uDir(lem, true);
    	}
    	
    	else{
    		lem.setAlive(lem.getForce() > lem.getCurrFall());
    		lem.setCurrFall(0);
    		if (lem.isAlive()) wall.setAlive(false);
    		else lem.setGrounded(true);
    	}
    	
		return true;
	}
}	
