package opp.test;

import java.io.BufferedReader;
import java.util.LinkedList;

import opp.model.MonHoc;
import opp.quanly.QuanLyMonHoc;

public class Check {

	private static BufferedReader in;

	public static void main(String[] args) {
//		Gson gson = new Gson();
		// MonHoc monHoc = new MonHoc("it3020", "Lập Trình C");
		// monHoc.setSoChuong(4);
		// TracNghiem ch1 = new TracNghiem();
		// ch1.setDeBai("Cau hoi 1");
		// TuLuan ch2 = new TuLuan();
		// ch2.setDeBai("De tu luan 2");
		// TracNghiem ch3 = new TracNghiem();
		// ch3.setDeBai("Cau hoi 3");
		// monHoc.themCauHoi(ch1);
		// monHoc.themCauHoiTuongDuong(0, ch2);
		// monHoc.themCauHoi(ch3);
		// System.out.println(gson.toJson(monHoc));
		
		
//		try {
//			in = new BufferedReader(new InputStreamReader(new FileInputStream("D:/test.json"), "UTF8"));
//			String str = in.readLine();
//			// System.out.println(str);
//			TracNghiem tn1;
//			tn1 = gson.fromJson(str, TracNghiem.class);
//			DapAn da1 = new DapAn("dap an 1", true);
//			DapAn da2 = new DapAn("dap an 2", false);
//			tn1.themDapAn(da1);
//			tn1.themDapAn(da2);
//			System.out.println(gson.toJson(tn1));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		QuanLyMonHoc ql = new QuanLyMonHoc(new LinkedList<MonHoc>());
		MonHoc mh = ql.layMonHoc("it3030");
		System.out.println(mh.getMaHocPhan());

	}
}
