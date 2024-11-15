package tp1.logic.roles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;
public class WalkerRole extends LemmingRole{
	private static final String NAME = "walker";
	private static final String SHORTCUT = "w";
	private static final String DETAILS = "[W]alker";
	private static final String HELP = "Lemming that walks";
	 private Messages m = new Messages(); 
	 public WalkerRole() {
			this.name = NAME;
			this.shortcut = SHORTCUT;
			this.details = DETAILS;
			this.help = HELP;
		}

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
