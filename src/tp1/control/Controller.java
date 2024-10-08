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
			view.showGame();
			command = scanner.nextLine().trim().toLowerCase();
			if(command.equals("help") || command.equals("h")) {
				System.out.println(game.help());
				command = scanner.nextLine().trim().toLowerCase();
				if(command.equals("reset") || command.equals("r")) { //Works (I guess?)
					run(); //Can I do this in order to reset the game?? Or do I have to make a new method?
				}
				else if(command.equals("help") || command.equals("h")) { //Works (I guess?)
					System.out.println(game.help()); //I do not get why we should do this (???
				}
				else if(command.equals("exit") || command.equals("e")) { //Works
					playerExits = true;
				}
				else if(command.equals("none") || command.equals("n")) {
					
				}
				else {
					view.showMessage("Please, insert a valid input");
				}
			}
			game.update();
		}
		//TODO fill your code: The main loop that displays the game, asks the user for input, and executes the action.
		view.showEndMessage();
		scanner.close();
	}

}
