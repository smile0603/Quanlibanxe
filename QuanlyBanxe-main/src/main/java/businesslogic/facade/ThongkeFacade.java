package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.table.DefaultTableModel;

import entity.Xe;

public interface ThongkeFacade extends Remote {
	public DefaultTableModel getAllCTHD(int thang, int nam) throws RemoteException;

	public DefaultTableModel getAllCTHD(int ngay, int thang, int nam) throws RemoteException;

	public DefaultTableModel getAllKH(int thang, int nam) throws RemoteException;

	public DefaultTableModel getAllKH(int nam) throws RemoteException;

	public DefaultTableModel getAllKH(int ngay, int thang, int nam) throws RemoteException;

	public DefaultTableModel getAllNV(int ngay, int thang, int nam) throws RemoteException;

	public DefaultTableModel getAllCTNV(int ngay, int thang, int nam, String ma) throws RemoteException;

	public DefaultTableModel getAllNV(int nam) throws RemoteException;

	public DefaultTableModel getAllCTNV(int nam, String ma) throws RemoteException;

	public DefaultTableModel getAllNV(int thang, int nam) throws RemoteException;

	public DefaultTableModel getAllCTNV(int thang, int nam, String ma) throws RemoteException;

	public DefaultTableModel getAllYear(int nam) throws RemoteException;

	public int BieuDoXeNhap(int thang, int nam) throws RemoteException;

	public int BieuDoXeBan(int thang, int nam) throws RemoteException;

	public int SoLuongKhachHangTrongThang(int thang, int nam) throws RemoteException;

	public int TongTienTheoThang(int thang, int nam) throws RemoteException;

	public int BieuDoXeNhap(int ngay, int thang, int nam) throws RemoteException;

	public int BieuDoXeBan(int ngay, int thang, int nam) throws RemoteException;

	public int BieuDoKhachHangTheoNgay(int ngay, int thang, int nam) throws RemoteException;

	public int TongTienTheoNgay(int ngay, int thang, int nam) throws RemoteException;

	public int SoLuongXeNhapTrongNam(int nam) throws RemoteException;

	public int SoLuongXeBanTrongNam(int nam) throws RemoteException;

	public int SoLuongKhachHangTrongNam(int nam) throws RemoteException;

	public int TongTienTheoNam(int nam) throws RemoteException;

	public Xe XeNhieuNhat() throws RemoteException;

	public String XeItNhat() throws RemoteException;

	public int TuoiTrungBinh() throws RemoteException;

	public int TiLe(int tuoi1, int tuoi2) throws RemoteException;

	public double SoLuongTuoi(int tuoi1, int tuoi2) throws RemoteException;
}
