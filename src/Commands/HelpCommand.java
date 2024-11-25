package Commands;

import tp1.logic.GameModel;
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
	public void execute(GameModel game, GameView view) { //it should call the help method
		view.showMessage(game.help());
	}
	@Override
	public Command parse(String[] name) {
		if(matchCommand(name[0].toLowerCase()) && name.length == 1) {
			
			return new HelpCommand();
		}
		else {
			return null;
		}
	}
}
