package Commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class HelpCommand extends NoParamsCommand{
	private static final String NAME = Messages.COMMAND_HELP_NAME;
	private static final String SHORTCUT = Messages.COMMAND_HELP_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_HELP_DETAILS;
	private static final String HELP = Messages.COMMAND_HELP_HELP;

	public HelpCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	protected boolean matchCommand(String name){
		return this.name.equals(name) || this.shortcut.equals(name);
	}
	public Command parse(String[] name) {
		if(matchCommand(name[0].toLowerCase())) {
			return this;
		}
		else {
			return null;
		}
	}
	public void execute(Game game, GameView view) { //it should call the help method
		
	}
}
