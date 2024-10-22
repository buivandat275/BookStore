package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDao {
	
	
	
	public ArrayList<TacGia> selectAll(){
		 ArrayList<TacGia> data = new ArrayList<TacGia>();
		 
		 try {
			 Connection con = JDBCUtil.getConnection();
			 
			 String sql ="select *from tacgia";
			 PreparedStatement st = con.prepareStatement(sql);
			 
			 System.out.println(sql);
			 ResultSet rs = st.executeQuery();
			 
			 while (rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hoten");
				Date ngaySinh = rs.getDate("date");
				String tieuSu = rs.getString("tieusu");
				
				TacGia tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				data.add(tg);
			 }
			 JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return data;
	}
	
	public TacGia selectById(TacGia id) {
		TacGia tg = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select *from tacgia where matacgia=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id.getMaTacGia());
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hoten");
				Date ngaySinh = rs.getDate("date");
				String tieuSu = rs.getString("tieusu");
				tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				break;
			}
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return tg;
		
	}
	
	public int insert(TacGia tg) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into tacgia (matacgia,hoten,date,tieusu) values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tg.getMaTacGia());
			st.setString(2, tg.getHoVaTen());
			st.setDate(3 ,tg.getNgaySinh());
			st.setString(4, tg.getTieuSu());
			ketqua = st.executeUpdate();
			
			
				JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketqua;
	}
	
	public int insertAll(ArrayList<TacGia> list) {
		int dem = 0;
		for (TacGia tacGia : list) {
			dem+= this.insert(tacGia);
		}
		return dem;
	}
	public int delete(TacGia tg) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE from tacgia "+
					 " WHERE matacgia=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tg.getMaTacGia());
			System.out.println(sql);
			ketQua = st.executeUpdate();
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	public int deleteAll(ArrayList<TacGia> list) {
		int dem = 0;
		for (TacGia tacGia : list) {
			dem+= this.delete(tacGia);
		}
		return dem;
	}
	
	public int update(TacGia tg) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE tacgia "+
					 " SET " +
					 " hoten=?"+
					 ", date=?"+
					 ", tieusu=?"+
					 " WHERE matacgia=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tg.getHoVaTen());
			st.setDate(2, tg.getNgaySinh());
			st.setString(3, tg.getTieuSu());
			st.setString(4, tg.getMaTacGia());

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	public static void main(String[] args) {
		TacGiaDao tgd = new TacGiaDao();
		ArrayList<TacGia> kq = tgd.selectAll();
		for (TacGia tacGia : kq) {
			System.out.println(tacGia);
		}
//		TacGia tl = new TacGia("7","duc van chu",new Date(2011-1999, 6, 3), "hoi dep");
//		tgd.insert(tl);
//		tgd.delete(new TacGia("6","",null,""));
		
//		TacGia tg = tgd.selectById(new TacGia("1","",null,""));
//		System.out.println(tg);
//		tg.setTieuSu("hoi xau trai");
//		tgd.update(tg);
		
	}
	

}
