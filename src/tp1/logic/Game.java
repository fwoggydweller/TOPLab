package tp1.logic;

import tp1.logic.GameObjectContainer;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.roles.CaveDigger;
import tp1.logic.roles.ParachuterRole;
import tp1.logic.roles.WalkerRole;
import tp1.logic.gameobjects.ExitDoor;
import tp1.view.Messages;
public class Game {

	public static final int DIM_X = 10; 
	public static final int DIM_Y = 10;
	public static final int INITIAL_LEMMING_NUM = 4;
	public static final int NUMBER_OF_WALLS = 15;
	public static final int LEMMING_THRESHOLD = 3;
	private GameObjectContainer cont;
	private ParachuterRole pR = new ParachuterRole();
	private WalkerRole wR = new WalkerRole();
	private CaveDigger cD = new CaveDigger();
	private Messages m;
	private int cycle = 0;
	public Game(int nLevel) {
		cont = new GameObjectContainer();
		if(nLevel == 1) { //adds 1 of each type	
			cont.registerDoor(new ExitDoor(4,5));
			Init1();
			Init2();
		}
		// TODO Auto-generated constructor stub
	}
	private void Init1() {
		cont.addLemming(new Lemming(9, 0, wR, this));
		cont.addLemming(new Lemming(3, 3, wR, this));
		cont.addLemming(new Lemming(2, 3, wR, this));
		cont.addLemming(new Lemming(0, 8, wR, this));
	}
	private void Init2() {
		cont.addWall(new Wall(9,1));	
		cont.addWall(new Wall(8,1));	
		cont.addWall(new Wall(2,4));
		cont.addWall(new Wall(3,4));	
		cont.addWall(new Wall(4,4));	
		cont.addWall(new Wall(7,5));
		cont.addWall(new Wall(7,6));	
		cont.addWall(new Wall(6,6));	
		cont.addWall(new Wall(5,6));
		cont.addWall(new Wall(4,6));	
		cont.addWall(new Wall(8,8));	
		cont.addWall(new Wall(9,9));
		cont.addWall(new Wall(8,9));	
		cont.addWall(new Wall(0,9));	
		cont.addWall(new Wall(1,9));
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

	public String help() { //Is this okay? Make a loop
		return concatenateAString(Messages.HELP_LINES);
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
	public void update() {
		cont.moveLemmings();
		cycle++;
	}
	public void reset() {
		cycle = 0;
		cont.reset();
		Init1();
	}
}
