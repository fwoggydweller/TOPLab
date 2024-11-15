package tp1.logic.roles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;
public class WalkerRole extends LemmingRole{
	private static final String NAME = Messages.COMMAND_RESET_NAME;
	private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
	private static final String HELP = Messages.COMMAND_RESET_HELP;
	 private Messages m = new Messages(); 

	    @Override
	 public String getIcon(Lemming lemmy) {
		 String icon = m.EMPTY;
		 if(lemmy.isAlive()){
	    	if(lemmy.getDir() == Direction.LEFT) { //if it's going left, print left
	    		icon = m.LEMMING_LEFT;
	    	}
	    	else if(lemmy.getDir() == Direction.RIGHT || lemmy.getDir() == Direction.NONE) { //if it goes right, print right
	    		icon = m.LEMMING_RIGHT;
	    	}	
	    }
		return icon;
	 }

}
