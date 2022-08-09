package businesslogic.control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.HangSanXuatDao;
import dao.HoaDonDao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.Xe;

public class HoaDonControl {
	private HoaDonDao hoaDonDao;

	public HoaDonControl() {

		hoaDonDao = new HoaDonDao();
	}

	public HoaDon getHoaDonByID(String ID) {
		return hoaDonDao.getHoaDonByID(ID);
	}

	public String getMaHDTail(String properties, String table) {
		return hoaDonDao.getMaHDTail(properties, table);
	}

	public double getTotalMoneyHD(String maHD) {
		return hoaDonDao.getTotalMoneyHD(maHD);
	}

	public KhachHang getKhachHangbyHDId(String maHD) {
		return hoaDonDao.getKhachHangbyHDId(maHD);
	}

	public ArrayList<Xe> getListOrderDetails(String maHD) {
		return hoaDonDao.getListOrderDetails(maHD);
	}

	public boolean createHD(HoaDon hd) {
		return hoaDonDao.createHD(hd);
	}

	public boolean createCTHD(ChiTietHoaDon cthd) {
		return hoaDonDao.createCTHD(cthd);
	}

	public DefaultTableModel getAllOrder() {
		return hoaDonDao.getAllOrder();
	}

	public DefaultTableModel getAllOrderById(String maHD, String maKH, String tenKH, String ngay) {
		try {
			return hoaDonDao.getAllOrderById(maHD, maKH, tenKH, ngay);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel getOrderDetails(String maHD) {
		try {
			return hoaDonDao.getOrderDetails(maHD);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
}
