package sach;

public class sach extends tailieu{
	private int namxb;
	private int giab;
	public sach() {}
	public sach(int m,String t,int n,int g) {
		super(m,t);
		this.namxb=n;
		this.giab=g;
	}
	public void setnam(int n) {
		this.namxb=n;
	}
	public void setgia(int gia) {
		this.giab=gia;
	}
	public int getnam() {
		return namxb;
	}
	public int getgia() {
		return giab;
	}
	@Override
	public float thanhtien() {
		// TODO Auto-generated method stub
		if(namxb<2015) {
			return (float) (giab*0.85);
		}
		else {
			return (float) (giab*0.95);
		}
	}
	
}
