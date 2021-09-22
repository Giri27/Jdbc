package com.xworkz.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudTester {
	
public static void main(String args[]) {
		
		save();
		update();
		deleted();
	}
	
	public static void save() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement stmt = c.createStatement();
			
			boolean inserted = stmt.execute("insert into student values(1, 'Giri', 8989768765), (2, 'Ratna', 7766568976),(3, 'Eshwar', 9807890767), (4, 'Sharan', 7890879876);");
			if(inserted == false) {
				System.out.println("Data inserted");
			} else {
				System.out.println("Data not inserted");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement stmt = c.createStatement( );
			
			boolean updated = stmt.execute("update student set name = 'Raksha' where id=2;");
			if(updated == false) {
				System.out.println("Data updated");
			} else {
				System.out.println("Data not updated");
			}
			
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deleted() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement stmt = c.createStatement( );
			
			boolean deleted = stmt.execute("delete from student where id=4;");
			if(deleted == false) {
				System.out.println("Data deleted");
			} else {
				System.out.println("Data not deleted");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
