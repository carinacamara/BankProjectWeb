package net.codejava.spring.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.model.Employee;
import net.codejava.spring.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO{
	
	
private JdbcTemplate jdbcTemplate;
	
	public TransactionDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	AccountDAO accountDAO;
	
	EmployeeDAO employeeDAO;
	
	
	
	@Override
	public void saveOrUpdate(Transaction transaction) {
		if (transaction.getId() > 0) {
			// update
			String sql = "UPDATE Transaction SET amount=?, type=?, creationDate=?, idEmployee=?, idAccount_from=?, "
						+ "idAccount_to=? WHERE id=?";
			jdbcTemplate.update(sql, transaction.getAmount(), transaction.getType(),
					transaction.getCreationDate(), transaction.getIdEmployee(), transaction.getIdAccountFrom(), transaction.getIdAccountTo(), transaction.getId());
		} else {
			// insert
			String sql = "INSERT INTO Transaction (amount, type, creationDate, idEmployee, idAccount_from, idAccount_to)"
						+ " VALUES (?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, transaction.getAmount(), transaction.getType(),
					transaction.getCreationDate(), transaction.getIdEmployee(), transaction.getIdAccountFrom(), 
					transaction.getIdAccountTo());
			
		String sql2 = "UPDATE Bank.Account SET balance = balance - ? WHERE id = ?";
		jdbcTemplate.update(sql2, transaction.getAmount(), transaction.getIdAccountFrom());
		
		String sql3 = "UPDATE Bank.Account SET balance = balance + ? WHERE id = ?";
		jdbcTemplate.update(sql3, transaction.getAmount(), transaction.getIdAccountTo());
									
	//	Account accountFrom = accountDAO.get(transaction.getIdAccountFrom());
	//	Account accountTo = accountDAO.get(transaction.getIdAccountTo());
	//	if(accountFrom.getBalance() > transaction.getAmount()){
		
	//	accountFrom.setBalance(accountFrom.getBalance() - transaction.getAmount());
			
	//	accountTo.setBalance(accountTo.getBalance() + transaction.getAmount());
		
	//	}

		
		
		}
		
	}


	@Override
	public List<Transaction> list() {
		String sql = "SELECT * FROM Transaction";
		List<Transaction> listTransaction = jdbcTemplate.query(sql, new RowMapper<Transaction>() {

			@Override
			public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
				Transaction aTransaction = new Transaction();
	
				aTransaction.setId(rs.getInt("id"));
				aTransaction.setAmount(rs.getInt("amount"));
				aTransaction.setType(rs.getString("type"));
				aTransaction.setCreationDate(rs.getDate("creationDate"));
				aTransaction.setIdEmployee(rs.getInt("idEmployee"));
				aTransaction.setIdAccountFrom(rs.getInt("idAccount_from"));
				aTransaction.setIdAccountTo(rs.getInt("idAccount_to"));
				
				return aTransaction;
			}
			
		});
		
		return listTransaction;
	}

	
	@Override
	public List<Transaction> getRaport(Date creationDateOne, Date creationDateTwo, int idEmployee){
		
		String sql = "SELECT * FROM Transaction WHERE (creationDate BETWEEN '" + creationDateOne + "' AND '" + creationDateTwo + "') AND idEmployee=" + idEmployee;
		List<Transaction> listTransaction = jdbcTemplate.query(sql, new RowMapper<Transaction>() {

			@Override
			public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
				Transaction aTransaction = new Transaction();
	
				aTransaction.setId(rs.getInt("id"));
				aTransaction.setAmount(rs.getInt("amount"));
				aTransaction.setType(rs.getString("type"));
				aTransaction.setCreationDate(rs.getDate("creationDate"));
				aTransaction.setIdEmployee(rs.getInt("idEmployee"));
				aTransaction.setIdAccountFrom(rs.getInt("idAccount_from"));
				aTransaction.setIdAccountTo(rs.getInt("idAccount_to"));
				
				return aTransaction;
			}
			
		});
		
		return listTransaction;
	}
	
	@Override
	public int setTransactionId(String username, String password){
	
	int idEmployee = 0;
	

	Employee employee = employeeDAO.getEmployee(username, password);
	
	
	idEmployee = employee.getId();
		
		//find the employee with that username and password
		//get his id
		// set the value on idEmployee 
	
	
	
		return idEmployee;
	}
	

}
