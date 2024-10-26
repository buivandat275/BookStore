package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhachHang;
import util.MaHoa;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import database.KhachHangDao;

/**
 * Servlet implementation class DoiThongTin
 */
@WebServlet("/doi-thong-tin")
public class DoiThongTin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoiThongTin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChiKhachHang = request.getParameter("diaChiKhachHang");
		String diaChiMuaHang = request.getParameter("diaChimh");
		String diaChiNhanHang = request.getParameter("diaChinh");
		String dienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String dongYNhanE = request.getParameter("DongYNhanE");
		
		request.setAttribute("hoVaTen", hoVaTen);
		request.setAttribute("gioiTinh", gioiTinh);
		request.setAttribute("ngaySinh", ngaySinh);
		request.setAttribute("diaChiKhachHang", diaChiKhachHang);
		request.setAttribute("diaChiMuaHang", diaChiMuaHang);
		request.setAttribute("diaChiNhanHang", diaChiNhanHang);
		request.setAttribute("dienThoai", dienThoai);
		request.setAttribute("email", email);
		request.setAttribute("dongYNhanE", dongYNhanE);
		String url ="";
		String baoLoi ="";
		KhachHangDao khanhHangDao = new KhachHangDao();
		
		
		request.setAttribute("baoLoi", baoLoi);
		if(baoLoi.length()>0) {
			url ="/doithongtin.jsp";
		}else {
			Object obj = request.getSession().getAttribute("khachHang");
			KhachHang khachHang = null;
			if (obj != null)
				khachHang = (KhachHang)obj;
			if (khachHang != null) {
			
			String maKhachHang = khachHang.getMaKhacHang();
			KhachHang kh = new KhachHang(maKhachHang, "", "", hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanE!=null);
			khanhHangDao.updateInfo(kh); 
			//load lai khachHang vao session
			KhachHang kh2 = khanhHangDao.selectById(kh);
			request.getSession().setAttribute("khachHang", kh2);
			
			url = "/thanhcong.jsp";
		}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
