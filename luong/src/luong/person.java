package luong;

public class person {
	private int ma;
	private String hoten;
	public person() {}
	public person(int ma,String hoten) {
		this.ma = ma;
		this.hoten=hoten;
	}
	public void setma(int ma) {
		this.ma = ma;
	}
	public void setten(String ten) {
		this.hoten=ten;
	}
	public int getma() {
		return ma;
	}
	public String getten() {
		return hoten;
	}
}
