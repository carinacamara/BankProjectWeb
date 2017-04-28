package net.codejava.spring.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

public class CostumerTest {

	int sizeBefore=0;
	int sizeAfter=0;
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "Bank";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root";
	String password = "root";
	
	@Test
	public void sizeInsertCostumer() {
		
		try{
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName, userName, password );
			Statement st = conn.createStatement();
			
			ResultSet result = st.executeQuery("SELECT COUNT(*) FROM Costumer");
			while(result.next()){
				sizeBefore=result.getInt(1);
			}
			
			st.executeUpdate("INSERT into Costumer VALUES('Alexandru'"+","+"'alexandru@sql.com'"+","+"'Oradea'"+","+"'0726105090'"+")");
		
			ResultSet result2 = st.executeQuery("SELECT COUNT(*) FROM Costumer");
			while(result2.next()){
				sizeAfter=result2.getInt(1);
			}
		
		Assert.assertEquals(sizeBefore+1, sizeAfter);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void sizeModifiCostumer(){
		
		try{
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName, userName, password );
			Statement st = conn.createStatement();
			
			ResultSet result = st.executeQuery("SELECT COUNT(*) FROM Costumer");
			while(result.next()){
				sizeBefore=result.getInt(1);
			}
			
			st.executeUpdate("UPDATE Costumer SET idCostumer = 312, name = 'Alexandru'"
					+ " , email = 'alexandru@sql.com', address = 'Oradea'  WHERE Costumer.name='Alexandru' ");
		
			ResultSet result2 = st.executeQuery("SELECT COUNT(*) FROM Costumer");
			while(result2.next()){
				sizeAfter=result2.getInt(1);
			}
		
		Assert.assertEquals(sizeBefore, sizeAfter);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
@Test
	public void sizeDeleteCostumer() {
		
		try{
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName, userName, password );
			Statement st = conn.createStatement();
			
			ResultSet result = st.executeQuery("SELECT COUNT(*) FROM Costumer");
			while(result.next()){
				sizeBefore=result.getInt(1);
			}
			
			st.executeUpdate("DELETE FROM Costumer WHERE Costumer.idCostumer = 312");
		
			ResultSet result2 = st.executeQuery("SELECT COUNT(*) FROM Costumer");
			while(result2.next()){
				sizeAfter=result2.getInt(1);
			}
		
		Assert.assertEquals(sizeBefore, sizeAfter+1);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
}
}
