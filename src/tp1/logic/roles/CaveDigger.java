package tp1.logic.roles;

import tp1.logic.gameobjects.Lemming;

public class CaveDigger extends LemmingRole{

	@Override
	public String getIcon(Lemming lemming) {
		// TODO Auto-generated method stub
		return "D";
	}
	// overwrite move wyhen interactions is done to destroy wall below but not if metalwall
}
