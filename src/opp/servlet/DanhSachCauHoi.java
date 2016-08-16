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
 * Servlet implementation class DanhSachCauHoi
 */
@WebServlet("/danh-sach-cau-hoi")
public class DanhSachCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachCauHoi() {
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

		// Lay ma hoc phần
		String maHocPhan = request.getParameter("maHocPhan");
		HttpSession session = request.getSession(true);

		if (maHocPhan == null)
			maHocPhan = (String) session.getAttribute("maHocPhan");

		if (maHocPhan == null)
			response.sendRedirect("/OPP/index.jsp");
		else {
			session.setAttribute("maHocPhan", new String(maHocPhan));
			MonHoc monHoc = QuanLyMonHoc.layMonHoc(maHocPhan);
			session.setAttribute("monHoc", monHoc);
			request.getRequestDispatcher("danh-sach-cau-hoi.jsp").forward(request, response);
			// response.getWriter().append("Don!");
			// response.sendRedirect("/OPP/index.jsp");
		}

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
		if (request.getParameter("action").equals("delete")) {
			String index1 = request.getParameter("index1");
			String index2 = request.getParameter("index2");

			MonHoc monHoc = (MonHoc) session.getAttribute("monHoc");
			
			QuanLyMonHoc ql = new QuanLyMonHoc(monHoc);
			ql.xoaCauHoi(Integer.parseInt(index1), Integer.parseInt(index2));
			QuanLyMonHoc.saveToFile(monHoc);
			response.getWriter().append("Xoa thanh cong");
		}

	}

}
