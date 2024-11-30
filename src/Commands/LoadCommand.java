package Commands;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameParseException;
import tp1.logic.GameModel;
import tp1.logic.Position;
import tp1.view.GameView;
import tp1.view.Messages;

public class LoadCommand extends Command {
	private String fileName;
	private static final String NAME = Messages.COMMAND_LOAD_NAME;
	private static final String SHORTCUT = Messages.COMMAND_LOAD_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_LOAD_DETAILS;
	private static final String HELP = Messages.COMMAND_LOAD_HELP;
	public LoadCommand() {
		this.name = NAME;
		this.details = DETAILS;
		this.shortcut = SHORTCUT;
		this.help = HELP;
	}
	public LoadCommand(String fileName) {
		this.name = NAME;
		this.details = DETAILS;
		this.shortcut = SHORTCUT;
		this.help = HELP;
		this.fileName = fileName;
	}
	public Command parse(String[] name)throws CommandException{
		if(matchCommand(name[0].toLowerCase())) {
			if(name.length == 2) {
				
				return new LoadCommand(name[1]);
			}
			else {
				throw new GameParseException("parse wrong length");
			}
		}
		else {
			return null;
		}
	}
	protected boolean matchCommand(String name){
		return this.name.equals(name) || this.shortcut.equals(name);
	}
	public void execute(GameModel game, GameView view)throws CommandException{
		game.readFile(fileName);
	}
}