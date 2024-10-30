package tp1.logic.roles;

public class LemmingRoleFactory {
	static ParachuterRole pR;
	static WalkerRole wR;
	static CaveDigger dR;

	public static LemmingRole parse(String input) {
		LemmingRole role;
		if(input == "PR"){
			role = pR;
		}
		else if(input == "DR") {
			role = dR;
		}
		else {
			role = wR;
		}
		return role;
	}

}
