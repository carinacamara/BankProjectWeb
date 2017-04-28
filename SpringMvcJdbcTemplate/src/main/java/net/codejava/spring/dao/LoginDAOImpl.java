package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import net.codejava.spring.model.Login;

public class LoginDAOImpl implements LoginDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public LoginDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addEntry(Login login) {
		String sql = "INSERT INTO Login (username, password)"
				+ " VALUES (?, ?)";
	jdbcTemplate.update(sql, login.getUsername(), login.getPassword());
}
	
	@Override
	public Login getLast(){
		String sql = "SELECT * FROM Login ORDER BY ID DESC LIMIT 1";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Login>() {

			@Override
			public Login extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Login login = new Login();
					login.setId(rs.getInt("id"));
					login.setUsername(rs.getString("username"));
					login.setPassword(rs.getString("password"));
				
					return login;
				}
				
				return new Login();
			}
			
		});
	}
	
	@Override
	public void delete() {
		String sql = "DELETE FROM Login";
		jdbcTemplate.execute(sql);
	}

}
