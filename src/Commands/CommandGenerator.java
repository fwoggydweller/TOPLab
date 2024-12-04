package Commands;

import Commands.Command;
import tp1.exceptions.CommandException;
import tp1.exceptions.CommandParseException;
import tp1.view.Messages;

import java.util.Arrays;
import java.util.List;


public class CommandGenerator {

    private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
    	new SetRoleCommand(),
    	new UpdateCommand(),
        new ResetCommand(1),
        new HelpCommand(),
        new ExitCommand(),
        new LoadCommand(),
    	new SaveCommand()
    );
    public static Command parse(String[] commandWords) throws CommandException{
    	Command aux = null;
    	
    	for(int i = 0; i < AVAILABLE_COMMANDS.size() && aux == null; i++) {
    		aux = AVAILABLE_COMMANDS.get(i).parse(commandWords);
    	}
    	if (aux == null) {
    		 throw new CommandParseException(Messages.UNKNOWN_COMMAND.formatted(commandWords[0]));
        }

        return aux;
    }

    public static String commandHelp(){
    	StringBuilder commands = new StringBuilder();
    	
    	for(Command c : AVAILABLE_COMMANDS) {
			commands.append(c.helpText());
		}
    	return commands.toString();
    }

}