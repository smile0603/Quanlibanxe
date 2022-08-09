package businesslogic.facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import businesslogic.control.HangSanXuatControl;
import businesslogic.control.KhachHangControl;
import businesslogic.facade.KhachHangFacade;
import entity.KhachHang;

public class KhachHangFacadeImpl extends UnicastRemoteObject implements KhachHangFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3424785954157979109L;
	private KhachHangControl khachHangControl;

	public KhachHangFacadeImpl() throws RemoteException {

		khachHangControl = new KhachHangControl();
	}

	@Override
	public boolean themKhachHang(KhachHang khachHang) throws RemoteException {

		return khachHangControl.themKhachHang(khachHang);
	}

	@Override
	public boolean xoaKhachHang(String makh) throws RemoteException {

		return khachHangControl.xoaKhachHang(makh);
	}

	@Override
	public boolean capnhatKhachHang(KhachHang khachHang) throws RemoteException {

		return khachHangControl.capnhatKhachHang(khachHang);
	}

	@Override
	public KhachHang layKhachHangById(String makh) throws RemoteException {

		return khachHangControl.layKhachHangById(makh);
	}

	@Override
	public int TongKhachHang() throws RemoteException {

		return khachHangControl.TongKhachHang();
	}

	@Override
	public int TongKhachNam() throws RemoteException {

		return khachHangControl.TongKhachNam();
	}

	@Override
	public int TongKhachNu() throws RemoteException {

		return khachHangControl.TongKhachNu();
	}

	@Override
	public DefaultTableModel timKiem(String id) throws RemoteException {

		return khachHangControl.timKiem(id);
	}

	@Override
	public DefaultTableModel getAllKH() throws RemoteException {

		return khachHangControl.getAllKH();
	}

	@Override
	public KhachHang getKhachHangTail() throws RemoteException {

		return khachHangControl.getKhachHangTail();
	}

	@Override
	public List<String> getListCMND() throws RemoteException {

		return khachHangControl.getListCMND();
	}

	@Override
	public KhachHang getKhachHangById(String string, String text) throws RemoteException {

		return khachHangControl.getKhachHangById(string, text);
	}
}
