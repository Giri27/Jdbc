package com.xworkz.gundetails;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.gundetails.dao.GunDAO;
import com.xworkz.gundetails.dao.GunDAOImpl;
import com.xworkz.gundetails.dto.GunDTO;

public class Tester {
	
	public static void main(String[] args) {
		
		GunDAO dao = new GunDAOImpl();
				
		List<GunDTO> list = dao.getAll();
		System.out.println("List elements");
		for (GunDTO gunDTO : list) {
			System.out.println(gunDTO);
		}
		
		//dao.save(dto);
		
		List<GunDTO> list1 = dao.getByName("AK47");
		System.out.println("Get by name");
		System.out.println(list1);
		
		//dao.updatePriceByName("Rifle", 300000);
		
		GunDTO dto = dao.getByPrice(400000);
		System.out.println("Get by price");
		System.out.println(dto);
		
		GunDTO dto1 = new GunDTO(8, "kk", 25000);
		GunDTO dto2 = new GunDTO(9, "AWM", 500000);
		GunDTO dto3 = new GunDTO(10, "ZK", 50000);
		List<GunDTO> list2 = new ArrayList<GunDTO>();
		list2.add(dto1);
		list2.add(dto2);
		list2.add(dto3);
		
		boolean saved = dao.saveAll(list2);
		if(saved) {
			System.out.println("data saved");
		} else {
			System.out.println("Not saved");
		}
	}
}
