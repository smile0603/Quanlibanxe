package entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


@Embeddable
public class TaiKhoan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5919529340128158866L;
	
	private String tenTaiKhoan;

	private String matKhau;
	@Column(columnDefinition = "nvarchar(255)")
	private String quyen;
	@Column(columnDefinition = "nvarchar(255)")
	private String chuThich;
	
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public TaiKhoan() {
		super();
	}
	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	public TaiKhoan(String tenTaiKhoan, String matKhau, String quyen, String chuThich) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.quyen = quyen;
		this.chuThich = chuThich;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", quyen=" + quyen + ", chuThich="
				+ chuThich + "]";
	}

	

}
