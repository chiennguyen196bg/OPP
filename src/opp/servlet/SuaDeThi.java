package opp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import opp.model.DeThi;
import opp.quanly.QuanLyDeThi;

/**
 * Servlet implementation class SuaDeThi
 */
@WebServlet("/sua-de-thi")
public class SuaDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String maDeThi = request.getParameter("maDeThi");
		DeThi deThi = QuanLyDeThi.layDeThi(maDeThi);
		HttpSession session = request.getSession();
		session.setAttribute("deThi", deThi);
		request.getRequestDispatcher("sua-de-thi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		DeThi deThi = (DeThi) session.getAttribute("deThi");
		String action = request.getParameter("action");
		if(action.equals("save")){
			deThi.setTenDeThi(request.getParameter("tenDeThi"));
			deThi.setThoiGian(Integer.parseInt(request.getParameter("thoiGian")));
			deThi.setNamHoc(request.getParameter("namHoc"));
			deThi.setKy(Integer.parseInt(request.getParameter("ki")));
			QuanLyDeThi.suaDeThi(deThi);
			session.invalidate();
		}
		
	}

}
