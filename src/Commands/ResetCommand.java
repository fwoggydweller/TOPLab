package Commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ResetCommand extends NoParamsCommand{
	private static final String NAME = Messages.COMMAND_RESET_NAME;
	private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
	private static final String HELP = Messages.COMMAND_RESET_HELP;

	public ResetCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	public void execute(Game game, GameView view) { //it should call the reset method
		game.reset();
	}
}
