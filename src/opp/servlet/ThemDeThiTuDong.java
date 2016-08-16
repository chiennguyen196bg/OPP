package opp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import opp.model.CauHoi;
import opp.model.DeThi;
import opp.model.MonHoc;
import opp.model.TracNghiem;
import opp.model.TuLuan;
import opp.quanly.QuanLyDeThi;

/**
 * Servlet implementation class ThemDeThiBangTay
 */
@WebServlet("/them-tu-dong")
public class ThemDeThiTuDong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemDeThiTuDong() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		MonHoc monHoc = (MonHoc) session.getAttribute("monHoc");
		DeThi deThi = (DeThi) session.getAttribute("deThi");
		
		String action = request.getParameter("action");

		if (action.equals("taoDeThi")) {
			ArrayList<LinkedList<CauHoi>> dsCauHoi = (ArrayList<LinkedList<CauHoi>>) monHoc.getDsCauHoi().clone();
			int doKho = Integer.parseInt(request.getParameter("doKho"));
			locTheoDoKho(dsCauHoi, doKho);
			int dangCauHoi = Integer.parseInt(request.getParameter("dangCauHoi"));
			locDangCau(dsCauHoi, dangCauHoi);
			int soCau = Integer.parseInt(request.getParameter("soCau"));
			deThi.setDsCauHoi(taoDsCauHoi(dsCauHoi, soCau));
			int sapXep = Integer.parseInt(request.getParameter("sapXep"));
			
			
			if(sapXep == 0)
				sapXepCauHoi(deThi.getDsCauHoi());
			response.getWriter().append("tao de thi thanh cong");
		}
	}

	//Them tu dong
	
	public static void locTheoDoKho(ArrayList<LinkedList<CauHoi>> dsCauHoi, int doKho){
		if((doKho > 0) && (doKho < 6)) {
			int size = dsCauHoi.size();
			for (int i = size -1; i > -1; i-- ) {
				LinkedList<CauHoi> list = dsCauHoi.get(i);
				int listSize = list.size();
				for(int j = listSize - 1; j > -1; j--){
					if(list.get(j).getDoKho() != doKho)
						list.remove(j);
				}
				if(list.isEmpty())
					dsCauHoi.remove(i);
			}
		}
	}

	public static void locDangCau(ArrayList<LinkedList<CauHoi>> dsCauHoi, int dangCauHoi){
		if(dangCauHoi == 1){
			int size = dsCauHoi.size();
			for (int i = size -1; i > -1; i-- ) {
				LinkedList<CauHoi> list = dsCauHoi.get(i);
				int listSize = list.size();
				for(int j = listSize - 1; j > -1; j--){
					if(!(list.get(j) instanceof TracNghiem))
						list.remove(j);
				}
				if(list.isEmpty())
					dsCauHoi.remove(i);
			}
		} else if(dangCauHoi == 2) {
			int size = dsCauHoi.size();
			for (int i = size -1; i > -1; i-- ) {
				LinkedList<CauHoi> list = dsCauHoi.get(i);
				int listSize = list.size();
				for(int j = listSize - 1; j > -1; j--){
					if(!(list.get(j) instanceof TuLuan))
						list.remove(j);
				}
				if(list.isEmpty())
					dsCauHoi.remove(i);
			}
		}
	}

	public static ArrayList<CauHoi> taoDsCauHoi(ArrayList<LinkedList<CauHoi>> dsCauHoi, int soCau){
		ArrayList<CauHoi> returnList = new ArrayList<CauHoi>();
		ArrayList<LinkedList<CauHoi>> temp = (ArrayList<LinkedList<CauHoi>>) dsCauHoi.clone();
		Random rd = new Random();
		int size = dsCauHoi.size();
		while((size > 0) && (soCau > 0)){
			int index = rd.nextInt(size);
			LinkedList<CauHoi> list = temp.get(index);
			returnList.add(list.get(rd.nextInt(list.size())));
			temp.remove(index);
			size--; soCau--;
		}
		return returnList;
	}

	public static void sapXepCauHoi(ArrayList<CauHoi> dsCauHoi){
		int size = dsCauHoi.size();
		int i = 0, j = size - 1;
		while(true){
			while(i < size){
				if(dsCauHoi.get(i) instanceof TuLuan)
					break;
				i++;
			}
			while(j > 0){
				if(dsCauHoi.get(j) instanceof TracNghiem)
					break;
				j--;
			}
			if(i>j)
				break;
			else{
				CauHoi temp = dsCauHoi.get(i);
				dsCauHoi.set(i, dsCauHoi.get(j));
				dsCauHoi.set(j, temp);
			}
		}
	}
	
	
	
	
	
}
