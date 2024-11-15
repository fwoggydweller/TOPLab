package tp1.logic.roles;
import tp1.logic.roles.LemmingRole;
import tp1.view.Messages;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.Direction;
import tp1.logic.Position;
public class ParachuterRole extends LemmingRole{
	private static final String NAME = "parachuter";
	private static final String SHORTCUT = "p";
	private static final String DETAILS = "[P]arachuter";
	private static final String HELP = "Lemming that falls with a parachute";
	public ParachuterRole() {
		this.name = NAME;
		this.shortcut = SHORTCUT;
		this.details = DETAILS;
		this.help = HELP;
	}
	@Override
	public String getIcon(Lemming lemmy) {
		 return "P";
	 }
	@Override
	 public boolean moveY(Lemming lemming) { // ovewrite in parachute (reset currFall) and caveDigger (falls even if isGrounded)
	    	boolean ok = true;
	    	if(lemming.IsGrounded()) {
	    		lemming.setCurrFall(0);	
	    		ok = false;
	    	}
	    	else {
	    		Position p = new Position (lemming.getPos().getCol(), lemming.getPos().getRow() + 1);
				lemming.setPosition(p);
	    	}
	    	
	    	return ok;
	}
}
