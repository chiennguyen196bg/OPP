/**
 * 
 */
package opp.quanly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.Properties;

import opp.model.CauHoi;
import opp.model.DeThi;
import opp.utils.Utils;

public class QuanLyDeThi {
	
	private static String WORKING_DIR = "C:/data/de_thi/";
	private DeThi deThi;
	
	public QuanLyDeThi(DeThi deThi){
		this.deThi = deThi;
	}
	
	
	public static void themDeThi(DeThi deThi) {
		Properties p = new Properties();
		try {
			// them vao properties
			p.load(new FileInputStream(WORKING_DIR + "listDeThi.properties"));
			p.setProperty(deThi.getMaDeThi(), deThi.getTenDeThi());
			p.store(new FileOutputStream(WORKING_DIR + "listDeThi.properties"), "");

			// them file
			saveToFile(deThi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DeThi layDeThi(String maDeThi) {
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(WORKING_DIR + "listDeThi.properties"));
			if(p.containsKey(maDeThi))
				return readFromFile(maDeThi);
			else return null;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void suaDeThi(DeThi deThi) {
		Properties p = new Properties();
		try {
			// sua properties
			p.load(new FileInputStream(WORKING_DIR + "listDeThi.properties"));
			p.setProperty(deThi.getMaDeThi(), deThi.getTenDeThi());
			p.store(new FileOutputStream(WORKING_DIR + "listDeThi.properties"), "");

			// sua file
			saveToFile(deThi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void xoaDeThi(String maDeThi) throws FileNotFoundException, IOException {
		// xoa o properties
		Properties p = new Properties();
		p.load(new FileInputStream(WORKING_DIR + "listDeThi.properties"));
		p.remove(maDeThi);
		p.store(new FileOutputStream(WORKING_DIR + "listDeThi.properties"), "");

		// xoa file
		(new File(WORKING_DIR + maDeThi + ".dat")).delete();
	}

	
	public static Properties getProperties() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(WORKING_DIR + "listDeThi.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			p = new Properties();
		}
		return p;
	}
	
	
	
	public void daoCauHoi(){
		deThi.setDsCauHoi(Utils.daoThuTu(deThi.getDsCauHoi()));
	}
	
	public StringBuilder inDeThi(){
		StringBuilder str = new StringBuilder();
		str.append(deThi.getTenDeThi()).append("\r\n");
		str.append("Kỳ: ").append(deThi.getKy()).append(" Năm học: ").append(deThi.getNamHoc()).append("\r\n");
		str.append("Thời gian: ").append(deThi.getThoiGian()).append(" phút").append("\r\n");
		for(int i = 0, size = deThi.getDsCauHoi().size(); i < size ; i++){
			CauHoi cauHoi = deThi.getDsCauHoi().get(i);
			QuanLyCauHoi qlCauHoi = new QuanLyCauHoi(cauHoi);
			str.append("Câu ").append(i+1).append(" (").append(cauHoi.getDiem()).append(" điểm)").append("\r\n");
			str.append(qlCauHoi.inCauHoi()).append("\r\n");
		}
		return str;
	}
	
	public void themCauHoi(CauHoi cauHoi){
		deThi.getDsCauHoi().add(cauHoi);
		double tongDiem = deThi.getTongDiem();
		tongDiem += cauHoi.getDiem();
		deThi.setTongDiem(tongDiem);
	}
	
	public void xoaCauHoi(int index){
		CauHoi cauHoi = deThi.getDsCauHoi().remove(index);
		double tongDiem = deThi.getTongDiem();
		tongDiem -= cauHoi.getDiem();
		deThi.setTongDiem(tongDiem);
	}
	
	

	public static boolean saveToFile(DeThi deThi) throws IOException {
		FileOutputStream f;
		f = new FileOutputStream(WORKING_DIR + deThi.getMaDeThi() + ".dat");
		ObjectOutputStream oStream = new ObjectOutputStream(f);
		oStream.writeObject(deThi);
		oStream.close();
		return true;
	}

	protected static DeThi readFromFile(String maDeThi) throws IOException, ClassNotFoundException {
		FileInputStream f;
		f = new FileInputStream(WORKING_DIR + maDeThi + ".dat");
		ObjectInputStream inStream = new ObjectInputStream(f);
		DeThi deThi = (DeThi) inStream.readObject();
		inStream.close();
		return deThi;
	}
	
	public String xuatDeThiRaFile() throws IOException{
		File dethi = new File(QuanLyDeThi.WORKING_DIR + deThi.getMaDeThi() + ".txt");
		Writer f = new FileWriter(dethi);
		f.write(this.inDeThi().toString());
		f.close();
		return deThi.getMaDeThi();
	}

}
