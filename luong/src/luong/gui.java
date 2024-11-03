package luong;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gui extends JFrame{
	xlluong x = new xlluong();
	public gui() {
		String[] d = {"Hải Phòng","Hà Nội","Nam Định"};
		JLabel mal = new JLabel("Mã");
		JLabel hotenl = new JLabel("Họ tên");
		JLabel dcl = new JLabel("Địa chỉ");
		JLabel luongl = new JLabel("Lương");
		JTextField ma = new JTextField(30);
		JTextField hoten = new JTextField(30);
		JTextField luong = new JTextField(30);
		JComboBox<String> dc = new JComboBox<>(d);
		JButton findbtn = new JButton("Tìm");
		JButton updatebtn = new JButton("Cập nhật");
		JPanel p1 = new JPanel(new GridLayout(4,2,20,20));
		p1.add(mal);
		p1.add(ma);
		p1.add(hotenl);
		p1.add(hoten);
		p1.add(dcl);
		p1.add(dc);
		p1.add(luongl);
		p1.add(luong);
		JPanel p2 = new JPanel(new FlowLayout());
		p2.add(findbtn);
		p2.add(updatebtn);
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		main.add(p1);
		main.add(p2);
		this.add(main);
		this.setVisible(true);
		this.setSize(500,500);
		x.getcon();
		findbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x.getnvbyma(Integer.parseInt(ma.getText()));
				for(nv a : x.nvlist) {
					ma.setText((String.valueOf(a.getma())))  ;
					hoten.setText(a.getten());
					dc.setSelectedItem(a.getdc());
					luong.setText(String.valueOf(a.getluong()));
				}
				
				
			}
			
		});
		updatebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x.updatenv(Integer.parseInt(ma.getText()) ,hoten.getText(), dc.getSelectedItem().toString(),Integer.parseInt(luong.getText()));
			}
			
		});
	}
}
