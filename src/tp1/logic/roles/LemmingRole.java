package tp1.logic.roles;
import tp1.logic.Game;
import tp1.logic.roles.LemmingRoleInterface;
import tp1.exceptions.CommandException;
import tp1.logic.Direction;
import tp1.logic.Position;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;
public abstract class LemmingRole implements LemmingRoleInterface{ // change into interface with default method
	protected String name;
	protected String shortcut;
	protected String details;
	protected String help;
	public LemmingRole() {
		this.name = Messages.COMMAND_NONE_NAME;
		this.details = Messages.COMMAND_NONE_DETAILS;
		this.help = Messages.COMMAND_NONE_HELP;
		this.shortcut = Messages.COMMAND_NONE_SHORTCUT;
	}
	protected Messages m = new Messages();
    public abstract String getIcon( Lemming lemming );
    public void move(Lemming lemming) throws CommandException {
    	if(lemming.isAlive()) {
	    	if(!moveY(lemming)) {
	    		moveX(lemming);
	    	}
    	}
    }
    private void moveX(Lemming lemming) {
    	
    	uDir(lemming, false);  		    
    	if(!lemming.getFlip()) {
			Position p = new Position (lemming.getPos().getCol() + lemming.getDir().getX(), lemming.getPos().getRow());
			lemming.setPosition(p);
    	}
    	else lemming.setFlip(false);
	}

    public boolean moveY(Lemming lemming)throws CommandException { // ovewrite in parachute (reset currFall) and caveDigger (falls even if isGrounded)
    	boolean ok = true;
    	if(lemming.IsGrounded()) {
    		lemming.setAlive(lemming.getForce() > lemming.getCurrFall());
    		lemming.setCurrFall(0);	
    		ok = false;
    	}
    	else {
    		if(lemming.IsVoid()) {
    			lemming.setAlive(false);
    		}
    		else {
    			Position p = new Position (lemming.getPos().getCol(), lemming.getPos().getRow() + 1);
    			lemming.setPosition(p);
    			lemming.setCurrFall(lemming.getCurrFall() + 1);	
    		}
    	}
    	
    	return ok;
    }
    
    public void flip(Lemming lemming) {
    	
    	if(lemming.getDir().isEqual(Direction.LEFT))lemming.setDir(Direction.RIGHT.getX(), Direction.RIGHT.getY());
    	else lemming.setDir(Direction.LEFT.getX(), Direction.LEFT.getY());
    }
    
    public void uDir(Lemming lemming, boolean wall) {

    	if (wall) {
    		flip(lemming);
    		lemming.setFlip(true);
    	}
    	else {
	    	if(lemming.getPos().getCol() + lemming.getDir().getX() < 0 || lemming.getPos().getCol() + lemming.getDir().getX() >= Game.DIM_X) { //must include interaction with solid obkject
	    		flip(lemming);
	    		lemming.setFlip(true);
	    	}
    	}
    } 
    public boolean interactWith(Wall wall, Lemming lem)throws CommandException {
    	  	
    	if(wall.isInPosition(new Position (lem.getPos().getCol() + lem.getDir().getX(), lem.getPos().getRow()))) {
    	 uDir(lem, true);
    	}
    	
    	else if (wall.isAlive()) lem.setGrounded(true);// it is below
    	
		return true;
	}
    public boolean interactWith(MetalWall mWall, Lemming lem) {
    	
    	if(mWall.isInPosition(new Position (lem.getPos().getCol() + lem.getDir().getX(), lem.getPos().getRow()))) {
       	 uDir(lem, true);
       	}
       	
       	else lem.setGrounded(true); 
    	
		return true;
	}
    public void play(Lemming lem) throws CommandException {
    	move(lem);
    	getIcon(lem);
    }
    public String getName() {
		return this.name;
	}
	public String getShortcut() {
		return this.shortcut;
	}
	public String getDetails() {
		return this.details;
	}
	public String getHelp() {
		return this.help;
	}
	protected boolean matchRole(String name){
		return this.name.equals(name) || this.shortcut.equals(name);
	}
	public abstract LemmingRoleInterface parse(String name);
	public String helpText(){
		return Messages.LINE_TAB.formatted(Messages.COMMAND_HELP_TEXT.formatted(getDetails(), getHelp()));
	}
}
