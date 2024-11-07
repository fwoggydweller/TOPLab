package Commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;
import Commands.CommandGenerator;

public class HelpCommand extends NoParamsCommand{
	private static final String NAME = Messages.COMMAND_HELP_NAME;
	private static final String SHORTCUT = Messages.COMMAND_HELP_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_HELP_DETAILS;
	private static final String HELP = Messages.COMMAND_HELP_HELP;

	public HelpCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	public void execute(Game game, GameView view) { //it should call the help method
		game.help();

	}
}
