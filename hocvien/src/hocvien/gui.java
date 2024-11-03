package hocvien;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class gui extends JFrame{
	xldiem x = new xldiem();
	private List<hocvien> hvlist = new ArrayList<>();
	String[] loplist = {"pm1","pm2","th1","th2"};
	public gui() {
		JComboBox<String> lopc = new JComboBox<>(loplist);
		JRadioButton nambtn = new JRadioButton("Nam");
		JRadioButton nubtn = new JRadioButton("Nữ");
		ButtonGroup grp = new ButtonGroup();
		grp.add(nambtn);
		grp.add(nubtn);
		JPanel gtpane = new JPanel(new FlowLayout());
		gtpane.add(nambtn);
		gtpane.add(nubtn);
		String[] field = {"Mã học viên","Họ tên","Lớp","Giới tính","Điểm","Kết quả"};
		DefaultTableModel tmodel = new DefaultTableModel(field,0);
		JTable tb = new JTable(tmodel);
		JScrollPane p2 = new JScrollPane(tb);
		update(tmodel);
		JButton findbtn = new JButton("Tìm");
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(lopc);
		p1.add(gtpane);
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		main.add(p1);
		main.add(findbtn);
		main.add(p2);
		add(main);
		this.setVisible(true);
		this.setSize(500, 500);
		findbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hvlist.clear();
				
				
				x.getcon();
				if(!nambtn.isSelected()&&!nubtn.isSelected()) {
					x.gethvbylop(lopc.getSelectedItem().toString());
					
				}
				if(nambtn.isSelected()) {
					x.gethvbylopgt(lopc.getSelectedItem().toString(), "nam");
				}
				if(nubtn.isSelected()) {
					x.gethvbylopgt(lopc.getSelectedItem().toString(), "nu");
				}
				try {
					
					while(x.rs.next()) {
						int m = x.rs.getInt(1);
						String n = x.rs.getString(2);
						String l = x.rs.getString(3);
						String g = x.rs.getNString(4);
						float d = x.rs.getFloat(5);
						hocvien h = new hocvien(m,n,l,g,d);
						hvlist.add(h);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				update(tmodel);
				grp.clearSelection();
			}
			
		});
	}
	public void update(DefaultTableModel tmodel) {
		tmodel.setRowCount(0);
		Object[] row = new Object[6];
		for(hocvien h : hvlist) {
			row[0]=h.getmahv();
			row[1]=h.getten();
			
			row[2]=h.getlop();
			row[3]=h.getgt();
			row[4]=h.getdiem();
			row[5]=h.ketqua();
			tmodel.addRow(row);
		}
		
	}
}
