package Commands;

import tp1.logic.GameModel;
import tp1.logic.Position;
import tp1.view.GameView;
import tp1.view.Messages;

public class ResetCommand extends Command{
	private static final String NAME = Messages.COMMAND_RESET_NAME;
	private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
	private static final String HELP = Messages.COMMAND_RESET_HELP;
	private int  n = 1;
	public ResetCommand() {
		this.name = NAME;
		this.details = DETAILS;
		this.shortcut = SHORTCUT;
		this.help = HELP;
	}
	@Override
	public Command parse(String[] name) {
		if(matchCommand(name[0].toLowerCase())) {
			if(name.length > 1) {
				n = Integer.parseInt(name[1]);
			}
			return this;
		}
		else {
			return null;
		}
	}
	protected boolean matchCommand(String name){
		return this.name.equals(name) || this.shortcut.equals(name);
	}
	@Override
	public void execute(GameModel game, GameView view) { //it should call the reset method
		if(n == 1 || n == 2) {
			game.reset(n);
		}
		else {
			view.showError(Messages.NOT_VALID_LEVEL_ERROR);
		}
	}
}
