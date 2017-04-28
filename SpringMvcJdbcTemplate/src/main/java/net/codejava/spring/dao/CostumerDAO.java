package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Costumer;


public interface CostumerDAO {
	
public void saveOrUpdate(Costumer costumer);
	
	public void delete(int costumerId);
	
	public Costumer get(int costumerId);
	
	public List<Costumer> list();

}
