package sach;

public abstract class tailieu {
	private int mas;
	private String tens;
	public tailieu() {
		
	}
	public tailieu(int m,String t) {
		this.mas=m;
		this.tens=t;
	}
	public int getma() {
		return mas;
	}
	public String getten() {
		return tens;
	}
	public void setma(int m) {
		this.mas=m;
	}
	public void setten(String t) {
		this.tens=t;
	}
	public abstract float thanhtien();
}
