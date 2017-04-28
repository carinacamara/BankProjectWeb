package net.codejava.spring.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//@Entity
//@Table(name= "Account")
public class Account {
	
//	@Id
//	@GeneratedValue
	private int id;
	
//	@Column(name="balance")
//	@Min(value = 1, message = "Let's put some money there")
	private int balance;
	
//	@Size(min=11, max=11, message = "Please use the format YYYY-MM-DD")
//	@Pattern(regexp = "[0-9]+[0-9]+[0-9]+[0-9]-{[0]+[0-9]|[1]+[0-2]}-{[0-2]+[0-9]|[3]+[0-1]}", message = "Please use the format YYYY-MM-DD")
//	@Column(name="creationDate")
	private Date creationDate;
	
//	@Column(name = "type")
	private String type;
	
	// cheie straina de la tabelul costumer la coloana id
//	@Column(name = "idCostumer")
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Bank.Costumer.id")
//	@Min(value = 1, message = "Please enter ID")
	private int idCostumer;
	
	private Date currentDate;
	
	public Account(){}

	public Account(int balance, Date creationDate, String type, int idCostumer) {
		this.balance = balance;
		this.creationDate = creationDate;
		this.type = type;
		this.idCostumer=idCostumer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIdCostumer() {
		return idCostumer;
	}

	public void setIdCostumer(int idCostumer) {
		this.idCostumer = idCostumer;
	}


	public void setCurrentDate(){
		
		Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		this.currentDate=currentDate;
	}
	
	public Date getCurrentDate(){
		return currentDate;
	}

}
