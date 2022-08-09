package businesslogic.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.HangSanXuatDao;
import dao.NhaCungCapDao;
import dao.NhanVienDao;
import entity.ChucVu;
import entity.HoaDon;
import entity.NhanVien;

public class NhanVienControl {
	private NhanVienDao nhanVienDao;

	public NhanVienControl() {

		nhanVienDao = new NhanVienDao();
	}

	public boolean themNhanVien(NhanVien nhanVien) {

		return nhanVienDao.themNhanVien(nhanVien);
	}

	public boolean xoaNhanVien(String manv) {

		return nhanVienDao.xoaNhanVien(manv);
	}

	public boolean capnhatNhanVien(NhanVien nhanVien) {

		return nhanVienDao.capnhatNhanVien(nhanVien);
	}

	public NhanVien layNhanVienById(String manv) {

		return nhanVienDao.layNhanVienById(manv);
	}

	public String getTenNhanVienById(String ID) {

		return nhanVienDao.getTenNhanVienById(ID);
	}

	public DefaultTableModel getAllNV() {

		try {
			return nhanVienDao.getAllNV();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel timKiem(String id, String sdt) {

		try {
			return nhanVienDao.timKiem(id, sdt);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public String getMaHDTail(String properties, String table) {

		return nhanVienDao.getMaHDTail(properties, table);
	}

	public NhanVien Login(String username, String password) {
		return nhanVienDao.Login(username, password);
	}

	public NhanVien getNhanVienById(String properties, String ID) {
		return nhanVienDao.getNhanVienById(properties, ID);
	}

	public ArrayList<ChucVu> getAllChucVus() {

		return nhanVienDao.getAllChucVus();
	}

	public ChucVu getMaChucVu(String selectedItem) {

		return nhanVienDao.getMaChucVu(selectedItem);
	}

	public List<String> getListMaNV() {

		return nhanVienDao.getListMaNV();
	}

	public DefaultTableModel getAllAccount(String[] header, DefaultTableModel tableModel) {

		return nhanVienDao.getAllAccount(header, tableModel);
	}

	public DefaultTableModel getAccountById(String[] header, DefaultTableModel tableModel, String id) {

		return nhanVienDao.getAccountById(header, tableModel, id);
	}

	public DefaultTableModel getAccountByName(String[] header, DefaultTableModel tableModel, String name) {

		return nhanVienDao.getAccountByName(header, tableModel, name);
	}
}
