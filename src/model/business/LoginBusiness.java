package model.business;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;
import view.LoginSuccessView;

public class LoginBusiness {
	private static LoginBusiness instance = null;
	
	public User user;
	public LoginDataAccess lda;
	public String userName;
	public String password;
	
	private LoginBusiness(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.user = new User(userName, password);
		this.lda = new LoginDataAccess();
	}
	
	public static LoginBusiness getInstance(String userName, String password) {
		if (instance == null) {
			instance = new LoginBusiness(userName, password);
		}
		return instance;
	}
	
	public boolean conductRules() {
		boolean loginSuccess = false;
		try {
			if (userName.equals("")) {
				throw new MessageException("Username not informed.");
			} else if (password.equals("")) {
				throw new MessageException("Password not informed.");
			} 
			
			if (!(lda.verifyCredentials(user))) {
				throw new MessageException("Incorrect credentials.");
			} else {
				new LoginSuccessView(userName);
				loginSuccess = true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog (null, e.getMessage());
		}
		
		return loginSuccess;
	}
}
