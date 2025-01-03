package tp1.view;

import tp1.util.MyStringUtils;

public class Messages {
	
	public static final String VERSION = "1.0";

	public static final String GAME_NAME = "Lemmings";

	public static final String USAGE = "Usage: %s [<level>]".formatted(GAME_NAME);

	public static final String WELCOME = String.format("%s %s%n", GAME_NAME, VERSION);
	
	public static final String SELECT_LEVEL = "Please choose a level between 1 and 2";

	public static final String LEVEL_NOT_A_NUMBER = "The level must be a number";

	public static final String LEVEL_NOT_A_NUMBER_ERROR = String.format("%s: %%s", LEVEL_NOT_A_NUMBER);

	public static final String CONFIGURED_LEVEL = "Level: %s";

	public static final String PROMPT = "Command > ";

	public static final String DEBUG = "[DEBUG] Executing: %s%n";

	public static final String ERROR = "[ERROR] Error: %s%n";
	public static final String ERROR2 = "[ERROR] Error: %s";

	public static final String LINE_SEPARATOR = System.lineSeparator();

	public static final String HELP_AVAILABLE_COMMANDS = "Available commands:";

	public static final String HELP_DETAILS_COMMAND_HELP_SEPARATOR = ": ";

	public static final String COMMAND_HELP_TEXT = "%s: %s";
	// Other
		public static final String SPACE = " ";
		public static final String TAB = "   ";
		public static final String LINE = "%s" + LINE_SEPARATOR;
		public static final String LINE_TAB = TAB + LINE;
		public static final String LINE_2TABS = TAB + LINE_TAB;
	/* @formatter:off */
	public static final String[] HELP_LINES = new String[] { "Available commands:",
			"[n]one | \"\": skips cycle",
			"[r]eset: start a new game",
			"[h]elp: print this help message",
			"[e]xit: end the execution of the game"};
	/* @formatter:on */

	public static final String HELP = String.join(LINE_SEPARATOR+"   ", HELP_LINES) + LINE_SEPARATOR;
	
	public static final String UNKNOWN_COMMAND = "Unknown command %s";

	public static final String COMMAND_PARAMETERS_MISSING = "Missing parameters";

	public static final String COMMAND_INCORRECT_PARAMETER_NUMBER = "Incorrect parameter number";

	public static final String INVALID_GAME_OBJECT = String.format("Invalid object %n");

	public static final String INVALID_COMMAND = "Invalid command";

	public static final String NUMBER_OF_CYCLES = "Number of cycles:";

	public static final String REMAINING_LEMMINGS = "Remaining lemmings:";

	public static final String DEAD_LEMMINGS = "Dead lemmings:";

	public static final Object EXIT_LEMMINGS = "Lemmings exit door:";

	public static final String NUM_LEMMINGS = "Lemmings in board:";

	public static final String GAME_OVER = "Game over";

	public static final String PLAYER_QUITS = "Player leaves the game";

	public static final String PLAYER_WINS = "Player wins!";
	public static final String PLAYER_LOOSES = "Player loses...";

	public static final String POSITION = "(%s,%s)";
//Errors
	public static final String LOAD_EXCEPTION_ERROR = "Invalid file configuration";
	public static final String EXECUTE_EXCEPTION_ERROR = "Command execute problem";
	public static final String INVALID_POSITION = "Position " + POSITION + " off the board";
	public static final String ROLE_ADMISSION_ERROR="No lemming in position " + POSITION + " admits the role %s";
	public static final String UNKNOWN_ROLE_ERROR = "Unknown Role";
	public static final String NOT_VALID_LEVEL_ERROR = "Not valid level number";
	public static final String INVALID_LEMMING_ROLE = "Invalid lemming role";
	public static final String UNKNOWN_OBJECT_DIRECTION = "Unknown object direction: ''%s''";
	public static final String INVALID_LEMMING_DIRECTION = "Invalid lemming direction: ''%s''";
	public static final String INVALID_OBJECT_POSITION = "Invalid object position: ''%s''";
	public static final String OBJECT_POSITION_OFF_BOARD = "Object position is off board: ''%s''";
	public static final String NO_FILE = "File not found: ''%s''";
	public static final String INCORRECT_GAME_STATUS = "Incorrect game status: ''%s''";
	public static final String UNKNOWN_OBJECT = "Unknown game object: ''%s''";
	//Commands
	public static final String COMMAND_NONE_NAME = "none";
	public static final String COMMAND_NONE_SHORTCUT = "n";
	public static final String COMMAND_NONE_DETAILS = "[n]one | \"\"";
	public static final String COMMAND_NONE_HELP = "user does not perform any action";
	
	public static final String COMMAND_RESET_NAME = "reset";
	public static final String COMMAND_RESET_SHORTCUT = "r";
	public static final String COMMAND_RESET_DETAILS = " [r]eset [numLevel]";
	public static final String COMMAND_RESET_HELP = "reset the game to initial configuration if not numLevel else load the numLevel map";
	
	public static final String COMMAND_EXIT_NAME = "exit";
	public static final String COMMAND_EXIT_SHORTCUT = "e";
	public static final String COMMAND_EXIT_DETAILS = "[e]xit";
	public static final String COMMAND_EXIT_HELP = "exits the game";

	public static final String COMMAND_HELP_NAME = "help";
	public static final String COMMAND_HELP_SHORTCUT = "h";
	public static final String COMMAND_HELP_DETAILS = "[h]elp";
	public static final String COMMAND_HELP_HELP = "shows this help";
	
	public static final String COMMAND_SETROLE_NAME = "setrole";
	public static final String COMMAND_SETROLE_SHORTCUT = "sr";
	public static final String COMMAND_SETROLE_DETAILS = "[s]et[R]ole ROLE ROW COL";
	public static final String COMMAND_SETROLE_HELP = "sets the lemming in position (ROW,COL) to role ROLE\n";
	
	public static final String COMMAND_LOAD_NAME = "load" ;
	public static final String COMMAND_LOAD_SHORTCUT = "l";
	public static final String COMMAND_LOAD_DETAILS = "[l]load <fileName>";
	public static final String COMMAND_LOAD_HELP = "loads new game configuration from file name";
	
	public static final String COMMAND_SAVE_NAME = "save" ;
	public static final String COMMAND_SAVE_SHORTCUT = "s";
	public static final String COMMAND_SAVE_DETAILS = "[s]ave <fileName>";
	public static final String COMMAND_SAVE_HELP = "saves game into file with filename";
	
//Roles
	public static final String ROLE_DIGGER_NAME = "digger";
	public static final String ROLE_DIGGER_SHORTCUT = "d";
	public static final String ROLE_DIGGER_DETAILS = "[D]igger";
	public static final String ROLE_DIGGER_HELP = "Lemming that diggs";
	
	public static final String ROLE_PARACHUTER_NAME = "parachuter";
	public static final String ROLE_PARACHUTER_SHORTCUT = "p";
	public static final String ROLE_PARACHUTER_DETAILS = "[P]arachuter";
	public static final String ROLE_PARACHUTER_HELP = "Lemming that falls with a parachute";
	
	public static final String ROLE_WALKER_NAME = "walker";
	public static final String ROLE_WALKER_SHORTCUT = "w";
	public static final String ROLE_WALKER_DETAILS = "[W]alker";
	public static final String ROLE_WALKER_HELP = "Lemming that walks";
//Symbols
	public static final String EMPTY = "";
	public static final String WALL = MyStringUtils.repeat("▓",ConsoleView.CELL_SIZE);
	public static final String METAL_WALL = "XXXXX";
	public static final String EXIT_DOOR = "🚪";
	public static final String LEMMING_RIGHT = "B";
	public static final String LEMMING_LEFT = "ᗺ";
	public static final String PARACHUTER = "🪂";
	public static final String DIGGER_RIGHT = "b";
	public static final String DIGGER_LEFT = "d";

}
