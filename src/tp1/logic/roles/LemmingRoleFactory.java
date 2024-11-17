package tp1.logic.roles;

import java.util.Arrays;
import java.util.List;

import Commands.Command;
import Commands.ExitCommand;
import Commands.HelpCommand;
import Commands.ResetCommand;
import Commands.SetRoleCommand;
import Commands.UpdateCommand;
import tp1.view.Messages;

public class LemmingRoleFactory {
	private static final List<LemmingRole> AVAILABLE_ROLES = Arrays.asList(
			new ParachuterRole(),
			new WalkerRole(),
			new CaveDigger()
	        // ...
	    );
	
	public static LemmingRole parse(String input) {
		LemmingRole role = null;
		for(int i = 0; i < AVAILABLE_ROLES.size() && role == null; i++) {
    		role = AVAILABLE_ROLES.get(i).parse(input);
    	}
		return role;
	}
	public static String commandHelp(){
    	String conc = "";
    	
    	for(int i = 0; i<AVAILABLE_ROLES.size(); i++) {
			conc += "   " + AVAILABLE_ROLES.get(i).getDetails(conc) + ": " + AVAILABLE_ROLES.get(i).getHelp();
			if(AVAILABLE_ROLES.size() > 1) {
				if(i < AVAILABLE_ROLES.size() - 1)
				conc += "\n";
			}
		}
    	return conc;
    }
}
