package tp1.logic;

public interface GameModel {
	public void update();
	public void reset(int n);
	public void playerExits();
	public boolean isFinished();
	public boolean getExit();
	public String help();
	public void setRole(Position pos, String role);// debería llamarse desde aquí o gameWorld?
}
