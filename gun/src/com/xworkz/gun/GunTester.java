package com.xworkz.gun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GunTester {
	
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
			
			boolean inserted = stmt.execute("insert into gun_details values(3, 'Fiflr', 200000);");
			if(inserted == false) {
				System.out.println("Data inserted");
			} else {
				System.out.println("Data not inserted");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.err.println(e.getMessage());   //prints error in red color
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement stmt = c.createStatement( );
			
			boolean updated = stmt.execute("update gun_details set name = 'Rifle' where id=3;");
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
			
			boolean deleted = stmt.execute("delete from gun_details where id=2;");
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
