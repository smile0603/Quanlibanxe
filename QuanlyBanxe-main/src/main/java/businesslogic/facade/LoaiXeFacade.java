package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entity.LoaiXe;

public interface LoaiXeFacade extends Remote {

	public boolean themLoaiXe(LoaiXe loaiXe) throws RemoteException;

	public boolean xoaLoaiXe(String makh) throws RemoteException;

	public boolean capnhatLoaiXe(LoaiXe loaiXe) throws RemoteException;

	public LoaiXe layLoaiXeById(String makh) throws RemoteException;

	public DefaultTableModel getAllLX() throws RemoteException;

	public DefaultTableModel timKiem(String id) throws RemoteException;

	public String getLoaiXeTail() throws RemoteException;

	public ArrayList<String> getListTenLoaiXe() throws RemoteException;

	public ArrayList<String> getListMaLoaiXe() throws RemoteException;
}
