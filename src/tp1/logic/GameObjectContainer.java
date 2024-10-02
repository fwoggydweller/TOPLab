package tp1.logic;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Wall;
import tp1.logic.Game;
public class GameObjectContainer {
	//TODO fill your code
	Game g;
	Lemming[] Lem = new Lemming[g.INITIAL_LEMMING_NUM];
	Wall[] walls = new Wall[g.NUMBER_OF_WALLS];
	private ExitDoor exit;
	int wallsReg=0;
	int LemmingsReg = 0;
	public void counterOfLemmings(Lemming Lemming) {
		if(LemmingsReg < g.INITIAL_LEMMING_NUM) {
			Lem[LemmingsReg] = Lemming;
			LemmingsReg++;
		}
		
	}
	public void counterOfWalls(Wall wall) {
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
		System.out.println(LemmingFound);
		return LemmingFound;
	}
	public boolean searchWall(int x, int y) {
		boolean WallFound = false;
		for(int i = 0; i<Lem.length && !WallFound; i++) {
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
}

