package tp1.logic.roles;
import tp1.logic.Game;
import tp1.logic.Direction;
import tp1.logic.Position;
import tp1.logic.gameobjects.Lemming;
public abstract class LemmingRole {
	private Game game;
    public abstract String getIcon( Lemming lemming );
    public void move(Lemming lemming) {
    	if(!moveY(lemming)) {
    		moveX(lemming);
    	}
    }
    private boolean willDie(Lemming lemming) { // overwrite in parachute
    	
    	return true;
    }
    private void moveX(Lemming lemming) {
    	if(lemming.getPos().getCol() + lemming.getDir().getX() >= game.DIM_X  || lemming.getPos().getCol() + lemming.getDir().getX() < 0) { //if lemming encounters wall next to it 
			if(lemming.getDir().equals(Direction.LEFT)) {
				lemming.setDir(Direction.RIGHT);
			}
			else if(lemming.getDir().equals(Direction.RIGHT)) {
				lemming.setDir(Direction.LEFT);
			}
			
		}
		else{
			Position p = new Position (lemming.getPos().getCol() + lemming.getDir().getX(), lemming.getPos().getRow());
			lemming.setPos(p);
		}
    }
    private boolean moveY(Lemming lemming) { 
    	boolean ok = true;
    	
    	return ok;
    }
}
