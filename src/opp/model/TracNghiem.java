package opp.model;

import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append(this.getDeBai());
		str.append("\n");
		this.getDeBai();
		return null;
	}
	
}
