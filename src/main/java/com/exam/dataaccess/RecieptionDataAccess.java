package com.exam.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.entity.Addpatient;
import com.exam.entity.Appoinment;
import com.exam.entity.Covid;
import com.exam.entity.Department;
import com.exam.entity.Invoice;
import com.exam.entity.Loginreciption;
public class RecieptionDataAccess {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public int loginRecipion(Loginreciption lgin) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("SELECT name,password FROM loginreciption WHERE name=? AND password=?");
			pst.setString(1, lgin.getName());
			pst.setString(2, lgin.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
	
	public List<Addpatient> Showpatint() {
		List<Addpatient> list = new ArrayList<>();
		Addpatient s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from addpatient");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Addpatient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	
	public void doInsertPatient(Addpatient patnt) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("insert into addpatient values(?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, patnt.getPatientId());
			pst.setString(2, patnt.getPatientName());
			pst.setString(3, patnt.getPatientAddress());
			pst.setString(4, patnt.getPatientMobile());
			pst.setString(5, patnt.getPatientAge());
			pst.setString(6, patnt.getPatientDisease());
			pst.setString(7, patnt.getReferenceDoctor());
			pst.setString(8, patnt.getDepartment());
			pst.setDate(9, patnt.getAdmittedDate());
			
			

			pst.executeUpdate();
			System.out.println("insert succesfull");

		} catch (Exception e) {

		}

	}
	
	
	
	
	public List<Department> doShowDepatmnt() {
		List<Department> list = new ArrayList<>();
		Department s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from department");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Department(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	
	
	public Integer getpatientID() {
		int x = 0;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select max(patientId) from addpatient");

			ResultSet rs = pst.executeQuery();
			rs.next();
			x = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
	
	
	
	public void doDeletepatint(Addpatient p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("delete from addpatient where PatientId=" + p.getPatientId());

			pst.executeUpdate();

			System.out.println("delete");
		} catch (Exception e) {

		}
	}
	
	
	
	public void doUpdatpatint(Addpatient ap) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			   pst = con.prepareStatement("update addpatient set patientName=?,patientAddress=?,patientMobile=?,patientAge=?,patientDisease=?,referenceDoctor=?,department=?,admittedDate=? where patientId=?");

	              
               pst.setString(1,ap.getPatientName());
               pst.setString(2, ap.getPatientAddress());
               pst.setString(3, ap.getPatientMobile());
               pst.setString(4, ap.getPatientAge());
               pst.setString(5, ap.getPatientDisease());
               pst.setString(6, ap.getReferenceDoctor());
               pst.setString(7, ap.getDepartment());
               pst.setDate(8, ap.getAdmittedDate());
              
               pst.setInt(9, ap.getPatientId());

               pst.executeUpdate();
               System.out.println("updtae");
              

		} catch (Exception e) {

		}

	}
	
	
	
	
	public void doApproveCovid(Covid cvid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			   pst = con.prepareStatement("update covid set covidStatus=? where CovidId=?");

	           String s="yes";   
               pst.setString(1, s);
              
              
               pst.setInt(2, cvid.getCovidId());

               pst.executeUpdate();
               System.out.println("updtae");
              

		} catch (Exception e) {

		}

	}
	
	
	
	public List<Covid> doShowApprovedCovid() {
		List<Covid> list = new ArrayList<>();
		Covid s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from covid where covidStatus='no'");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Covid(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getString(6), rs.getString(7));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	public List<Addpatient> Showpatintofinvoic(Addpatient addpatient) {
		List<Addpatient> list = new ArrayList<>();
		Addpatient s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from addpatient where patientId=" + addpatient.getPatientId());

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Addpatient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	public Integer getinvoiceID() {
		int x = 0;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select max(invoiceId) from invoice");

			ResultSet rs = pst.executeQuery();
			rs.next();
			x = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
	
	
	public void doInsertInvoice(Invoice inv) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("insert into invoice values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, inv.getInvoiceId());
			pst.setString(2, inv.getPatientName());
			pst.setString(3, inv.getAge());
			pst.setString(4, inv.getPhone());
			pst.setString(5, inv.getAddress());
			pst.setString(6, inv.getReferenceDoctor());
			pst.setString(7, inv.getBillingAddress());
			pst.setDate(8, inv.getInvoiceDate());
			pst.setString(9, inv.getBedCharge());
			pst.setString(10, inv.getMedecineCharge());
			pst.setString(11, inv.getPathologyCharge());
			pst.setString(12, inv.getSubTotal());
			pst.setString(13, inv.getDiscount());
			pst.setString(14, inv.getGrandTotal());
			pst.setString(15, inv.getPaymentMethod());
			
			

			pst.executeUpdate();
			System.out.println("insert succesfull");

		} catch (Exception e) {

		}

	}
	
	
	
	
	public List<Invoice> ShowInvoice() {
		List<Invoice> list = new ArrayList<>();
		Invoice s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from invoice");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Invoice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	
	
	

	public void doDeleteInvoice(Invoice p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("delete from invoice where invoiceId=" + p.getInvoiceId());

			pst.executeUpdate();

			System.out.println("delete");
		} catch (Exception e) {

		}
	}
	

	
	
	
	public void doUpdatInvic(Invoice ap) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			   pst = con.prepareStatement("update invoice set patientName=?,age=?,phone=?,address=?,referenceDoctor=?,billingAddress=?,invoiceDate=?,bedCharge=?,medecineCharge=?,pathologyCharge=?,subTotal=?,discount=?,grandTotal=?,paymentMethod=? where invoiceId=?");

		
               pst.setString(1,ap.getPatientName());
               pst.setString(2, ap.getAge());
               pst.setString(3, ap.getPhone());
               pst.setString(4, ap.getAddress());
               pst.setString(5, ap.getReferenceDoctor());
               pst.setString(6, ap.getBillingAddress());
               pst.setDate(7, ap.getInvoiceDate());
               pst.setString(8, ap.getBedCharge());
               pst.setString(9, ap.getMedecineCharge());
               pst.setString(10, ap.getPathologyCharge());
               pst.setString(11, ap.getSubTotal());
               pst.setString(12, ap.getDiscount());
               pst.setString(13, ap.getGrandTotal());
               pst.setString(14, ap.getPaymentMethod());
             
              
               pst.setInt(15, ap.getInvoiceId());

               pst.executeUpdate();
               System.out.println("updtae");
              

		} catch (Exception e) {

		}

	}
	
	
	
	
	
	
	public List<Appoinment> doShowAppnment() {
		List<Appoinment> list = new ArrayList<>();
		Appoinment s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from appoinment where status='no'");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Appoinment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(9));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	
	
	
	
	public void doUpdatAppoinment(Appoinment ap) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			   pst = con.prepareStatement("update appoinment set status=? where appoinmentId=?");

		       String ss="yes";
               pst.setString(1, ss);
               pst.setInt(2, ap.getAppoinmentId());

               pst.executeUpdate();
               System.out.println("updtae");
              

		} catch (Exception e) {

		}

	}
	
	
	
	
	public Integer getappnmentID() {
		int x = 0;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select max(appoinmentId) from appoinment");

			ResultSet rs = pst.executeQuery();
			rs.next();
			x = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
	
	
	
	
	public List<Department> doShowDepartmentName() {
		List<Department> list = new ArrayList<>();
		Department s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from department");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Department(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	
	
	
	
	
	
	public void doInsertAppnnment(Appoinment ap) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("insert into appoinment values(?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, ap.getAppoinmentId());
			pst.setString(2, ap.getPatientName());
			pst.setString(3, ap.getPatientAge());
			pst.setString(4, ap.getPatientPhone());
			pst.setString(5, ap.getDoctorName());
			pst.setString(6, ap.getDoctorEmail());
			pst.setString(7, ap.getDepartment());
			pst.setDate(8, ap.getDate());
			pst.setString(9, ap.getTime());
			String s="no";
			pst.setString(10, s);
	
			pst.executeUpdate();
			System.out.println("insert succesfull");

		} catch (Exception e) {

		}

	}
	

}
