package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class ProductInsert {

	public static void main(String[] args)throws Exception{
		//Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Estatblish Connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root", "root");
		
		//Create Statement
		Statement statement=connection.createStatement();
		
		//Execute Statement
		int result=statement.executeUpdate("INSERT INTO PRODUCT VALUES(16,'MI',13000,'LATUR',500)");
		
		if(result!=0)
		{
			System.out.println("Data Inserted");
		}
		else
		{
			System.out.println("Data not inserted");
		}
		
		connection.close();

	}

}
