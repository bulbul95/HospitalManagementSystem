package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.dataaccess.AdminDataaccess;
import com.exam.dataaccess.Dao;
import com.exam.dataaccess.PathologyDataAccess;
import com.exam.dataaccess.PatientDataAccess;
import com.exam.dataaccess.RecieptionDataAccess;
import com.exam.entity.Addpatient;
import com.exam.entity.Covid;
import com.exam.entity.Covidtest;
import com.exam.entity.Department;
import com.exam.entity.Loginadmin;
import com.exam.entity.Loginpathology;


@Controller
public class PathologyController {

	@RequestMapping("/logformpatholy")
	public String log() {

		return "logformpathology";

	}
	
	
	@RequestMapping("/dashbrd")
	public String ddddd() {

		return "covidappointmentspatholgy";

	}
	
	
	
	@RequestMapping("/patholgysms")
	public String chatPathlgySms() {

		return "chatpatholgySMS";

	}
	
	
	
	
	

	@RequestMapping(value = "/loginnpatholyy", method = RequestMethod.POST)
	public String loginpahlogy(@ModelAttribute("Loginpathology") Loginpathology loginpathology, Model m) {

		String log = "";
		Dao dao = new Dao();

		try {
			String st = dao.pathologyLogin(loginpathology.getName(), loginpathology.getPassword());
			if ("Success".equals(st)) {

				log = "covidappointmentspatholgy";

			} else {
				m.addAttribute("alert", "Id is wrong");
				log = "logformpathology";
			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return log;
	}
	
	
	
	
	
	

	@RequestMapping("/showpathologycovid")
	public String covidappointshow(Model m) {
		
		  List<Covid> list; 
		 PathologyDataAccess dao = new PathologyDataAccess();
		  
		  list = dao.doShowpatholgyCovid();
		  
		  m.addAttribute("covidf", list);
		 

		return "covidappointmentspatholgy2";

	}
	
	
	
	 @RequestMapping("/takupCovid")
		public String takeupCovid(@ModelAttribute() Covid covid, Model m) {
		    List<Covid> lis;
			PathologyDataAccess dao = new PathologyDataAccess(); 
			
			lis =dao.ShowAppvdPatholgyCovid(covid);
			m.addAttribute("pcovid", lis);
			return"covidappointmentspatholgyrepost";
		}
		
	
	
	 @RequestMapping("/insertcovidtest")
		public String insertcovidtest(@ModelAttribute() Covidtest Covidtest,Model m) {
		 List<Covidtest> lis;
		 PathologyDataAccess dao = new PathologyDataAccess(); 
		
		dao.doInsertCovidtest(Covidtest);
		m.addAttribute("creport", Covidtest);
		 
			return "covidTestRepot";

		}
	 
	 
	 
	 
	 @RequestMapping("/patgyDepatmnt")
		public String  patgyDepatmnt(Model m) {
        List<Department>lis;
        AdminDataaccess dao = new AdminDataaccess();
		 lis=dao.doShowDepartment();
		 m.addAttribute("deptmnt", lis);
		 
			return "covidPathlgyDepatment";
	
		}
	 
	 
	
	 @RequestMapping("/patgPthology")
		public String  patgyDepatshow(Model m) {
		 
		 List<Department>lis;
		 AdminDataaccess dao = new AdminDataaccess();
		 lis=dao.doShowDepartment();
		
		 
		m.addAttribute("patholyy", lis);
			return "covidPathlgyShow";
		}
	 
		
	

}
