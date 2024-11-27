package Commands;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandParseException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class UpdateCommand extends NoParamsCommand{
	private static final String NAME = Messages.COMMAND_NONE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_NONE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_NONE_DETAILS;
	private static final String HELP = Messages.COMMAND_NONE_HELP;

	public UpdateCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	public void execute(GameModel game, GameView view) throws CommandException {
		game.update();
	}
	@Override
	public Command parse(String[] name) throws CommandException {
		if(matchCommand(name[0].toLowerCase()) && name.length == 1) {
			return this;
		}
		else {
			return null;
		}
	}
}
