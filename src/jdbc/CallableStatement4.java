package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatement4 {
		public static void main(String[] args) throws SQLException {
			Scanner sc=new Scanner(System.in);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cardb","root","root");
			
			CallableStatement call=conn.prepareCall("{call getcar(?,?)}");
			call.setString(1,"punch");
			
			int rs=call.executeUpdate();
			System.out.println(rs);
			System.out.println(call.getDouble(3));
			
			call.close();
			conn.close();
		}
		
		
}

