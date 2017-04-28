package net.codejava.spring.dao;

import net.codejava.spring.model.Login;

public interface LoginDAO {

	public void addEntry(Login login);
	public Login getLast();
	public void delete();
}
