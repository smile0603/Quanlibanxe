package businesslogic.control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.HangSanXuatDao;
import dao.NhaCungCapDao;
import entity.NhaCungCap;

public class NhaCungCapControl {
	private NhaCungCapDao nhaCungCapDao;

	public NhaCungCapControl() {

		nhaCungCapDao = new NhaCungCapDao();
	}

	public NhaCungCap getTenNhaCCById(String ID) {

		return nhaCungCapDao.getTenNhaCCById(ID);
	}

	public ArrayList<String> getListSuppilerName() {

		return nhaCungCapDao.getListSuppilerName();
	}

	public DefaultTableModel getAllNCC() {

		try {
			return nhaCungCapDao.getAllNCC();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel timKiem(String maNCC) {

		try {
			return nhaCungCapDao.timKiem(maNCC);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public boolean themNCC(NhaCungCap ncc) {

		return nhaCungCapDao.themNCC(ncc);
	}

	public void xoaNCC(String maNCC) {
		nhaCungCapDao.xoaNCC(maNCC);
	}

	public boolean update(NhaCungCap ncc) {

		return nhaCungCapDao.update(ncc);
	}

	public int demNhaCungCap() {

		return nhaCungCapDao.demNhaCungCap();
	}

	public ArrayList<String> getListTenNhaCC() {

		return nhaCungCapDao.getListTenNhaCC();
	}
}
