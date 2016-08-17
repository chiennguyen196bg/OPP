package opp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import opp.model.CauHoi;
import opp.model.DapAn;
import opp.model.DeThi;
import opp.model.TracNghiem;

/**
 * Servlet implementation class DanhGiaKetQua
 */
@WebServlet("/danh-gia-ket-qua")
public class DanhGiaKetQua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhGiaKetQua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DeThi deThi = (DeThi) session.getAttribute("deThi");
		String answer = (String) session.getAttribute("answer");
		request.setAttribute("answer", answer);
		ArrayList<CauHoi> dsCauHoiDung;
		try {
			dsCauHoiDung = timSoCauTraLoiDung(deThi.getDsCauHoi(), answer);
			request.setAttribute("dsCauHoiDung", dsCauHoiDung);
			request.getRequestDispatcher("danh-gia-ket-qua.jsp").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public static ArrayList<CauHoi> timSoCauTraLoiDung(ArrayList<CauHoi> dsCauHoi, String answer) throws ParseException{
		ArrayList<CauHoi> returnList = new ArrayList<CauHoi>();
		JSONParser parser = new JSONParser();
		JSONObject answerObj = (JSONObject) parser.parse(answer);
		
		for(int i=0, size = dsCauHoi.size(); i < size; i++){
			boolean flag = true;
			CauHoi cauHoi = dsCauHoi.get(i);
			if(cauHoi instanceof TracNghiem){
				TracNghiem tn = (TracNghiem) cauHoi;
				Object obj = answerObj.get(Integer.toString(i));
				if(obj == null)
					continue;
				JSONObject jobj = (JSONObject) obj;
				for(int j = 0, dsDapAnSize = tn.getDsDapAn().size(); j < dsDapAnSize; j++){
					Boolean traLoi;
					Object o = jobj.get(Integer.toString(j));
					if(o == null)
						traLoi = new Boolean(false);
					else
						traLoi = (Boolean) o;
					DapAn dapAn = tn.getDsDapAn().get(j);
					if(dapAn.isDapAnDung()){
						if(traLoi.equals(false)){
							flag = false;
							break;
						}
					} else {
						if(traLoi.equals(true)){
							flag = false;
							break;
						}
					}
				}
				if (flag == true){
					returnList.add(cauHoi);
				}
			}
		}
		return returnList;
	}

}
