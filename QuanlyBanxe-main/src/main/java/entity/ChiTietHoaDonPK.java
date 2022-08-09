package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212309762319588057L;
	private String hoaDon;
	private String xe;
	public ChiTietHoaDonPK() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDon == null) ? 0 : hoaDon.hashCode());
		result = prime * result + ((xe == null) ? 0 : xe.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDonPK other = (ChiTietHoaDonPK) obj;
		if (hoaDon == null) {
			if (other.hoaDon != null)
				return false;
		} else if (!hoaDon.equals(other.hoaDon))
			return false;
		if (xe == null) {
			if (other.xe != null)
				return false;
		} else if (!xe.equals(other.xe))
			return false;
		return true;
	}
	
}
