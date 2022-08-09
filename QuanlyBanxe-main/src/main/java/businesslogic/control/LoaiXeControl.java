package businesslogic.control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityTransaction;
import javax.swing.table.DefaultTableModel;

import dao.HangSanXuatDao;
import dao.LoaiXeDao;
import entity.LoaiXe;

public class LoaiXeControl {
	private LoaiXeDao loaiXeDao;

	public LoaiXeControl() {

		loaiXeDao = new LoaiXeDao();
	}

	public boolean themLoaiXe(LoaiXe loaiXe) {
		return loaiXeDao.themLoaiXe(loaiXe);
	}

	public boolean xoaLoaiXe(String makh) {
		return loaiXeDao.xoaLoaiXe(makh);
	}

	public boolean capnhatLoaiXe(LoaiXe loaiXe) {
		return loaiXeDao.capnhatLoaiXe(loaiXe);
	}

	public LoaiXe layLoaiXeById(String makh) {

		return loaiXeDao.layLoaiXeById(makh);
	}

	public DefaultTableModel getAllLX() {

		try {
			return loaiXeDao.getAllLX();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel timKiem(String id) {

		try {
			return loaiXeDao.timKiem(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public String getLoaiXeTail() {

		return loaiXeDao.getLoaiXeTail();
	}

	public ArrayList<String> getListTenLoaiXe() {

		return loaiXeDao.getListTenLoaiXe();
	}

	public ArrayList<String> getListMaLoaiXe() {

		return loaiXeDao.getListMaLoaiXe();
	}
}
