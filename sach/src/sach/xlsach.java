package sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class xlsach {
	List<sach> slist = new ArrayList<>();
	Connection conn;
	Statement st;
	ResultSet rs;
	public xlsach() {}
	public void getcon() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/dlsach","root","290104");
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getSA() {
		try {
			rs = st.executeQuery("select * from tbsach");
			while(rs.next()) {
				int m = rs.getInt(1);
				String t = rs.getString(2);
				int n = rs.getInt(3);
				int g = rs.getInt(4);
				sach s = new sach(m,t,n,g);
				slist.add(s);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteSA(int nam) {
		try {
			st.executeUpdate("delete from tbsach where namxb = "+nam+"");
			List<sach> del = new ArrayList<>();
			for(sach s : slist) {
				if(s.getnam()==nam) {
					del.add(s);
				}
			}
			slist.removeAll(del);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
