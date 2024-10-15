package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {

	public static void main(String[] args)throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		//1. Load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Establish Connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		
		//3.Create Statement
		Statement statement=connection.createStatement();
		
		//4. Execute Statement
		int result=statement.executeUpdate("INSERT INTO EMPLOYEE VALUES(5,'ANUJ',8888774543,90000,'KARVE NAGAR'),(6,'NILESH',7658795462,300000,'LAMJANA'),"
											+"(7,'SURAJ',8956879643,100000,'ASHTI')");
		
		if(result!=0)
		{
			System.out.println("Data inserted");
		}
		else
		{
			System.out.println("Data not inserted");
		}
		
		//5. Close connection
		connection.close();

	}

}
