package opp.quanly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Properties;

import opp.model.MonHoc;

public class QuanLyMonHoc {
	private LinkedList<MonHoc> listMonHoc;
	private final static String WORKING_DIR = "D:/WorkSpace/JavaEE/OPP/src/data/mon_hoc/";
	private final static int MAX_SIZE = 6;

	public QuanLyMonHoc(LinkedList<MonHoc> list) {
		this.listMonHoc = list;
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
			return false;
		}
		return true;
	}

	public MonHoc layMonHoc(String maHocPhan) {
		MonHoc mh = null;
		// neu mon hoc co trong list
		for (int num = 0, size = listMonHoc.size(); num < size; num++) {
			mh = listMonHoc.get(num);
			if ((mh.getMaHocPhan()).equals(maHocPhan)) {
				if (num > 0) {
					listMonHoc.addFirst(listMonHoc.remove(num));
				}
				return mh;
			}
		}
		// neu mon hoc khong co trong list
		try {
			mh = readFromFile(maHocPhan);
			listMonHoc.addFirst(mh);
			if (listMonHoc.size() > MAX_SIZE)
				saveToFile(listMonHoc.removeLast());
		} catch (ClassNotFoundException | IOException e) {
			return null;
		}
		return mh;
	}

	public void suaMonHoc(String maHocPhan, MonHoc mh) {
		try {
			xoaMonHoc(maHocPhan);
			themMonHoc(mh);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void xoaMonHoc(String maHocPhan) throws FileNotFoundException, IOException {
		// xoa o properties
		Properties p = new Properties();
		p.load(new FileInputStream(WORKING_DIR + "list.properties"));
		p.remove(maHocPhan);
		p.store(new FileOutputStream(WORKING_DIR + "list.properties"), "");

		// xoa file
		(new File(WORKING_DIR + maHocPhan + ".dat")).delete();

		// xoa trong list
		for (int num = 0, size = listMonHoc.size(); num < size; num++) {
			if (listMonHoc.get(num).getMaHocPhan().equals(maHocPhan))
				listMonHoc.remove(num);
		}
	}

	
	public static Properties getProperties() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(WORKING_DIR + "list.properties"));
		} catch (IOException e) {
			p = new Properties();
		}
		return p;
	}

	protected static boolean saveToFile(MonHoc mh) throws IOException {
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
