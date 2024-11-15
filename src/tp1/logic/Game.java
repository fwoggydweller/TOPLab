package tp1.logic;

import Commands.CommandGenerator;
import tp1.logic.GameObjectContainer;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.roles.CaveDigger;
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
	public static final int INITIAL_LEMMING_NUM = 4;
	public static final int NUMBER_OF_WALLS = 15;
	public static final int LEMMING_THRESHOLD = 3;
	private GameObjectContainer cont;
	private LemmingRoleFactory roles;
	private Messages m;
	private int cycle = 0;
	private int numLemmingsDead = 0;
	private int numLemmingsExit = 0;
	private boolean playerExit = false;
	public Game(int nLevel) {
		cont = new GameObjectContainer();
		if(nLevel == 1) { //adds 1 of each type
			Init1();
			Init2();
		}
		// TODO Auto-generated constructor stub
	}
	private void Init1() {
		cont.add(new Lemming(9, 0, roles.parse("w"), this));
		cont.add(new Lemming(3, 3, roles.parse("w"), this));
		cont.add(new Lemming(2, 3, roles.parse("w"), this));
		cont.add(new Lemming(0, 8, roles.parse("w"), this));
	}
	private void Init2() {
		cont.add(new Wall(9,1));	
		cont.add(new Wall(8,1));	
		cont.add(new Wall(2,4));
		cont.add(new Wall(3,4));	
		cont.add(new Wall(4,4));	
		cont.add(new Wall(7,5));
		cont.add(new Wall(7,6));	
		cont.add(new Wall(6,6));	
		cont.add(new Wall(5,6));
		cont.add(new Wall(4,6));	
		cont.add(new Wall(8,8));	
		cont.add(new Wall(9,9));
		cont.add(new Wall(8,9));	
		cont.add(new Wall(0,9));	
		cont.add(new Wall(1,9));
		cont.add(new ExitDoor(4,5));
	}
	/*public boolean searchWall(int col, int row) {
		return (cont.whatInPos(col, row)) == m.WALL;
	}
	public boolean searchExit(int col, int row) {
		return cont.whatInPos(col, row) == m.EXIT_DOOR;
	}*/
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
	public void update() {
		cont.update();
		cycle++;
	}
	public void reset() {
		cycle = 0;
		numLemmingsDead = 0;
		numLemmingsExit = 0;
		cont.reset();
		Init1();
		Init2();
	}
	public void updateDeadLemmings() {
		numLemmingsDead++;
	}
	public void updateExitLemmings() {
		numLemmingsExit++;
	}
	public GameItem posToObject (Position pos) {
		return cont.posToObject(pos);
	}
	public boolean isFinished() {
		return playerLoses() || playerWins() || getExit();
	}
	/*public void setRole(Position pos, String role) { // eto tamal?
		GameItem a;
		a = cont.posToObject(pos);
		if(a != null && a.isAlive()) {
			a.setRole(roles.parse(role));
		}
		else {
			System.out.println("AA");
		}
		
	}*/
	@Override
	public void setRole(Position pos, String role) {
		// TODO Auto-generated method stub
		
	}
}
