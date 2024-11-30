package tp1.logic.roles;

import tp1.exceptions.CommandException;
import tp1.exceptions.RoleParseException;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.MetalWall;
import tp1.logic.gameobjects.Wall;

public interface LemmingRoleInterface {
	public void play(Lemming lem)throws CommandException;
    public boolean interactWith(MetalWall mWall, Lemming lem);
    public boolean interactWith(Wall wall, Lemming lem)throws CommandException;
    public abstract String getIcon( Lemming lemming );
	public LemmingRoleInterface parse(String name)throws RoleParseException;
	public String getHelp();
	public String getDetails();
	public String helpText();
}
