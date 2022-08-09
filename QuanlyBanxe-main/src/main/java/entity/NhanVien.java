package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4615855544025243531L;
	@Id
	private String maNhanVien;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String tenNhanVien;
	@Column(nullable = false,unique = true)
	private String CMND;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String gioiTinh;
	@Column(nullable = false)
	private Date ngaySinh;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String diaChi;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String sdt;
	@Column(nullable = false)
	private Date ngayVaoLam;
	
	@ManyToOne
	@JoinColumn(name="chucVuID")
	private ChucVu chucVu;
	
	@Embedded
	private TaiKhoan taiKhoan;
	
	@OneToMany(mappedBy = "nhanVien")
	private List<HopDong> listHopDong;
	
	
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	public NhanVien(String maNhanVien, String tenNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String cMND, String gioiTinh, Date ngaySinh, String diaChi,
			String email, String sdt, Date ngayVaoLam) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		CMND = cMND;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
		this.ngayVaoLam = ngayVaoLam;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, String cMND, String gioiTinh, Date ngaySinh, String diaChi,
			String email, ChucVu chucVu, String sdt, Date ngayVaoLam) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.CMND = cMND;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.chucVu = chucVu;
		this.sdt = sdt;
		this.ngayVaoLam = ngayVaoLam;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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

	public ChucVu getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	
	public List<HopDong> getListHopDong() {
		return listHopDong;
	}
	public void setListHopDong(List<HopDong> listHopDong) {
		this.listHopDong = listHopDong;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", CMND=" + CMND + ", gioiTinh="
				+ gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", email=" + email + ", sdt=" + sdt
				+ ", ngayVaoLam=" + ngayVaoLam + "]";
	}

}
