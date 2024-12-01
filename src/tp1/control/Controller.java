package tp1.control;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.GameLoadException;
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
			Command command;
		    	try {
		    		command = CommandGenerator.parse(userWords);
		    		command.execute(game, view);
		    	}
		    	catch (GameLoadException g) {
		    		view.showError("Invalid file configuration");
					view.showError(g.getMessage());
		 			Throwable cause = g.getCause();
			 		if (cause != null) 
			 			view.showError(cause.getMessage());
		 			}
				catch (CommandException e) {
					view.showError(Messages.EXECUTE_EXCEPTION_ERROR);
					view.showError(e.getMessage());
		 			Throwable cause = e.getCause();
			 		if (cause != null) 
			 			view.showError(cause.getMessage());
		 			}
				}
		view.showGame();
		view.showEndMessage();
		}
}