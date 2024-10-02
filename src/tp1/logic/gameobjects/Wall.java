package tp1.logic.gameobjects;
import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.logic.Position;
public class Wall {
	Position pos;
	GameObjectContainer gCont;
	boolean solid = false;
	public Wall(int x,int y) {
		pos = new Position(x,y);
		gCont.counterOfWalls(this);
	}
	public Position getPos() {
		return pos;
	}
}
