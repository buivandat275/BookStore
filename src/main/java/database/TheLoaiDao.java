package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDao {
		
		
		public ArrayList<TheLoai> selectTheLoai() {
			ArrayList<TheLoai> theloai = new ArrayList<TheLoai>();
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "select *from theloai";
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					String maTheLoai = rs.getString("matheloai");
					String tenTheLoai = rs.getString("tentheloai");
					
					TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
					theloai.add(tl);
				}
				JDBCUtil.closeConnection(con);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return theloai;
		}
		
		public TheLoai selectById(TheLoai id) {
			TheLoai tl = null;
			try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select *from theloai where matheloai=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id.getMaTheLoai());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString("matheloai");
				String tenTheLoai = rs.getString("tentheloai");
				
				tl = new TheLoai(maTheLoai, tenTheLoai);
				break;
			}
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return tl;
		}
		
		public int insert(TheLoai tl) {
			int ketqua = 0;
			try {
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into theloai(matheloai, tentheloai) values(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, tl.getMaTheLoai());
				st.setString(2, tl.getTenTheLoai());
				
				ketqua = st.executeUpdate();
				
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketqua;
	
		}
		
		public int insertAll(ArrayList<TheLoai> list) {
			int dem = 0;
			for (TheLoai theLoai : list) {
				dem += this.insert(theLoai);
			}
			return dem;
		}
		
		public int delete(TheLoai tl) {
			int ketqua = 0;
			try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from theloai where matheloai =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tl.getMaTheLoai());
			
			ketqua = st.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketqua;
		}
		
		public int deleteAll(ArrayList<TheLoai> list) {
			int dem = 0;
			for (TheLoai theLoai : list) {
				dem += this.delete(theLoai);
			}
			return dem;
		}
		
		
		public int update(TheLoai tl) {
			int ketqua = 0;
			try {
			Connection con = JDBCUtil.getConnection();
			String sql = "update theloai set tentheloai=? where matheloai = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tl.getTenTheLoai());
			st.setString(2, tl.getMaTheLoai());
			ketqua = st.executeUpdate();
		
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketqua;
			
		}
		
	public static void main(String[] args) {
		TheLoaiDao tld = new TheLoaiDao();
//		ArrayList<TheLoai> kq = tld.selectTheLoai();
//		for (TheLoai theLoai : kq) {
//			System.out.println(theLoai);
//		}
//		
//		TheLoai tl = tld.selectById(new TheLoai("tl1",null));
//		System.out.println(tl);
//	}
		
//		TheLoai tl = new TheLoai("tl6", "sach tinh yeu");
//		tld.insert(tl);
//		tld.delete(new TheLoai("tl6", null));

//		TheLoai tl = tld.selectById(new TheLoai("tl1", ""));
//		tl.setTenTheLoai("sach tham khao");
//		tld.update(tl);
	}
		
		
}		
