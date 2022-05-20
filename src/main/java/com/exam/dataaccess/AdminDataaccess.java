package com.exam.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.entity.Adddoctor;
import com.exam.entity.Department;
public class AdminDataaccess {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	/* Department part */

	public void doInsertappnment(Department department) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("insert into department values(?,?,?)");
			pst.setInt(1, department.getDepartmentId());
			pst.setString(2, department.getDepartmentName());
			pst.setString(3, department.getDepartmentStatus());

			pst.executeUpdate();
			System.out.println("insert succesfull");

		} catch (Exception e) {

		}

	}

	public List<Department> doShowDepartment() {
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

	/* Appoinmentpart */

	public Integer getappoinmentID() {
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
	
	
	
	

	
	
	
	public void DeleteAdminDoctor(Adddoctor p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "root");
			pst = con.prepareStatement("delete from adddoctor where doctorId=" + p.getDoctorId());

			pst.executeUpdate();

			System.out.println("delete");
		} catch (Exception e) {

		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
