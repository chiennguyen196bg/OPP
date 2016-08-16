package opp.model;

import java.io.Serializable;

public abstract class CauHoi implements Serializable {
	private String deBai;
	private int doKho;
	private int chuong;
	private double diem;
	
	public CauHoi() {

	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public String getDeBai() {
		return deBai;
	}

	public void setDeBai(String deBai) {
		this.deBai = deBai;
	}

	public int getDoKho() {
		return doKho;
	}

	public void setDoKho(int doKho) {
		this.doKho = doKho;
	}

	public int getChuong() {
		return chuong;
	}

	public void setChuong(int chuong) {
		this.chuong = chuong;
	}
	
}
