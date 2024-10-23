package tp1.logic;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Wall;
import tp1.logic.Game;
import tp1.view.Messages;
public class GameObjectContainer {
	//TODO fill your code
	private Game g;
	private Messages m;
	private GameObject[] obj = new GameObject[g.INITIAL_LEMMING_NUM+g.NUMBER_OF_WALLS+ 1]; // the 1 is equal to the exit
	int globalReg = 0;
	int wallsReg=0;
	int LemmingsReg = 0;
	public void addLemming(Lemming Lemming) {
		if(LemmingsReg < g.INITIAL_LEMMING_NUM) {
			obj[globalReg] = Lemming;
			LemmingsReg++;
			globalReg++;
		}
	}
	public void addWall(Wall wall) {
		if(wallsReg < g.NUMBER_OF_WALLS) {
				obj[globalReg]= wall;
				wallsReg++;
				globalReg++;
		}
	}
	public void registerDoor(ExitDoor exit) {
		obj[globalReg] = exit;
		globalReg++;
	}
	public int searchLemming(int x, int y) {
		boolean LemmingFound = false;
		int i = 0;
		while(i < LemmingsReg && !LemmingFound) {
			if(Lem[i] != null && Lem[i].getPos().Equals(x, y)) {
				LemmingFound = true;
			}
			else {
				i++;
			}
		}
		if(!LemmingFound) {
			i = -1;
		}
		return i;
	}
	public boolean searchWall(int x, int y) {
		boolean WallFound = false;
		for(int i = 0; i < wallsReg && !WallFound; i++) {
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
		
		if(searchExit(col, row)) { // new (not submitted)  // print the toString of wall, not the direct msg
			name = m.EXIT_DOOR;
		}
		else if(searchLemming(col, row) != -1) { // call searchLem once
			name = Lem[searchLemming(col,row)].toString();
		}
		else if(searchWall(col, row)) { // print the toString of wall, not the direct msg (all gameobjects need a toString)
			name = m.WALL;
		}
		else { // the toStrings all return the icon or empty so this case will not be needed
			name = m.EMPTY;
		}
		return name;
	}
	public int numLemmingsDead() {
		int n = 0;
		for(int i = 0; i<globalReg; i++) {
			if(obj[i] != null && obj[i].isAlive()) {
				n++;
			}
		}
		return LemmingsReg - n;
	}
	public int numLemmingsExit() {
		int n = 0;
		for(int i = 0; i<LemmingsReg; i++) {
			if(Lem[i] != null && Lem[i].isExit()) {
				n++;
			}
		}
		return n;
	
	}
	public void moveLemmings() {
		for(int i = 0; i < LemmingsReg; i++) {
			if(Lem[i] != null && Lem[i].isAlive() && !Lem[i].isExit()) {
				Lem[i].update();
			}
		}
	}
	public void reset() {
		LemmingsReg = 0;
		removeLemmings();
	}
	private void removeLemmings() {
		Lemming[] L = new Lemming[g.INITIAL_LEMMING_NUM];
		this.Lem = L;
	}
}


