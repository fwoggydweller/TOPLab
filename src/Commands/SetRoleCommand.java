package Commands;

import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.logic.Position;
import tp1.logic.roles.LemmingRoleFactory;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{
	String type = "";
	String X = "";
	String Y = "";
	Position pos;
	private String[] empty = { ""};
	private static final String NAME = Messages.COMMAND_SETROLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SETROLE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SETROLE_DETAILS;
	private static final String HELP = Messages.COMMAND_SETROLE_HELP;
	public SetRoleCommand() {
		this.name = NAME;
		this.details = DETAILS;
		this.shortcut = SHORTCUT;
		this.help = HELP;
	}
	@Override
	public Command parse(String[] name) {
		if(matchCommand(name[0].toLowerCase())) {
			type = name[1];
			Y = name[2].toUpperCase();
			X = name[3];
			pos = new Position(Integer.parseInt(X)-1, (int)Y.charAt(0)-65);
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
	public void execute(GameModel game, GameView view) {
		if(pos.getCol() >= Game.DIM_X || pos.getRow()>= Game.DIM_Y) {
			view.showError(Messages.POSITION_ADMISSION_ERROR);
		}
		else {
			if(LemmingRoleFactory.parse(type) == null) {
				view.showError(Messages.UNKNOWN_ROLE_ERROR);
				view.showMessage(Messages.PROMPT + Messages.DEBUG.formatted("none"));
				CommandGenerator.parse(empty).execute(game, view);
			}
			else {
				if(!game.setRole(LemmingRoleFactory.parse(type), pos)) {
					view.showError(Messages.POSITION_ADMISSION_ERROR);
					view.showMessage(Messages.PROMPT + Messages.DEBUG.formatted("none"));
					CommandGenerator.parse(empty).execute(game, view);
				}
			}
		}
	}
	@Override
	public String getHelp() {
		return super.getHelp() + LemmingRoleFactory.commandHelp();
	}
}
