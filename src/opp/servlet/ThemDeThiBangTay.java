package opp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

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
@WebServlet("/them-bang-tay")
public class ThemDeThiBangTay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDeThiBangTay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
//		HttpSession session = request.getSession();
//		MonHoc monHoc = (MonHoc) session.getAttribute("monHoc");
//		DeThi deThi = (DeThi) session.getAttribute("deThi");
		request.getRequestDispatcher("them-bang-tay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MonHoc monHoc = (MonHoc) session.getAttribute("monHoc");
		DeThi deThi = (DeThi) session.getAttribute("deThi");
		deThi.setTenDeThi("De thi " + monHoc.getTenMonHoc());
		String action = request.getParameter("action");
		
		if(action.equals("getCauHoiList")){
			int type = Integer.parseInt(request.getParameter("type"));
			response.getWriter().append(getCauHoiList(monHoc.getDsCauHoi(), type));
		} else if(action.equals("getCauHoiInfo")){
			int index1 = Integer.parseInt(request.getParameter("index1"));
			int index2 = Integer.parseInt(request.getParameter("index2"));
			response.getWriter().append(getCauHoiInfo(monHoc, index1, index2));
		} else if(action.equals("addToDeThi")){
			int index1 = Integer.parseInt(request.getParameter("index1"));
			int index2 = Integer.parseInt(request.getParameter("index2"));
			double diem = Double.parseDouble(request.getParameter("diem"));
			this.chonVaoDeThi(deThi, monHoc, index1, index2, diem);
			
		} else if(action.equals("getCauHoiDeThi")){
			response.getWriter().append(this.getCauHoiDeThi(deThi));
		} else if(action.equals("getDeThi")){
			response.getWriter().append(deThi.inDeThi());
		} else if(action.equals("xoaCauHoi")){
			int index = Integer.parseInt(request.getParameter("index"));
			deThi.getDsCauHoi().remove(index);
		} else if(action.equals("xaoTronCauHoi")){
			deThi.daoCauHoi();
		} else if(action.equals("thayThe")){
			int index = Integer.parseInt(request.getParameter("index"));
			deThi.getDsCauHoi().set(index, monHoc.timCauHoiTuongDuong(deThi.getDsCauHoi().get(index)));
		} else if(action.equals("inRaFile")){
			
		} else if(action.equals("save")){
			deThi.setSoCauHoi(deThi.getDsCauHoi().size());

			deThi.setNamHoc(request.getParameter("hocKi"));
			deThi.setThoiGian(Integer.parseInt(request.getParameter("thoiGian")));
			deThi.setKy(Integer.parseInt(request.getParameter("ki")));
			QuanLyDeThi.themDeThi(deThi);
			response.getWriter().append("Them de thi thanh cong");
		} else if(action.equals("delete")){
			session.removeAttribute("deThi");
			session.removeAttribute("monHoc");
		}
		
	}
	
	protected String getCauHoiList(ArrayList<LinkedList<CauHoi>> listCauHoi, int type){
		JSONArray arr = new JSONArray();
		for(int index1 = 0, sizeArr = listCauHoi.size(); index1 < sizeArr; index1 ++){
			LinkedList<CauHoi> list = listCauHoi.get(index1);
			JSONObject obj = new JSONObject();
			if(type == 1){
				for(int index2 = 0, size = list.size(); index2 < size; index2++){
					CauHoi cauHoi = list.get(index2);
					if(cauHoi instanceof TracNghiem){
						obj.put("index1", index1);
						obj.put("index2", index2);
						obj.put("deBai", cauHoi.getDeBai());
						arr.add(obj);
						break;
					}
				}
			} else if(type == 2){
				for(int index2 = 0, size = list.size(); index2 < size; index2++){
					CauHoi cauHoi = list.get(index2);
					if(cauHoi instanceof TuLuan){
						obj.put("index1", index1);
						obj.put("index2", index2);
						obj.put("deBai", cauHoi.getDeBai());
						arr.add(obj);
						break;
					}
				}
			} else {
				obj.put("index1", index1);
				obj.put("index2", new Integer(0));
				obj.put("deBai", list.getFirst().getDeBai());
				arr.add(obj);
			}
		}
		return arr.toJSONString();
	}
	
	protected String getCauHoiInfo(MonHoc monHoc, int i1, int i2){
		CauHoi cauHoi = monHoc.layCauHoi(i1, i2);
		StringBuilder str = new StringBuilder();
		str.append(cauHoi.inCauHoi()).append("\n");
		str.append("Độ khó:").append(cauHoi.getDoKho()).append('\n');
		str.append("Chương:").append(cauHoi.getChuong()).append('\n');
		
		return str.toString();
	}
	
	protected void chonVaoDeThi(DeThi deThi, MonHoc monHoc, int index1, int index2, double diem){
		CauHoi cauHoi = monHoc.layCauHoi(index1, index2);
		cauHoi.setDiem(diem);
		deThi.getDsCauHoi().add(cauHoi);
		LinkedList ls = monHoc.getDsCauHoi().get(index1);
		ls.addFirst(ls.remove(index2));
	}
	
	protected String getCauHoiDeThi(DeThi deThi){
		JSONArray arr = new JSONArray();
		ArrayList<CauHoi> list = deThi.getDsCauHoi();
		for(int i = 0, size = list.size(); i< size; i++){
			JSONObject obj = new JSONObject();
			obj.put("index", i);
			obj.put("deBai", list.get(i).getDeBai());
			arr.add(obj);
		}
		return arr.toJSONString();
	}

}
