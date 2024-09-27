package tp1.logic;

public class GameObjectContainer {
	//TODO fill your code
	tp1.logic.gameobjects.Lemming[] Lem = new tp1.logic.gameobjects.Lemming[tp1.logic.Game.INITIAL_LEMMING_NUM];
	int LemmingsReg = 0;
	public void counterOfLemmings(tp1.logic.gameobjects.Lemming Lemming) {
		if(LemmingsReg < tp1.logic.Game.INITIAL_LEMMING_NUM) {
			Lem[LemmingsReg] = Lemming;
			LemmingsReg++;
		}
	}
}
