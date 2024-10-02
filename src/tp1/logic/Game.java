package tp1.logic;

import tp1.logic.GameObjectContainer;
import tp1.view.Messages;
public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	public static final int INITIAL_LEMMING_NUM = 2;
	public static final int NUMBER_OF_WALLS = 10;
	GameObjectContainer cont;
	Messages m;
	public Game(int nLevel) {
		// TODO Auto-generated constructor stub
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
		String Elem = whatInPos(col,row);
		String valueToPrint = m.EMPTY;
		if(Elem == "Lemming") {
			valueToPrint = m.LEMMING_RIGHT;
		}
		else if(Elem == "Wall") {
			valueToPrint = m.WALL;
		}
		else {
			
		}
		return valueToPrint;
	}

	public boolean playerWins() {
		return numLemmingsToWin() == 0;
	}

	public boolean playerLooses() {
		return numLemmingsDead() == INITIAL_LEMMING_NUM;
	}

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}
	//Check what is in that position in order to know what to print
	private String whatInPos(int col, int row) {
		String name = "Nothing";
		if(cont.searchLemming(col, row)) {
			name = "Lemming";
		}
		else if(cont.searchWall(col, row)) {
			name = "Wall";
		}
		else {
			
		}
		return name;
	}

}
