package tp1.logic.roles;

import tp1.logic.Position;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class CaveDigger extends LemmingRole{

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
    		lem.setAlive(lem.getForce() > lem.getCurrFall()); //chapuza?
    		lem.setCurrFall(0);
    	}
    	
		return true;
	}
}	
