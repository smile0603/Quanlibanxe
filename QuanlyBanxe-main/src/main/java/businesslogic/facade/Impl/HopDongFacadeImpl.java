package businesslogic.facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import businesslogic.control.HangSanXuatControl;
import businesslogic.control.HopDongControl;
import businesslogic.facade.HopDongFacade;
import entity.HopDong;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhanVien;
import entity.Xe;

public class HopDongFacadeImpl extends UnicastRemoteObject implements HopDongFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2298878239699792177L;
	private HopDongControl hopDongControl;

	public HopDongFacadeImpl() throws RemoteException {

		hopDongControl = new HopDongControl();
	}

	@Override
	public HopDong getInfoHD(String properties) throws RemoteException {

		return hopDongControl.getInfoHD(properties);
	}

	@Override
	public HopDong getHopDongByVehicleNum(String maXe) throws RemoteException {

		return hopDongControl.getHopDongByVehicleNum(maXe);
	}

	@Override
	public DefaultTableModel getAllXe() throws RemoteException {

		return hopDongControl.getAllXe();
	}

	@Override
	public DefaultTableModel getAllHD() throws RemoteException {

		return hopDongControl.getAllHD();
	}

	@Override
	public ArrayList<String> getListXeByCustomer(String maKH, String ngay) throws RemoteException {

		return hopDongControl.getListXeByCustomer(maKH, ngay);
	}

	@Override
	public boolean themHD(HopDong hd) throws RemoteException {

		return hopDongControl.themHD(hd);
	}

	@Override
	public DefaultTableModel timKiem(String cmnd) throws RemoteException {

		return hopDongControl.timKiem(cmnd);
	}

	@Override
	public DefaultTableModel timKiemXe(String tenXe) throws RemoteException {

		return hopDongControl.timKiemXe(tenXe);
	}

	@Override
	public DefaultTableModel timKiemNgay(String ngayLap) throws RemoteException {

		return hopDongControl.timKiemNgay(ngayLap);
	}

	@Override
	public DefaultTableModel locData(String cmnd, String ngayLap) throws RemoteException {

		return hopDongControl.locData(cmnd, ngayLap);
	}

	@Override
	public void xoaHD(String maHD) throws RemoteException {

		hopDongControl.xoaHD(maHD);
	}

	@Override
	public boolean update(HopDong hd) throws RemoteException {

		return hopDongControl.update(hd);
	}

	@Override
	public ArrayList<NhanVien> getAllNV() throws RemoteException {

		return hopDongControl.getAllNV();
	}

	@Override
	public ArrayList<KhachHang> getAllKH() throws RemoteException {

		return hopDongControl.getAllKH();
	}

	@Override
	public ArrayList<Xe> getAllXes() throws RemoteException {

		return hopDongControl.getAllXes();
	}

	@Override
	public ArrayList<LoaiXe> getAllLoai() throws RemoteException {

		return hopDongControl.getAllLoai();
	}

	@Override
	public void getList(String tenXe, JComboBox comboBox) throws RemoteException {

		hopDongControl.getList(tenXe, comboBox);
	}

	@Override
	public HopDong getInfoHDG(String properties, String id) throws RemoteException {

		return hopDongControl.getInfoHDG(properties, id);
	}

	@Override
	public String getMaHDGTail(String properties, String table) throws RemoteException {

		return hopDongControl.getMaHDGTail(properties, table);
	}
}
