package opp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class MonHoc implements Serializable {
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

	public void themCauHoi(CauHoi cauHoi) {
		if(cauHoi == null)
			throw new NullPointerException("Cau hoi is null");
		LinkedList<CauHoi> linkedList = new LinkedList<CauHoi>();
		linkedList.add(cauHoi);
		dsCauHoi.add(linkedList);
	}

	public void themCauHoiTuongDuong(int index, CauHoi cauHoi) {
		if(cauHoi == null)
			throw new NullPointerException("Cau hoi is null");
		this.dsCauHoi.get(index).add(cauHoi);
	}

	public void xoaCauHoi(int index1, int index2) {
		LinkedList<CauHoi> ls = this.dsCauHoi.get(index1);
		ls.remove(index2);
		if (ls.isEmpty())
			this.dsCauHoi.remove(index1);
	}

	public void suaCauHoi(int index1, int index2, CauHoi cauHoi) {
		LinkedList<CauHoi> ls = this.dsCauHoi.get(index1);
		ls.remove(index2);
		ls.add(index2, cauHoi);

	}
	
	public CauHoi layCauHoi(int index1, int index2){
		return this.dsCauHoi.get(index1).get(index2);
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

}
