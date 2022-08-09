package businesslogic.facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.control.HangSanXuatControl;
import businesslogic.control.LoaiXeControl;
import businesslogic.facade.LoaiXeFacade;
import entity.LoaiXe;

public class LoaiXeFacadeImpl extends UnicastRemoteObject implements LoaiXeFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2622772062850167441L;
	private LoaiXeControl loaiXeControl;

	public LoaiXeFacadeImpl() throws RemoteException {

		loaiXeControl = new LoaiXeControl();
	}

	@Override
	public boolean themLoaiXe(LoaiXe loaiXe) throws RemoteException {

		return loaiXeControl.themLoaiXe(loaiXe);
	}

	@Override
	public boolean xoaLoaiXe(String makh) throws RemoteException {

		return loaiXeControl.xoaLoaiXe(makh);
	}

	@Override
	public boolean capnhatLoaiXe(LoaiXe loaiXe) throws RemoteException {

		return loaiXeControl.capnhatLoaiXe(loaiXe);
	}

	@Override
	public LoaiXe layLoaiXeById(String makh) throws RemoteException {

		return loaiXeControl.layLoaiXeById(makh);
	}

	@Override
	public DefaultTableModel getAllLX() throws RemoteException {

		return loaiXeControl.getAllLX();
	}

	@Override
	public DefaultTableModel timKiem(String id) throws RemoteException {

		return loaiXeControl.timKiem(id);
	}

	@Override
	public String getLoaiXeTail() throws RemoteException {

		return loaiXeControl.getLoaiXeTail();
	}

	@Override
	public ArrayList<String> getListTenLoaiXe() throws RemoteException {

		return loaiXeControl.getListTenLoaiXe();
	}

	@Override
	public ArrayList<String> getListMaLoaiXe() throws RemoteException {

		return loaiXeControl.getListMaLoaiXe();
	}
}
