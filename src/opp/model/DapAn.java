package opp.model;

import java.io.Serializable;

public class DapAn implements Serializable {
	private String noiDung;
	private boolean dapAnDung;

	public DapAn() {

	}

	public DapAn(String noiDung, boolean isTrue) {
		this.noiDung = noiDung;
		this.dapAnDung = isTrue;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public boolean isDapAnDung() {
		return dapAnDung;
	}

	public void setDapAnDung(boolean dapAnDung) {
		this.dapAnDung = dapAnDung;
	}

}
