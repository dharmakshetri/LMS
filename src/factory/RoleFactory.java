package factory;

import bInterface.Roles;
import common.DataHelper;
import enums.Role;
import model.User;
 
public class RoleFactory {
	public Roles createRoles(String roleType) {
		if (roleType == null) {
			return null;
		}
		if (roleType.equalsIgnoreCase(DataHelper.ROLE_ADMIN)) {
			return new User("admin", "admin", Role.ADMIN);
		} else if (roleType.equalsIgnoreCase(DataHelper.ROLE_LIBRAIN)) {
			return new User("lib", "lib", Role.LIBRARIAN);
		} else {
			return null;
		}
	}

}
