package Commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ExitCommand extends NoParamsCommand{
	private static final String NAME = Messages.COMMAND_EXIT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_EXIT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_EXIT_DETAILS;
	private static final String HELP = Messages.COMMAND_EXIT_HELP;

	public ExitCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	public void execute(Game game, GameView view) { //it should call the help method
		
	}
}

