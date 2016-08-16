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

	
}
