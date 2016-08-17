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
 * Servlet implementation class LamDeThi
 */
@WebServlet("/lam-de-thi")
public class LamDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LamDeThi() {
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
		if(maDeThi == null){
			response.sendRedirect("chon-de-thi");
		} else {
			HttpSession session = request.getSession(true);
			DeThi deThi = QuanLyDeThi.layDeThi(maDeThi);
			session.setAttribute("deThi", deThi);
			request.getRequestDispatcher("lam-bai-thi.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String answer = request.getParameter("answer");
		session.setAttribute("answer", answer);
		response.getWriter().append("Nop bai thanh cong");
	}

}
