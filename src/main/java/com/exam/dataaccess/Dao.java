package com.exam.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.entity.Adddoctor;
import com.exam.entity.Appoinment;
import com.exam.entity.Covid;
public class Dao {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	
	
	
	
	                                     /* loginpage Dataaccess part */
	
	
	public void doInsertCovid(Covid covid) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("insert into covid values(?,?,?,?,?,?,?)");
			pst.setInt(1, covid.getCovidId());
			pst.setString(2, covid.getCovidName());
			pst.setString(3, covid.getCovidEmail());
			pst.setString(4, covid.getCovidPhone());
			pst.setDate(5, covid.getCovidDate());
			pst.setString(6, covid.getCovidMessage());
			String ss = "no";
			pst.setString(7, ss);
			
			

			pst.executeUpdate();
			System.out.println("insert succesfull");

		} catch (Exception e) {

		}

	}
	
	
	
	public void doInsertAppoinment(Appoinment ap) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	                                  /* <!-- Admin-DataAccess-part --> */
	
	

	public String adminLogin(String name, String password) {
		String ss = "fail";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement(
					"select * from loginadmin where name='" + name + "' and password='" + password + "'");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ss = "Success";

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ss;
	}

	
	
	
	
	
	public void doInsert(Adddoctor doctor) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("insert into adddoctor values(?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, doctor.getDoctorId());
			pst.setString(2, doctor.getDoctorName());
			pst.setString(3, doctor.getDoctorGender());
			pst.setString(4, doctor.getDoctorDepartment());
			pst.setString(5, doctor.getDoctorEmail());
			pst.setString(6, doctor.getDoctorUserName());
			pst.setString(7, doctor.getDoctorPassword());
			pst.setDate(8, doctor.getDoctorJoin());
			pst.setString(9, doctor.getDoctorImage());

			pst.executeUpdate();
			System.out.println("insert succesfull");

		} catch (Exception e) {

		}

	}

	
	
	
	
	
	
	public Integer getdoctorID() {
		int x = 0;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select max(doctorId) from adddoctor");

			ResultSet rs = pst.executeQuery();
			rs.next();
			x = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	
	
	
	public List<Covid> doShowCovid() {
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
	
	
	
	
	public List<Covid> doShowCovidpathology() {
		List<Covid> list = new ArrayList<>();
		Covid s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from covid where covidStatus='yes'");

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Adddoctor> doShowdoctor() {
		List<Adddoctor> list = new ArrayList<>();
		Adddoctor s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from adddoctor");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Adddoctor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	                                 /* <!-- Doctor-DataAccess-part --> */
	
	

	public String doctorLogin(String name, String password) {
		String ss = "fail";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement(
					"select * from Logindoctor where name='" + name + "' and password='" + password + "'");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ss = "Success";

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ss;
	}
	
	
	
	
	
	
	
	
	
	                                                      /* Pathology Dataacesss */
	
	public String pathologyLogin(String name, String password) {
		String ss = "fail";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement(
					"select * from loginpathology where name='" + name + "' and password='" + password + "'");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ss = "Success";

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ss;
	}
	
	
	
	
	public List<Covid> doShowCovidpathlyf() {
		List<Covid> lis = new ArrayList<>();
		Covid s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from covid where covidStatus='no'");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Covid(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getString(6), rs.getString(7));
				lis.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return lis;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	

//	
//	public void registration(Loginlogout log) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "nh123456");
//			pst=con.prepareStatement("insert into loginlogout values(?,?,?,?)");
//			pst.setInt(1, log.getId());
//			pst.setString(2, log.getName());
//			pst.setString(3, log.getEmail());
//			pst.setString(4, log.getPassword());
//			
//		
//			pst.executeUpdate();
//			System.out.println("Registration succesfull");
//
//		} catch (Exception e) {
//
//		}
//
//	}
//	
//	
//	
//	public  String login(String email, String password) {
//		 String ss="fail";
//		try {
//          
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "nh123456");
//			pst = con.prepareStatement("select * from loginlogout where email='"+email+"' and password='"+password+"'");
//
//			ResultSet rs = pst.executeQuery();
//			while(rs.next()) {
//				ss="Success";
//	
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return ss;
//	}

}
