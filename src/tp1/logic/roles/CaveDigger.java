package tp1.logic.roles;

import tp1.exceptions.CommandException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.RoleParseException;
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
	public LemmingRoleInterface parse(String name) {
		if(matchRole(name)) {
			return new CaveDigger();
		}
		else {
			return null;
		}
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
    public boolean interactWith(Wall wall, Lemming lem) throws RoleParseException{ 
    	  	
	    	if(wall.isInPosition(new Position (lem.getPos().getCol() + lem.getDir().getX(), lem.getPos().getRow()))) {
	    	 uDir(lem, true);
	    	}
	    	
	    	else { // overwrites interact with wall to kill the wall below (y todas las cosas que conlleva)
	    		lem.setAlive(lem.getForce() > lem.getCurrFall()); // hace vibe check
	    		lem.setCurrFall(0);
	    		if (lem.isAlive()) wall.setAlive(false); // si pasa el check mata a la pared 
	    		else lem.setGrounded(true); // si no está grounded pa que su cadaver no atraviese la pared
	    		lem.disableRole(); // solo cava 1 master + se podria hacer que si el currfall es > 0 entonces disable pa que cave mas 
	    	}
	    	
			return true;
	}	
}
