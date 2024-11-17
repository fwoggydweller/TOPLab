package tp1.logic.roles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;
public class WalkerRole extends LemmingRole{
	private static final String NAME = Messages.ROLE_WALKER_NAME;
	private static final String SHORTCUT = Messages.ROLE_WALKER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_WALKER_DETAILS;
	private static final String HELP = Messages.ROLE_WALKER_HELP;
	 public WalkerRole() {
			this.name = NAME;
			this.shortcut = SHORTCUT;
			this.details = DETAILS;
			this.help = HELP;
		}

	 @Override
	 public String getIcon(Lemming lemmy) {
		 String icon;
		 
	    	if(lemmy.getDir() == Direction.LEFT) { //if it's going left, print left
	    		icon = Messages.LEMMING_LEFT;
	    	}
	    	else { //if it goes right, print right
	    		icon = Messages.LEMMING_RIGHT;
	    	}	
	    
		return icon;
	 }

}
