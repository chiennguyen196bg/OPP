package opp.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
import opp.quanly.QuanLyCauHoi;
import opp.quanly.QuanLyDeThi;
import opp.quanly.QuanLyMonHoc;

/**
 * Servlet implementation class TaoDeThi
 */
@WebServlet("/tao-de-thi")
public class TaoDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaoDeThi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String maHocPhan = request.getParameter("maHocPhan");
		String taoDeThi = request.getParameter("taoDeThi");

		HttpSession session = request.getSession(true);

		MonHoc monHoc = QuanLyMonHoc.layMonHoc(maHocPhan);
		DeThi deThi = new DeThi();
		deThi.setTenDeThi("Đề thi môn " + monHoc.getTenMonHoc());

		session.setAttribute("monHoc", monHoc);
		session.setAttribute("deThi", deThi);
		if (taoDeThi.equals("bangTay"))
			request.getRequestDispatcher("them-bang-tay.jsp").forward(request, response);
		else
			request.getRequestDispatcher("them-tu-dong.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		MonHoc monHoc = (MonHoc) session.getAttribute("monHoc");
		DeThi deThi = (DeThi) session.getAttribute("deThi");

		QuanLyMonHoc qlMonHoc = new QuanLyMonHoc(monHoc);
		QuanLyDeThi qlDeThi = new QuanLyDeThi(deThi);

		String action = request.getParameter("action");

		
		
		if (action.equals("getCauHoiDeThi")) {
			response.getWriter().append(this.getCauHoiDeThi(deThi));
		} else if (action.equals("getDeThi")) {
			response.getWriter().append(qlDeThi.inDeThi());
		} else if (action.equals("xoaCauHoi")) {
			int index = Integer.parseInt(request.getParameter("index"));
			qlDeThi.xoaCauHoi(index);
		} else if (action.equals("xaoTronCauHoi")) {
			qlDeThi.daoCauHoi();
		} else if (action.equals("thayThe")) {
			int index = Integer.parseInt(request.getParameter("index"));
			CauHoi cauHoi = deThi.getDsCauHoi().get(index);
			CauHoi tuongDuong = qlMonHoc.timCauHoiTuongDuong(cauHoi);
			tuongDuong.setDiem(cauHoi.getDiem());
			deThi.getDsCauHoi().set(index, tuongDuong);
		} else if (action.equals("inRaFile")) {
			String maDeThi = qlDeThi.xuatDeThiRaFile();
			response.getWriter().append(maDeThi).append(".txt");
		} else if (action.equals("save")) {
			deThi.setSoCauHoi(deThi.getDsCauHoi().size());

			deThi.setNamHoc(request.getParameter("hocKi"));
			deThi.setThoiGian(Integer.parseInt(request.getParameter("thoiGian")));
			deThi.setKy(Integer.parseInt(request.getParameter("ki")));
			QuanLyDeThi.themDeThi(deThi);
			response.getWriter().append("Them de thi thanh cong");
		} else if (action.equals("delete")) {
			session.removeAttribute("deThi");
			session.removeAttribute("monHoc");
		} else if (action.equals("daoDapAn")){
			for(CauHoi cauHoi : deThi.getDsCauHoi()){
				QuanLyCauHoi ql = new QuanLyCauHoi(cauHoi);
				ql.daoDapAn();
			}
		}

	}

	protected String getCauHoiDeThi(DeThi deThi) {
		JSONArray arr = new JSONArray();
		ArrayList<CauHoi> list = deThi.getDsCauHoi();
		for (int i = 0, size = list.size(); i < size; i++) {
			JSONObject obj = new JSONObject();
			obj.put("index", i);
			obj.put("deBai", list.get(i).getDeBai());
			arr.add(obj);
		}
		return arr.toJSONString();
	}

}
