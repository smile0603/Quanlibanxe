package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import entity.KhachHang;

public interface KhachHangFacade extends Remote {

	public boolean themKhachHang(KhachHang khachHang) throws RemoteException;

	public boolean xoaKhachHang(String makh) throws RemoteException;

	public boolean capnhatKhachHang(KhachHang khachHang) throws RemoteException;

	public KhachHang layKhachHangById(String makh) throws RemoteException;

	public int TongKhachHang() throws RemoteException;

	public int TongKhachNam() throws RemoteException;

	public int TongKhachNu() throws RemoteException;

	public DefaultTableModel timKiem(String id) throws RemoteException;

	public DefaultTableModel getAllKH() throws RemoteException;

	public KhachHang getKhachHangTail() throws RemoteException;

	public List<String> getListCMND() throws RemoteException;

	public KhachHang getKhachHangById(String string, String text) throws RemoteException;
}
