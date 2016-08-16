package opp.quanly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

import opp.model.CauHoi;
import opp.model.MonHoc;
import opp.model.TracNghiem;
import opp.model.TuLuan;

public class QuanLyMonHoc {

	private final static String WORKING_DIR = "D:/WorkSpace/JavaEE/OPP/src/data/mon_hoc/";
	private final static int MAX_SIZE = 6;
	private MonHoc monHoc;
	
	public QuanLyMonHoc(MonHoc monHoc){
		this.monHoc = monHoc;
	}
	
	public static boolean themMonHoc(MonHoc mh) {
		Properties p = new Properties();
		try {
			// them vao properties
			p.load(new FileInputStream(WORKING_DIR + "list.properties"));
			p.setProperty(mh.getMaHocPhan(), mh.getTenMonHoc());
			p.store(new FileOutputStream(WORKING_DIR + "list.properties"), "");

			// them file
			saveToFile(mh);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static MonHoc layMonHoc(String maHocPhan) {
		try {
			MonHoc mh = readFromFile(maHocPhan);
			return mh;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static void suaMonHoc(String maHocPhan, MonHoc mh) {
		try {
			xoaMonHoc(maHocPhan);
			themMonHoc(mh);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void xoaMonHoc(String maHocPhan) throws FileNotFoundException, IOException {
		// xoa o properties
		Properties p = new Properties();
		p.load(new FileInputStream(WORKING_DIR + "list.properties"));
		p.remove(maHocPhan);
		p.store(new FileOutputStream(WORKING_DIR + "list.properties"), "");

		// xoa file
		(new File(WORKING_DIR + maHocPhan + ".dat")).delete();

	}

	
	public static Properties getProperties() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(WORKING_DIR + "list.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			p = new Properties();
		}
		return p;
	}
	
	public void themCauHoi(CauHoi cauHoi) {
		LinkedList<CauHoi> linkedList = new LinkedList<CauHoi>();
		linkedList.add(cauHoi);
		this.monHoc.getDsCauHoi().add(linkedList);
	}

	public void themCauHoiTuongDuong(int index, CauHoi cauHoi) {
		this.monHoc.getDsCauHoi().get(index).add(cauHoi);
	}

	public void xoaCauHoi(int index1, int index2) {
		LinkedList<CauHoi> ls = this.monHoc.getDsCauHoi().get(index1);
		ls.remove(index2);
		if (ls.isEmpty())
			this.monHoc.getDsCauHoi().remove(index1);
	}

	public void suaCauHoi(int index1, int index2, CauHoi cauHoi) {
		LinkedList<CauHoi> ls = this.monHoc.getDsCauHoi().get(index1);
		ls.set(index2, cauHoi);
	}

	public CauHoi layCauHoi(int index1, int index2) {
		return this.monHoc.getDsCauHoi().get(index1).get(index2);
	}
	
	
	public CauHoi timCauHoiTuongDuong(CauHoi cauHoi) {
		for (int i = 0, size = monHoc.getDsCauHoi().size(); i < size; i++) {
			LinkedList<CauHoi> list = monHoc.getDsCauHoi().get(i);
			int index = list.indexOf(cauHoi);
			if (index > -1)
				return list.get((index + 1) % (list.size()));
		}
		return cauHoi;
	}
	
	public ArrayList<CauHoi> locCauHoi(int type) {
		ArrayList<CauHoi> returnList = new ArrayList<CauHoi>();
		if (type == 1) {
			for (LinkedList<CauHoi> ls : monHoc.getDsCauHoi()) {
				for (CauHoi cauHoi : ls) {
					if(cauHoi instanceof TracNghiem){
						returnList.add(cauHoi);
						break;
					}
				}
			}
		} else if(type == 2){
			for (LinkedList<CauHoi> ls : monHoc.getDsCauHoi()) {
				for (CauHoi cauHoi : ls) {
					if(cauHoi instanceof TuLuan){
						returnList.add(cauHoi);
						break;
					}
				}
			}
		} else {
			for (LinkedList<CauHoi> ls : monHoc.getDsCauHoi()) {
				returnList.add(ls.getFirst());
			}
		}
		return returnList;
	}
	

	public static boolean saveToFile(MonHoc mh) throws IOException {
		FileOutputStream f;
		f = new FileOutputStream(WORKING_DIR + mh.getMaHocPhan() + ".dat");
		ObjectOutputStream oStream = new ObjectOutputStream(f);
		oStream.writeObject(mh);
		oStream.close();
		return true;
	}

	protected static MonHoc readFromFile(String maHocPhan) throws IOException, ClassNotFoundException {
		FileInputStream f;
		f = new FileInputStream(WORKING_DIR + maHocPhan + ".dat");
		ObjectInputStream inStream = new ObjectInputStream(f);
		MonHoc mh = (MonHoc) inStream.readObject();
		inStream.close();
		return mh;
	}

}
