package com.tap.entity;

import javax.persistence.Column;
 import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Shoppingmalls")
public class MallsEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name="mallname")
	private String mallname;
	
	
	@Column(name="state")
	private String state;
	
	
	@Column(name="city")
	private String city;
	
	
	@Column(name="address")
	private String address;
	
	@Column(name="totalfloors")
	private int totalfloors;
	
	@Column(name="totalshops")
	private int totalshops;

	@Column(name="totalstaff")
	private int totalstaff;

	public MallsEntity() {
		
		System.out.println("malls Entity created");
	}
	

	public MallsEntity(int id, String mallname, String state, String city, String address, int totalfloors,
			int totalshops, int totalstaff) {
		
		this.id = id;
		this.mallname = mallname;
		this.state = state;
		this.city = city;
		this.address = address;
		this.totalfloors = totalfloors;
		this.totalshops = totalshops;
		this.totalstaff = totalstaff;
	}


	public MallsEntity( String mallname, String state, String city, String address, int totalfloors,
			int totalshops, int totalstaff) {
		this.mallname = mallname;
		this.state = state;
		this.city = city;
		this.address = address;
		this.totalfloors = totalfloors;
		this.totalshops = totalshops;
		this.totalstaff = totalstaff;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMallname() {
		return mallname;
	}

	public void setMallname(String mallname) {
		this.mallname = mallname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalfloors() {
		return totalfloors;
	}

	public void setTotalfloors(int totalfloors) {
		this.totalfloors = totalfloors;
	}

	public int getTotalshops() {
		return totalshops;
	}

	public void setTotalshops(int totalshops) {
		this.totalshops = totalshops;
	}

	public int getTotalstaff() {
		return totalstaff;
	}

	public void setTotalstaff(int totalstaff) {
		this.totalstaff = totalstaff;
	}
	
	
	
	


}