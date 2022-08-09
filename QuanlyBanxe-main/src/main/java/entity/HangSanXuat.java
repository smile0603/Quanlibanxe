package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HangSanXuat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1941280344852213508L;
	@Id
	private String maHangSX;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String tenHangSX;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String quocGia;
	
	@OneToMany(mappedBy = "hangSanXuat")
	private List<Xe> dsXe;
	
	public List<Xe> getDsXe() {
		return dsXe;
	}
	public void setDsXe(List<Xe> dsXe) {
		this.dsXe = dsXe;
	}
	public HangSanXuat(String maHangSX) {
		super();
		this.maHangSX = maHangSX;
	}
	public HangSanXuat() {
		super();
	}
	public HangSanXuat(String maHangSX, String tenHangSX) {
		super();
		this.maHangSX = maHangSX;
		this.tenHangSX = tenHangSX;
	}
	
	public HangSanXuat(String maHangSX, String tenHangSX, String quocGia) {
		super();
		this.maHangSX = maHangSX;
		this.tenHangSX = tenHangSX;
		this.quocGia = quocGia;
	}
	public String getMaHangSX() {
		return maHangSX;
	}
	public void setMaHangSX(String maHangSX) {
		this.maHangSX = maHangSX;
	}
	public String getTenHangSX() {
		return tenHangSX;
	}
	public void setTenHangSX(String tenHangSX) {
		this.tenHangSX = tenHangSX;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	@Override
	public String toString() {
		return "HangSanXuat [maHangSX=" + maHangSX + ", tenHangSX=" + tenHangSX + ", quocGia=" + quocGia + "]";
	}
	
	
}
