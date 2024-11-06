package Commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class UpdateCommand extends NoParamsCommand{

	public UpdateCommand(){
		super();
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
