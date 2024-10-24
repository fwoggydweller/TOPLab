package tp1.logic.roles;
import tp1.logic.roles.LemmingRole;
import tp1.view.Messages;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.Direction;
public class ParachuterRole extends LemmingRole{
	private Messages m = new Messages();
	@Override
	public String getIcon(Lemming lemmy) {
		String icon = m.EMPTY;
		if(!lemmy.IsGrounded()) { //there's no parachutter icon
		
		}
		return icon;
	 }
	@Override
	public void start(Lemming lemming) {
		// TODO Auto-generated method stub
	}
	@Override
	public void play(Lemming lemming) { //I think it's like this
		if(lemming.IsGrounded()) {
			lemming.disableRole();
		}
		else {
			lemming.setCurrFall(0);
		}
	}
}
