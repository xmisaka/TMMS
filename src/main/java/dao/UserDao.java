package dao;

import java.util.Set;

import entity.User;

public interface UserDao {

	public User getByUserName(String userName);
	
	public Set<String> getRoles(String userName);
	
	public Set<String> getPermissions(String userName);
}
