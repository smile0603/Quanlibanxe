package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class HoaDon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1943897316909128312L;
	@Id
	private String maHoaDon;
	
	@ManyToOne
	@JoinColumn(name="khachHangID")
	private KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(name="nhanVienID")
	private NhanVien nhanVien;
	@Column(nullable = false)
	private Date ngayLapHoaDon;
	@Column(nullable = false)
	private double tongTien;
	
	@OneToMany(mappedBy = "hoaDon")
	private List<ChiTietHoaDon> chiTietHoaDon;
    
	//private 
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	public HoaDon(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, Date ngayLapHoaDon, double tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tongTien = tongTien;
	}
	public HoaDon(String maHoaDon, Date ngayLapHoaDon, double tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tongTien = tongTien;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
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

	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	

	public List<ChiTietHoaDon> getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(List<ChiTietHoaDon> chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", tongTien=" + tongTien + "]";
	}



}
