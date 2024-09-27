package tp1.logic;

import tp1.logic.GameObjectContainer;
public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	public static final int INITIAL_LEMMING_NUM = 2;
	GameObjectContainer cont;
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
		String valueToPrint = "     ";
		if(Elem == "Lemming") {
			
		}
		else if(Elem == "Wall") {
			
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
		
		return name;
	}

}
