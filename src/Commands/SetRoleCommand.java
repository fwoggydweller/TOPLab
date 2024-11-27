package Commands;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameParseException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
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
	public SetRoleCommand(int x, int y, String type) {
		this.name = NAME;
		this.details = DETAILS;
		this.shortcut = SHORTCUT;
		this.help = HELP;
		this.pos = new Position(x, y);
		this.type = type;
	}
	@Override
	public Command parse(String[] name) throws CommandException {
		if(matchCommand(name[0].toLowerCase())) {
			if(name.length == 4) {
				type = name[1];
				Y = name[2].toUpperCase();
				X = name[3];
				this.pos = new Position(Integer.parseInt(X)-1, (int)Y.charAt(0)-65);
				return new SetRoleCommand(this.pos.getCol(), this.pos.getRow(), this.type);
			}
			else {
				throw new GameParseException(Messages.UNKNOWN_ROLE_ERROR);
			}
		}
		else {
			return null;
		}
	}
	protected boolean matchCommand(String name){
		return this.name.equals(name) || this.shortcut.equals(name);
	}
	@Override
	public void execute(GameModel game, GameView view) throws CommandException{
			game.posInBoard(pos);
			game.setRole(LemmingRoleFactory.parse(type), this.pos);
	}
	@Override
	public String getHelp() {
		return super.getHelp() + LemmingRoleFactory.commandHelp();
	}
}
