package com.xworkz.gundetails.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.xworkz.gundetails.dto.GunDTO;

public class GunDAOImpl implements GunDAO {

	@Override
	public List<GunDTO> getAll() {
		List<GunDTO> list = new ArrayList<GunDTO>();
		try {
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "giri@123");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jdbc", prop);
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from gun_details");
			
			//converting resultset into list bcoz our data is in resultset
			while(rs.next()) {
				
				//creating an object to transfer data from resultset to dto
				GunDTO dto = new GunDTO();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				System.out.println(id +"\t"+ name +"\t" +price);
				
				//setting the data into dto
				dto.setId(id);
				dto.setName(name);
				dto.setPrice(price);
				
				//adding dto to list
				list.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(getClass().getSimpleName());
		}
		return list;
	}
	
	@Override
	public boolean save(GunDTO dto) {
		boolean inserted = false;
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement s = c.createStatement();
			
			inserted = s.execute("insert into gun_details values(7, 'RM', 40000);");
			if(inserted == false) {
				System.out.println("Data inserted into the table gun_details");
			} else {
				System.out.println("Data not inserted");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return inserted;
	}

	@Override
	public List<GunDTO> getByName(String name) {
		List<GunDTO> list = new ArrayList<GunDTO>();
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from gun_details where name = '"+ name +"'");
			while (rs.next()) {
				GunDTO dto = new GunDTO();
				int id = rs.getInt(1);
				String namee = rs.getString(2);
				int price = rs.getInt(3);
				dto.setId(id);
				dto.setName(name);
				dto.setPrice(price);
				list.add(dto);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean updatePriceByName(String name, int price) {
		boolean updated = false;
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement stmt = c.createStatement( );
			
			updated = stmt.execute("update gun_details set name = 'Rifle' where id=4;");
			if(updated == false) {
				System.out.println("Data updated");
			} else {
				System.out.println("Data not updated");
			}
			
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());   
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public GunDTO getByPrice(int price) {
		
		GunDTO dto = new GunDTO();
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from gun_details where price = '"+ price +"'");
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int pricee = rs.getInt(3);
				dto.setId(id);
				dto.setName(name);
				dto.setPrice(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public boolean saveAll(List<GunDTO> list) {
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "giri@123");
			//Transaction method, executing all the queries at a time
			//disabling the auto commit
			c.setAutoCommit(false);
			PreparedStatement ps = c.prepareStatement("insert into gun_details values(?,?,?)");
			for (GunDTO gunDTO : list) {
				ps.setInt(1, gunDTO.getId());
				ps.setString(2, gunDTO.getName());
				ps.setInt(3, gunDTO.getPrice());
				ps.execute();
			}
			c.commit();
			return true;
		} catch (SQLException e) {
			
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				c.commit();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}

	

}
