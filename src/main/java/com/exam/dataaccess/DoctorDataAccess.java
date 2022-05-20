package com.exam.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.entity.Addpatient;
import com.exam.entity.Appoinment;
import com.exam.entity.Prescription;
public class DoctorDataAccess {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;



	

	public String doctorLogin(String name, String password) {
		String ss = "fail";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement(
					"select * from logindoctor where name='" + name + "' and password='" + password + "'");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ss = "Success";

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ss;
	}

	
	
	
	
	
	
	
	
	public List<Appoinment> doShowDoctorAppnment() {
		List<Appoinment> list = new ArrayList<>();
		Appoinment s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from appoinment where status='yes' and doctorName='bulbul'");

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
	
	
	
	
	
	
	
	
	
	public List<Appoinment> doShowprescptionAppnment(Appoinment ap) {
		List<Appoinment> list = new ArrayList<>();
		Appoinment s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from appoinment where appoinmentId=" +ap.getAppoinmentId());

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
	
	
	
	

	public Integer getprescriptionID() {
		int x = 0;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select max(prescriptionId) from prescription");

			ResultSet rs = pst.executeQuery();
			rs.next();
			x = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
	
	
	
	
	
	

	public void doInsertPrescption(Prescription p) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("insert into prescription values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, p.getPrescriptionId());
			pst.setString(2, p.getPatientName());
			pst.setString(3, p.getAge());
			pst.setDate(4, p.getDate());
			pst.setString(5, p.getPathology1());
			pst.setString(6, p.getMedecine1());
			pst.setString(7, p.getM());
			pst.setString(8, p.getA());
			pst.setString(9, p.getN());
			pst.setString(10, p.getPathology2());
			pst.setString(11, p.getMedecine2());
			pst.setString(12, p.getM1());
			pst.setString(13, p.getA1());
			pst.setString(14, p.getN1());
			pst.setString(15, p.getDoctorName());
			
			
			

			pst.executeUpdate();
			System.out.println("insert succesfull");

		} catch (Exception e) {

		}

	}
	
	
	
	
	
	

	public List<Addpatient> Showdoctorpatint() {
		List<Addpatient> list = new ArrayList<>();
		Addpatient s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from addpatient where referenceDoctor='bulbul'");

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
	
	
	
	
	
	
	

	public List<Prescription> ShowDoctorAllprescription() {
		List<Prescription> list = new ArrayList<>();
		Prescription s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from prescription");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Prescription(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	
	
	
	
	

	public List<Prescription> searchDoctorPrescription(String search) {
		List<Prescription> list = new ArrayList<>();
		Prescription s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from prescription where doctorName ='"+search+"'");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Prescription(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {
			System.out.println(e);

		}
		return list;

	}
	
	
	
	
	
	
	
	public List<Prescription> viewDoctorprescription(Prescription p) {
		List<Prescription> list = new ArrayList<>();
		Prescription s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from prescription where prescriptionId=" + p.getPrescriptionId());

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Prescription(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
				list.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	
	
	
	
	
	
	public void doDeletprscription(Prescription p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("delete from prescription where prescriptionId=" + p.getPrescriptionId());

			pst.executeUpdate();

			System.out.println("delete");
		} catch (Exception e) {

		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<Addpatient> Showdoctorpatint2(Addpatient p) {
		List<Addpatient> list = new ArrayList<>();
		Addpatient s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from addpatient where patientId="+p.getPatientId());

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
	
	
	
	
}
