package model;
import java.io.Serializable;

import bInterface.Roles;
import enums.Role;

public class User implements Roles, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1026492093669725657L;
	private String userName;
	private String passWord;
	private Role role;
	
	public User(String userName, String passWord) {
	
		this.userName = userName;
		this.passWord = passWord;
	}
	public User(String userName, String passWord, Role role) {
		
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public void setRoles() {
		// TODO Auto-generated method stub
		System.out.println("Role set"+role );
		//new User(userName, passWord, role)
		
	}
}
