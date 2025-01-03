package tp1.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Commands.CommandGenerator;
import tp1.exceptions.CommandException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.GameParseException;
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
	private int INITIAL_LEMMING_NUM;
	public static int NUMBER_OF_WALLS;
	private int numLemmingsToWin;
	private GameConfiguration conf; // exchange
	private GameConfiguration one;
	private GameConfiguration two;
	private GameConfiguration prev;
	private int cycle = 0;
	private int numLemmingsDead = 0;
	private int numLemmingsExit = 0;
	private GameConfiguration previous;
	private boolean playerExit = false;
	private String file = "";
	
	public Game(int nLevel) throws GameLoadException {
		this.one = new FileGameConfiguration("configOne.txt", this);
		this.two = new FileGameConfiguration("configTwo.txt", this);
		if(nLevel == 1) { //adds 1 of each type
			file = "configOne.txt";
			this.conf = new FileGameConfiguration(file, this);
			this.cycle = conf.getCycle();
			this.numLemmingsDead = conf.numLemmingsDead();
			this.numLemmingsExit = conf.numLemingsExit();
			this.INITIAL_LEMMING_NUM = conf.numLemmingsInBoard()-conf.numLemingsExit()-conf.numLemmingsDead();
			this.numLemmingsToWin = conf.numLemmingToWin();
		}
		else if(nLevel == 2) {
			file = "configTwo.txt";
			this.conf = new FileGameConfiguration(file, this);
			this.cycle = conf.getCycle();
			this.numLemmingsDead = conf.numLemmingsDead();
			this.numLemmingsExit = conf.numLemingsExit();
			this.INITIAL_LEMMING_NUM = conf.numLemmingsInBoard()-conf.numLemingsExit()-conf.numLemmingsDead();
			this.numLemmingsToWin = conf.numLemmingToWin();
		}
		else {
			throw new GameLoadException(Messages.NOT_VALID_LEVEL_ERROR);
		}
		this.prev = new FileGameConfiguration(file, this);
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
		return  numLemmingsToWin;
	}

	public String positionToString(int col, int row) {
		return conf.getGameObjects().whatInPos(col,row);
	}

	public boolean playerWins() {
		return numLemmingsToWin() == numLemmingsExit;
	}

	public boolean playerLoses() { //The game will stop when it's impossible for the player to win
		return numLemmingsDead() > numLemmingsToWin;
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
	public void update() throws GameModelException {
			conf.getGameObjects().update();
			cycle++;
	}
	public void reset(int n) throws GameLoadException {
		if(n == 1) {
			this.conf.copyGameConf(this.one);
		}
		else if(n==2) {
			this.conf.copyGameConf(this.two);
		}
		else {
			this.conf.copyGameConf(this.prev);
		}
		this.cycle = conf.getCycle();
		this.numLemmingsDead = conf.numLemmingsDead();
		this.numLemmingsExit = conf.numLemingsExit();
		this.INITIAL_LEMMING_NUM = conf.numLemmingsInBoard()-conf.numLemingsExit()-conf.numLemmingsDead();
		this.numLemmingsToWin = conf.numLemmingToWin();
	}
	public void updateDeadLemmings() {
		numLemmingsDead++;
	}
	public void updateExitLemmings() {
		numLemmingsExit++;
	}
	public GameItem posToObject (Position pos) throws GameModelException {
		return conf.getGameObjects().posToObject(pos);
	}
	public boolean isFinished() {
		return playerLoses() || playerWins() || getExit();
	}
	public void posInBoard(Position pos) throws OffBoardException {
		if(pos.getCol() >= DIM_X || pos.getRow()>= DIM_Y || pos.getCol() < 0 || pos.getRow()< 0){
			throw new OffBoardException(Messages.ERROR.formatted(Messages.INVALID_POSITION.formatted(pos.getCol(), pos.getRow())));
		}
	}
	@Override
	public boolean setRole(LemmingRoleInterface r, Position pos) throws GameModelException {
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
				throw new GameModelException(Messages.INVALID_OBJECT_POSITION.formatted(Messages.POSITION.formatted(pos.getCol(), pos.getRow())));
			}
	}
	public void readFile(String fileName) throws GameLoadException{
		this.conf = new FileGameConfiguration(fileName, this);
		prev.copyGameConf(conf);
		cycle = conf.getCycle();
		numLemmingsDead = conf.numLemmingsDead();
		numLemmingsExit = conf.numLemingsExit();
		INITIAL_LEMMING_NUM = conf.numLemmingsInBoard()-conf.numLemingsExit()-conf.numLemmingsDead();
		numLemmingsToWin = conf.numLemmingToWin();
	}
	public void saveFile(String fileName) throws GameModelException{
		fileName = System.getProperty("user.dir") + File.separator + "src" + File.separator + fileName;
		BufferedWriter writer = null;
		try {
		writer =  new BufferedWriter(new FileWriter(fileName));
		writer.write(this.cycle + " " + (this.INITIAL_LEMMING_NUM - this.numLemmingsExit - this.numLemmingsDead) + " " + this.numLemmingsDead + " " + this.numLemmingsExit+ " " + this.numLemmingsToWin);
		writer.write(conf.getGameObjects().stringify(fileName)); 
		}
			
		catch (Exception ioe){
			throw new GameModelException("unable to close output stream", ioe);
		}
		finally {
			try {
				writer.close();
			} catch (Exception e) {
				throw new GameModelException("unable to close output stream", e);
			}
		}
	}
}


