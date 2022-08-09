package businesslogic.control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import dao.HangSanXuatDao;
import dao.XeDao;
import entity.HangSanXuat;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;

public class XeControl {
	private XeDao xeDao;

	public XeControl() {

		xeDao = new XeDao();
	}

	public boolean themXe(Xe xe) {

		return xeDao.themXe(xe);
	}

	public boolean xoaXe(String maxe) {

		return xeDao.xoaXe(maxe);
	}

	public boolean capnhatXe(Xe xe) {

		return xeDao.capnhatXe(xe);
	}

	public Xe layXeById(String maxe) {

		return xeDao.layXeById(maxe);
	}

	public int getAmountByVehicleID(String maXe) {

		return xeDao.getAmountByVehicleID(maXe);
	}

	public void getListTenXe(JComboBox comboBox) {

		xeDao.getListTenXe(comboBox);
	}

	public String getMaXeTail() {

		return xeDao.getMaXeTail();
	}

	public String getHangXeTail() {

		return xeDao.getHangXeTail();
	}

	public ArrayList<String> getListVersion(String tenXe) {

		return xeDao.getListVersion(tenXe);
	}

	public ArrayList<String> getListChassisNumber(String tenXe, String version, String mauXe) {

		return xeDao.getListChassisNumber(tenXe, version, mauXe);
	}

	public ArrayList<String> getListColor(String tenXe, String version) {

		return xeDao.getListColor(tenXe, version);
	}

	public ArrayList<NhaCungCap> getAllNCC() {

		return xeDao.getAllNCC();
	}

	public ArrayList<NhaCungCap> getAllNCC(String id) {

		return xeDao.getAllNCC(id);
	}

	public ArrayList<HangSanXuat> getAllHangSX() {

		return xeDao.getAllHangSX();
	}

	public ArrayList<HangSanXuat> getAllHangSX(String id) {

		return xeDao.getAllHangSX(id);
	}

	public ArrayList<LoaiXe> getAllLoaiXe() {

		return xeDao.getAllLoaiXe();
	}

	public ArrayList<LoaiXe> getAllLoaiXe(String id) {

		return xeDao.getAllLoaiXe(id);
	}

	public Xe getInfoXe(String properties, String id) {

		return xeDao.getInfoXe(properties, id);
	}
	public Xe getInfoXe22(String properties, String id) {

		return xeDao.getInfoXe22(properties, id);
	}
	public DefaultTableModel getAllXe() {

		try {
			return xeDao.getAllXe();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel SapXepTangDanTen() {

		try {
			return xeDao.SapXepTangDanTen();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel SapXepGiamDanTen() {

		try {
			return xeDao.SapXepGiamDanTen();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel SapXepTangDanGia() {

		try {
			return xeDao.SapXepTangDanGia();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel SapXepGiamDanGia() {

		try {
			return xeDao.SapXepGiamDanGia();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel timKiem(String search) {

		try {
			return xeDao.timKiem(search);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public boolean getImage(JLabel lblImage, String text) {

		return true;
	}

	public ArrayList<Xe> getSoKhung() {

		return xeDao.getSoKhung();
	}

	public int XeDaBan() {

		return xeDao.XeDaBan();
	}

	public int XeConLai() {

		return xeDao.XeConLai();
	}

	public boolean updateTrangThai(String maXe, String string) {

		return xeDao.updateTrangThai(maXe, string);
	}

	public ArrayList<String> getXeByTrangThai(String string, String string2) {

		return xeDao.getXeByTrangThai(string, string2);
	}

	public void getSoKhungByTrangThai(String string, JComboBox cbbChasisNumber) {
		xeDao.getSoKhungByTrangThai(string, cbbChasisNumber);

	}

	public ArrayList<String> getAllTenXe(String ten) {
		// TODO Auto-generated method stub
		return xeDao.getAllTenXe(ten);
	}
}
