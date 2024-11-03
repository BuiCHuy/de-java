package hocvien;

public class hocvien {
	private int mahv;
	private String hoten;
	private String lop;
	private String gt;
	private float diem;
	public hocvien(int ma,String ten,String lop,String gt,float diem) {
		this.mahv = ma;
		this.hoten = ten;
		this.lop = lop;
		this.gt = gt;
		this.diem = diem;
	}
	public hocvien() {
		
	}
	public int getmahv() {
		return mahv;
	}
	public String getten() {
		return hoten;
	}
	public String getlop() {
		return lop;
	}
	public String getgt() {
		return gt;
	}
	public float getdiem() {
		return diem;
	}
	public void setmahv(int m) {
		this.mahv = m;
	}
	public void setten(String t) {
		this.hoten=t;
	}
	public void setlop(String l ) {
		this.lop=l;
	}
	public void setgt(String g) {
		this.gt = g;
	}
	public void setdiem(float d) {
		this.diem = d;
	}
	public String ketqua() {
		if(diem>=20) {
			return "Đỗ";
		}
		else {
			return "Trượt";
		}
	}
	
}
