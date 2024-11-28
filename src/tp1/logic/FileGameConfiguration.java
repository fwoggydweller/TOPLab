package tp1.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileGameConfiguration implements GameConfiguration {
	private int cycle, lBoard, lDead, lExit, lWin;
	private GameObjectContainer cont;
	
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException{ // 
		BufferedReader reader = new BufferedReader(new FileReader(fileName)); 
		try { 
		      String line;
		      line = reader.readLine();
		      String[] sLine = line.split(" ");
		      cycle = Integer.parseInt(sLine[0]);
		      lBoard = Integer.parseInt(sLine[1]);
		      lDead = Integer.parseInt(sLine[2]);
		      lExit = Integer.parseInt(sLine[3]);
		      lWin = Integer.parseInt(sLine[4]);
		      
		      while((line = reader.readLine()) != null) {
		        cont.add(null);
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		 	finally {
			      reader.close();
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
	 public GameObjectContainer getGameObjects();
}
