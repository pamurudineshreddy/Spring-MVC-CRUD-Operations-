package com.tap.dao;

import java.util.List;

import com.tap.entity.MallsEntity;

public interface MallsDAO {
	
	
	public boolean insertData(MallsEntity entity);
	public MallsEntity searchId(int id);
	public MallsEntity searchByName(String name);
	public List<MallsEntity> getTableData();
	public boolean deleteDataById(int id);
	public List<MallsEntity> searchByCity(String name);
	public boolean updateEntity(int id, String name, String state, String city, String address, int totalfloors,
			int totalshops, int totalstaff);
	

}
