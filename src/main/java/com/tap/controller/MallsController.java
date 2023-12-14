package com.tap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tap.entity.MallsEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.dao.*;
import com.tap.service.*;
@Controller
public class MallsController {
	
	@Autowired
	MallsDAO mallsDAOImpl;
	public MallsController() {
		System.out.println("controller obj created");
	}
	@RequestMapping(value="/insertionmallsdata")
	public String insertMallData(@RequestParam String name,@RequestParam String state,
			@RequestParam String city,@RequestParam String address,@RequestParam int totalfloors,
			@RequestParam int totalshops,@RequestParam int totalstaff ,Model model) {
		System.out.println(name);
		System.out.println(state);
		System.out.println(city);
		System.out.println(address);
		System.out.println(totalfloors);
		System.out.println(totalshops);
		System.out.println(totalstaff);
		MallsEntity mallsEntity = new MallsEntity(name, state, city, address, totalfloors, totalshops, totalstaff);
		
		boolean insertData = mallsDAOImpl.insertData(mallsEntity);
		
		if (insertData) {
			model.addAttribute("message", "saved");
			return "/index.jsp";
			
		} else {
			model.addAttribute("message", " not saved");
			return "/index.jsp";
			

		}
	}
	
	@RequestMapping(value="/getDatabyId")
	public String dataByID(@RequestParam int id , Model model) {
		
		System.out.println(id);
		boolean validateId = HtmlDataService.validateId(id);
		if(validateId) {
			MallsEntity entity = mallsDAOImpl.searchId(id);
			if(entity!=null) {
				model.addAttribute("idData",entity);

				
			}
			else {
				model.addAttribute("message","data with "+id+" doesn't exist");
				
			}
			
		}
		else {
			model.addAttribute("message", "id cant be 0 or negative");
			
		}
		return "/index.jsp";
	

	}
	
	
	
	@RequestMapping(value="/getDatabyName")
	public String getDataByName(@RequestParam String name,Model model) {
		System.out.println(name);
		
		boolean validateName = HtmlDataService.validateName(name);
		
		if(validateName) {
			 MallsEntity entityByName = mallsDAOImpl.searchByName(name);
			if(entityByName!=null  ) {
				model.addAttribute("response1", entityByName.getId());
				model.addAttribute("response2", entityByName.getMallname());
				model.addAttribute("response3", entityByName.getState());
				model.addAttribute("response4", entityByName.getCity());
				model.addAttribute("response5", entityByName.getAddress());
				model.addAttribute("response6", entityByName.getTotalfloors());
				model.addAttribute("response7", entityByName.getTotalshops());
				model.addAttribute("response8", entityByName.getTotalstaff());
			}else {
				model.addAttribute("message", "entity with name"+name+"doesn't exist");
			}
			
			
		}
		else {
			model.addAttribute("message", "name cant be null or empty");
			
		}
		return "/index.jsp";
		
		

	}
	@RequestMapping(value="/getDatabyCity")
	public String getDataByCity(@RequestParam String name,Model model) {
		System.out.println(name);
		
		boolean validateName = HtmlDataService.validateName(name);
		
		if(validateName) {
			 List<MallsEntity> searchByCity = mallsDAOImpl.searchByCity(name);
			if(searchByCity!=null  ) {
				model.addAttribute("citydata",searchByCity);
			}
			else {
				model.addAttribute("message", "entity with name"+name+"doesn't exist");
				
			}
			
			
		}
		else {
			model.addAttribute("message", "name cant be null or empty");
			
		}
		return "/index.jsp";
		
		

	}

	@RequestMapping(value="/gellalldata")
	public String method(Model model) {
		
		List<MallsEntity> tableData = mallsDAOImpl.getTableData();
		if(tableData!=null) {
			model.addAttribute("data", tableData);
			
		}else {
			model.addAttribute("nodata", "No data available");
			
		}
		
		return "/index.jsp";
		

	}
	
	@RequestMapping(value = "/updateData/{id}")
	public  String updateData(@PathVariable int id, Model model ) {
		System.out.println(id);
		
		MallsEntity entity = mallsDAOImpl.searchId(id);
		
		model.addAttribute("id", entity.getId());
		model.addAttribute("mallname", entity.getMallname());
		model.addAttribute("state", entity.getState());
		model.addAttribute("city", entity.getCity());
		model.addAttribute("address", entity.getAddress());
		model.addAttribute("totalfloors", entity.getTotalfloors());
		model.addAttribute("totalshops", entity.getTotalshops());
		model.addAttribute("totalstaff", entity.getTotalstaff());
		
		
		
		return "/WEB-INF/UpdateData.jsp";

	}
	
	@RequestMapping(value="/updatedatabyid" ,method = RequestMethod.POST)
	public String updateDataById(@RequestParam String name,@RequestParam String state,
			@RequestParam String city,@RequestParam String address,@RequestParam int totalfloors,
			@RequestParam int totalshops,@RequestParam int totalstaff ,Model model,@RequestParam int id ) {
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(state);
		System.out.println(city);
		System.out.println(address);
		System.out.println(totalfloors);
		System.out.println(totalfloors);
		System.out.println(totalstaff);
		
		boolean updateEntity = mallsDAOImpl.updateEntity(id, name, state, city, address, totalfloors, totalshops, totalstaff);
		
		if(updateEntity) {
			model.addAttribute("updateentity", "updated successfully");
		}else  {
			model.addAttribute("updateentity", " not updated successfully");
			
		}
		  
		
		return "/WEB-INF/index.jsp";
	}
	
	int deletedid;
	@RequestMapping(value="/deleteData/{id}")
	public String deleteData(@PathVariable int id, Model model) {
		
		System.out.println(id);
		deletedid = id;
		
		
		boolean deleteDataById = mallsDAOImpl.deleteDataById(id);
		
		if(deleteDataById) {
			model.addAttribute("deleteid", "successfully  data with "+deletedid+" "+" deleted");
			
		}
		return "/index.jsp";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
