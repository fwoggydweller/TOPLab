package tp1.logic;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Wall;
import tp1.logic.Game;
import tp1.view.Messages;
public class GameObjectContainer {
	//TODO fill your code
	private Game g;
	private Messages m;
	private Lemming[] Lem = new Lemming[g.INITIAL_LEMMING_NUM];
	private Wall[] walls = new Wall[g.NUMBER_OF_WALLS];
	private ExitDoor exit;
	
	int wallsReg=0;
	int LemmingsReg = 0;
	public void addLemming(Lemming Lemming) {
		if(LemmingsReg < g.INITIAL_LEMMING_NUM) {
			Lem[LemmingsReg] = Lemming;
			LemmingsReg++;
		}
	}
	public void addWall(Wall wall) {
			if(wallsReg < g.NUMBER_OF_WALLS) {
				walls[wallsReg]= wall;
				wallsReg++;
			}
	}
	public void registerDoor(ExitDoor exit) {
		this.exit = exit;
	}
	public boolean searchLemming(int x, int y) {
		boolean LemmingFound = false;
		int i = 0;
		while(i < Lem.length && !LemmingFound) {
			if(Lem[i].getPos().Equals(x, y)) {
				LemmingFound = true;
			}
			else {
				i++;
			}
		}
		return LemmingFound;
	}
	public boolean searchWall(int x, int y) {
		boolean WallFound = false;
		for(int i = 0; i<walls.length && !WallFound; i++) {
			if(walls[i].getPos().getCol() == x && walls[i].getPos().getRow() == y) {
				WallFound = true;
			}
		}
		return WallFound;
	}
	public boolean searchExit(int x, int y) {
		boolean ExitFound = false;
			if(exit.getPos().getCol() == x && exit.getPos().getRow()== y) {
				 ExitFound = true;
		}
		return ExitFound;
	}
	public String whatInPos(int col, int row) {
		return searchElems(col, row);
	}
	private String searchElems(int col, int row) {
		String name;
		if(searchLemming(col, row)) {
			name = m.LEMMING_RIGHT;
		}
		else if(searchWall(col, row)) {
			name = m.WALL;
		}
		else if(searchExit(col, row)) {
			name = m.EXIT_DOOR;
		}
		else {
			name = m.EMPTY;
		}
		return name;
	}
	public int numLemmingsDead() {
		int n = 0;
		for(int i = 0; i<Lem.length; i++) {
			if(!Lem[i].isAlive()) {
				n++;
			}
		}
		return n;
	}
	public int numLemmingsExit() {
		int n = 0;
		for(int i = 0; i<Lem.length; i++) {
			if(Lem[i].isExit()) {
				n++;
			}
		return n;
	}
	
}

