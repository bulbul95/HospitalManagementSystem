package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.dataaccess.AdminDataaccess;
import com.exam.dataaccess.Dao;
import com.exam.dataaccess.RecieptionDataAccess;
import com.exam.entity.Adddoctor;
import com.exam.entity.Addpatient;
import com.exam.entity.Covid;
import com.exam.entity.Department;
import com.exam.entity.Invoice;
import com.exam.entity.Loginadmin;
import com.exam.repository.AddDoctorRepository;
import com.exam.repository.AppoinmentRepository;
import com.exam.entity.Appoinment;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class AdminDashboardControler {
	@Autowired
	AddDoctorRepository addDocRep;
	AppoinmentRepository apoinmtRep;
	@RequestMapping("/logformadmin")
	public String logformadmin() {

		return "logformAdmin";
	}

	@RequestMapping("/logoutadmin")
	public String logoutadmin() {

		return "userrole";

	}

	
	@RequestMapping("/admindashord")
	public String admindashord() {

		return "admindashboard";
		
		

	}
	
	                              /* Appoinment Part */
	
	
	
	@RequestMapping("/adminaddapnmnt")
	public String adminaddapnmnt() {

		return "admin-add-appointment";
		
		

	}
	
	
	
	
	
	
	
	
	
	                             /* Department part */
	
	
	
	@RequestMapping("/admindepartments")
	public String 	admindepartment(@ModelAttribute() Department department, Model m) {
		  List<Department> lis;
		  AdminDataaccess dao =  new AdminDataaccess();
          lis=dao.doShowDepartment();
          m.addAttribute("deprtmnt",lis);
        
		return "admindepartments";

	}
	
	@RequestMapping("/adminadddepartment")
	public String 	adminadddepartmen(Model m) {
		AdminDataaccess dao = new AdminDataaccess();
    int x =dao.getappoinmentID();
    m.addAttribute("id", x);
		return "admin-add-department";

	}
	
	
	

	@RequestMapping("/inserdepartmnt")
	public String inserdepartmnt(@ModelAttribute() Department department, Model m) {
		 List<Department> lis;
		 AdminDataaccess dao = new AdminDataaccess();
		dao.doInsertappnment(department);
		lis=dao.doShowDepartment();
        m.addAttribute("deprtmnt",lis);
		return "admindepartments2";

	}
	
	
	
	/*
	 * @RequestMapping("/") public String showalldoctor(@ModelAttribute() Adddoctor
	 * adddoctor, Model m) { List<Adddoctor> lis; Dao dao = new Dao(); lis
	 * =dao.doShowdoctor(); m.addAttribute("alldoctor", lis);
	 * 
	 * 
	 * return "viewalldoctor";
	 * 
	 * }
	 */
	
	
	
	                               /* End Department part */
	
	
	
	
	
	
									/* Covid part */
	
	
	
	
	
	

	@RequestMapping("/admindoctorprofile")
	public String admindoctorprofile(Model m) {

		    List<Adddoctor> lis;
			Dao dao = new Dao();
			lis =dao.doShowdoctor();
			m.addAttribute("doctorprofile", lis);
		
		return "admindoctorprofile";

	}
	
	
	
	
	
	

	@RequestMapping("/ChatAdmin")
	public String ChatAdmin() {
		
		return "AdminChat";

	}
	
	
	
	
	
	
	

	@RequestMapping("/adddoctrbtn")
	public String adddoctorbtn(Model m) {
		Dao dao = new Dao();
		int id=dao.getdoctorID()+1;
        m.addAttribute("id", id);
		return "add-doctor";
	}
	
	


	@RequestMapping("/admindoctorshow")
	public String showalldoctor(@ModelAttribute() Adddoctor adddoctor, Model m) {
	    List<Adddoctor> lis;
		Dao dao = new Dao();
		lis =dao.doShowdoctor();
		m.addAttribute("alldoctor", lis);
		
		
		return "viewalldoctor";

	}
	

	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/loginadmin", method = RequestMethod.POST)
	public String finstudent(Model md, @ModelAttribute("Loginadmin") Loginadmin loginadmin, Model m) {
		String log = "";
		Dao dao = new Dao();
		try {
			String st = dao.adminLogin(loginadmin.getName(), loginadmin.getPassword());
			if ("Success".equals(st)) {
				 RecieptionDataAccess daoo = new RecieptionDataAccess();
					Dao da=new Dao();
				 

				  List<Adddoctor> lis;
				  List<Appoinment> list;
				  List<Invoice> listt;
				  List<Addpatient> listtt;
				  List<Appoinment> ap;
				  
				  
				  
				  
				  lis =da.doShowdoctor();
				  m.addAttribute("doc", lis);
				  
				  
				  list=daoo.doShowAppnment();
				  m.addAttribute("ap", list);
				  
				  listtt=daoo.Showpatint();
				  m.addAttribute("paa", listtt);
				  
				  listt=daoo.ShowInvoice();
				  m.addAttribute("in", listt);
				  
				  
				  ap=daoo.doShowAppnment();
				  m.addAttribute("apnmt", ap);
				 

				log = "admindashboard";
				m.addAttribute("admin", loginadmin.getName());
			} else {
				md.addAttribute("alert", "Id is wrong");
				log = "logformAdmin";
			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return log;
	}
	
	
	
	
	@RequestMapping("/monthlyincome")
	public String 	monthlyincome(@ModelAttribute() Invoice invoice, Model m) {
	  RecieptionDataAccess dao = new RecieptionDataAccess();
	  List<Invoice>lis;
	  lis=dao.ShowInvoice();
	 
	  m.addAttribute("in", lis);
	  
	  
	  
	  
		
		return "MonthlyIncomeReportFinal";

	}	
	
	

	  @RequestMapping("/admininvoicc")
			public String admininvoicc(Model m) {

				    List<Addpatient> lis;
					RecieptionDataAccess dao = new RecieptionDataAccess();
					lis =dao.Showpatint();
					m.addAttribute("psnt", lis);
				
				return "AdminInvoiceCreate";

			}
	
	
	  
	
	  @RequestMapping("/admincreateInvoice")
		public String createInvoice(@ModelAttribute() Addpatient addpatient, Model m) {
			RecieptionDataAccess dao = new RecieptionDataAccess();
	
			  List<Addpatient> lis;
			  lis =dao.Showpatintofinvoic(addpatient);
			  int x = dao.getinvoiceID();
				m.addAttribute("psnt", lis);
				m.addAttribute("id",x+1);
				return"Admin-create-invoice";
		
		}
	
	
	
	
	  
	  @RequestMapping("/admininserInvoice")
		public String inserInvoice(@ModelAttribute() Invoice invoice, Model m) {
		
			RecieptionDataAccess dao = new RecieptionDataAccess();
			dao.doInsertInvoice(invoice);
			m.addAttribute("inv", invoice);
			
			
			return "admin-invoice-view";

		}
	
	
	
	
	
	  @RequestMapping("/admininviceView")
		public String inviceView( Model m) {
			RecieptionDataAccess dao = new RecieptionDataAccess();
			 List<Invoice> lis;
			lis=dao.ShowInvoice();
			m.addAttribute("inv", lis);
			 
				return"adminInvoicView";
		
		}
	  
	
	
	  
	  
	  @RequestMapping("/admindeleteInvoie")
		public String deleteInvoie(@ModelAttribute() Invoice invoice, Model m) {
			RecieptionDataAccess dao = new RecieptionDataAccess();
	           dao.doDeleteInvoice(invoice);
	           List<Invoice> lis;
				lis=dao.ShowInvoice();
				m.addAttribute("inv", lis);
		
				return"adminInvoicView";
		
		}
	  
	
	  
	  @RequestMapping("/adminupdatefInvoice")
			public String updatefInvoice(@ModelAttribute() Invoice invoice, Model m) {
			
				m.addAttribute("p",invoice);
				
				return"admin-update-invoice";
			}  
	  
	  
	  
	  
	  
	  

	  @RequestMapping("/adminupdateInvoice")
		public String updateInvoice(@ModelAttribute() Invoice invoice, Model m) {
			RecieptionDataAccess dao = new RecieptionDataAccess();
			dao.doUpdatInvic(invoice);
			  List<Invoice> lis;
			  lis =dao.ShowInvoice();
				m.addAttribute("inv", lis);
				return"adminInvoicView";
		
		}
	  
	  
	  
	  
	  
	  @RequestMapping("/deletDoctor")
			public String deletDoctor(@ModelAttribute()Adddoctor adddoctor,Model m) {
				
//		  AdminDataaccess da= new AdminDataaccess();
//	      da.DeleteAdminDoctor(adddoctor);
//		  
//		    List<Adddoctor> lis;
//			Dao dao = new Dao();
//			lis =dao.doShowdoctor();
		  
		  addDocRep.delete(adddoctor);
		  List<Adddoctor> lis = addDocRep.findAll();
			
			m.addAttribute("alldoctor", lis);
			
			
		  
		  
					return"viewalldoctor";
			
			}  
	  
	

	  
	  @RequestMapping("/insertdoctor")
		public String insertdoctor(@ModelAttribute()Adddoctor adddoctor,Model m) {
			
//	   Dao dao = new Dao();
//	   dao.doInsert(adddoctor);
//	   
//	   List<Adddoctor> lis;
//		
//		lis =dao.doShowdoctor();
		  
		  addDocRep.save(adddoctor);
		  List<Adddoctor> lis = addDocRep.findAll();
		
		m.addAttribute("alldoctor", lis);
		  
		  System.out.println("add doctor");
		
	  
	  
				return"viewalldoctor";
		
		}  
	  
	  
	  

		 @RequestMapping("/adminreciponcovid")
		  public String reciptioncovid(Model m) {
			 List<Covid> lis;
			  Dao dao= new Dao();
			 lis= dao.doShowCovid();
			 m.addAttribute("cvid", lis);
			  
			  
			return "admincovidappointments";
			
		}
		 	  
	  
	  
	  
		 

		 @RequestMapping("/adminapproveCovid")
			public String approveCovid(@ModelAttribute() Covid covid, Model m) {
			  List<Covid> lis;
				RecieptionDataAccess dao = new RecieptionDataAccess();
				dao.doApproveCovid(covid);
				lis=dao.doShowApprovedCovid();
				m.addAttribute("cvid", lis);
				return"admincovidappointments";
			} 
		  
	
		 
		 
		 

			@RequestMapping("/adminappointmentShow")
			public String 	adminappointmentApprve(Model m) {
				  List<Appoinment> lis;
			     RecieptionDataAccess dao = new RecieptionDataAccess();			  
			      lis=dao.doShowAppnment();
	              m.addAttribute("apnmt", lis);
			      return "adminnappointmentshow";

			}
			
			
			
			

			  @RequestMapping("/adminapprovAppnmnt")
				public String updateAppnmnt(@ModelAttribute() Appoinment appoinment, Model m) {
//					RecieptionDataAccess dao = new RecieptionDataAccess();
//					dao.doUpdatAppoinment(appoinment);
//					  List<Appoinment> lis;
//					  lis =dao.doShowAppnment();
				  apoinmtRep.save(appoinment);
				  List<Appoinment> lis = apoinmtRep.findAll();
						m.addAttribute("apnmt", lis);
						return"adminnappointmentshow";
				
				}
			  
			  
			
	  
	  
			
			

			@RequestMapping("/adminadddApppnment")
			public String addApppnment(Model m) {
				RecieptionDataAccess dao = new RecieptionDataAccess();
				Dao da= new Dao();
				  List<Appoinment> lis;
				  List<Department> list;
				  List<Adddoctor> listt;
				  
				 list=dao.doShowDepartmentName();
				 m.addAttribute("dn", list);
					
				 
				listt= da.doShowdoctor();
				m.addAttribute("doc", listt);
				 
			      int x = dao.getappnmentID();
				  m.addAttribute("id", x+1);
					  
					
			      return "adminnn-add-appointment";

			}
			
			
			
			
			
			

			  @RequestMapping("/adminsaveAppnmnet")
				public String saveAppnmnet(@ModelAttribute() Appoinment appoinment, Model m) {
//					RecieptionDataAccess dao = new RecieptionDataAccess();
//					dao.doInsertAppnnment(appoinment);
//					  List<Appoinment> lis;
//					  lis =dao.doShowAppnment();
				  apoinmtRep.save(appoinment);
				  List<Appoinment> lis = apoinmtRep.findAll();
						m.addAttribute("apnmt", lis);
						return"adminnappointmentshow";
				
				}
			  
			


}
