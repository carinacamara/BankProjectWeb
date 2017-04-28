package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import net.codejava.spring.model.Manager;

public class ManagerDAOImpl implements ManagerDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public ManagerDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Manager getManager(String username, String password) {
		String sql = "SELECT * FROM Manager WHERE username='" + username + "' AND password='" + password + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Manager>() {

			@Override
			public Manager extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Manager manager = new Manager();
					manager.setId(rs.getInt("id"));
					manager.setUsername(rs.getString("username"));
					manager.setPassword(rs.getString("password"));
					return manager;
				}
				
				return null;
			}
			
		});
	}

	@Override
	public boolean validManager(String username, String password){
		
/*		Manager checkManager = getManager("root","root");
		
		if(checkManager.equals(null)) 
			return false;
	
		if(username.equalsIgnoreCase(checkManager.getUsername()) && password.equals(checkManager.getPassword())) 
			return true;
		
		return false;
		*/
		return username.equalsIgnoreCase("root") && password.equals("root");
	}

}
