package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.KhachHang;
import model.TacGia;
import model.TheLoai;

public class KhachHangDao {
	
	
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM khachhang";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hoVaTen");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");

				KhachHang kh = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi,
						diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
				ketQua.add(kh);
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM khachhang WHERE makhachhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhacHang());

			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			

			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");

				ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
						diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public KhachHang selectByUserNameAndPassWord(KhachHang t) {
		KhachHang ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM khachhang WHERE tendangnhap=? and matkhau=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenDangNhap());
			st.setString(2, t.getMatKhau());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");

				ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
						diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, hovaten, gioitinh, diachi, diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkynhanbangtin) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhacHang());
			st.setString(2, t.getTenDangNhap());
			st.setString(3, t.getMatKhau());
			st.setString(4, t.getHoVaTen());
			st.setString(5, t.getGioiTinh());
			st.setString(6, t.getDiaChi());
			st.setString(7, t.getDiaChiNhanHang());
			st.setString(8, t.getDiaChiMuaHang());
			st.setDate(9, t.getNgaySinh());
			st.setString(10, t.getSoDienThoai());
			st.setString(11, t.getEmail());
			st.setBoolean(12, t.isDangKyNhanBangTin());

			ketQua = st.executeUpdate();

			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public int insertAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang KhachHang : arr) {
			dem += this.insert(KhachHang);
		}
		return dem;
	}

	public int delete(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from khachhang " + " WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKhacHang());

			System.out.println(sql);
			ketQua = st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public int deleteAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang KhachHang : arr) {
			dem += this.delete(KhachHang);
		}
		return dem;
	}
	

	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE khachhang  SET tendangnhap=?, matkhau=?, hovaten=?, gioitinh=?"
					+ ", diachi=?, diachinhanhang=?, diachimuahang=?, ngaysinh=?, sodienthoai=?"
					+ ", email=?, dangkynhanbangtin=? WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenDangNhap());
			st.setString(2, t.getMatKhau());
			st.setString(3, t.getHoVaTen());
			st.setString(4, t.getGioiTinh());
			st.setString(5, t.getDiaChi());
 			st.setString(6, t.getDiaChiNhanHang());
			st.setString(7, t.getDiaChiMuaHang());
			st.setDate(8, t.getNgaySinh());
			st.setString(9, t.getSoDienThoai());
			st.setString(10, t.getEmail());
			st.setBoolean(11, t.isDangKyNhanBangTin());
			st.setString(12, t.getMaKhacHang());

			System.out.println(sql);
			ketQua = st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public int updateInfo(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE khachhang  SET  hovaten=?, gioitinh=?"
					+ ", diachi=?, diachinhanhang=?, diachimuahang=?, ngaysinh=?, sodienthoai=?"
					+ ", email=?, dangkynhanbangtin=? WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getHoVaTen());
			st.setString(2, t.getGioiTinh());
			st.setString(3, t.getDiaChi());
 			st.setString(4, t.getDiaChiNhanHang());
			st.setString(5, t.getDiaChiMuaHang());
			st.setDate(6, t.getNgaySinh());
			st.setString(7, t.getSoDienThoai());
			st.setString(8, t.getEmail());
			st.setBoolean(9, t.isDangKyNhanBangTin());
			st.setString(10, t.getMaKhacHang());

			System.out.println(sql);
			ketQua = st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public boolean doiPass(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE khachhang  SET  matkhau=? WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMatKhau());
			st.setString(2, t.getMaKhacHang());

			System.out.println(sql);
			ketQua = st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua>0;
	}
	
	public boolean kiemTraTenDangNhap(String tenDangNhap) {
		boolean ketQua = false;
		try {
			Connection con = JDBCUtil.getConnection();
			if (con == null) {
			    System.out.println("Kết nối cơ sở dữ liệu thất bại");
			    return false;  // hoặc xử lý tùy ý
			}
			String sql = "SELECT * FROM khachhang WHERE tenDangNhap=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tenDangNhap);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				ketQua= true;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
//	public static void main(String[] args) {
	//	KhachHangDao khd = new KhachHangDao();
//		ArrayList<KhachHang> kq = khd.selectAll();
//		for (KhachHang khachHang : kq) {
//			System.out.println(khachHang);
//		}
		//KhachHang kh = new KhachHang("002", "uer4", "123", "bui van", "nam", "123LN", "123LN", "123LN", null, "0238828828", "bui22@gmail.com", false);
			//	khd.insert(kh);
//		khd.delete(new KhachHang("001", null, null, null, null, null, null, null, null, null, null, false));		
//				
//		TacGia tg = tgd.selectById(new TacGia("1","",null,""));
//		System.out.println(tg);
//		tg.setTieuSu("hoi xau trai");
//		tgd.update(tg);
//		KhachHang kh1= khd.selectById(new KhachHang("KH001", "", "", "", "", "", "", "", null, "", "", true));
//		System.out.println(kh1);
//		kh1.setEmail("bvdat22@gmail.com");
//		khd.update(kh1);
//		 String tenDangNhap = "user1"; // bạn có thể thay thế bằng tên đăng nhập bạn muốn kiểm tra
//
//	        // Gọi hàm kiemTraTenDangNhap
//	        boolean ketQua = khd.kiemTraTenDangNhap(tenDangNhap);
//
//	        // In ra kết quả kiểm tra
//	        if (ketQua) {
//	            System.out.println("Tên đăng nhập " + tenDangNhap + " tồn tại.");
//	        } else {
//	            System.out.println("Tên đăng nhập " + tenDangNhap + " không tồn tại.");
//	        }
//}
	
}
