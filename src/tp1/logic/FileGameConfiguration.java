package tp1.logic;

import java.io.BufferedReader;
import java.io.File;
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
	public void copyGameConf(GameConfiguration g) {
		cont.reset();
		cont.resetArray(g.getGameObjects().getSize());
		//Should we reset the game object factory?? It stays the same through all the game
		for(int i = 0; i < cont.getSize(); i++) {
			cont.add(g.getGameObjects().objInIndex(i).returnCopy());
		}
		this.cycle = g.getCycle();
		this.lBoard = g.numLemmingsInBoard();
		this.lDead = g.numLemmingsDead();
		this.lExit = g.numLemingsExit();
		this.lWin = g.numLemmingToWin();
	}
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException{
		fileName = System.getProperty("user.dir") + File.separator + "src" + File.separator + fileName;
		BufferedReader reader = null;
		
		try{
			  reader = new BufferedReader(new FileReader(fileName));
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
			catch (IOException ioe) {
				throw new GameLoadException(Messages.NO_FILE.formatted(fileName), ioe);
		    }
		    catch (Exception e) {
		    	throw new GameLoadException(Messages.LOAD_EXCEPTION_ERROR, e);
		    
		    }
			finally { //Not needed but just in case
				if(reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						throw new GameLoadException("unable to close input stream");
					}
				}
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
