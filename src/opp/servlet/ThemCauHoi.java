package opp.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import opp.model.CauHoi;
import opp.model.MonHoc;
import opp.model.TracNghiem;
import opp.model.TuLuan;
import opp.quanly.QuanLyMonHoc;

/**
 * Servlet implementation class ThemCauHoi
 */
@WebServlet("/them-cau-hoi")
public class ThemCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemCauHoi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		MonHoc monHoc = (MonHoc) session.getAttribute("monHoc");

		request.setAttribute("monHoc", monHoc);

		request.getRequestDispatcher("them-cau-hoi.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		Gson gson = new Gson();
		HttpSession session = request.getSession();
		MonHoc monHoc = (MonHoc) session.getAttribute("monHoc");
		QuanLyMonHoc ql = new QuanLyMonHoc(monHoc);
		// them cau hoi vao mon hoc
		CauHoi cauHoi;

		if (request.getParameter("type").equals("0"))
			cauHoi = gson.fromJson(request.getParameter("cauHoi"), TracNghiem.class);
		else
			cauHoi = gson.fromJson(request.getParameter("cauHoi"), TuLuan.class);

		int index = Integer.parseInt(request.getParameter("cauHoiTuongDuong"));
		if (index < 0)
			ql.themCauHoi(cauHoi);
		else
			ql.themCauHoiTuongDuong(index, cauHoi);
		QuanLyMonHoc.saveToFile(monHoc);
		response.getWriter().append("Them cau hoi thanh cong");

	}

}
