package hocvien;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class xldiem implements Ihocvien{
	Connection conn;
	Statement st;
	ResultSet rs;
	
	@Override
	public void getcon() {
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/dldiem","root","290104");
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void gethvbylop(String lop) {
		// TODO Auto-generated method stub
		 try {
			rs = st.executeQuery("select * from tbhocvien where lop = '"+lop+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void gethvbylopgt(String lop,String gt) {
		// TODO Auto-generated method stub
		try {
			rs = st.executeQuery("select * from tbhocvien where lop='"+lop+"'and gt='"+gt+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
