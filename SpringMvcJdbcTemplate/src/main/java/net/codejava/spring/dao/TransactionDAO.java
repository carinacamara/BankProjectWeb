package net.codejava.spring.dao;

import java.sql.Date;
import java.util.List;

import net.codejava.spring.model.Transaction;

public interface TransactionDAO {
	
	public void saveOrUpdate(Transaction transaction);
	
	public List<Transaction> list();
	
	public List<Transaction> getRaport(Date creationDateOne, Date creationDateTwo, int idEmployee);

	public int setTransactionId(String username, String password);
}
