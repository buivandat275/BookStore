package model;

import java.util.Objects;

public class TheLoai {
	private String maTheLoai;
	private String tenTheLoai;
	public TheLoai() {
		super();
	}
	public TheLoai(String maTheLoai, String tenTheLoai) {
		super();
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
	}
	public String getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTheLoai, tenTheLoai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheLoai other = (TheLoai) obj;
		return Objects.equals(maTheLoai, other.maTheLoai) && Objects.equals(tenTheLoai, other.tenTheLoai);
	}
	@Override
	public String toString() {
		return "TheLoai [maTheLoai=" + maTheLoai + ", tenTheLoai=" + tenTheLoai + "]";
	}
	
	
	
}
