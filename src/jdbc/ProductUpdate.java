package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProductUpdate {

	public static void main(String[] args)throws Exception {
		//1. Load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Establish Connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root");
		
		//3.Create Statement
		Statement statement=connection.createStatement();
		
		//4. Execute Statement
		int result=statement.executeUpdate("UPDATE PRODUCT SET NAME='Apple', PRICE=45000, MANUFACTURE='CHENNAI',QUANTITY=10 WHERE ID=11");
		if(result!=0)
		{
			System.out.println("Data Updated");
		}
		else
		{
			System.out.println("Data not update");
		}

		connection.close();
	}

}
