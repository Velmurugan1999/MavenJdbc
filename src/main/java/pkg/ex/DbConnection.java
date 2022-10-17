package pkg.ex;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection con;
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
