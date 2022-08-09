package businesslogic.control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import dao.HangSanXuatDao;
import dao.HopDongDao;
import entity.HopDong;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhanVien;
import entity.Xe;

public class HopDongControl {
	private HopDongDao hopDongDao;

	public HopDongControl() {

		hopDongDao = new HopDongDao();
	}

	public HopDong getInfoHD(String properties) {
		return hopDongDao.getInfoHD(properties);
	}

	public HopDong getHopDongByVehicleNum(String maXe) {

		return hopDongDao.getHopDongByVehicleNum(maXe);
	}

	public DefaultTableModel getAllXe() {

		try {
			return hopDongDao.getAllXe();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel getAllHD() {

		try {
			return hopDongDao.getAllHD();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getListXeByCustomer(String maKH, String ngay) {

		return hopDongDao.getListXeByCustomer(maKH, ngay);
	}

	public boolean themHD(HopDong hd) {

		return hopDongDao.themHD(hd);
	}

	public DefaultTableModel timKiem(String cmnd) {

		try {
			return hopDongDao.timKiem(cmnd);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel timKiemXe(String tenXe) {

		try {
			return hopDongDao.timKiemXe(tenXe);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel timKiemNgay(String ngayLap) {

		try {
			return hopDongDao.timKiemNgay(ngayLap);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel locData(String cmnd, String ngayLap) {

		try {
			return hopDongDao.locData(cmnd, ngayLap);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public void xoaHD(String maHD) {
		hopDongDao.xoaHD(maHD);
	}

	public boolean update(HopDong hd) {

		return hopDongDao.update(hd);
	}

	public ArrayList<NhanVien> getAllNV() {

		return hopDongDao.getAllNV();
	}

	public ArrayList<KhachHang> getAllKH() {

		return hopDongDao.getAllKH();
	}

	public ArrayList<Xe> getAllXes() {

		return hopDongDao.getAllXes();
	}

	public ArrayList<LoaiXe> getAllLoai() {

		return hopDongDao.getAllLoai();
	}

	public void getList(String tenXe, JComboBox comboBox) {

		hopDongDao.getList(tenXe, comboBox);
	}

	public HopDong getInfoHDG(String properties, String id) {

		return hopDongDao.getInfoHDG(properties, id);
	}

	public String getMaHDGTail(String properties, String table) {

		return hopDongDao.getMaHDGTail(properties, table);
	}
}
