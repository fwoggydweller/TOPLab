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
		while(i < globalReg && !LemmingFound) {
			if(obj[i] != null && obj[i].isInPosition(new Position(x,y)) && obj[i].isAlive()) {
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
		for(int i = 0; i < globalReg && !WallFound; i++) {
			if(obj[i].isInPosition(new Position(x,y)) && obj[i].isSolid()) {
				WallFound = true;
			}
		}
		return WallFound;
	}
	public boolean searchExit(int x, int y) {
		boolean ExitFound = false;
		for(int i = 0; i < globalReg && !ExitFound; i++) {
			if(obj[i].isInPosition(new Position(x,y)) && obj[i].isExit()) { 
				 ExitFound = true;
			}
		}
		return ExitFound;
	}
	public String whatInPos(int col, int row) {
		return searchElems(col, row);
	}
	private String searchElems(int col, int row) { //idk how to make this anymore
		String name = "";
		if(searchLemming(col, row) != -1) {
			//name = Lem[searchLemming(col,row)].toString();
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
		for(int i = 0; i<globalReg; i++) {
			if(obj[i] != null && obj[i].isAlive()) {
				n++;
			}
		}
		return LemmingsReg - n;
	}
	public int numLemmingsExit() { //TODO
		int n = 0;
		for(int i = 0; i<globalReg; i++) {
			if(obj[i] != null && obj[i].isAlive()) { //How can I differenciate between lemmings that are alive and lemmings that exited
				n++;
			}
		}
		return n;
	
	}
	public void moveLemmings() {
		for(int i = 0; i < globalReg; i++) {
			if(obj[i] != null && obj[i].isAlive()) {
				g.update();
			}
		}
	}
	public void reset() {
		LemmingsReg = 0;
		resetLemmings();
	}
	private void resetLemmings() {
		for(int i = 0; i < globalReg; i++) {
			if(!obj[i].isExit() && !obj[i].isSolid()) {
				
			}
		}
	}
}


