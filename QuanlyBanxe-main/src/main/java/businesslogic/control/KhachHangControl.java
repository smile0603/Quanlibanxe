package businesslogic.control;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.swing.table.DefaultTableModel;

import dao.HangSanXuatDao;
import dao.KhachHangDao;
import entity.KhachHang;

public class KhachHangControl {
	private KhachHangDao khachHangDao;

	public KhachHangControl() {

		khachHangDao = new KhachHangDao();
	}

	public boolean themKhachHang(KhachHang khachHang) {

		return khachHangDao.themKhachHang(khachHang);
	}

	public boolean xoaKhachHang(String makh) {

		return khachHangDao.xoaKhachHang(makh);
	}

	public boolean capnhatKhachHang(KhachHang khachHang) {

		return khachHangDao.capnhatKhachHang(khachHang);
	}

	public KhachHang layKhachHangById(String makh) {

		return khachHangDao.layKhachHangById(makh);
	}

	public int TongKhachHang() {

		return khachHangDao.TongKhachHang();
	}

	public int TongKhachNam() {

		return khachHangDao.TongKhachNam();
	}

	public int TongKhachNu() {

		return khachHangDao.TongKhachNu();
	}

	public DefaultTableModel timKiem(String id) {

		try {
			return khachHangDao.timKiem(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel getAllKH() {

		try {
			return khachHangDao.getAllKH();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public KhachHang getKhachHangTail() {
		return khachHangDao.getKhachHangTail();
	}

	public List<String> getListCMND() {

		return khachHangDao.getListCMND();
	}

	public KhachHang getKhachHangById(String string, String text) {

		return khachHangDao.getKhachHangById(string, text);
	}
}
