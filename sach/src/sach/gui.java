package sach;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class gui extends JFrame {
	xlsach x = new xlsach();
	public gui() {
		Integer[] nl = {2019,2020,2021}; 
		JComboBox<Integer> nam = new JComboBox<>(nl);
		JButton delbtn = new JButton("Xoá sách");
		String[] field = {"Mã","Tên","Năm XB","Giá bán","Thành tiền"};
		DefaultTableModel tmodel = new DefaultTableModel(field,0);
		JTable tb = new JTable(tmodel);
		JScrollPane p2 = new JScrollPane(tb);
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(nam);
		p1.add(delbtn);
		main.add(p1);
		main.add(p2);
		this.add(main);
		this.setVisible(true);
		this.setSize(500,500);
		x.getcon();
		x.getSA();
		update(tmodel);
		delbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int confirm = JOptionPane.showConfirmDialog(main, "Are you sure?");
				if(confirm == JOptionPane.YES_OPTION) {
					x.deleteSA(Integer.parseInt(nam.getSelectedItem().toString()));
					update(tmodel);
				}
			}
			
		});
		
	}
	public void update(DefaultTableModel tmodel) {
		tmodel.setRowCount(0);
		Object[] row = new Object[5];
		for(sach s : x.slist) {
			row[0]=s.getma();
			row[1]=s.getten();
			row[2]=s.getnam();
			row[3]=s.getgia();
			row[4]=s.thanhtien();
			tmodel.addRow(row);
		}
	}
}
