package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDelete {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		//1. Load the Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//2. Establish Connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
				
				//3.Create Statement
				Statement statement=connection.createStatement();
				
				//4. Execute Statement
				int result=statement.executeUpdate("DELETE FROM EMPLOYEE  WHERE ID=6");
				if(result!=0)
				{
					System.out.println("Data Deleted");
				}
				else
				{
					System.out.println("Data not delete");
				}

	}

}
