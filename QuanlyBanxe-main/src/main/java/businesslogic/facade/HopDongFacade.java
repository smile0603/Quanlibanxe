package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import entity.HopDong;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhanVien;
import entity.Xe;

public interface HopDongFacade extends Remote {

	public HopDong getInfoHD(String properties) throws RemoteException;

	public HopDong getHopDongByVehicleNum(String maXe) throws RemoteException;

	public DefaultTableModel getAllXe() throws RemoteException;

	public DefaultTableModel getAllHD() throws RemoteException;

	public ArrayList<String> getListXeByCustomer(String maKH, String ngay) throws RemoteException;

	public boolean themHD(HopDong hd) throws RemoteException;

	public DefaultTableModel timKiem(String cmnd) throws RemoteException;

	public DefaultTableModel timKiemXe(String tenXe) throws RemoteException;

	public DefaultTableModel timKiemNgay(String ngayLap) throws RemoteException;

	public DefaultTableModel locData(String cmnd, String ngayLap) throws RemoteException;

	public void xoaHD(String maHD) throws RemoteException;

	public boolean update(HopDong hd) throws RemoteException;

	public ArrayList<NhanVien> getAllNV() throws RemoteException;

	public ArrayList<KhachHang> getAllKH() throws RemoteException;

	public ArrayList<Xe> getAllXes() throws RemoteException;

	public ArrayList<LoaiXe> getAllLoai() throws RemoteException;

	public void getList(String tenXe, JComboBox comboBox) throws RemoteException;

	public HopDong getInfoHDG(String properties, String id) throws RemoteException;

	public String getMaHDGTail(String properties, String table) throws RemoteException;
}
