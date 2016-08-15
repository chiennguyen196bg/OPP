package opp.model;

import java.util.ArrayList;
import java.util.Random;

import opp.utils.Utils;

public class TracNghiem extends CauHoi{
	private boolean coTheDaoDapAn;
	ArrayList<DapAn> dsDapAn;
	
	public TracNghiem(){
		this.dsDapAn = new ArrayList<DapAn>();
	}
	
	public void themDapAn(DapAn dapAn){
		this.dsDapAn.add(dapAn);
	}
	
	public void xoaDapAn(){
		
	}
	
	public void suaDapAn(){
		
	}
	
	public void daoDapAn() {
		if(this.coTheDaoDapAn){
			this.dsDapAn = Utils.daoThuTu(this.dsDapAn);
		}
	}
	
	
	

	public boolean isCoTheDaoDapAn() {
		return coTheDaoDapAn;
	}

	public void setCoTheDaoDapAn(boolean coTheDaoDapAn) {
		this.coTheDaoDapAn = coTheDaoDapAn;
	}

	public ArrayList<DapAn> getDsDapAn() {
		return dsDapAn;
	}

	public void setDsDapAn(ArrayList<DapAn> dsDapAn) {
		this.dsDapAn = dsDapAn;
	}

	@Override
	public String inCauHoi() {
		StringBuilder str = new StringBuilder();
		str.append(super.getDeBai());
		str.append("\n");
		for(int i = 0, size = this.dsDapAn.size(); i < size; i++){
			str.append(i+1).append(". ").append(this.dsDapAn.get(i).getNoiDung()).append("\n");
		}
		return str.toString();
	}
	
}
