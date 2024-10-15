package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatement2 {
	
	static String url="jdbc:mysql://localhost:3306/cardb";
	static String user="root";
	static String pass="root";
    static Connection conn;
	static CallableStatement call;
	
	public static void main(String[] args)throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		
		conn=DriverManager.getConnection(url,user,pass);
		System.out.println("Connection Established");
		
		call=conn.prepareCall("{call fetchData()}");
		System.out.println("Statement call");
		System.out.println("Enter price");
		double price=sc.nextDouble();
		call.setDouble(3, price);
		
		ResultSet rs=call.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));
			System.out.println(rs.getString(4));
			System.out.println("-------------------------");
		}
		
		
	}

}
