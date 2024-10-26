package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.KhachHang;
import util.MaHoa;

import java.io.IOException;

import database.KhachHangDao;

/**
 * Servlet implementation class DoiMatKhau
 */
@WebServlet("/doi-mat-khau")
public class DoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoiMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String matKhauHienTai = request.getParameter("matKhauHienTai"); 
		String matKhauMoi = request.getParameter("matKhauMoi"); 
		String matKhauNhapLai = request.getParameter("matKhauNhapLai"); 
//kiểm tra mật khẩu có giống hay không		
		String matKhauHienTaiSha1 = MaHoa.toSHA1(matKhauHienTai);
		String baoLoi = "";
		String url="";
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		
		if(obj!= null) 
			khachHang = (KhachHang)obj;
		if(khachHang==null) {
			baoLoi="Bạn chưa đăng nhập vào hệ thống!";
			url= "/doimatkhau.jsp";
			
		}else {//nếu khách hàng đã đăng nhập
			if(!matKhauHienTaiSha1.equals(khachHang.getMatKhau())) {
				baoLoi="Mật khẩu hiện tại không chính xác!";
				url="/doimatkhau.jsp";
			}else {
				if(!matKhauMoi.equals(matKhauNhapLai)) {
					baoLoi="Mật khẩu nhập lại không khớp!";
					url="/doimatkhau.jsp";
				}else if(matKhauMoi.equals(matKhauHienTai)) {
					baoLoi="Mật khẩu vừa tạo giống mật khẩu cũ";
					url="/doimatkhau.jsp";
					
				}else {
					String matKhauMoi_Sha1 =MaHoa.toSHA1(matKhauMoi);
					khachHang.setMatKhau(matKhauMoi_Sha1);
					KhachHangDao khd = new KhachHangDao();
					if(khd.doiPass(khachHang)) {
						baoLoi="Mật khẩu đã thay đổi thành công";
						url="/doimatkhau.jsp";
					}else {
						baoLoi="Qúa trình đổi mật khẩu không thành côngg!";
						
						url="/doimatkhau.jsp";
						
					}
					
				}
			}
		}
		request.setAttribute("baoLoi", baoLoi);
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
