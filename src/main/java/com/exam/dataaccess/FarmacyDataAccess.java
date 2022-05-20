package com.exam.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.entity.Addmedicine;
import com.exam.entity.Loginfarmacy;
public class FarmacyDataAccess {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public int loginpharmacy(Loginfarmacy lgin) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("SELECT name,password FROM loginfarmacy WHERE name=? AND password=?");
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
	
	
	
	
	public List<Addmedicine> ShowMedecine() {
		List<Addmedicine> lis = new ArrayList<>();
		Addmedicine s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("select * from addmedicine");

			rs = pst.executeQuery();
			while (rs.next()) {
				s = new Addmedicine(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				lis.add(s);

			}

			System.out.println("Show succesfull");

		} catch (Exception e) {

		}
		return lis;

	}

	
	
	
	
	
	
}
