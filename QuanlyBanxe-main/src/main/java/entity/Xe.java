package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Xe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7045615925609020147L;
	@Id
	private String maXe;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String tenXe;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String phienBan;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String mauXe;
	@Column(nullable = false)
	private int phanKhoi;
	@Column(nullable = false ,unique = true)
	private String soKhung;
	@Column(nullable = false ,unique = true)
	private String soMay;
	@Column(nullable = false)
	private double giaNhap;
	@Column(nullable = false)
	private Date ngayNhap;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	@Column(columnDefinition = "nvarchar(255)")
	private String chuThich;
	@Column(nullable = false)
	private String img1;
	
	@ManyToOne
	@JoinColumn(name="nhaCungCapID")
	private NhaCungCap nhaCungCap;
	
	@ManyToOne
	@JoinColumn(name="hangSanXuatID")
	private HangSanXuat hangSanXuat;
	
	@ManyToOne
	@JoinColumn(name="loaiXeID")
	private LoaiXe loaiXe;
	
	@OneToMany(mappedBy = "xe")
	private List<ChiTietHoaDon> chiTietHoaDon;
	
	public Xe(String maXe) {
		super();
		this.maXe = maXe;
	}

	public Xe(String maXe, String tenXe) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
	}

	public Xe(String maXe, String tenXe, LoaiXe loaiXe, String mauXe, int phanKhoi, double giaNhap) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.mauXe = mauXe;
		this.phanKhoi = phanKhoi;
		this.giaNhap = giaNhap;
		this.loaiXe = loaiXe;
	}
	

	public Xe(String maXe, String tenXe, String phienBan, String mauXe, int phanKhoi, String soKhung, String soMay,
			double giaNhap, Date ngayNhap, String trangThai, String chuThich, String img1) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.phienBan = phienBan;
		this.mauXe = mauXe;
		this.phanKhoi = phanKhoi;
		this.soKhung = soKhung;
		this.soMay = soMay;
		this.giaNhap = giaNhap;
		this.ngayNhap = ngayNhap;
		this.trangThai = trangThai;
		this.chuThich = chuThich;
		this.img1 = img1;
	}

	public Xe(String maXe, String tenXe, LoaiXe loaiXe, String phienBan, String mauXe, NhaCungCap nhaCungCap,
			HangSanXuat hangSanXuat, int phanKhoi, String soKhung, String soMay, double giaNhap, Date ngayNhap,
			String trangThai, String chuThich, String img1) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.loaiXe = loaiXe;
		this.phienBan = phienBan;
		this.mauXe = mauXe;
		this.nhaCungCap = nhaCungCap;
		this.hangSanXuat = hangSanXuat;
		this.phanKhoi = phanKhoi;
		this.soKhung = soKhung;
		this.soMay = soMay;
		this.giaNhap = giaNhap;
		this.ngayNhap = ngayNhap;
		this.trangThai = trangThai;
		this.chuThich = chuThich;
		this.img1 = img1;
	}

	public Xe(String maXe, String soKhung, String soMay) {
		super();
		this.maXe = maXe;
		this.soKhung = soKhung;
		this.soMay = soMay;
	}


	public Xe() {
		super();
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public LoaiXe getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}

	public String getPhienBan() {
		return phienBan;
	}

	public void setPhienBan(String phienBan) {
		this.phienBan = phienBan;
	}

	public String getMauXe() {
		return mauXe;
	}

	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}

	public int getPhanKhoi() {
		return phanKhoi;
	}

	public void setPhanKhoi(int phanKhoi) {
		this.phanKhoi = phanKhoi;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getSoKhung() {
		return soKhung;
	}

	public void setSoKhung(String soKhung) {
		this.soKhung = soKhung;
	}

	public String getSoMay() {
		return soMay;
	}

	public void setSoMay(String soMay) {
		this.soMay = soMay;
	}
	

	public List<ChiTietHoaDon> getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(List<ChiTietHoaDon> chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public double getDonGia() {
		if (getGiaNhap() < 20000000)
			return getGiaNhap() * 110 / 100;
		else if (getGiaNhap() < 40000000)
			return getGiaNhap() * 115 / 100;
		else if (getGiaNhap() < 80000000)
			return getGiaNhap() * 120 / 100;
		else if (getGiaNhap() < 1000000000)
			return getGiaNhap() * 125 / 100;
		else
			return getGiaNhap() * 130 / 100;
	}
	public double getThueVAT() {
		if (getGiaNhap() < 20000000)
			return getGiaNhap() * 5 / 100;
		else if (getGiaNhap() < 40000000)
			return getGiaNhap() * 8 / 100;
		else if (getGiaNhap() < 60000000)
			return getGiaNhap() * 10 / 100;
		else if (getGiaNhap() < 100000000)
			return getGiaNhap() * 0.12;
		else
			return getGiaNhap() * 15 / 100;
	}
	public double getThanhTien() {
		return getDonGia() + getThueVAT();
	}
	@Override
	public String toString() {
		return "Xe [maXe=" + maXe + ", tenXe=" + tenXe + ", phienBan=" + phienBan + ", mauXe=" + mauXe + ", phanKhoi="
				+ phanKhoi + ", soKhung=" + soKhung + ", soMay=" + soMay + ", giaNhap=" + giaNhap + ", ngayNhap="
				+ ngayNhap + ", trangThai=" + trangThai + ", chuThich=" + chuThich + ", img1=" + img1 + "]";
	}
}
