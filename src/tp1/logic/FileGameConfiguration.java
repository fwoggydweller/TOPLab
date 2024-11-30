package tp1.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;

public class FileGameConfiguration implements GameConfiguration {
	private int cycle, lBoard, lDead, lExit, lWin;
	private GameObjectContainer cont;
	private GameObjectFactory fact;
	public FileGameConfiguration() {
		cont = new GameObjectContainer();
		fact = new GameObjectFactory();
	}
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException{
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){ 
		      String line;
		      line = reader.readLine();
		      String[] sLine = line.split(" ");
		      cont = new GameObjectContainer();
			  fact = new GameObjectFactory();
		      cycle = Integer.parseInt(sLine[0]);
		      lBoard = Integer.parseInt(sLine[1]);
		      lDead = Integer.parseInt(sLine[2]);
		      lExit = Integer.parseInt(sLine[3]);
		      lWin = Integer.parseInt(sLine[4]);
		      
		      while((line = reader.readLine()) != null) {
		        cont.add(fact.parse(line, game));
		      }
		    }
			catch (OffBoardException obe) {
				throw new GameLoadException("Se te va");
			}
			catch (IOException ioe) {
				throw new GameLoadException("IO problem arose, unable to properly read file");
		    }
			catch (NumberFormatException nfe) {
			throw new GameLoadException("Unable to properly read board state counters");
			}
			catch (ObjectParseException ope) {
			throw new GameLoadException("NoObjeto");
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
