package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {
	
	private Game game;
	private GameView view;
	public Controller(Game game, GameView view) {
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
		    else 
		        view.showError(Messages.UNKNOWN_COMMAND);
		}
		view.showGame();
		view.showEndMessage();
	}

}
