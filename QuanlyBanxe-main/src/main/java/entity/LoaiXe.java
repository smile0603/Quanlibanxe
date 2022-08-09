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
public class LoaiXe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3570444599467553318L;
	@Id
	private String maLoaiXe;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String tenLoaiXe;
	
	@OneToMany(mappedBy = "loaiXe")
	private List<Xe> dsXe;
	
	public LoaiXe(String tenLoaiXe) {
		super();
		this.tenLoaiXe = tenLoaiXe;
	}
	public LoaiXe(String maLoaiXe, String tenLoaiXe) {
		super();
		this.maLoaiXe = maLoaiXe;
		this.tenLoaiXe = tenLoaiXe;
	}
	public LoaiXe() {
		super();
	}
	public String getMaLoaiXe() {
		return maLoaiXe;
	}
	public void setMaLoaiXe(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}
	public String getTenLoaiXe() {
		return tenLoaiXe;
	}
	public void setTenLoaiXe(String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
	}
	
	public List<Xe> getDsXe() {
		return dsXe;
	}
	public void setDsXe(List<Xe> dsXe) {
		this.dsXe = dsXe;
	}
	@Override
	public String toString() {
		return "LoaiXe [maLoaiXe=" + maLoaiXe + ", tenLoaiXe=" + tenLoaiXe + "]";
	}
	
}
