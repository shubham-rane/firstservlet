package model;

public class LoginUtility {
	public boolean validate(Login login) {
		if(login.getUsername().equals("admin") && login.getPassword().equals("admin")) {
			return true;
		}
		else {
			return false;
		}
	}
}
