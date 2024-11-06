package Commands;

import Commands.Commands;
import java.util.List;


public class CommandGenerator {

    private static final List<Commands> AVAILABLE_COMMANDS = Arrays.asList(
        new UpdateCommand(),
        new ResetCommand(),
        new HelpCommand(),
        new ExitCommand()
        // ...
    );

    public static Commands parse(String[] commandWords){
    	Commands aux;
    	
    	for(int i = 0; i < AVAILABLE_COMMANDS.size() && aux == null; i++) {
    		aux = AVAILABLE_COMMANDS[i].parse;
    	}
    	
    	return aux;
    }

    public static String commandHelp(){
    	String conc;
    	
    	for(int i = 0; i<m.length; i++) {
			conc += AVAILABLE_COMMANDS[i].helpText;
			if(AVAILABLE_COMMANDS.size() > 1) {
				conc += "\n";
			}
		}
    	
    	return conc;
    }

}