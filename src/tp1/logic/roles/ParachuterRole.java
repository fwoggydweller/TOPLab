package tp1.logic.roles;
import tp1.logic.roles.LemmingRole;
import tp1.view.Messages;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.Direction;
public class ParachuterRole implements LemmingRole{
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
	@Override
	public void start(Lemming lemming) {
		// TODO Auto-generated method stub
	}
	@Override
	public void play(Lemming lemming) {
		// TODO Auto-generated method stub
	}
}
