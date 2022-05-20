package com.exam.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.entity.Covid;
import com.exam.entity.Covidtest;
public class PathologyDataAccess {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	
	public List<Covid> doShowpatholgyCovid() {
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
	
	
	
	
	/*
	 * public void showApprvPatholgyCovid(Covid cvid) { try {
	 * Class.forName("com.mysql.cj.jdbc.Driver"); con =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root",
	 * "nh123456"); pst =
	 * con.prepareStatement("select * from covid where CovidId=?");
	 * 
	 * 
	 * pst.setInt(1, cvid.getCovidId());
	 * 
	 * pst.executeUpdate(); System.out.println("Takup");
	 * 
	 * 
	 * } catch (Exception e) {
	 * 
	 * }
	 * 
	 * }
	 * 
	 */
	
	
	
	
	public List<Covid> ShowAppvdPatholgyCovid(Covid cvid) {
		List<Covid> list = new ArrayList<>();
		Covid s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from covid where covidId=" + cvid.getCovidId());
			
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
	
	
	
	
	
	public void doInsertCovidtest(Covidtest ctest) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("insert into covidtest values(?,?,?,?,?,?)");
			pst.setInt(1, ctest.getId());
			pst.setString(2, ctest.getName());
			pst.setString(3, ctest.getPhone());
			pst.setDate(4, ctest.getDate());
			pst.setString(5, ctest.getResult());
			pst.setString(6, ctest.getFee());
			
			pst.executeUpdate();
			System.out.println("insert succesfull");

		} catch (Exception e) {

		}

	}
	
	
	
	

	public List<Covidtest> ShowCovidtestpathology() {
		List<Covidtest> list = new ArrayList<>();
		Covidtest s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from covidtest");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Covidtest(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6));

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return list;

	}
	
	

	
	
	

//	public List<Ptholgy> ShowtpathologyPatholy() {
//		List<Ptholgy> list = new ArrayList<>();
//		Ptholgy s;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
//			pst = con.prepareStatement("select * from ptholgy");
//
//			rs = pst.executeQuery();
//			while (rs.next()) {
//				s = new Ptholgy(rs.getInt(1), rs.getString(2), rs.getString(3));
//
//			}
//
//			System.out.println("Show succesfull");
//
//		} catch (Exception e) {
//
//		}
//		return list;

	}
	
	
	

//}
