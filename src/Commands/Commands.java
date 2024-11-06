package Commands;

public abstract class Commands {
	// It has four attributes of type String, initialised in the constructor: name, shortcut, details, help, and getter methods for each of these attributes.
	protected String name;
	protected String shortcut;
	protected String details;
	protected String help;
	public String getName(String name) {
		return this.name;
	}
	public String getShortcut(String shortcut) {
		return this.shortcut;
	}
	public String getDetails(String details) {
		return this.details;
	}
	public String getHelp(String help) {
		return this.help;
	}
}
