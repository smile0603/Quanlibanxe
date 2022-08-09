package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.ChucVu;
import entity.HoaDon;
import entity.NhanVien;

public interface NhanVienFacade extends Remote {

	public boolean themNhanVien(NhanVien nhanVien) throws RemoteException;

	public boolean xoaNhanVien(String manv) throws RemoteException;

	public boolean capnhatNhanVien(NhanVien nhanVien) throws RemoteException;

	public NhanVien layNhanVienById(String manv) throws RemoteException;

	public String getTenNhanVienById(String ID) throws RemoteException;

	public DefaultTableModel getAllNV() throws RemoteException;

	public DefaultTableModel timKiem(String id, String sdt) throws RemoteException;

	public String getMaHDTail(String properties, String table) throws RemoteException;

	public NhanVien Login(String username, String password) throws RemoteException;

	public NhanVien getNhanVienById(String properties, String ID) throws RemoteException;

	public ArrayList<ChucVu> getAllChucVus() throws RemoteException;

	public ChucVu getMaChucVu(String selectedItem) throws RemoteException;

	public List<String> getListMaNV() throws RemoteException;

	public DefaultTableModel getAllAccount(String[] header, DefaultTableModel tableModel) throws RemoteException;

	public DefaultTableModel getAccountById(String[] header, DefaultTableModel tableModel, String id)
			throws RemoteException;

	public DefaultTableModel getAccountByName(String[] header, DefaultTableModel tableModel, String name)
			throws RemoteException;

}
