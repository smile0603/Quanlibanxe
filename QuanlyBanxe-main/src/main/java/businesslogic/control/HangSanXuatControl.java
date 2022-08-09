package businesslogic.control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import dao.HangSanXuatDao;
import entity.HangSanXuat;

public class HangSanXuatControl {
	private HangSanXuatDao hangSanXuatDao;

	public HangSanXuatControl() {

		hangSanXuatDao = new HangSanXuatDao();
	}

	public void getListHSX(String tenXe, JComboBox comboBox) {
		hangSanXuatDao.getListHSX(tenXe, comboBox);
	}

	public HangSanXuat getHangSanXuatById(String id) {
		return hangSanXuatDao.getHangSanXuatById(id);
	}

	public DefaultTableModel getAllHSX() {
		try {
			return hangSanXuatDao.getAllHSX();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel timKiem(String mahSX) {
		try {
			return hangSanXuatDao.timKiem(mahSX);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public boolean themHSX(HangSanXuat hsx) {
		return hangSanXuatDao.themHSX(hsx);
	}

	public boolean xoaHSX(String mahsx) {
		return hangSanXuatDao.xoaHSX(mahsx);
	}

	public boolean update(HangSanXuat hsx) {
		return hangSanXuatDao.update(hsx);
	}

	public ArrayList<String> getListTenHangSX() {

		return hangSanXuatDao.getListTenHangSX();
	}
}
