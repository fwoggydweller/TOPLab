package Commands;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
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
	public void execute(GameModel game, GameView view) throws CommandExecuteException {
		try{
			game.update();
		}
		catch (GameModelException l) {
			throw new CommandExecuteException(Messages.EXECUTE_EXCEPTION_ERROR,l);
		}
	}
	@Override
	public Command parse(String[] name) throws CommandParseException {//Checks if the input matches this command and returns itself
		if(matchCommand(name[0].toLowerCase()) && name.length == 1) {
			return this;
		}
		else {
			return null;
		}
	}
}
