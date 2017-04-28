package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Employee;


public interface EmployeeDAO {
	
public void saveOrUpdate(Employee employee);
	
	public void delete(int employeeId);
	
	public Employee get(int employeeId);
	
	public List<Employee> list();
	
	public Employee getEmployee(String username, String password);
	
	public boolean validEmployee(String username, String password);

}
