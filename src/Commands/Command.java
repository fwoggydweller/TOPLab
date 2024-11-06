package Commands;

import tp1.logic.Game;
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
	public String getName(String name) {
		return this.name;
	}
	public String getShortcut(String shortcut) {
		return this.shortcut;
	}
	public String getDetails(String details) {
		return this.details;
	}
	public String getHelp() {
		return this.help;
	}

	public abstract Command parse(String[] name);

	public abstract void execute(Game game, GameView view);
}
