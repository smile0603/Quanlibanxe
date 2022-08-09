package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ChiTietHoaDonPK.class)
public class ChiTietHoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8178492503096605356L;
	@Id
	@ManyToOne
	@JoinColumn(name="hoaDonID")
	private HoaDon hoaDon;
	@Id
	@ManyToOne
	@JoinColumn(name="xeID")
	private Xe xe;
	@Column(nullable = false)
	private double donGia;
	@Column(nullable = false)
	private double ThueVAT;
	
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public Xe getXe() {
		return xe;
	}
	public void setXe(Xe xe) {
		this.xe = xe;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getThueVAT() {
		return ThueVAT;
	}
	public void setThueVAT(double thueVAT) {
		ThueVAT = thueVAT;
	}
	public ChiTietHoaDon(HoaDon hoaDon, Xe xe, double donGia, double thueVAT) {
		super();
		this.hoaDon = hoaDon;
		this.xe = xe;
		this.donGia = donGia;
		ThueVAT = thueVAT;
	}
	public ChiTietHoaDon() {
		super();
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon.getMaHoaDon() + ", xe=" + xe.getMaXe() + ", donGia=" + donGia + ", ThueVAT=" + ThueVAT + "]";
	}
	
}
