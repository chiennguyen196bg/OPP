package opp.quanly;

import opp.model.CauHoi;
import opp.model.TracNghiem;
import opp.utils.Utils;

public class QuanLyCauHoi {
	private CauHoi cauHoi;
	
	public QuanLyCauHoi(CauHoi cauHoi){
		this.cauHoi = cauHoi;
	}
	
	public void daoDapAn(){
		if(cauHoi instanceof TracNghiem){
			TracNghiem tn = (TracNghiem) cauHoi;
			if(tn.isCoTheDaoDapAn())
				tn.setDsDapAn(Utils.daoThuTu(tn.getDsDapAn()));
		}
	}
	
	public StringBuilder inCauHoi(){
		StringBuilder str = new StringBuilder();
		str.append(cauHoi.getDeBai()).append("\r\n");
		if(cauHoi instanceof TracNghiem){
			TracNghiem tn = (TracNghiem) cauHoi;
			char k = 'A';
			for(int i = 0, size = tn.getDsDapAn().size(); i < size; i++, k++){
				str.append(k).append(". ").append(tn.getDsDapAn().get(i).getNoiDung()).append("\r\n");
			}
		}
		return str;
	}
}
