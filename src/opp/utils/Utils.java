package opp.utils;

import java.util.ArrayList;
import java.util.Random;

public class Utils {
	public static <E> ArrayList<E> daoThuTu(ArrayList<E> list){
		int size = list.size();
		ArrayList<E> tempArrayList = new ArrayList<E>(size);
		Random rn = new Random();
		while(size > 0){
			tempArrayList.add(list.remove(rn.nextInt(size)));
			size--;
		}
		return tempArrayList;
	}
}
