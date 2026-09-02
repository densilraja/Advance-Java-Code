package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "densil@raja");
		
		System.out.println("jdbc connected");
		
//		Statement st = con.createStatement();
		
//		st.execute("create table demo (id int primary key, name varchar(20));");
		
//		System.out.println("Table created");
		
//		st.execute("insert into demo values (1, 'densil');");
//				+ "insert into demo values (2, 'raja');");
		
		PreparedStatement st = con.prepareStatement();
		System.out.println("value inserted");
	}

}
