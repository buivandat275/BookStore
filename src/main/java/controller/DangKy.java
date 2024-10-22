package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhachHang;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import database.KhachHangDao;

/**
 * Servlet implementation class DangKy
 */
@WebServlet("/DangKy")
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String tenDangNhap = request.getParameter("user");
		String matKhau = request.getParameter("pass");
		String matKhauNhapLai = request.getParameter("passnn");
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChiKhachHang = request.getParameter("diaChiKhachHang");
		String diaChiMuaHang = request.getParameter("diaChimh");
		String diaChiNhanHang = request.getParameter("diaChinh");
		String dienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String dongYNhanE = request.getParameter("DongYNhanE");
		request.setAttribute("tenDangNhap", tenDangNhap);
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
		if(khanhHangDao.kiemTraTenDangNhap(tenDangNhap)) {
			baoLoi+="Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác .<br/>";
		}
		if(!matKhau.equals(matKhauNhapLai)) {
			baoLoi+="Mật khẩu không Khớp.<br/>";
		}
		
		request.setAttribute("baoLoi", baoLoi);
		if(baoLoi.length()>0) {
			url ="/dangky.jsp";
		}else {
			Random rd = new Random();
			String maKhachHang =rd.nextInt(1000)+"";
			KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhauNhapLai, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanE!=null);
			khanhHangDao.insert(kh); 
			
			url = "/thanhcong.jsp";
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
