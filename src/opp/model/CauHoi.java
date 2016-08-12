package opp.model;

import java.io.Serializable;

public abstract class CauHoi implements Serializable{
	private String deBai;
	private int doKho;
	private int chuong;
	
	public CauHoi(){
		
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
	
	public abstract String inCauHoi();
	
}
