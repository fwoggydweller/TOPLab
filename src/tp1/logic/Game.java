package tp1.logic;

import tp1.logic.GameObjectContainer;
import tp1.logic.gameobjects.WalkerRole;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;
import tp1.view.Messages;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	public static final int INITIAL_LEMMING_NUM = 1;
	public static final int NUMBER_OF_WALLS = 10;
	private GameObjectContainer cont;
	private WalkerRole w = new WalkerRole();
	Messages m;
	public Game(int nLevel) {
		if(nLevel == 1) { //adds 1 of each type
			cont = new GameObjectContainer();
			cont.registerDoor(new ExitDoor(9,9));
			cont.addLemming(new Lemming(0, 0, w, this));
			cont.addWall(new Wall(2,2));
		}
		// TODO Auto-generated constructor stub
	}
	public boolean searchWall(int col, int row) {
		return cont.searchWall(col, row);
	}
	public int getCycle() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsInBoard() {
		return (INITIAL_LEMMING_NUM - numLemmingsExit());
	}

	public int numLemmingsDead() {
		return 0;
	}

	public int numLemmingsExit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsToWin() {
		return 0;
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

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}
}
