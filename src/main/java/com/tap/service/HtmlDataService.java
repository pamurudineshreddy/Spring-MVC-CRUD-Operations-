package com.tap.service;

import org.springframework.stereotype.Component;

@Component
public class HtmlDataService {
	
	
	
	public HtmlDataService() {
		System.out.println("htmldata obj created");
	}

	public boolean validatedata(String name, String state, String city, String address,
			int totalfloors, int totalshops, int totalstaff) {
		
		boolean isvalid = false;;
		
		if(!(name==null || name.isBlank() || name.isEmpty() || name == "")) {
			isvalid = true;
			
		}else {
			return false;
		}
		if(!(state==null || state.isBlank() || state.isEmpty() || state == "")) {
			isvalid = true;
			
		}else {
			return false;
		}
		if(!(city==null || city.isBlank() || city.isEmpty() || city == "")) {
			isvalid = true;
			
		}else {
			return false;
		}
		if(!(address==null || address.isBlank() || address.isEmpty() || address == "")) {
			isvalid = true;
			
		}else {
			return false;
		}
		if(!(totalfloors<0 )) {
			isvalid = true;
			
		}else {
			return false;
		}
		if(!(totalshops<0 )) {
			isvalid = true;
			
		}else {
			return false;
		}
		if(!(totalstaff<0 )) {
			isvalid = true;
			
		}else {
			return false;
		}
		
		
		
		return isvalid;
	}

	public static boolean validateId(int id) {
		if(id<0 || id==0) {
			return false;
			
		}
		else  {
			return true;
			
		}
	}

	public static boolean validateName(String name) {
		
		System.out.println("validate validateName");
		
		if(name==null && name.isBlank() && name.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
		
	}

}
