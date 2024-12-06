package tp1.control;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
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
	public Controller(GameModel game, GameView view) {
		this.game = game;
		this.view = view;
	}



	public void run() {
		view.showWelcome();
		while(!game.isFinished()) {
			view.showGame();
			String[] userWords = view.getPrompt();
			Command command;
		    	try {
		    		command = CommandGenerator.parse(userWords);
		    		command.execute(game, view);
		    	}
		    	catch (CommandException e) {
					view.showError(e.getMessage());
					Throwable wrapped = e;
					// display all levels of error message
					while ( (wrapped = wrapped.getCause()) != null )
						view.showError(wrapped.getMessage());
				}
		}
		view.showGame();
		view.showEndMessage();
		}
}