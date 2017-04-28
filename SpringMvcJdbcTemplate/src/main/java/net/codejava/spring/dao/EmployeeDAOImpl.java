package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		if (employee.getId() > 0) {
			// update
			String sql = "UPDATE Employee SET name=?, username=?, password=?, "
						+ "email=? WHERE id=?";
			jdbcTemplate.update(sql, employee.getName(), employee.getUsername(),
					employee.getPassword(), employee.getEmail(), employee.getId());
		} else {
			// insert
			String sql = "INSERT INTO Employee (name, username, password, email)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, employee.getName(), employee.getUsername(),
					employee.getPassword(), employee.getEmail());
		}
		
	}

	@Override
	public void delete(int employeeId) {
		String sql = "DELETE FROM Employee WHERE id=?";
		jdbcTemplate.update(sql, employeeId);
	}

	@Override
	public List<Employee> list() {
		String sql = "SELECT * FROM Employee";
		List<Employee> listEmployee = jdbcTemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee aEmployee = new Employee();
	
				aEmployee.setId(rs.getInt("id"));
				aEmployee.setName(rs.getString("name"));
				aEmployee.setUsername(rs.getString("username"));
				aEmployee.setPassword(rs.getString("password"));
				aEmployee.setEmail(rs.getString("email"));
				
				return aEmployee;
			}
			
		});
		
		return listEmployee;
	}

	@Override
	public Employee get(int employeeId) {
		String sql = "SELECT * FROM Employee WHERE id=" + employeeId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Employee employee = new Employee();
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setUsername(rs.getString("username"));
					employee.setPassword(rs.getString("password"));
					employee.setEmail(rs.getString("email"));
					return employee;
				}
				
				return null;
			}
			
		});
	}
	
	@Override
	public Employee getEmployee(String username, String password) {
		String sql = "SELECT * FROM Employee WHERE username='" + username + "' AND password='" + password + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Employee employee = new Employee();
				
				if (rs.next()) {
					
					
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setUsername(rs.getString("username"));
					employee.setPassword(rs.getString("password"));
					employee.setEmail(rs.getString("email"));
					
					return employee;
					
				}
				
				return new Employee();
			}
			
		});
	}

	@Override
	public boolean validEmployee(String username, String password){
		
		
		Employee checkEmployee = getEmployee(username,password);
		
	
		if(username.equalsIgnoreCase(checkEmployee.getUsername()) && password.equals(checkEmployee.getPassword())) 
			return true;
		
		return false;
			
	//return username.equalsIgnoreCase(checkEmployee.getUsername()) && password.equals(checkEmployee.getPassword());
	}
}
