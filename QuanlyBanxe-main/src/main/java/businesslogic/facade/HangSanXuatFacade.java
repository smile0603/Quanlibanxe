package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import entity.HangSanXuat;

public interface HangSanXuatFacade extends Remote {

	public void getListHSX(String tenXe, JComboBox comboBox) throws RemoteException;

	public HangSanXuat getHangSanXuatById(String id) throws RemoteException;

	public DefaultTableModel getAllHSX() throws RemoteException;

	public DefaultTableModel timKiem(String mahSX) throws RemoteException;

	public boolean themHSX(HangSanXuat hsx) throws RemoteException;

	public boolean xoaHSX(String mahsx) throws RemoteException;

	public boolean update(HangSanXuat hsx) throws RemoteException;

	public ArrayList<String> getListTenHangSX() throws RemoteException;
}
