package tp1.logic;

import tp1.exceptions.CommandException;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.GameModelException;
import tp1.logic.roles.LemmingRoleInterface;

public interface GameModel {
	public void update() throws GameModelException;
	public void reset(int n)throws GameLoadException;
	public void playerExits();
	public boolean isFinished();
	public boolean getExit();
	public String help();
	public void posInBoard(Position pos) throws GameModelException;
	public boolean setRole(LemmingRoleInterface r, Position pos) throws GameModelException;
	public void readFile(String fileName)throws GameLoadException;
	public void saveFile(String fileName) throws GameModelException;
}
