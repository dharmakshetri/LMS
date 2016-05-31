package dataservice;

import java.util.List;
import java.util.Map.Entry;

import model.User;

public class UserDataAccess extends iDataAccess {
	public void saveUser(User user){
		List<User> allUser = getAllItems();
		allUser.add(user);
		save(allUser);
	}
	public User serachUser(User temp){
		List<User> allUser = getAllItems();
		for(User user:allUser){
			if (user.getUserName().equals(temp.getUserName())
					&& user.getPassWord().equals(temp.getPassWord()))
				return user;
		}
		return null;
		
	}

	
}
