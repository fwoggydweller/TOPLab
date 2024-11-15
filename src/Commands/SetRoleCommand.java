package Commands;

import tp1.logic.GameModel;
import tp1.logic.Position;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{
	String type = "";
	String X = "";
	String Y = "";
	Position pos;
	public SetRoleCommand() { // ponerlo desde messages?
		this.name = "setrole";
		this.details = "[s]et[R]ole ROLE ROW COL";
		this.shortcut = "sr";
		this.help = "sets the lemming in position (ROW,COL) to role ROLE\n" + "      [P]arachuter: Lemming falls with a parachute\n"
				+ "      [W]alker: Lemming that walks\n" + "      [D]igger: Lemming that diggs if the floor is not made out of metal";
	}
	@Override
	public Command parse(String[] name) {
		if(matchCommand(name[0].toLowerCase())) {
			type = name[1];
			Y = name[2];
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
		game.setRole(pos, type);
	}
	
}
