package tp1.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import tp1.exceptions.CommandException;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.view.Messages;

public class FileGameConfiguration implements GameConfiguration {
	private int cycle, lBoard, lDead, lExit, lWin;
	private GameObjectContainer cont;
	private GameObjectFactory fact;
	public FileGameConfiguration() {
		cont = new GameObjectContainer(Game.INITIAL_LEMMING_NUM+ Game.NUMBER_OF_WALLS+1);
		fact = new GameObjectFactory();
	}
	public FileGameConfiguration(String fileName, GameWorld game) throws CommandException{
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			  long lines = Files.lines(Paths.get(fileName)).count() - 1;
		      String line;
		      line = reader.readLine();
		      String[] sLine = line.split(" ");
		      if(sLine.length == 5) {
		    	  cont = new GameObjectContainer((int)lines);
				  fact = new GameObjectFactory();
			      cycle = Integer.parseInt(sLine[0]);
			      lBoard = Integer.parseInt(sLine[1]);
			      lDead = Integer.parseInt(sLine[2]);
			      lExit = Integer.parseInt(sLine[3]);
			      lWin = Integer.parseInt(sLine[4]);
		      }
		      else {
		    	  throw new GameLoadException(Messages.INCORRECT_GAME_STATUS.formatted(line));
		      }
		      while((line = reader.readLine()) != null) {
		        cont.add(fact.parse(line, game));
		      }
		    }
			catch (OffBoardException obe) {
				throw new GameLoadException(obe.getMessage()); //Hacer que cuando detecte que se sale del board, mande el mensaje de que se sale del board
			}
			catch (IOException ioe) {
				throw new GameLoadException(Messages.NO_FILE.formatted(fileName));
		    }
	}
	
	 public int getCycle() {
		 return cycle;
	 }
	 public int numLemmingsInBoard(){
		 return lBoard;
	 }
	 public int numLemmingsDead(){
		 return lDead;
	 }
	 public int numLemingsExit(){
		 return lExit;
	 }
	 public int numLemmingToWin(){
		 return lWin;
	 }
	   // game objects
	 public GameObjectContainer getGameObjects() {
		 return cont;
	 }
}
