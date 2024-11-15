package tp1.logic.roles;

import java.util.Arrays;
import java.util.List;

import Commands.Command;
import Commands.ExitCommand;
import Commands.HelpCommand;
import Commands.ResetCommand;
import Commands.SetRoleCommand;
import Commands.UpdateCommand;

public class LemmingRoleFactory {
	static ParachuterRole pR = new ParachuterRole();
	static WalkerRole wR = new WalkerRole();
	static CaveDigger dR = new CaveDigger();
	private static final List<LemmingRole> AVAILABLE_ROLES = Arrays.asList(
			pR,
			wR,
			dR
	        // ...
	    );

	public static LemmingRole parse(String input) {
		LemmingRole role;
		if(input.toLowerCase().equals("p") || input.toLowerCase().equals("parachuter")){
			role = pR;
		}
		else if(input.toLowerCase().equals("d") || input.toLowerCase().equals("digger")) {
			role = dR;
		}
		else{
			role = wR;
		}
		return role;
	}

}
