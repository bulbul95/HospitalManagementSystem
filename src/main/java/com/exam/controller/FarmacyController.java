package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.dataaccess.Dao;
import com.exam.dataaccess.FarmacyDataAccess;
import com.exam.entity.Addmedicine;
import com.exam.entity.Covid;
import com.exam.entity.Loginfarmacy;




@Controller
public class FarmacyController {
	
	  @RequestMapping(value="/loginfarmacy", method = RequestMethod.POST)
	  public String logfarmacy() {
		  
		  
		return "logformpharmcy";
		
	}
	  
	  
	  
	  @RequestMapping(value = "/loginpharmacy", method = RequestMethod.POST)
			public String loginfarmcy(@ModelAttribute() Loginfarmacy lgin, Model m) {
		    FarmacyDataAccess dao = new FarmacyDataAccess();
				
				if (dao.loginpharmacy(lgin) == 1) {
				
					return "pharmacyDashboard";

				} else {
					return "logformpharmcy";
				}

			}
	  
	 
	
		
	  
	  

		  
	
	
	

}
