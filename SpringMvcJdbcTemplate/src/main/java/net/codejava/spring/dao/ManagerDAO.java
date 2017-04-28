package net.codejava.spring.dao;

import net.codejava.spring.model.Manager;

public interface ManagerDAO {

	public Manager getManager(String username, String password);
	public boolean validManager(String username, String password);
	
	

}
