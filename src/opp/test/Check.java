package opp.test;

import java.io.BufferedReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class Check {

	private static BufferedReader in;

	public static void main(String[] args) throws CloneNotSupportedException, ParseException {
		Gson gson = new Gson();
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
		
//		JSONObject obj = new JSONObject();
//		JSONArray arr = new JSONArray();
//		StringBuilder str = new StringBuilder();
//		str.append("111").append("\n");
//		obj.put("index1", new Integer(10));
//		obj.put("index2", "123");
//		obj.put("str", str);
//		arr.add(obj);
//		arr.add(obj);
//		System.out.println(obj.toJSONString());
//		System.out.println(arr.toJSONString());
		
		
//		CauHoi ch1 = new CauHoi();
//		CauHoi ch2 = new CauHoi();
//		CauHoi ch3 = new CauHoi();
//		CauHoi ch4 = new CauHoi();
//		ch1.setDeBai("cau hoi 1");
//		ch2.setDeBai("cau hoi 1a");
//		ch3.setDeBai("cau hoi 1b");
//		ch4.setDeBai("cau hoi 1c");
//		
//		DeThi deThi = new DeThi();
//		deThi.getDsCauHoi().add(ch1);
//		deThi.getDsCauHoi().add(ch2);
//		deThi.getDsCauHoi().add(ch3);
//		deThi.getDsCauHoi().add(ch4);
//		
//		System.out.println(deThi.inDeThi());
		
//		DeThi deThi = new DeThi();
//		TracNghiem tracNghiem = new TracNghiem();
//		DapAn da1 = new DapAn();
//		da1.setNoiDung("dap an 1");
//		DapAn da2 = new DapAn();
//		da2.setNoiDung("dap an 2");
//		DapAn da3 = new DapAn();
//		da3.setNoiDung("dap an 3");
//		tracNghiem.setCoTheDaoDapAn(true);
//		tracNghiem.getDsDapAn().add(da1);
//		tracNghiem.getDsDapAn().add(da2);
//		tracNghiem.getDsDapAn().add(da3);
//		for(DapAn x : tracNghiem.getDsDapAn()){
//			System.out.println(x.getNoiDung());
//		}
		String test = "{ \"0\": { \"0\": true, \"3\": true } }";
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(test);
		int i = 2;
		System.out.println();
	}
	
	
}
