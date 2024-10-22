package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;
import model.SanPham;

public class ChiTietDonHangDao {

	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> ketQua = new ArrayList<ChiTietDonHang>();

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM chitietdonhang";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maChiTietDonHang = rs.getString("machitietdonhang");
				String donhang = rs.getString("donhang");
				String sanpham = rs.getString("sanpham");
				double soluong = rs.getDouble("soluong");
				double giagoc = rs.getDouble("giagoc");
				double giamgia = rs.getDouble("giamgia");
				double giaban = rs.getDouble("giaban");
				double thuevat = rs.getDouble("thuevat");
				double tongtien = rs.getDouble("tongtien");

				DonHang dh = new DonHangDao().selectById(new DonHang(donhang, null, "", "", "", "", "", 0, 0, null, null));
				SanPham sp = new SanPhamDao().selectById(new SanPham("", "", null, 0, 0, 0, 0, 0, null, "", ""));

				ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, dh, sp, soluong, giagoc, giamgia, giaban,
						thuevat, tongtien);
				ketQua.add(ctdh);
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public ChiTietDonHang selectById(ChiTietDonHang t) {
		ChiTietDonHang ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM chitietdonhang WHERE machitietdonhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHang());

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maChiTietDonHang = rs.getString("machitietdonhang");
				String donhang = rs.getString("donhang");
				String sanpham = rs.getString("sanpham");
				double soluong = rs.getDouble("soluong");
				double giagoc = rs.getDouble("giagoc");
				double giamgia = rs.getDouble("giamgia");
				double giaban = rs.getDouble("giaban");
				double thuevat = rs.getDouble("thuevat");
				double tongtien = rs.getDouble("tongtien");

				DonHang dh = new DonHangDao().selectById(new DonHang(donhang, null, "", "", "", "", "", 0, 0, null, null));
				SanPham sp = new SanPhamDao().selectById(new SanPham(sanpham, "", null, 0, 0, 0, 0, 0, null, "", ""));

				ketQua = new ChiTietDonHang(maChiTietDonHang, dh, sp, soluong, giagoc, giamgia, giaban, thuevat,
						tongtien);
				break;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public int insert(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO chitietdonhang (machitietdonhang, donhang,sanpham, soluong, giagoc,giamgia,giaban,thuevat,tongtien) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHang());
			st.setString(2, t.getDonHang().getMaDonHang());
			st.setString(3, t.getSanPham().getMaSanPham());
			st.setDouble(4, t.getSoLuong());
			st.setDouble(5, t.getGiaGoc());
			st.setDouble(7, t.getGiamGia());
			st.setDouble(6, t.getGiaBan());
			st.setDouble(8, t.getThueVAT());
			st.setDouble(9, t.getTongTien());
			ketQua = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public int insertAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : arr) {
			dem += this.insert(ChiTietDonHang);
		}
		return dem;
	}

	public int delete(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from chitietdonhang " + " WHERE machitietdonhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHang());

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

	public int deleteAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : arr) {
			dem += this.delete(ChiTietDonHang);
		}
		return dem;
	}

	public int update(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE chitietdonhang SET donhang=?, sanpham=?, soluong=?, giagoc=?, giamgia=?, giaban=?, thuevat=?, tongtien=?"
					+ " WHERE machitietdonhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getDonHang().getMaDonHang());
			st.setString(2, t.getSanPham().getMaSanPham());
			st.setDouble(3, t.getSoLuong());
			st.setDouble(4, t.getGiaGoc());
			st.setDouble(5, t.getGiamGia());
			st.setDouble(6, t.getGiaBan());
			st.setDouble(7, t.getThueVAT());
			st.setDouble(8, t.getTongTien());
			st.setString(9, t.getMaChiTietDonHang());


			System.out.println(sql);
			ketQua = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
}
