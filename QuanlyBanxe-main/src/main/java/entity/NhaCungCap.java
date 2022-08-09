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
public class NhaCungCap implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2285670180712097637L;
	@Id
	private String maNhaCungCap;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String tenNhaCungCap;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String diaChi;
	@Column(columnDefinition = "nvarchar(255)")
	private String chuThich;
	
	private String soDienThoai;
	
	private String email;
	
	@OneToMany(mappedBy = "nhaCungCap")
	private List<Xe> listXe;
	
	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String chuThich, String soDienThoai, String email) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.chuThich = chuThich;
		this.soDienThoai = soDienThoai;
		this.email= email;
	}

	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public NhaCungCap(String maNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
	}

	public NhaCungCap() {
		super();
	}

	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String nhaCungCap) {
		this.maNhaCungCap = nhaCungCap;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChuThich() {
		return chuThich;
	}
	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public List<Xe> getListXe() {
		return listXe;
	}

	public void setListXe(List<Xe> listXe) {
		this.listXe = listXe;
	}

	@Override
	public String toString() {
		return "NhaCungCap [nhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", diaChi=" + diaChi
				+ ", chuThich=" + chuThich + ", soDienThoai=" + soDienThoai + ", email=" + email + "]";
	}

	
	
}
