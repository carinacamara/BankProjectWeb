package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Account;


public interface AccountDAO {
	
	public void saveOrUpdate(Account account);
	
	public void delete(int accountId);
	
	public Account get(int accountId);
	
	public List<Account> list();

}
