package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SanPham;
import model.TacGia;
import model.TheLoai;
public class SanPhamDao {
		public ArrayList<SanPham> selectAll() {
			ArrayList<SanPham> sanPhams = new ArrayList<SanPham>();
			try {
				Connection con = JDBCUtil.getConnection();
				String sql  = "select * from sanpham ";
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					String maSanPhan = rs.getString("masanpham");
					String tenSanPham = rs.getString("tensanpham");
					String maTacGia = rs.getString("matacgia");
					int namSanXuat = rs.getInt("namsanxuat");
					Double giaNhap = rs.getDouble("gianhap");
					Double giaGoc = rs.getDouble("giagoc");
					Double giaBan = rs.getDouble("giaban");
					int soLuong = rs.getInt("soluong");
					String maTheLoai = rs.getString("matheloai");
					String moTa= rs.getString("mota");
					String ngonNgu = rs.getString("ngonngu");
					
					TacGia tacgia = new TacGiaDao().selectById(new TacGia(maTacGia, "", null, ""));
					TheLoai theloai = new TheLoaiDao().selectById(new TheLoai(maTheLoai,""));

					SanPham sp = new SanPham(maSanPhan, tenSanPham, tacgia, namSanXuat,giaNhap,giaGoc,giaBan,soLuong, theloai, moTa,ngonNgu);
					sanPhams.add(sp);
					
				
				}
			JDBCUtil.closeConnection(con);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return sanPhams;
		}

		public SanPham selectById(SanPham id) {
			SanPham ketqua = null;
			try {
				Connection con = JDBCUtil.getConnection();
				String sql  = "select * from sanpham where masanpham = ? ";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, id.getMaSanPham());
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					String maSanPhan = rs.getString("masanpham");
					String tenSanPham = rs.getString("tensanpham");
					String maTacGia = rs.getString("matacgia");
					int namSanXuat = rs.getInt("namsanxuat");
					Double giaNhap = rs.getDouble("gianhap");
					Double giaGoc = rs.getDouble("giagoc");
					Double giaBan = rs.getDouble("giaban");
					int soLuong = rs.getInt("soluong");
					String maTheLoai = rs.getString("matheloai");
					String moTa= rs.getString("mota");
					String ngonNgu = rs.getString("ngonngu");
					
					TacGia tacgia = new TacGiaDao().selectById(new TacGia(maTacGia, "", null, ""));
					TheLoai theloai = new TheLoaiDao().selectById(new TheLoai(maTheLoai,""));

					ketqua =new SanPham(maSanPhan, tenSanPham, tacgia, namSanXuat,giaNhap,giaGoc,giaBan,soLuong, theloai, moTa,ngonNgu);
					break;
					
				
				}
			JDBCUtil.closeConnection(con);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return ketqua;
		}
			
			
		

		public int insertAll(ArrayList<SanPham> list) {
			int dem = 0;
			for (SanPham sanPham : list) {
				dem += this.insert(sanPham);
			}
			return dem;
		}

		public int insert(SanPham sp) {
			int ketQua = 0;
			try {
				Connection con = JDBCUtil.getConnection();

				String sql = "INSERT INTO sanpham (masanpham,tensanpham, matacgia, namxuatban,gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, sp.getMaSanPham());
				st.setString(2, sp.getTenSanPham());
				st.setString(3,sp.getTacGia().getMaTacGia());
				st.setInt(4,sp.getNamSanXuat());
				st.setDouble(5,sp.getGiaNhap());
				st.setDouble(6,sp.getGiaGoc());
				st.setDouble(7,sp.getGiaBan());
				st.setInt(8,sp.getSoLuong());
				st.setString(9,sp.getTheLoai().getMaTheLoai());
				st.setString(10,sp.getNgonNgu());
				st.setString(11,sp.getMoTa());

				ketQua = st.executeUpdate();

				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ketQua;
		}

		public int delete(SanPham t) {
			int ketQua = 0;
			try {
				Connection con = JDBCUtil.getConnection();

				String sql = "DELETE from sanpham " + " WHERE masanpham=?";

				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaSanPham());

				System.out.println(sql);
				ketQua = st.executeUpdate();
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ketQua;
		}

		public int deleteAll(ArrayList<SanPham> arr) {
			int dem = 0;
			for (SanPham SanPham : arr) {
				dem += this.delete(SanPham);
			}
			return dem;
		}

		public int update(SanPham t) {
			int ketQua = 0;
			try {
				Connection con = JDBCUtil.getConnection();

				String sql = "UPDATE sanpham " + " SET " + "tensanpham=?, matacgia=?, namxuatban=?, gianhap=?, giagoc=?, "
						+ "giaban=?, soluong=?, matheloai=?, ngonngu=?, mota=?" + " WHERE masanpham=?";

				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getTenSanPham());
				st.setString(2, t.getTacGia().getMaTacGia());
				st.setInt(3, t.getNamSanXuat());
				st.setDouble(4, t.getGiaNhap());
				st.setDouble(5, t.getGiaGoc());
				st.setDouble(6, t.getGiaBan());
				st.setInt(7, t.getSoLuong());
				st.setString(8, t.getTheLoai().getMaTheLoai());
				st.setString(9, t.getNgonNgu());
				st.setString(10, t.getMoTa());
				st.setString(11, t.getMaSanPham());

				System.out.println(sql);
				ketQua = st.executeUpdate();

				System.out.println("Bạn đã thực thi: " + sql);
				System.out.println("Có " + ketQua + " dòng bị thay đổi!");

				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ketQua;
		}

		public static void main(String[] args) {
			SanPhamDao spd = new SanPhamDao();
//			ArrayList<SanPham> sp = spd.selectAll();
//			for (SanPham sanPham : sp) {
//				System.out.println(sanPham);
//			}
//			SanPham sp = spd.selectById(new SanPham("001", null, null, 0, 0, 0, 0, 0, null, null, null));
//			System.out.println(sp);
			
			
		}
}
