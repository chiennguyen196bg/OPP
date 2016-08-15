package opp.test;

import java.util.Date;
import java.util.LinkedList;

import opp.model.CauHoi;
import opp.model.DeThi;
import opp.model.MonHoc;
import opp.model.TracNghiem;
import opp.model.TuLuan;
import opp.quanly.QuanLyDeThi;
import opp.quanly.QuanLyMonHoc;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		LinkedList<MonHoc> list = new LinkedList<MonHoc>();
		// MonHoc mh = new MonHoc("it3407", "Toan roi rac");
		// MonHoc mh1 = new MonHoc("it2000", "lap trinh c 1");
		// MonHoc mh2 = new MonHoc("it2001", "lap trinh c 2");
		// MonHoc mh3 = new MonHoc("it2002", "lap trinh c 3");
		// QuanLyMonHoc ql = new QuanLyMonHoc(list);
		//
		// ql.themMonHoc(mh);
		// ql.themMonHoc(mh1);
		// ql.themMonHoc(mh2);
		// ql.themMonHoc(mh3);
		// try {
		// ql.xoaMonHoc("it3407");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// ql.suaMonHoc("it2002", new MonHoc("it2003", "lap trinh c++"));
		// MonHoc test = ql.layMonHoc("it2000");
		// System.out.println(test.getTenMonHoc());
		// ArrayList<MonHocInfo> listMonHoc = ql.layListMonHoc();
		// for(MonHocInfo x : listMonHoc){
		// System.out.println(x.getTenMonHoc()+" "+ x.getMaHocPhan());
		// }
		// for(MonHoc x : list){
		// System.out.println(x.getTenMonHoc()+" "+ x.getMaHocPhan());
		// }

		 MonHoc mh = new MonHoc("it3031", "Lập trình hướng đối tượng 2");
		 CauHoi cauHoi1 = new TracNghiem();
		 cauHoi1.setDeBai("cau hỏi số 1");
		 CauHoi cauHoi1a = new TracNghiem();
		 cauHoi1a.setDeBai("cau hỏi số 1a");
		 CauHoi cauHoi1b = new TuLuan();
		 cauHoi1b.setDeBai("cau hỏi số 1b");
		 CauHoi cauHoi2 = new TracNghiem();
		 cauHoi2.setDeBai("câu hỏi số 2");
		 CauHoi cauHoi3 = new TracNghiem();
		 cauHoi3.setDeBai("câu hỏi số 3");
		 CauHoi cauHoi4 = new TracNghiem();
		 cauHoi4.setDeBai("câu hỏi số 4");
		 mh.themCauHoi(cauHoi1);
		 mh.themCauHoiTuongDuong(0, cauHoi1a);
		 mh.themCauHoiTuongDuong(0, cauHoi1b);
		 mh.themCauHoi(cauHoi2);
		 mh.themCauHoiTuongDuong(1, cauHoi3);
		 mh.themCauHoi(cauHoi4);
		 mh.setSoChuong(7);
		 QuanLyMonHoc ql = new QuanLyMonHoc(list);
		 QuanLyMonHoc.themMonHoc(mh);

		 
		 
		 DeThi deThi = new DeThi();
		 deThi.getDsCauHoi().add(cauHoi1);
		 deThi.getDsCauHoi().set(0, mh.timCauHoiTuongDuong(cauHoi1));
		 System.out.println(deThi.getDsCauHoi().get(0).getDeBai());
	}
}
