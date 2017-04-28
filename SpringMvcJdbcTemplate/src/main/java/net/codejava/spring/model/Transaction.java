package net.codejava.spring.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import net.codejava.spring.dao.EmployeeDAO;




//@Entity
//@Table(name = "Transaction")
public class Transaction {
	
	//@Id
//	@GeneratedValue
	private int id;
	
	private int amount;
	
	private String type;
	
	@Column(name="creationDate", nullable = false)
	private Date creationDate;
	
//	@Column(name = "idEmployee")
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Bank.Account.id")
//	@Min(value = 1, message = "Please login first")
	private int idEmployee;
	
//	@Column(name = "idAccountFrom")
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Bank.Account.id")
//	@Min(value = 1, message = "Please enter ID")
	private int idAccountFrom;
	
//	@Column(name = "idAccount_to")
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Bank.Account.id")
//	@Min(value = 1, message = "Please enter ID")
	private int idAccountTo;
	
	
	private Date currentDate;
	
	public Transaction(){}
	
	public Transaction(int amount, String type, Date creationDate, int idEmployee, int idAccountFrom, int idAccountTo) {
		this.amount = amount;
		this.type = type;
		this.creationDate = creationDate;
		this.idEmployee = idEmployee;
		this.idAccountFrom = idAccountFrom;
		this.idAccountTo = idAccountTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getIdEmployee() {
		return idEmployee;
	}



	public void setIdEmployee(int idEmployee){
		this.idEmployee=idEmployee;
	}

	public int getIdAccountFrom() {
		return idAccountFrom;
	}

	public void setIdAccountFrom(int idAccountFrom) {
		this.idAccountFrom = idAccountFrom;
	}

	public int getIdAccountTo() {
		return idAccountTo;
	}

	public void setIdAccountTo(int idAccountTo) {
		this.idAccountTo = idAccountTo;
	}
	
	public Date getCurrentDate(){
		return currentDate;
	}

	public void setCurrentDate(){
		
		Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		this.currentDate=currentDate;
	}
}
