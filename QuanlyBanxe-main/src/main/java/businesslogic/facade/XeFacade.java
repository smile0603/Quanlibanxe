package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import entity.HangSanXuat;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;

public interface XeFacade extends Remote {

	public boolean themXe(Xe xe) throws RemoteException;

	public boolean xoaXe(String maxe) throws RemoteException;

	public boolean capnhatXe(Xe xe) throws RemoteException;

	public Xe layXeById(String maxe) throws RemoteException;

	public int getAmountByVehicleID(String maXe) throws RemoteException;

	public void getListTenXe(JComboBox comboBox) throws RemoteException;

	public String getMaXeTail() throws RemoteException;

	public String getHangXeTail() throws RemoteException;

	public ArrayList<String> getListVersion(String tenXe) throws RemoteException;

	public ArrayList<String> getListChassisNumber(String tenXe, String version, String mauXe) throws RemoteException;

	public ArrayList<String> getListColor(String tenXe, String version) throws RemoteException;

	public ArrayList<NhaCungCap> getAllNCC() throws RemoteException;

	public ArrayList<NhaCungCap> getAllNCC(String id) throws RemoteException;

	public ArrayList<HangSanXuat> getAllHangSX() throws RemoteException;

	public ArrayList<HangSanXuat> getAllHangSX(String id) throws RemoteException;

	public ArrayList<LoaiXe> getAllLoaiXe() throws RemoteException;

	public ArrayList<LoaiXe> getAllLoaiXe(String id) throws RemoteException;

	public Xe getInfoXe(String properties, String id) throws RemoteException;
	
	public Xe getInfoXe22(String properties, String id) throws RemoteException;

	public DefaultTableModel getAllXe() throws RemoteException;

	public DefaultTableModel SapXepTangDanTen() throws RemoteException;

	public DefaultTableModel SapXepGiamDanTen() throws RemoteException;

	public DefaultTableModel SapXepTangDanGia() throws RemoteException;

	public DefaultTableModel SapXepGiamDanGia() throws RemoteException;

	public DefaultTableModel timKiem(String search) throws RemoteException;

	public boolean getImage(JLabel lblImage, String text) throws RemoteException;

	public ArrayList<Xe> getSoKhung() throws RemoteException;

	public int XeDaBan() throws RemoteException;

	public int XeConLai() throws RemoteException;

	public boolean updateTrangThai(String maXe, String string) throws RemoteException;

	public ArrayList<String> getXeByTrangThai(String string, String string2) throws RemoteException;

	public void getSoKhungByTrangThai(String string, JComboBox cbbChasisNumber) throws RemoteException;

	public ArrayList<String> getAllTenXe(String ten) throws RemoteException;
}
