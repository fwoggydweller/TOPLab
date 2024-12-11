package tp1.logic.roles;

import java.util.Arrays;
import java.util.List;

import Commands.Command;
import Commands.ExitCommand;
import Commands.HelpCommand;
import Commands.ResetCommand;
import Commands.SetRoleCommand;
import Commands.UpdateCommand;
import tp1.exceptions.CommandException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.RoleParseException;
import tp1.view.Messages;

public class LemmingRoleFactory {
	private static final List<LemmingRoleInterface> AVAILABLE_ROLES = Arrays.asList( // add here new roles if needed (que luegp no sabemos que pasa eh)
			new ParachuterRole(),
			new WalkerRole(),
			new CaveDigger()
	        // ...
	    );
	
	public static LemmingRoleInterface parse(String input) throws RoleParseException{  // parses each role and returns it, throws expception if the role isn't found
		LemmingRoleInterface role = null;
		for(int i = 0; i < AVAILABLE_ROLES.size() && role == null; i++){
    		role = AVAILABLE_ROLES.get(i).parse(input);
    	}
		if(role == null) {
			throw new RoleParseException(Messages.UNKNOWN_ROLE_ERROR);
		}
		return role;
	}
	public static String commandHelp(){ // should be called roleHelp and gets the name and definition of each role for the help command
    	StringBuilder commands = new StringBuilder();
    	
    	for(LemmingRoleInterface c : AVAILABLE_ROLES) {
			commands.append("    " + c.helpText());
		}
    	return commands.toString();
    }
}
