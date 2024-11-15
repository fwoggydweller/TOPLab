package Commands;

import Commands.Command;
import java.util.Arrays;
import java.util.List;


public class CommandGenerator {

    private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
    	new SetRoleCommand(),
    	new UpdateCommand(),
        new ResetCommand(),
        new HelpCommand(),
        new ExitCommand()
        // ...
    );
    public static Command parse(String[] commandWords){
    	Command aux = null;
    	
    	for(int i = 0; i < AVAILABLE_COMMANDS.size() && aux == null; i++) {
    		aux = AVAILABLE_COMMANDS.get(i).parse(commandWords);
    	}
    	
    	return aux;
    }

    public static String commandHelp(){
    	String conc = "";
    	
    	for(int i = 0; i<AVAILABLE_COMMANDS.size(); i++) {
			conc += AVAILABLE_COMMANDS.get(i).getDetails(conc) + ": " + AVAILABLE_COMMANDS.get(i).getHelp();
			if(AVAILABLE_COMMANDS.size() > 1) {
				if(i<AVAILABLE_COMMANDS.size()-1) {
					conc += "\n";
				}
			}
		}
    	System.out.print(conc);
    	return conc;
    }

}