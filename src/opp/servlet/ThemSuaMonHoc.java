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

import opp.model.MonHoc;
import opp.quanly.QuanLyMonHoc;

/**
 * Servlet implementation class ThemSuaMonHoc
 */
@WebServlet("/them-sua-mon-hoc")
public class ThemSuaMonHoc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemSuaMonHoc() {
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

		String maHocPhan = (String) request.getParameter("maHocPhan");
		HttpSession session = request.getSession(true);
		MonHoc monHoc;
		if (maHocPhan == null) {
			monHoc = new MonHoc("", "");
			request.setAttribute("action", "add");
		} else {
			monHoc = QuanLyMonHoc.layMonHoc(maHocPhan);
			request.setAttribute("action", "edit");
		}
		session.setAttribute("monHoc", monHoc);
		
		request.getRequestDispatcher("mon-hoc-them-sua.jsp").forward(request, response);

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
		String action = (String) request.getParameter("action");
		if (action.equals("edit")) {
			
			String old_maHocPhan = request.getParameter("old_maHocPhan");
			monHoc.setTenMonHoc(request.getParameter("tenMonHoc"));
			monHoc.setMaHocPhan(request.getParameter("maHocPhan"));
			monHoc.setSoChuong(Integer.parseInt(request.getParameter("soChuong")));
			monHoc.setGioiThieu(request.getParameter("gioiThieu"));
			QuanLyMonHoc.suaMonHoc(old_maHocPhan, monHoc);
			
			response.getWriter().append("Chỉnh sửa thành công");
		} else if (action.equals("add")) {
			monHoc = new MonHoc(request.getParameter("maHocPhan"), request.getParameter("tenMonHoc"));
			monHoc.setSoChuong(Integer.parseInt(request.getParameter("soChuong")));
			monHoc.setGioiThieu(request.getParameter("gioiThieu"));
			QuanLyMonHoc.themMonHoc(monHoc);
			response.getWriter().append("Thêm mới thành công");
		}
		
	}

}
