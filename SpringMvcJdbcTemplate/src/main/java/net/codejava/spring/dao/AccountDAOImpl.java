package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.model.Account;

public class AccountDAOImpl implements AccountDAO{
	
private JdbcTemplate jdbcTemplate;
	
	public AccountDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Account account) {
		if (account.getId() > 0) {
			// update
			String sql = "UPDATE Account SET balance=?, creationDate=?, type=?, idCostumer=?"
						+ " WHERE id=?";
			jdbcTemplate.update(sql, account.getBalance(), account.getCreationDate(),
					account.getType(), account.getIdCostumer() ,account.getId());
		} else {
			// insert
			String sql = "INSERT INTO Account (balance, creationDate, type, idCostumer)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, account.getBalance(), account.getCreationDate(),
					account.getType(), account.getIdCostumer());
		}
		
	}

	@Override
	public void delete(int accountId) {
		String sql = "DELETE FROM Account WHERE id=?";
		jdbcTemplate.update(sql, accountId);
	}

	@Override
	public List<Account> list() {
		String sql = "SELECT * FROM Account";
		List<Account> listAccount = jdbcTemplate.query(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account aAccount = new Account();
	
				aAccount.setId(rs.getInt("id"));
				aAccount.setBalance(rs.getInt("balance"));
				aAccount.setCreationDate(rs.getDate("creationDate"));
				aAccount.setType(rs.getString("type"));
				aAccount.setIdCostumer(rs.getInt("idCostumer"));
				
				return aAccount;
			}
			
		});
		
		return listAccount;
	}

	@Override
	public Account get(int accountId) {
		String sql = "SELECT * FROM Account WHERE id=" + accountId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Account>() {

			@Override
			public Account extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Account account = new Account();
					account.setId(rs.getInt("id"));
					account.setBalance(rs.getInt("balance"));
					account.setCreationDate(rs.getDate("creationDate"));
					account.setType(rs.getString("type"));
					account.setIdCostumer(rs.getInt("idCostumer"));

					return account;
				}
				
				return null;
			}
			
		});
	}

}
