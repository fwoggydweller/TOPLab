package tp1.logic;

import Commands.CommandGenerator;
import tp1.exceptions.CommandException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.GameObjectContainer;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;
import tp1.logic.roles.CaveDigger;
import tp1.logic.roles.LemmingRoleInterface;
import tp1.logic.roles.LemmingRoleFactory;
import tp1.logic.roles.ParachuterRole;
import tp1.logic.roles.WalkerRole;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.GameItem;
import tp1.view.Messages;
public class Game implements GameModel, GameStatus,GameWorld{

	public static final int DIM_X = 10; 
	public static final int DIM_Y = 10;
	public static int INITIAL_LEMMING_NUM;
	public static int NUMBER_OF_WALLS;
	public static final int LEMMING_THRESHOLD = 3;
	private GameObjectContainer cont; // exchange
	private LemmingRoleFactory roles;
	private int cycle = 0;
	private int numLemmingsDead = 0;
	private int numLemmingsExit = 0;
	private boolean playerExit = false;
	public Game(int nLevel) throws CommandException {
		if(nLevel == 1) { //adds 1 of each type
			INITIAL_LEMMING_NUM = 4;
			NUMBER_OF_WALLS = 15;
			cont = new GameObjectContainer();
			Init1(nLevel);
			Init2(nLevel);
		}
		else if(nLevel == 2) {
			INITIAL_LEMMING_NUM = 5;
			NUMBER_OF_WALLS = 17;
			cont = new GameObjectContainer();
			Init1(nLevel);
			Init2(nLevel);
		}
		
	}
	private void Init1(int n) throws CommandException {
		if(n == 1) {
			cont.add(new Lemming(9, 0, this, roles.parse("w")));
			cont.add(new Lemming(3, 3, this, roles.parse("w")));
			cont.add(new Lemming(2, 3, this, roles.parse("w")));
			cont.add(new Lemming(0, 8, this, roles.parse("w")));
		}
		else if(n == 2) {
			cont.add(new Lemming(9, 0, this, roles.parse("w")));
			cont.add(new Lemming(6, 0, this, roles.parse("p")));
			cont.add(new Lemming(3, 3, this, roles.parse("w")));
			cont.add(new Lemming(2, 3, this, roles.parse("w")));
			cont.add(new Lemming(0, 8, this, roles.parse("w")));
		}
	}
	private void Init2(int n) {
		if(n == 1) {	
			cont.add(new Wall(9,1, this));	
			cont.add(new Wall(8,1, this));	
			cont.add(new Wall(2,4, this));
			cont.add(new Wall(3,4, this));	
			cont.add(new Wall(4,4, this));	
			cont.add(new Wall(7,5, this));
			cont.add(new Wall(7,6, this));	
			cont.add(new Wall(6,6, this));	
			cont.add(new Wall(5,6, this));
			cont.add(new Wall(4,6, this));	
			cont.add(new Wall(8,8, this));	
			cont.add(new Wall(9,9, this));
			cont.add(new Wall(8,9, this));	
			cont.add(new Wall(0,9, this));	
			cont.add(new Wall(1,9, this));
			cont.add(new ExitDoor(4,5, this));
		}
		else if(n == 2) {
			cont.add(new MetalWall(3, 6, this));
			cont.add(new ExitDoor(4,5, this));
			cont.add(new Wall(9,1, this));	
			cont.add(new Wall(8,1, this));	
			cont.add(new Wall(2,4, this));
			cont.add(new Wall(3,4, this));	
			cont.add(new Wall(4,4, this));	
			cont.add(new Wall(7,5, this));
			cont.add(new Wall(7,6, this));	
			cont.add(new Wall(6,6, this));	
			cont.add(new Wall(5,6, this));
			cont.add(new Wall(4,6, this));	
			cont.add(new Wall(8,8, this));	
			cont.add(new Wall(9,9, this));
			cont.add(new Wall(8,9, this));	
			cont.add(new Wall(0,9, this));	
			cont.add(new Wall(1,9, this));
			cont.add(new Wall(3,5, this));
		}
		
	}
	public int getCycle() {
		return cycle;
	}

	public int numLemmingsInBoard() {
		return (INITIAL_LEMMING_NUM - numLemmingsExit() -numLemmingsDead());
	}

	public int numLemmingsDead() {
		return numLemmingsDead;
	}

	public int numLemmingsExit() {
		return numLemmingsExit;
	}

	public int numLemmingsToWin() {
		return  LEMMING_THRESHOLD - numLemmingsExit();
	}

	public String positionToString(int col, int row) {
		return cont.whatInPos(col,row);
	}

	public boolean playerWins() {
		return numLemmingsToWin() == 0;
	}

	public boolean playerLoses() { //The game will stop when it's impossible for the player to win
		return numLemmingsDead() > INITIAL_LEMMING_NUM - LEMMING_THRESHOLD;
	}
	public void playerExits() {
		playerExit=true;
	}
	public boolean getExit() {
		return playerExit;
	}
	public String help() {
		return CommandGenerator.commandHelp();
	}
	public String concatenateAString(String[] m) {
		String conc = "";
		for(int i = 0; i<m.length; i++) {
			conc += m[i];
			if(m.length > 1) {
				conc += "\n";
			}
		}
		return conc;
	}
	public void update() throws CommandException {
		cont.update();
		cycle++;
	}
	public void reset(int n) throws CommandException {
			cycle = 0;
			numLemmingsDead = 0;
			numLemmingsExit = 0;
			cont.reset();
			Init1(n);
			Init2(n);
	}
	public void updateDeadLemmings() {
		numLemmingsDead++;
	}
	public void updateExitLemmings() {
		numLemmingsExit++;
	}
	public GameItem posToObject (Position pos) throws CommandException {
		return cont.posToObject(pos);
	}
	public boolean isFinished() {
		return playerLoses() || playerWins() || getExit();
	}
	public void posInBoard(Position pos) throws CommandException {
		if(pos.getCol() >= DIM_X || pos.getRow()>= DIM_Y || pos.getCol() < 0 || pos.getRow()< 0){
			throw new OffBoardException(Messages.ERROR.formatted(Messages.INVALID_POSITION.formatted(pos.getCol(), pos.getRow())));
		}
	}
	@Override
	public boolean setRole(LemmingRoleInterface r, Position pos) throws CommandException {
		if(cont.posToObject(pos) != null) {
			boolean res = cont.posToObject(pos).setRole(r);
			if(res) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public void readFile(String fileName){
		this.conf = new FileGameConfiguration(fileName, this);
	}
}

