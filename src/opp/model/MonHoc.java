package opp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class MonHoc implements Serializable, Cloneable {
	private String tenMonHoc;
	private String maHocPhan;
	private int soChuong;
	private String gioiThieu;
	private ArrayList<LinkedList<CauHoi>> dsCauHoi;

	public MonHoc(String maHocPhan, String tenMonHoc) {
		this.maHocPhan = maHocPhan;
		this.tenMonHoc = tenMonHoc;
		dsCauHoi = new ArrayList<LinkedList<CauHoi>>();
	}

	
	// Getter va Setter
	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getMaHocPhan() {
		return maHocPhan;
	}

	public void setMaHocPhan(String maHocPhan) {
		this.maHocPhan = maHocPhan;
	}

	public int getSoChuong() {
		return soChuong;
	}

	public void setSoChuong(int soChuong) {
		this.soChuong = soChuong;
	}

	public ArrayList<LinkedList<CauHoi>> getDsCauHoi() {
		return dsCauHoi;
	}

	public void setDsCauHoi(ArrayList<LinkedList<CauHoi>> dsCauHoi) {
		this.dsCauHoi = dsCauHoi;
	}

	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}


