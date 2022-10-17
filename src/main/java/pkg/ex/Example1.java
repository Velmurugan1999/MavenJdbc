package pkg.ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.custom.printer.*;


public class Example1 {

	public static void main(String[] args) {
		Connection con = DbConnection.getConnection();
		System.out.println("All Employee details ==>");
		System.err.println("Eid  ||   Name  || Age  ||Department || Salary || Company Name");
		try {
			Statement smt=con.createStatement();
			ResultSet rs;
			rs = smt.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + " || " + rs.getString(2) + " || " + rs.getInt(3) + " || "
						+ rs.getString(4) + " || " + rs.getLong(5) + " || " + rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n\nEmployee details Ordered by Salary==>");
		try {
			Statement smt=con.createStatement();
			ResultSet rs;
			rs = smt.executeQuery("select * from employee order by salary");
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + " || " + rs.getString(2) + " || " + rs.getInt(3) +  " || " + rs.getLong(5)) ;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n\nEmployee details Ordered by Name==>");
		try {
			Statement smt=con.createStatement();
			ResultSet rs;
			rs = smt.executeQuery("select * from employee order by ename");
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + " || " + rs.getString(2) + " || " + rs.getInt(3) +  " || " + rs.getLong(5)) ;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n\nEmployee details salary greater then 50000==>");
		try {
			Statement smt=con.createStatement();
			ResultSet rs;
			rs = smt.executeQuery("select * from employee where salary>50000");
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + " || " + rs.getString(2) + " || " + rs.getInt(3) +  " || " + rs.getLong(5)) ;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\nSecond Largest Salary=>");
		try {
			Statement smt=con.createStatement();
			ResultSet rs;
			rs = smt.executeQuery("SELECT * from employee WHERE salary<(SELECT max(salary) from employee) order by salary DESC LIMIT 1;");
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + " || " + rs.getString(2) + " || " + rs.getInt(3) +  " || " + rs.getLong(5)) ;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.err.println("====================================================");
	}


}
