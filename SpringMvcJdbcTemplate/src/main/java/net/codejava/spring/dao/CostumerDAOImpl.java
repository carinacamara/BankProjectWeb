package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.model.Costumer;

public class CostumerDAOImpl implements CostumerDAO {

private JdbcTemplate jdbcTemplate;
	
	public CostumerDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Costumer costumer) {
		if (costumer.getId() > 0) {
			// update
			String sql = "UPDATE Costumer SET name=?, email=?, address=?, "
						+ "telephone=? WHERE id=?";
			jdbcTemplate.update(sql, costumer.getName(), costumer.getEmail(),
					costumer.getAddress(), costumer.getTelephone(), costumer.getId());
		} else {
			// insert
			String sql = "INSERT INTO Costumer (name, email, address, telephone)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, costumer.getName(), costumer.getEmail(),
					costumer.getAddress(), costumer.getTelephone());
		}
		
	}

	@Override
	public void delete(int costumerId) {
		String sql = "DELETE FROM Costumer WHERE id=?";
		jdbcTemplate.update(sql, costumerId);
	}

	@Override
	public List<Costumer> list() {
		String sql = "SELECT * FROM Costumer";
		List<Costumer> listCostumer = jdbcTemplate.query(sql, new RowMapper<Costumer>() {

			@Override
			public Costumer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Costumer aCostumer = new Costumer();
	
				aCostumer.setId(rs.getInt("id"));
				aCostumer.setName(rs.getString("name"));
				aCostumer.setEmail(rs.getString("email"));
				aCostumer.setAddress(rs.getString("address"));
				aCostumer.setTelephone(rs.getString("telephone"));
				
				return aCostumer;
			}
			
		});
		
		return listCostumer;
	}

	@Override
	public Costumer get(int costumerId) {
		String sql = "SELECT * FROM Costumer WHERE id=" + costumerId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Costumer>() {

			@Override
			public Costumer extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Costumer costumer = new Costumer();
					costumer.setId(rs.getInt("id"));
					costumer.setName(rs.getString("name"));
					costumer.setEmail(rs.getString("email"));
					costumer.setAddress(rs.getString("address"));
					costumer.setTelephone(rs.getString("telephone"));
					return costumer;
				}
				
				return null;
			}
			
		});
	}

}
