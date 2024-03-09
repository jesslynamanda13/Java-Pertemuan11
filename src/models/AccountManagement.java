package models;

import java.util.ArrayList;

public class AccountManagement {
	protected ArrayList<User> users;
	protected User activeUser;
	
	public AccountManagement() {
		this.users = new ArrayList<>();
	}
	
	public void signUpUser(User user) {
		users.add(user);
	}
	
	public boolean loginUser(String email, String password) {
		for(User user : users) {
			if(user.getEmail().equals(email) && 
					user.getPassword().equals(password)) {
					activeUser = user;
					return true;
			}
		}
		return false;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public User getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}
	
	
}
