package opp.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		MonHoc monHoc;
		if (maHocPhan == null) {
			monHoc = new MonHoc("", "");
			request.setAttribute("action", "add");
		} else {

			// lay list mon hoc
			ServletContext app = getServletConfig().getServletContext();
			LinkedList<MonHoc> listMonHoc = (LinkedList<MonHoc>) app.getAttribute("listMonHoc");
			if (listMonHoc == null) {
				listMonHoc = new LinkedList<MonHoc>();
				app.setAttribute("listMonHoc", listMonHoc);
			}

			// lay mon hoc.
			QuanLyMonHoc ql = new QuanLyMonHoc(listMonHoc);
			monHoc = ql.layMonHoc(maHocPhan);
			request.setAttribute("action", "edit");
		}
		request.setAttribute("monHoc", monHoc);
		
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
		
		String action = (String) request.getParameter("action");
		if (action.equals("edit")) {
			// lay list mon hoc
			String old_maHocPhan = request.getParameter("old_maHocPhan");
			ServletContext app = getServletConfig().getServletContext();
			LinkedList<MonHoc> listMonHoc = (LinkedList<MonHoc>) app.getAttribute("listMonHoc");
			if (listMonHoc == null) {
				listMonHoc = new LinkedList<MonHoc>();
				app.setAttribute("listMonHoc", listMonHoc);
			}

			// lay mon hoc.
			QuanLyMonHoc ql = new QuanLyMonHoc(listMonHoc);
			MonHoc monHoc = ql.layMonHoc(old_maHocPhan);
			monHoc.setTenMonHoc(request.getParameter("tenMonHoc"));
			monHoc.setMaHocPhan(request.getParameter("maHocPhan"));
			monHoc.setSoChuong(Integer.parseInt(request.getParameter("soChuong")));
			monHoc.setGioiThieu(request.getParameter("gioiThieu"));
			ql.xoaMonHoc(old_maHocPhan);
			QuanLyMonHoc.themMonHoc(monHoc);
			
			response.getWriter().append("Chỉnh sửa thành công");
		} else if (action.equals("add")) {
			MonHoc monHoc = new MonHoc(request.getParameter("maHocPhan"), request.getParameter("tenMonHoc"));
			monHoc.setSoChuong(Integer.parseInt(request.getParameter("soChuong")));
			monHoc.setGioiThieu(request.getParameter("gioiThieu"));
			QuanLyMonHoc.themMonHoc(monHoc);
			response.getWriter().append("Thêm mới thành công");
		}
		
	}

}
