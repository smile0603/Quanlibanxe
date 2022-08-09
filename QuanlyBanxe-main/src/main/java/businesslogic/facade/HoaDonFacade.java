package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.Xe;

public interface HoaDonFacade extends Remote {

	public HoaDon getHoaDonByID(String ID) throws RemoteException;

	public String getMaHDTail(String properties, String table) throws RemoteException;

	public double getTotalMoneyHD(String maHD) throws RemoteException;

	public KhachHang getKhachHangbyHDId(String maHD) throws RemoteException;

	public ArrayList<Xe> getListOrderDetails(String maHD) throws RemoteException;

	public boolean createHD(HoaDon hd) throws RemoteException;

	public boolean createCTHD(ChiTietHoaDon cthd) throws RemoteException;

	public DefaultTableModel getAllOrder() throws RemoteException;

	public DefaultTableModel getAllOrderById(String maHD, String maKH, String tenKH, String ngay)
			throws RemoteException;

	public DefaultTableModel getOrderDetails(String maHD) throws RemoteException;
}
