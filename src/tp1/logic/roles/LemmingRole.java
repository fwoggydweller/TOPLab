package tp1.logic.roles;
import tp1.logic.Game;
import tp1.logic.Direction;
import tp1.logic.Position;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;
public abstract class LemmingRole { // change into interface with default method
	private Game game;

	protected Messages m = new Messages();
    public abstract String getIcon( Lemming lemming );
    public void move(Lemming lemming) {
    	if(!moveY(lemming)) {
    		moveX(lemming);
    	}
    }
    private void moveX(Lemming lemming) {
    	
    		uDir(lemming, false);
			Position p = new Position (lemming.getPos().getCol() + lemming.getDir().getX(), lemming.getPos().getRow());
			lemming.setPosition(p);
	}

    public boolean moveY(Lemming lemming) { // ovewrite in parachute (reset currFall) and caveDigger (falls even if isGrounded)
    	boolean ok = true;
    	if(lemming.IsGrounded()) {
    		lemming.setAlive();
    		lemming.setCurrFall(0);	
    		ok = false;
    	}
    	else {
    		Position p = new Position (lemming.getPos().getCol(), lemming.getPos().getRow() + 1);
			lemming.setPosition(p);
			lemming.setCurrFall(lemming.getCurrFall() + 1);	
    	}
    	
    	return ok;
    }
    
    public void flip(Lemming lemming) {
    	
    	if(lemming.getDir().isEqual(Direction.RIGHT))lemming.setDir(Direction.RIGHT.getX(), Direction.RIGHT.getY());
    	else lemming.setDir(Direction.LEFT.getX(), Direction.LEFT.getY());
    }
    
    public void uDir(Lemming lemming, boolean wall) {
    	
    	if (wall) {
    		flip(lemming);
    	}
    	else {
	    	if(lemming.getPos().getCol() + lemming.getDir().getX() < 0 || lemming.getPos().getCol() + lemming.getDir().getX() >= game.DIM_X) { //must include interaction with solid obkject
	    		flip(lemming);
	    	}
    	}	
    } 
    public boolean interactWith(Wall wall, Lemming lem) {// have to check if it is in fron or below
    	
    	uDir(lem, true);
    	
		return true;
	}
    public boolean interactWith(MetalWall mWall, Lemming lem) {//TODO porbably after adding wall types
		return true;
	}
    public void play(Lemming lem) {
    	move(lem);
    	getIcon(lem);
    }
    
    
    
}
