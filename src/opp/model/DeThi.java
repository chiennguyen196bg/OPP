package opp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import opp.utils.Utils;

public class DeThi implements Serializable {
	private String maDeThi;
	private String tenDeThi;
	private int thoiGian;
	private String namHoc;
	private int ky;
	private double tongDiem;
	private int soCauHoi;
	private ArrayList<CauHoi> dsCauHoi;
	
	public DeThi(){
		this.maDeThi = Long.toString((new Date()).getTime());
		this.dsCauHoi = new ArrayList<CauHoi>();
	}
	
	public String getMaDeThi() {
		return maDeThi;
	}


	public ArrayList<CauHoi> getDsCauHoi() {
		return dsCauHoi;
	}

	public void setDsCauHoi(ArrayList<CauHoi> dsCauHoi) {
		this.dsCauHoi = dsCauHoi;
	}

	public void daoCauHoi(){
		this.dsCauHoi = Utils.daoThuTu(this.dsCauHoi);
	}

	public int getSoCauHoi() {
		return soCauHoi;
	}

	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}

	public String getTenDeThi() {
		return tenDeThi;
	}

	public void setTenDeThi(String tenDeThi) {
		this.tenDeThi = tenDeThi;
	}

	public int getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(int thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}

	public int getKy() {
		return ky;
	}

	public void setKy(int ky) {
		if ((0 < ky) && (ky < 4))
			this.ky = ky;
	}

	public double getTongDiem() {
		return tongDiem;
	}

	public void setTongDiem(double tongDiem) {
		this.tongDiem = tongDiem;
	}
	
	public StringBuilder inDeThi(){
		StringBuilder str = new StringBuilder();
		str.append(this.getTenDeThi()).append("\n");
		str.append("Kỳ: ").append(this.getKy()).append("Năm học: ").append(this.getNamHoc()).append("\n");
		for(int i = 0, size = this.dsCauHoi.size(); i < size ; i++){
			CauHoi cauHoi = this.dsCauHoi.get(i);
			str.append("Câu ").append(i+1).append(" (").append(cauHoi.getDiem()).append(") \n");
			str.append(cauHoi.getDeBai()).append("\n");
		}
		return str;
	}

}
