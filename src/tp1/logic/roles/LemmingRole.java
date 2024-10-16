package tp1.logic.roles;
import tp1.logic.gameobjects.Lemming;
public interface LemmingRole {
	public void start( Lemming lemming );
    public void play( Lemming lemming );
    public String getIcon( Lemming lemming );
}
