package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entity.NhaCungCap;

public interface NhaCungCapFacade extends Remote {

	public NhaCungCap getTenNhaCCById(String ID) throws RemoteException;

	public ArrayList<String> getListSuppilerName() throws RemoteException;

	public DefaultTableModel getAllNCC() throws RemoteException;

	public DefaultTableModel timKiem(String maNCC) throws RemoteException;

	public boolean themNCC(NhaCungCap ncc) throws RemoteException;

	public void xoaNCC(String maNCC) throws RemoteException;

	public boolean update(NhaCungCap ncc) throws RemoteException;

	public int demNhaCungCap() throws RemoteException;

	public ArrayList<String> getListTenNhaCC() throws RemoteException;
}