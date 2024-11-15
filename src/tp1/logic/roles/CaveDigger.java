package tp1.logic.roles;

import tp1.logic.Position;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;
import tp1.logic.gameobjects.Wall;

public class CaveDigger extends LemmingRole{
	private static final String NAME = "digger";
	private static final String SHORTCUT = "d";
	private static final String DETAILS = "[D]igger";
	private static final String HELP = "Lemming that diggs";
	public CaveDigger() {
		this.name = NAME;
		this.shortcut = SHORTCUT;
		this.details = DETAILS;
		this.help = HELP;
	}
	@Override
	public String getIcon(Lemming lemming) {
		// TODO Auto-generated method stub
		return "D";
	}
	@Override 
    public boolean interactWith(Wall wall, Lemming lem) {
	  	
    	if(wall.isInPosition(new Position (lem.getPos().getCol() + lem.getDir().getX(), lem.getPos().getRow()))) {
    	 uDir(lem, true);
    	}
    	
    	else{
    		lem.setAlive(lem.getForce() > lem.getCurrFall());
    		lem.setCurrFall(0);
    	}
    	
		return true;
	}
}	
