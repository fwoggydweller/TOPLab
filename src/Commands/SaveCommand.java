package Commands;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.GameParseException;
import tp1.logic.GameModel;
import tp1.logic.Position;
import tp1.view.GameView;
import tp1.view.Messages;

public class SaveCommand extends Command {
	private String fileName;
	private static final String NAME = Messages.COMMAND_SAVE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SAVE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SAVE_DETAILS;
	private static final String HELP = Messages.COMMAND_SAVE_HELP;
	public SaveCommand() {
		this.name = NAME;
		this.details = DETAILS;
		this.shortcut = SHORTCUT;
		this.help = HELP;
	}
	public SaveCommand(String fileName) {
		this.name = NAME;
		this.details = DETAILS;
		this.shortcut = SHORTCUT;
		this.help = HELP;
		this.fileName = fileName;
	}
	public Command parse(String[] name)throws CommandParseException{//Checks if the input matches this command and returns a new instance of itself
		if(matchCommand(name[0].toLowerCase())) {
			if(name.length == 2) {
				
				return new SaveCommand(name[1]);
			}
			else {
				throw new CommandParseException(Messages.INVALID_COMMAND);
			}
		}
		else {
			return null;
		}
	}
	protected boolean matchCommand(String name){
		return this.name.equals(name) || this.shortcut.equals(name);
	}
	public void execute(GameModel game, GameView view)throws CommandExecuteException{ //Calls the save file from the game and tries to save it
		try {
			game.saveFile(fileName);
		}
		catch(GameModelException gme) //If there's an error when saving the file
		{
			throw new CommandExecuteException(Messages.EXECUTE_EXCEPTION_ERROR, gme);
		}
		
	}
}
