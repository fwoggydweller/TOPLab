package Commands;

import tp1.view.Messages;

public abstract class NoParamsCommand extends Command{
	public NoParamsCommand() {
		this.name = Messages.COMMAND_NONE_NAME;
		this.details = Messages.COMMAND_NONE_DETAILS;
		this.shortcut = Messages.COMMAND_EXIT_SHORTCUT;
		this.help = Messages.COMMAND_NONE_HELP;
	}
	public NoParamsCommand(String name, String sc, String details, String help) {
		this.name = name;
		this.shortcut = sc;
		this.details = details;
		this.help = help;
	}
	protected boolean matchCommand(String name){
		return this.name.equals(name) || this.shortcut.equals(name) || name.equals(Messages.EMPTY);
	}
	
	public abstract Command parse(String[] name);
}
