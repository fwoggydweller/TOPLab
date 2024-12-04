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
	private LemmingRoleFactory roles;
	private int cycle = 0;
	private int numLemmingsDead = 0;
	private int numLemmingsExit = 0;
	private boolean playerExit = false;
	private String file = "";
	
	public Game(int nLevel) throws CommandException {
		if(nLevel == 1) { //adds 1 of each type
			file = "configOne.txt";
			readFile(file);
		}
		else if(nLevel == 2) {
			file = "configTwo.txt";
			readFile(file);
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
		try {
			conf.getGameObjects().update();
			cycle++;
		}
		catch(CommandException c) {
			throw new GameModelException(c.getMessage());
		}
	}
	public void reset(int n) throws GameLoadException {
		if(n == 1) {
			readFile("configOne.txt");
		}
		if(n==2) {
			readFile("configTwo.txt");
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
				return false;
			}
	}
	public void readFile(String fileName) throws GameLoadException{
		file = fileName;
		this.conf = new FileGameConfiguration(fileName, this);
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
			
		catch (IOException ioe){
			throw new GameModelException("unable to close output stream");
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new GameModelException("unable to close output stream");
			}
		}
	}
}


