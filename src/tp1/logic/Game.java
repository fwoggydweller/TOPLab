package tp1.logic;

import java.io.File;

import Commands.CommandGenerator;
import tp1.exceptions.CommandException;
import tp1.exceptions.GameLoadException;
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
	private GameConfiguration conf; // exchange
	private LemmingRoleFactory roles;
	private int cycle = 0;
	private int numLemmingsDead = 0;
	private int numLemmingsExit = 0;
	private boolean playerExit = false;
	private String file = "";
	private String path1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "ConfigOne.txt";
	private String path2 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "ConfigTwo.txt";
	private GameConfiguration ONE = new FileGameConfiguration(path1, this);
	private GameConfiguration TWO = new FileGameConfiguration(path2, this);
	
	public Game(int nLevel) throws CommandException {
		if(nLevel == 1) { //adds 1 of each type
			INITIAL_LEMMING_NUM = 4;
			NUMBER_OF_WALLS = 15;
			conf = ONE;
		}
		else if(nLevel == 2) {
			INITIAL_LEMMING_NUM = 5;
			NUMBER_OF_WALLS = 17;
			conf = TWO;
		}
		else {
			throw new GameLoadException(Messages.NOT_VALID_LEVEL_ERROR);
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
		return conf.getGameObjects().whatInPos(col,row);
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
		conf.getGameObjects().update();
		cycle++;
	}
	public void reset(int n) throws CommandException {
		if(conf == ONE || n == 1) {
			readFile(path1);
		}
		else if(conf == TWO || n == 2) {
			readFile(path2);
		}
		else {
			readFile(file);
		}
	}
	public void updateDeadLemmings() {
		numLemmingsDead++;
	}
	public void updateExitLemmings() {
		numLemmingsExit++;
	}
	public GameItem posToObject (Position pos) throws CommandException {
		return conf.getGameObjects().posToObject(pos);
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
		if(conf.getGameObjects().posToObject(pos) != null) {
			boolean res = conf.getGameObjects().posToObject(pos).setRole(r);
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
	public void readFile(String fileName) throws CommandException{
		file = fileName;
		this.conf = new FileGameConfiguration(fileName, this);
	}
}

