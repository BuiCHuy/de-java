package luong;

public class nv extends person {
	private String dc;
	private int luong;
	public nv() {}
	public nv(int m,String t,String dc,int l) {
		super(m,t);
		this.dc =dc;
		this.luong=l;
	}
	public void setdc(String d) {
		this.dc=d;
	}
	public void setluong(int l) {
		this.luong=l;
	}
	public String getdc() {
		return dc;
	}
	public int getluong() {
		return luong;
	}
}
