package tp1.logic.roles;

import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class CaveDigger extends LemmingRole{
	private static final String NAME = Messages.COMMAND_RESET_NAME;
	private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
	private static final String HELP = Messages.COMMAND_RESET_HELP;
	@Override
	public String getIcon(Lemming lemming) {
		// TODO Auto-generated method stub
		return "D";
	}
	// overwrite move when interactions is done to destroy wall below but not if metalwall
}
