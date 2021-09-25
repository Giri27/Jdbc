package com.xworkz.gundetails.dao;

import java.util.List;

import com.xworkz.gundetails.dto.GunDTO;

public interface GunDAO {
	
	List<GunDTO> getAll();
	
	boolean save(GunDTO dto);
	
	List<GunDTO> getByName(String name);
	
	boolean updatePriceByName(String name, int price);
	
	GunDTO getByPrice(int price);
	
	boolean saveAll(List<GunDTO> list);
	

}
