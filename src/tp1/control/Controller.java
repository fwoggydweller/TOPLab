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
	private boolean playerExits = false;
	private boolean playerResets = false;
	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}



	public void run() {
		view.showWelcome();
		while(!game.playerLoses() && !game.playerWins() && !playerExits && !playerResets) {
			view.showGame();
			/*command = game.concatenateAString(view.getPrompt());
			if(command.equals("reset") || command.equals("r")) { 
				game.reset();
			}
			else if(command.equals("help") || command.equals("h")) { 
				System.out.println(game.help()); 
			}
			else if(command.equals("exit") || command.equals("e")) { 
				playerExits = true;
			}
			else if(command.equals("none") || command.equals("n")) { 
				game.update();
			}
			else {
				view.showMessage("Please, insert a valid input"); //We should add an exception here so that this is repeated until a correct input is inserted
			}*/
			String[] userWords = view.getPrompt();
		    Command command = CommandGenerator.parse(userWords);

		    if (command != null) 
		        command.execute(game, view);
		    else 
		        view.showError(Messages.UNKNOWN_COMMAND);
		}
		view.showGame();
		view.showEndMessage();
	}

}
