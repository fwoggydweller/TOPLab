package tp1.logic.gameobjects.roles;
import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;
public class WalkerRole{
	 private Messages m = new Messages(); // here?
	 public void advance(Lemming lemmy) {
		 lemmy.Move();
	 }

	    //@Override
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
