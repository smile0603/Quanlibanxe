package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HopDong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8255864322728722975L;
	@Id
	private String maHD;
	@Column(nullable = false)
	private Date ngayLap;
	@Column(nullable = false)
	private int thoiGianBaoHanh;
	
	@ManyToOne
	@JoinColumn(name="khachHangID")
	private KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(name="nhanVienID")
	private NhanVien nhanVien;
	
	@ManyToOne
	@JoinColumn(name="xeID")
	private Xe xe;
	
	public HopDong() {
		super();
		
	}
	public HopDong(String maHD) {
		super();
		this.maHD = maHD;
	}
	
	public HopDong(String maHD, KhachHang khachHang, NhanVien nhanVien, Xe xe, Date ngayLap, int thoiGianBaoHanh) {
		super();
		this.maHD = maHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.xe = xe;		
		this.ngayLap = ngayLap;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	


	public HopDong(String maHD, KhachHang khachHang, Xe xe, Date ngayLap, int thoiGianBaoHanh) {
		super();
		this.maHD = maHD;
		this.khachHang = khachHang;
		this.xe = xe;
		this.ngayLap = ngayLap;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public HopDong(String maHD, Date ngayLap, int thoiGianBaoHanh) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Xe getXe() {
		return xe;
	}
	public void setXe(Xe xe) {
		this.xe = xe;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	@Override
	public String toString() {
		return "HopDong [maHD=" + maHD + ", ngayLap=" + ngayLap + ", thoiGianBaoHanh=" + thoiGianBaoHanh + "]";
	}
	
	
	
}