package tp1.logic;

import tp1.logic.GameObjectContainer;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.roles.WalkerRole;
import tp1.logic.gameobjects.ExitDoor;
import tp1.view.Messages;
public class Game {

	public static final int DIM_X = 10; 
	public static final int DIM_Y = 10;
	public static final int INITIAL_LEMMING_NUM = 1;
	public static final int NUMBER_OF_WALLS = 10;
	private int LEMMING_EXIT = 0; 
	private GameObjectContainer cont;
	private WalkerRole w = new WalkerRole();
	private Messages m;
	private int cycle = 0;
	public Game(int nLevel) {
		if(nLevel == 1) { //adds 1 of each type
			cont = new GameObjectContainer();
			cont.registerDoor(new ExitDoor(9,9));
			cont.addLemming(new Lemming(1, 1, w, this));
			cont.addWall(new Wall(1,2));		
		}
		// TODO Auto-generated constructor stub
	}
	public boolean searchWall(int col, int row) {
		return (cont.searchWall(col, row));
	}
	public boolean searchExit(int col, int row) {
		return cont.searchExit(col, row);
	}
	public int getCycle() {
		return cycle;
	}

	public int numLemmingsInBoard() {
		return (INITIAL_LEMMING_NUM - numLemmingsExit() -numLemmingsDead());
	}

	public int numLemmingsDead() {
		return cont.numLemmingsDead();
	}

	public int numLemmingsExit() {
		// TODO Auto-generated method stub
		return cont.numLemmingsExit() ;
	}

	public int numLemmingsToWin() {
		return INITIAL_LEMMING_NUM - numLemmingsExit();
	}

	public String positionToString(int col, int row) {
		return cont.whatInPos(col,row);
	}

	public boolean playerWins() {
		return numLemmingsToWin() == 0;
	}

	public boolean playerLoses() {
		return numLemmingsDead() == INITIAL_LEMMING_NUM;
	}

	public String help() { //Is this okay? Make a loop
		return Messages.HELP_LINES[0] + "\n" + Messages.HELP_LINES[1] + "\n" + Messages.HELP_LINES[2] + "\n" + Messages.HELP_LINES[3] + "\n" + Messages.HELP_LINES[4];
	}
	public void update() {
		cont.moveLemmings();
		cycle++;
	}
}
