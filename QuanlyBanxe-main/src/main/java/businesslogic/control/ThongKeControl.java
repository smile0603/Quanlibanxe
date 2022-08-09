package businesslogic.control;

import java.rmi.RemoteException;

import javax.swing.table.DefaultTableModel;

import dao.ThongKeDao;
import entity.Xe;

public class ThongKeControl {
	private ThongKeDao thongKeDao;

	public ThongKeControl() {
		thongKeDao = new ThongKeDao();
	}

	public DefaultTableModel getAllCTHD(int thang, int nam) {
		return thongKeDao.getAllCTHD(thang, nam);
	}

	public DefaultTableModel getAllCTHD(int ngay, int thang, int nam) {
		return thongKeDao.getAllCTHD(ngay, thang, nam);
	}

	public DefaultTableModel getAllKH(int thang, int nam) {
		return thongKeDao.getAllKH(thang, nam);
	}

	public DefaultTableModel getAllKH(int nam) {
		return thongKeDao.getAllKH(nam);
	}

	public DefaultTableModel getAllKH(int ngay, int thang, int nam) {
		return thongKeDao.getAllKH(ngay, thang, nam);
	}

	public DefaultTableModel getAllNV(int ngay, int thang, int nam) {
		return thongKeDao.getAllNV(ngay, thang, nam);
	}

	public DefaultTableModel getAllCTNV(int ngay, int thang, int nam, String ma) {
		return thongKeDao.getAllCTNV(ngay, thang, nam, ma);
	}

	public DefaultTableModel getAllNV(int nam) {
		return thongKeDao.getAllNV(nam);
	}

	public DefaultTableModel getAllCTNV(int nam, String ma) {
		return thongKeDao.getAllCTNV(nam, ma);
	}

	public DefaultTableModel getAllNV(int thang, int nam) {
		return thongKeDao.getAllNV(thang, nam);
	}

	public DefaultTableModel getAllCTNV(int thang, int nam, String ma) {
		return thongKeDao.getAllCTNV(thang, nam, ma);
	}

	public DefaultTableModel getAllYear(int nam) {
		return thongKeDao.getAllYear(nam);
	}

	public int BieuDoXeNhap(int thang, int nam) {
		return thongKeDao.BieuDoXeNhap(thang, nam);
	}

	public int BieuDoXeBan(int thang, int nam) {
		return thongKeDao.BieuDoXeBan(thang, nam);
	}

	public int SoLuongKhachHangTrongThang(int thang, int nam) {
		return thongKeDao.SoLuongKhachHangTrongThang(thang, nam);
	}

	public int TongTienTheoThang(int thang, int nam) {
		return thongKeDao.TongTienTheoThang(thang, nam);
	}

	public int BieuDoXeNhap(int ngay, int thang, int nam) {
		return thongKeDao.BieuDoXeNhap(ngay, thang, nam);
	}

	public int BieuDoXeBan(int ngay, int thang, int nam) {
		return thongKeDao.BieuDoXeBan(ngay, thang, nam);
	}

	public int BieuDoKhachHangTheoNgay(int ngay, int thang, int nam) {
		return thongKeDao.BieuDoKhachHangTheoNgay(ngay, thang, nam);
	}

	public int TongTienTheoNgay(int ngay, int thang, int nam) {
		return thongKeDao.TongTienTheoNgay(ngay, thang, nam);
	}

	public int SoLuongXeNhapTrongNam(int nam) {
		return thongKeDao.SoLuongXeNhapTrongNam(nam);
	}

	public int SoLuongXeBanTrongNam(int nam) {
		return thongKeDao.SoLuongXeBanTrongNam(nam);
	}

	public int SoLuongKhachHangTrongNam(int nam) {
		return thongKeDao.SoLuongKhachHangTrongNam(nam);
	}

	public int TongTienTheoNam(int nam) {
		return thongKeDao.TongTienTheoNam(nam);
	}

	public Xe XeNhieuNhat() {
		return thongKeDao.XeNhieuNhat();
	}

	public String XeItNhat() {
		return thongKeDao.XeItNhat();
	}

	public int TuoiTrungBinh() {
		return thongKeDao.TuoiTrungBinh();
	}

	public int TiLe(int tuoi1, int tuoi2) {
		return thongKeDao.TiLe(tuoi1, tuoi2);
	}

	public double SoLuongTuoi(int tuoi1, int tuoi2) {
		return thongKeDao.SoLuongTuoi(tuoi1, tuoi2);
	}
}
