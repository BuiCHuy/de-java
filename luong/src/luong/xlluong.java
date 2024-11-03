package luong;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class xlluong {
	List<nv> nvlist = new ArrayList<>();
	Connection conn;
	Statement st;
	ResultSet rs;
	void getcon() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/dlluong","root","290104");
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void getnvbyma(int ma) {
		nv n = null;
		nvlist.clear();
		try {
			rs = st.executeQuery("select * from tbnv where manv = "+ma+"");
			while(rs.next()) {
				int m = rs.getInt(1);
				String t = rs.getString(2);
				String dc = rs.getString(3);
				int l = rs.getInt(4);
				n = new nv(m,t,dc,l);	
				nvlist.add(n);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void updatenv(int m,String n,String dc,int l) {
		try {
			st.executeUpdate("update tbnv set hoten='"+n+"',dc='"+dc+"',luong="+l+" where manv = "+m+" ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
