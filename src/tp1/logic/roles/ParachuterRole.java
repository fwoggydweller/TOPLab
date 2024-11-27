package tp1.logic.roles;
import tp1.view.Messages;
import tp1.logic.gameobjects.Lemming;
import tp1.exceptions.CommandException;
import tp1.logic.Position;
public class ParachuterRole extends LemmingRole{
	private static final String NAME = Messages.ROLE_PARACHUTER_NAME;
	private static final String SHORTCUT = Messages.ROLE_PARACHUTER_SHORTCUT;
	private static final String DETAILS = Messages.ROLE_PARACHUTER_DETAILS;
	private static final String HELP = Messages.ROLE_PARACHUTER_HELP;
	public ParachuterRole() {
		this.name = NAME;
		this.shortcut = SHORTCUT;
		this.details = DETAILS;
		this.help = HELP;
	}
	@Override
	public LemmingRoleInterface parse(String name) {
		if(matchRole(name.toLowerCase())) {
			return new ParachuterRole();
		}
		else {
			return null;
		}
	}
	@Override
	public String getIcon(Lemming lemmy) {
		 String icon;
		
	    icon = Messages.PARACHUTER;
	    	
		return icon;
	 
	 }
	@Override
	 public boolean moveY(Lemming lemming) throws CommandException { 
	    	boolean ok = true;
	    	if(lemming.IsGrounded()) {
	    		if(lemming.getCurrFall() > 0) lemming.disableRole();
	    		lemming.setCurrFall(0);	
	    		ok = false;
	    	}
	    	else {
	    		Position p = new Position (lemming.getPos().getCol(), lemming.getPos().getRow() + 1);
				lemming.setPosition(p);
				lemming.setCurrFall(1);
	    	}
	    	
	    	return ok;
	}
}
