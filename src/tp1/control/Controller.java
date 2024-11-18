package tp1.control;

import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {
	
	private GameModel game;
	private GameView view;
	private String[] aux = {"none"};
	public Controller(GameModel game, GameView view) {
		this.game = game;
		this.view = view;
	}



	public void run() {
		view.showWelcome();
		while(!game.isFinished()) {
			view.showGame();
			String[] userWords = view.getPrompt();
		    Command command = CommandGenerator.parse(userWords);

		    if (command != null) {
		    	command.execute(game, view);
		    }
		    else {
		        view.showError(Messages.UNKNOWN_COMMAND);
		    	view.showMessage(Messages.PROMPT + Messages.DEBUG.formatted("none"));
		    	command = CommandGenerator.parse(aux);
		    	command.execute(game, view);
		    }
		}
		view.showGame();
		view.showEndMessage();
	}

}
