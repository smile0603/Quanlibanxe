package businesslogic.facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.control.HangSanXuatControl;
import businesslogic.control.HoaDonControl;
import businesslogic.facade.HoaDonFacade;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.Xe;

public class HoaDonFacadeImpl extends UnicastRemoteObject implements HoaDonFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2838233405887190622L;
	private HoaDonControl hoaDonControl;

	public HoaDonFacadeImpl() throws RemoteException {

		hoaDonControl = new HoaDonControl();
	}

	@Override
	public HoaDon getHoaDonByID(String ID) throws RemoteException {

		return hoaDonControl.getHoaDonByID(ID);
	}

	@Override
	public String getMaHDTail(String properties, String table) throws RemoteException {

		return hoaDonControl.getMaHDTail(properties, table);
	}

	@Override
	public double getTotalMoneyHD(String maHD) throws RemoteException {

		return hoaDonControl.getTotalMoneyHD(maHD);
	}

	@Override
	public KhachHang getKhachHangbyHDId(String maHD) throws RemoteException {

		return hoaDonControl.getKhachHangbyHDId(maHD);
	}

	@Override
	public ArrayList<Xe> getListOrderDetails(String maHD) throws RemoteException {

		return hoaDonControl.getListOrderDetails(maHD);
	}

	@Override
	public boolean createHD(HoaDon hd) throws RemoteException {

		return hoaDonControl.createHD(hd);
	}

	@Override
	public boolean createCTHD(ChiTietHoaDon cthd) throws RemoteException {

		return hoaDonControl.createCTHD(cthd);
	}

	@Override
	public DefaultTableModel getAllOrder() throws RemoteException {

		return hoaDonControl.getAllOrder();
	}

	@Override
	public DefaultTableModel getAllOrderById(String maHD, String maKH, String tenKH, String ngay)
			throws RemoteException {

		return hoaDonControl.getAllOrderById(maHD, maKH, tenKH, ngay);
	}

	@Override
	public DefaultTableModel getOrderDetails(String maHD) throws RemoteException {

		return hoaDonControl.getOrderDetails(maHD);
	}
}
