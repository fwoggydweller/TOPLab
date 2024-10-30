package tp1.logic.roles;
import tp1.logic.roles.LemmingRole;
import tp1.view.Messages;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.Direction;
import tp1.logic.Position;
public class ParachuterRole extends LemmingRole{
	@Override
	public String getIcon(Lemming lemmy) {
		 String icon = m.EMPTY;
		 
		 if(lemmy.isAlive()){
	    	if(lemmy.getDir() == Direction.LEFT) { //if it's going left, print left
	    	}
	    	else if(lemmy.getDir() == Direction.RIGHT || lemmy.getDir() == Direction.NONE) { //if it goes right, print right
	    		icon = m.LEMMING_RIGHT;
	    	}
	    }
		return icon;
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
