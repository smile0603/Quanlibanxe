package businesslogic.facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import businesslogic.control.HangSanXuatControl;
import businesslogic.control.NhanVienControl;
import businesslogic.facade.NhanVienFacade;
import entity.ChucVu;
import entity.HoaDon;
import entity.NhanVien;

public class NhanVienFacadeImpl extends UnicastRemoteObject implements NhanVienFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5673944151170790094L;
	private NhanVienControl nhanVienControl;

	public NhanVienFacadeImpl() throws RemoteException {

		nhanVienControl = new NhanVienControl();
	}

	@Override
	public boolean themNhanVien(NhanVien nhanVien) throws RemoteException {

		return nhanVienControl.themNhanVien(nhanVien);
	}

	@Override
	public boolean xoaNhanVien(String manv) throws RemoteException {

		return nhanVienControl.xoaNhanVien(manv);
	}

	@Override
	public boolean capnhatNhanVien(NhanVien nhanVien) throws RemoteException {

		return nhanVienControl.capnhatNhanVien(nhanVien);
	}

	@Override
	public NhanVien layNhanVienById(String manv) throws RemoteException {

		return nhanVienControl.layNhanVienById(manv);
	}

	@Override
	public String getTenNhanVienById(String ID) throws RemoteException {

		return nhanVienControl.getTenNhanVienById(ID);
	}

	@Override
	public DefaultTableModel getAllNV() throws RemoteException {

		return nhanVienControl.getAllNV();
	}

	@Override
	public DefaultTableModel timKiem(String id, String sdt) throws RemoteException {

		return nhanVienControl.timKiem(id, sdt);
	}

	@Override
	public String getMaHDTail(String properties, String table) throws RemoteException {

		return nhanVienControl.getMaHDTail(properties, table);
	}

	@Override
	public NhanVien Login(String username, String password) throws RemoteException {

		return nhanVienControl.Login(username, password);
	}

	@Override
	public NhanVien getNhanVienById(String properties, String ID) throws RemoteException {

		return nhanVienControl.getNhanVienById(properties, ID);
	}

	@Override
	public ArrayList<ChucVu> getAllChucVus() throws RemoteException {

		return nhanVienControl.getAllChucVus();
	}

	@Override
	public ChucVu getMaChucVu(String selectedItem) throws RemoteException {

		return nhanVienControl.getMaChucVu(selectedItem);
	}

	@Override
	public List<String> getListMaNV() throws RemoteException {

		return nhanVienControl.getListMaNV();
	}

	@Override
	public DefaultTableModel getAllAccount(String[] header, DefaultTableModel tableModel) throws RemoteException {

		return nhanVienControl.getAllAccount(header, tableModel);
	}

	@Override
	public DefaultTableModel getAccountById(String[] header, DefaultTableModel tableModel, String id)
			throws RemoteException {

		return nhanVienControl.getAccountById(header, tableModel, id);
	}

	@Override
	public DefaultTableModel getAccountByName(String[] header, DefaultTableModel tableModel, String name)
			throws RemoteException {

		return nhanVienControl.getAccountByName(header, tableModel, name);
	}

}
