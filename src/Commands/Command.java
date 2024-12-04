package Commands;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public abstract class Command {
	protected String name;
	protected String shortcut;
	protected String details;
	protected String help;
	public Command() {
		this.name = Messages.COMMAND_NONE_NAME;
		this.details = Messages.COMMAND_NONE_DETAILS;
		this.help = Messages.COMMAND_NONE_HELP;
		this.shortcut = Messages.COMMAND_NONE_SHORTCUT;
	}
	public String getName() {
		return this.name;
	}
	public String getShortcut() {
		return this.shortcut;
	}
	public String getDetails() {
		return this.details;
	}
	public String getHelp() {
		return this.help;
	}
	public String helpText(){
		return Messages.LINE_TAB.formatted(Messages.COMMAND_HELP_TEXT.formatted(getDetails(), getHelp()));
	}

	public abstract Command parse(String[] name)throws CommandParseException;

	public abstract void execute(GameModel game, GameView view)throws CommandExecuteException;
}
