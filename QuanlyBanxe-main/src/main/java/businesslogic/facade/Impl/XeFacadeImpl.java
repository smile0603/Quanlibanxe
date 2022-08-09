package businesslogic.facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import businesslogic.control.HangSanXuatControl;
import businesslogic.control.XeControl;
import businesslogic.facade.XeFacade;
import entity.HangSanXuat;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;

public class XeFacadeImpl extends UnicastRemoteObject implements XeFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4513326287181632977L;
	private XeControl xeControl;

	public XeFacadeImpl() throws RemoteException {

		xeControl = new XeControl();
	}

	@Override
	public boolean themXe(Xe xe) throws RemoteException {

		return xeControl.themXe(xe);
	}

	@Override
	public boolean xoaXe(String maxe) throws RemoteException {

		return xeControl.xoaXe(maxe);
	}

	@Override
	public boolean capnhatXe(Xe xe) throws RemoteException {

		return xeControl.capnhatXe(xe);
	}

	@Override
	public Xe layXeById(String maxe) throws RemoteException {

		return xeControl.layXeById(maxe);
	}

	@Override
	public int getAmountByVehicleID(String maXe) throws RemoteException {

		return xeControl.getAmountByVehicleID(maXe);
	}

	@Override
	public void getListTenXe(JComboBox comboBox) throws RemoteException {

		xeControl.getListTenXe(comboBox);
	}

	@Override
	public String getMaXeTail() throws RemoteException {

		return xeControl.getMaXeTail();
	}

	@Override
	public String getHangXeTail() throws RemoteException {

		return xeControl.getHangXeTail();
	}

	@Override
	public ArrayList<String> getListVersion(String tenXe) throws RemoteException {

		return xeControl.getListVersion(tenXe);
	}

	@Override
	public ArrayList<String> getListChassisNumber(String tenXe, String version, String mauXe) throws RemoteException {

		return xeControl.getListChassisNumber(tenXe, version, mauXe);
	}

	@Override
	public ArrayList<String> getListColor(String tenXe, String version) throws RemoteException {

		return xeControl.getListColor(tenXe, version);
	}

	@Override
	public ArrayList<NhaCungCap> getAllNCC() throws RemoteException {

		return xeControl.getAllNCC();
	}

	@Override
	public ArrayList<NhaCungCap> getAllNCC(String id) throws RemoteException {

		return xeControl.getAllNCC(id);
	}

	@Override
	public ArrayList<HangSanXuat> getAllHangSX() throws RemoteException {

		return xeControl.getAllHangSX();
	}

	@Override
	public ArrayList<HangSanXuat> getAllHangSX(String id) throws RemoteException {

		return xeControl.getAllHangSX(id);
	}

	@Override
	public ArrayList<LoaiXe> getAllLoaiXe() throws RemoteException {

		return xeControl.getAllLoaiXe();
	}

	@Override
	public ArrayList<LoaiXe> getAllLoaiXe(String id) throws RemoteException {

		return xeControl.getAllLoaiXe(id);
	}

	@Override
	public Xe getInfoXe(String properties, String id) throws RemoteException {

		return xeControl.getInfoXe(properties, id);
	}

	@Override
	public DefaultTableModel getAllXe() throws RemoteException {

		return xeControl.getAllXe();
	}

	@Override
	public DefaultTableModel SapXepTangDanTen() throws RemoteException {

		return xeControl.SapXepTangDanTen();
	}

	@Override
	public DefaultTableModel SapXepGiamDanTen() throws RemoteException {

		return xeControl.SapXepGiamDanTen();
	}

	@Override
	public DefaultTableModel SapXepTangDanGia() throws RemoteException {

		return xeControl.SapXepTangDanGia();
	}

	@Override
	public DefaultTableModel SapXepGiamDanGia() throws RemoteException {

		return xeControl.SapXepGiamDanGia();
	}

	@Override
	public DefaultTableModel timKiem(String search) throws RemoteException {

		return xeControl.timKiem(search);
	}

	@Override
	public boolean getImage(JLabel lblImage, String text) throws RemoteException {

		return xeControl.getImage(lblImage, text);
	}

	@Override
	public ArrayList<Xe> getSoKhung() throws RemoteException {

		return xeControl.getSoKhung();
	}

	@Override
	public int XeDaBan() throws RemoteException {

		return xeControl.XeDaBan();
	}

	@Override
	public int XeConLai() throws RemoteException {

		return xeControl.XeConLai();
	}

	@Override
	public boolean updateTrangThai(String maXe, String string) throws RemoteException {

		return xeControl.updateTrangThai(maXe, string);
	}

	@Override
	public void getSoKhungByTrangThai(String string, JComboBox cbbChasisNumber) throws RemoteException {
		xeControl.getSoKhungByTrangThai(string, cbbChasisNumber);

	}

	@Override
	public ArrayList<String> getXeByTrangThai(String string, String string2) throws RemoteException {
		// TODO Auto-generated method stub
		return xeControl.getXeByTrangThai(string, string2);
	}

	@Override
	public ArrayList<String> getAllTenXe(String ten) throws RemoteException {
		// TODO Auto-generated method stub
		return xeControl.getAllTenXe(ten);
	}

	@Override
	public Xe getInfoXe22(String properties, String id) throws RemoteException {
		// TODO Auto-generated method stub
		return xeControl.getInfoXe22(properties, id);
	}
}
