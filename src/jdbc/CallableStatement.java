package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatement {
	
	static String url = "jdbc:mysql://localhost:3306/cardb";
	static String user = "root";
	static String pass = "root";
	static Connection conn;
	static java.sql.CallableStatement call;
	
	public static void main(String[] args) {
		
		try {
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("Connection Established..");
		}
		catch(SQLException sql) {
			System.out.println("Issue in connecting DB..!");
		}
		
		try {
			call = conn.prepareCall("{call carDetails()}");
			System.out.println("call done");
		}catch(SQLException e) {
			System.out.println("Issue in calling the Stored procedure..!");
		}
		ResultSet rs = null;
		try {
			rs = call.executeQuery();
			System.out.println("Query Executed..");
		}
		catch(SQLException e) {
			System.out.println("issue in executing query..!");
		}
		
		if(rs!=null) {
			try {
				while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
				System.out.println(rs.getString(4));
				System.out.println("-------------------------");
				}
			} catch (SQLException e) {
				System.out.println("not result..");
			}
		}
		
		
	}

}
