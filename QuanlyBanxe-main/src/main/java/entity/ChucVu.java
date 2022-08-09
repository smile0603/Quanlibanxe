
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
public class ChucVu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3551915983176753766L;
	@Id
	private String maChucVu;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String tenChucVu;

	@OneToMany(mappedBy = "chucVu")
	private List<NhanVien> dsNhanVien;
	
	public List<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}
	public void setDsNhanVien(List<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}
	public ChucVu() {
	}
	public ChucVu(String maChucVu) {
		super();
		this.maChucVu = maChucVu;
	}
	public String getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	public ChucVu(String maChucVu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	@Override
	public String toString() {
		return "ChucVu [maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + "]";
	}
	
}
