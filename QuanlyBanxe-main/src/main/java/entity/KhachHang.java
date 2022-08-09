package entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2346356800806298062L;
	@Id
	private String maKhachHang;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String tenKhachHang;
	@Column(nullable = false,unique = true)
	private String CMND;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String gioiTinh;
	
	private Date ngaySinh;
	@Column(nullable = false)
	private Date ngaygiaNhap;
	@Column(columnDefinition = "nvarchar(255)")
	private String diaChi;
	
	private String email;
	
	private String soDienThoai;
	@Column(columnDefinition = "nvarchar(255)")
	private String chuThich;
	
	@OneToMany(mappedBy = "khachHang")
	private List<HopDong> listHopDong;
	
	@OneToMany(mappedBy = "khachHang")
	private List<HoaDon> listHoaDon;
	public KhachHang() {
		super();
	}
	
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}



	public KhachHang(String tenKhachHang, String cMND) {
		super();
		this.tenKhachHang = tenKhachHang;
		CMND = cMND;
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String cMND, Date ngaySinh ,String diaChi,
			String soDienThoai) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		CMND = cMND;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	
	public KhachHang(String maKhachHang, String tenKhachHang, String cMND, String gioiTinh, Date ngaySinh,
			Date ngaygiaNhap, String diaChi, String email, String soDienThoai, String chuThich) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		CMND = cMND;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngaygiaNhap = ngaygiaNhap;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.chuThich = chuThich;
	}
	
	
	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Date getNgaygiaNhap() {
		return ngaygiaNhap;
	}

	public void setNgaygiaNhap(Date ngaygiaNhap) {
		this.ngaygiaNhap = ngaygiaNhap;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	

	public List<HopDong> getListHopDong() {
		return listHopDong;
	}

	public void setListHopDong(List<HopDong> listHopDong) {
		this.listHopDong = listHopDong;
	}

	public List<HoaDon> getListHoaDon() {
		return listHoaDon;
	}

	public void setListHoaDon(List<HoaDon> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", CMND=" + CMND
				+ ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", ngaygiaNhap=" + ngaygiaNhap + ", diaChi="
				+ diaChi + ", email=" + email + ", soDienThoai=" + soDienThoai + ", chuThich=" + chuThich + "]";
	}


	
}
