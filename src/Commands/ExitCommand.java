package Commands;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandParseException;
import tp1.logic.GameModel;
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
	public void execute(GameModel game, GameView view) { //Calls a method from the game that ends the game
		game.playerExits();
	}
	@Override
	public Command parse(String[] name) { //Checks if the input matches this command and returns a new instance of itself
		if(matchCommand(name[0].toLowerCase()) && name.length == 1) {
			return this;
		}
		else {
			return null;
		}
	}
}

