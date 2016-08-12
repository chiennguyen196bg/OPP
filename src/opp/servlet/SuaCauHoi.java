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
 * Servlet implementation class SuaCauHoi
 */
@WebServlet("/sua-cau-hoi")
public class SuaCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaCauHoi() {
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
		String maHocPhan = (String) session.getAttribute("maHocPhan");
		if (maHocPhan == null)
			response.sendRedirect("/OPP/index.jsp");
		else {
			if ((request.getParameter("index1") == null) || (request.getParameter("index2") == null))
				response.sendRedirect("/OPP/danh-sach-cau-hoi");
			else {

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
				System.out.println(monHoc == null);
				int index1 = Integer.parseInt(request.getParameter("index1"));
				int index2 = Integer.parseInt(request.getParameter("index2"));
				request.setAttribute("monHoc", monHoc);
				request.setAttribute("index1", index1);
				request.setAttribute("index2", index2);
				request.setAttribute("cauHoi", monHoc.layCauHoi(index1, index2));
				request.getRequestDispatcher("sua-cau-hoi.jsp").forward(request, response);
			}
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
		
		
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		String maHocPhan = (String) session.getAttribute("maHocPhan");
		if (maHocPhan == null)
			response.getWriter().append("Có lỗi xảy ra");
		else {
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
			
			//them cau hoi vao mon hoc
			CauHoi cauHoi;
			
			if(request.getParameter("type").equals("0"))
				cauHoi = gson.fromJson(request.getParameter("cauHoi"), TracNghiem.class);
			else
				cauHoi = gson.fromJson(request.getParameter("cauHoi"), TuLuan.class);
			
			int index1 = Integer.parseInt(request.getParameter("index1"));
			int old_index1 = Integer.parseInt(request.getParameter("old_index1"));
			int old_index2 = Integer.parseInt(request.getParameter("old_index2"));
			if(index1 == old_index1){
				monHoc.suaCauHoi(old_index1, old_index2, cauHoi);
			} else {
				if(index1 < 0){
					monHoc.xoaCauHoi(old_index1, old_index2);
					monHoc.themCauHoi(cauHoi);
				} else {
					monHoc.themCauHoiTuongDuong(index1, cauHoi);
					monHoc.xoaCauHoi(old_index1, old_index2);
				}
			}
			response.getWriter().append("Sửa câu hỏi thành công!");
			
		}
		
	}

}
