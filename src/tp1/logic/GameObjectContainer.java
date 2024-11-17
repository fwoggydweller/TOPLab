package tp1.logic;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.Wall;
import tp1.logic.Game;
import tp1.view.Messages;
public class GameObjectContainer {
	//TODO fill your code
	private GameItem[] gO = new GameItem[Game.INITIAL_LEMMING_NUM+Game.NUMBER_OF_WALLS+1]; // game Items?
	private int objCount = 0;
	
	public void add(GameObject go) {
		if(objCount < gO.length) {
			gO[objCount] = go;
			objCount++;
		}
	}
	
	public String whatInPos(int col, int row) {
		String name = Messages.EMPTY;
		int pos = 0;
		//Make a loop for searching the gO of the given pos
		while(pos < gO.length && name == Messages.EMPTY) {
			if(gO[pos].isInPosition(new Position(col,row))) {
				name = gO[pos].toString(); //All of the game objects must have an overwritten toString method
				}
			pos++;
			}
		
		return name;
	}
	public void update() {
		for(int i = 0; i < gO.length; i++) {
			gO[i].update();
		}
	}
	
	public void reset() {
		objCount = 0;
	}

	public GameItem posToObject (Position pos) {
		for(int i = 0; i<objCount; i++) {
			if(gO[i].getPos().getCol() == pos.getCol() && gO[i].getPos().getRow() == pos.getRow()) {
				 return gO[i];
				}
			}
		return null;
	}
}

