package tp1.logic;

import tp1.exceptions.CommandException;
import tp1.logic.roles.LemmingRoleInterface;

public interface GameModel {
	public void update() throws CommandException;
	public void reset(int n)throws CommandException;
	public void playerExits();
	public boolean isFinished();
	public boolean getExit();
	public String help();
	public void posInBoard(Position pos) throws CommandException;
	public boolean setRole(LemmingRoleInterface r, Position pos) throws CommandException;
	public void readFile(String fileName) throws CommandException;
}
