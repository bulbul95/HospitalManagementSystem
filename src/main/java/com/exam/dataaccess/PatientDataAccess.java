package com.exam.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.entity.Invoice;
import com.exam.entity.Loginpatient;
import com.exam.entity.Prescription;
public class PatientDataAccess {

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public int loginPatient(Loginpatient lgin) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("SELECT name,password FROM loginpatient WHERE name=? AND password=?");
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
	
	

	
	
	
	public List<Invoice> searchPatientInvoice(int search) {
		List<Invoice> list = new ArrayList<>();
		Invoice s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from invoice where invoiceId ='"+search+"'");

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
	
	
	
	
	
	
	public List<Prescription> searchDoctorPrescription(int search) {
		List<Prescription> list = new ArrayList<>();
		Prescription s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from prescription where prescriptionId ='"+search+"'");

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
	
	
	
	
	
}
