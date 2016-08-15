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

import opp.model.DeThi;
import opp.model.MonHoc;
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
		
		// lay list mon hoc
		ServletContext app = getServletConfig().getServletContext();
		LinkedList<MonHoc> listMonHoc = (LinkedList<MonHoc>) app.getAttribute("listMonHoc");
		if (listMonHoc == null) {
			listMonHoc = new LinkedList<MonHoc>();
			app.setAttribute("listMonHoc", listMonHoc);
		}

		// lay mon hoc.
		QuanLyMonHoc ql = new QuanLyMonHoc(listMonHoc);
		MonHoc monHoc = ql.layMonHoc(maHocPhan);

		try {
			MonHoc monHocClone = (MonHoc) monHoc.clone();
			session.setAttribute("monHoc", monHocClone);
			session.setAttribute("deThi", new DeThi());
			if (taoDeThi.equals("bangTay"))
				response.sendRedirect("them-bang-tay");
			else
				response.sendRedirect("them-tu-dong");
		} catch (CloneNotSupportedException e) {
			response.sendRedirect("danh-sach-de-thi");
			e.printStackTrace();
		}

	}

}
