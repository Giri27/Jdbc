package com.xworkz.mobile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MobileTester {
	
	public static void main(String[] args) {
		
		save();
		update();
		delete();
	}

	private static void save() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement s = c.createStatement();
			
			boolean inserted = s.execute("insert into mobile_details values(1, 'Oneplus6T', 38000),(2, 'Samsungf62','23000'),(3, 'AsusRog2', '35000'),(4, 'Nokia8.1', '18000');");
			if(inserted == false) {
				System.out.println("Data inserted");
			} else {
				System.out.println("Data not inserted");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void update() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement s = c.createStatement();
			
			boolean updated = s.execute("update mobile_details set name='IphoneSe2020' where price=35000;");
			if(updated == false) {
				System.out.println("Data updated");
			} else {
				System.out.println("Data not updated");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
	
	private static void delete() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement s = c.createStatement();
			
			boolean deleted = s.execute("delete from mobile_details where id=4;");
			if(deleted == false) {
				System.out.println("Data deleted");
			} else {
				System.out.println("Data not deleted");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
