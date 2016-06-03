package dataservice;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import bInterface.Roles;
import model.User;

public class UserDataAccess extends iDataAccess {
	
	@SuppressWarnings("unchecked")
	public void saveUser1(Roles admin){
		List<User> allUser = getAllItems(); 
		allUser.addAll((Collection<? extends User>) admin);
		save(allUser);
	}
	
//	public void saveUser(User user){
//		List<User> allUser = getAllItems();
//		allUser.add(user);
//		save(allUser);
//	}
	public User serachUser(User temp){
		List<User> allUser = getAllItems();
		for(User user:allUser){
			if (user.getUserName().equals(temp.getUserName())
					&& user.getPassWord().equals(temp.getPassWord()))
				return user;
		}
		return null;
		
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		List<User> allUser = getAllItems();
		allUser.add(user);
		save(allUser);
	}

	
}
