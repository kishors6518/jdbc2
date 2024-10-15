package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeFetch {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//Load the Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Establish Connection 
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		
		//3.Create Statement
		Statement statement=connection.createStatement();
		
		//4.Execute Statement
		ResultSet set=statement.executeQuery("SELECT * FROM EMPLOYEE");
		
		System.out.println("ID    Name        PhoneNo      Salary      Address ");
		System.out.println("==================================================");
//		while (set.next()) {
//			
//			System.out.println(set.getInt("id"));
//			System.out.println(set.getString("Name"));
//			System.out.println(set.getLong("Phno"));
//			System.out.println(set.getDouble("Salary"));
//			System.out.println(set.getString("Address"));
//			System.out.println("=============================");
//		}
		while(set.next())
		{
			System.out.println(set.getInt("id")+"    "+set.getString("Name")+"      "+set.getLong("Phno")+"    "+set.getDouble("Salary")+"    "+set.getString("Address"));
		}
		
		connection.close();
		

	}

}
