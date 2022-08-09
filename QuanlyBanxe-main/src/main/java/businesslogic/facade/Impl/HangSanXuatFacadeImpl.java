package businesslogic.facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import businesslogic.control.HangSanXuatControl;
import businesslogic.facade.HangSanXuatFacade;
import entity.HangSanXuat;

public class HangSanXuatFacadeImpl extends UnicastRemoteObject implements HangSanXuatFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1009066885396068664L;

	private HangSanXuatControl hangSanXuatControl;

	public HangSanXuatFacadeImpl() throws RemoteException {

		hangSanXuatControl = new HangSanXuatControl();
	}

	@Override
	public void getListHSX(String tenXe, JComboBox comboBox) throws RemoteException {
		hangSanXuatControl.getListHSX(tenXe, comboBox);
	}

	@Override
	public HangSanXuat getHangSanXuatById(String id) throws RemoteException {

		return hangSanXuatControl.getHangSanXuatById(id);
	}

	@Override
	public DefaultTableModel getAllHSX() throws RemoteException {

		return hangSanXuatControl.getAllHSX();
	}

	@Override
	public DefaultTableModel timKiem(String mahSX) throws RemoteException {

		return hangSanXuatControl.timKiem(mahSX);
	}

	@Override
	public boolean themHSX(HangSanXuat hsx) throws RemoteException {

		return hangSanXuatControl.themHSX(hsx);
	}

	@Override
	public boolean xoaHSX(String mahsx) throws RemoteException {

		return hangSanXuatControl.xoaHSX(mahsx);
	}

	@Override
	public boolean update(HangSanXuat hsx) throws RemoteException {

		return hangSanXuatControl.update(hsx);
	}

	@Override
	public ArrayList<String> getListTenHangSX() throws RemoteException {

		return hangSanXuatControl.getListTenHangSX();
	}
}
