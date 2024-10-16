package tp1.logic.gameobjects.roles;
import tp1.view.Messages;
public class ParachuterRole extends LemmingRole{
	private Messages m = new Messages();
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
}
