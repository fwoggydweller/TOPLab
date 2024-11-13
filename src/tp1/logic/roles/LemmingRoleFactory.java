package tp1.logic.roles;

public class LemmingRoleFactory {
	static ParachuterRole pR = new ParachuterRole();
	static WalkerRole wR = new WalkerRole();
	static CaveDigger dR = new CaveDigger();

	public static LemmingRole parse(String input) {
		LemmingRole role;
		if(input.toLowerCase().equals("p") || input.toLowerCase().equals("parachuter")){
			role = pR;
		}
		else if(input.toLowerCase().equals("d") || input.toLowerCase().equals("digger")) {
			role = dR;
		}
		else{
			role = wR;
		}
		return role;
	}

}
