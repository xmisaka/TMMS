package service;

import java.util.Set;

import entity.User;

public interface UserService {


	public User getByUserName(String userName);
	
	
	public Set<String> getRoles(String userName);
	

	public Set<String> getPermissions(String userName);
}
