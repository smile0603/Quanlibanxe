package businesslogic.facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.control.HangSanXuatControl;
import businesslogic.control.NhaCungCapControl;
import businesslogic.facade.NhaCungCapFacade;
import entity.NhaCungCap;

public class NhaCungCapFacadeImpl extends UnicastRemoteObject implements NhaCungCapFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7130048663933423070L;
	private NhaCungCapControl nhaCungCapControl;

	public NhaCungCapFacadeImpl() throws RemoteException {

		nhaCungCapControl = new NhaCungCapControl();
	}

	@Override
	public NhaCungCap getTenNhaCCById(String ID) throws RemoteException {

		return nhaCungCapControl.getTenNhaCCById(ID);
	}

	@Override
	public ArrayList<String> getListSuppilerName() throws RemoteException {

		return nhaCungCapControl.getListSuppilerName();
	}

	@Override
	public DefaultTableModel getAllNCC() throws RemoteException {

		return nhaCungCapControl.getAllNCC();
	}

	@Override
	public DefaultTableModel timKiem(String maNCC) throws RemoteException {

		return nhaCungCapControl.timKiem(maNCC);
	}

	@Override
	public boolean themNCC(NhaCungCap ncc) throws RemoteException {

		return nhaCungCapControl.themNCC(ncc);
	}

	@Override
	public void xoaNCC(String maNCC) throws RemoteException {

		nhaCungCapControl.xoaNCC(maNCC);
	}

	@Override
	public boolean update(NhaCungCap ncc) throws RemoteException {

		return nhaCungCapControl.update(ncc);
	}

	@Override
	public int demNhaCungCap() throws RemoteException {

		return nhaCungCapControl.demNhaCungCap();
	}

	@Override
	public ArrayList<String> getListTenNhaCC() throws RemoteException {

		return nhaCungCapControl.getListTenNhaCC();
	}
}
