package tp1.control;

import tp1.logic.Game;
import tp1.view.GameView;
import java.util.Scanner;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {
	
	private Game game;
	private GameView view;
	private boolean playerExits = false;
	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}


	/**
	 * Runs the game logic, coordinate Model(game) and View(view)
	 * 
	 */
	public void run() {
		Scanner scanner = new Scanner(System.in);
        String command;
		view.showWelcome();
		while(!game.playerLoses() && !game.playerWins() && !playerExits) {
			command = scanner.nextLine().trim().toLowerCase();
			view.showGame();
			if(command == "help" || command == "h") {
				System.out.println(game.help());
				if(command == "reset" || command == "r") {
					run(); //Can I do this in order to reset the game?? Or do I have to make a new method?
				}
				else if(command == "help" || command == "h") {
					game.help();
				}
				else if(command == "exit" || command == "e") {
					playerExits = true;
				}
				else if(command == "none" || command == "n") {
					
				}
				else {
					view.showMessage("Please, insert a valid input");
				}
			}
			else {
				game.update();
			}
		}
		//TODO fill your code: The main loop that displays the game, asks the user for input, and executes the action.
		view.showEndMessage();
		scanner.close();
	}

}
