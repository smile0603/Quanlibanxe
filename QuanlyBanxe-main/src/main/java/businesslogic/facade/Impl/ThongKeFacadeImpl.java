package businesslogic.facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.table.DefaultTableModel;

import businesslogic.control.ThongKeControl;
import businesslogic.facade.ThongkeFacade;
import entity.Xe;

public class ThongKeFacadeImpl extends UnicastRemoteObject implements ThongkeFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5392747278663618031L;
	private ThongKeControl thongKeControl;

	public ThongKeFacadeImpl() throws RemoteException {
		super();

		thongKeControl = new ThongKeControl();
	}

	@Override
	public DefaultTableModel getAllCTHD(int thang, int nam) throws RemoteException {

		return thongKeControl.getAllCTHD(thang, nam);
	}

	@Override
	public DefaultTableModel getAllCTHD(int ngay, int thang, int nam) throws RemoteException {

		return thongKeControl.getAllCTHD(ngay, thang, nam);
	}

	@Override
	public DefaultTableModel getAllKH(int thang, int nam) throws RemoteException {

		return thongKeControl.getAllKH(thang, nam);
	}

	@Override
	public DefaultTableModel getAllKH(int nam) throws RemoteException {

		return thongKeControl.getAllKH(nam);
	}

	@Override
	public DefaultTableModel getAllKH(int ngay, int thang, int nam) throws RemoteException {

		return thongKeControl.getAllKH(ngay, thang, nam);
	}

	@Override
	public DefaultTableModel getAllNV(int ngay, int thang, int nam) throws RemoteException {

		return thongKeControl.getAllNV(ngay, thang, nam);
	}

	@Override
	public DefaultTableModel getAllCTNV(int ngay, int thang, int nam, String ma) throws RemoteException {

		return thongKeControl.getAllCTNV(ngay, thang, nam, ma);
	}

	@Override
	public DefaultTableModel getAllNV(int nam) throws RemoteException {

		return thongKeControl.getAllNV(nam);
	}

	@Override
	public DefaultTableModel getAllCTNV(int nam, String ma) throws RemoteException {

		return thongKeControl.getAllCTNV(nam, ma);
	}

	@Override
	public DefaultTableModel getAllNV(int thang, int nam) throws RemoteException {

		return thongKeControl.getAllNV(thang, nam);
	}

	@Override
	public DefaultTableModel getAllCTNV(int thang, int nam, String ma) throws RemoteException {

		return thongKeControl.getAllCTNV(thang, nam, ma);
	}

	@Override
	public DefaultTableModel getAllYear(int nam) throws RemoteException {

		return thongKeControl.getAllYear(nam);
	}

	@Override
	public int BieuDoXeNhap(int thang, int nam) throws RemoteException {

		return thongKeControl.BieuDoXeNhap(thang, nam);
	}

	@Override
	public int BieuDoXeBan(int thang, int nam) throws RemoteException {

		return thongKeControl.BieuDoXeBan(thang, nam);
	}

	@Override
	public int SoLuongKhachHangTrongThang(int thang, int nam) throws RemoteException {

		return thongKeControl.SoLuongKhachHangTrongThang(thang, nam);
	}

	@Override
	public int TongTienTheoThang(int thang, int nam) throws RemoteException {

		return thongKeControl.TongTienTheoThang(thang, nam);
	}

	@Override
	public int BieuDoXeNhap(int ngay, int thang, int nam) throws RemoteException {

		return thongKeControl.BieuDoXeNhap(ngay, thang, nam);
	}

	@Override
	public int BieuDoXeBan(int ngay, int thang, int nam) throws RemoteException {

		return thongKeControl.BieuDoXeBan(ngay, thang, nam);
	}

	@Override
	public int BieuDoKhachHangTheoNgay(int ngay, int thang, int nam) throws RemoteException {

		return thongKeControl.BieuDoKhachHangTheoNgay(ngay, thang, nam);
	}

	@Override
	public int TongTienTheoNgay(int ngay, int thang, int nam) throws RemoteException {

		return thongKeControl.TongTienTheoNgay(ngay, thang, nam);
	}

	@Override
	public int SoLuongXeNhapTrongNam(int nam) throws RemoteException {

		return thongKeControl.SoLuongXeNhapTrongNam(nam);
	}

	@Override
	public int SoLuongXeBanTrongNam(int nam) throws RemoteException {

		return thongKeControl.SoLuongXeBanTrongNam(nam);
	}

	@Override
	public int SoLuongKhachHangTrongNam(int nam) throws RemoteException {

		return thongKeControl.SoLuongKhachHangTrongNam(nam);
	}

	@Override
	public int TongTienTheoNam(int nam) throws RemoteException {

		return thongKeControl.TongTienTheoNam(nam);
	}

	@Override
	public Xe XeNhieuNhat() throws RemoteException {

		return thongKeControl.XeNhieuNhat();
	}

	@Override
	public String XeItNhat() throws RemoteException {

		return thongKeControl.XeItNhat();
	}

	@Override
	public int TuoiTrungBinh() throws RemoteException {

		return thongKeControl.TuoiTrungBinh();
	}

	@Override
	public int TiLe(int tuoi1, int tuoi2) throws RemoteException {

		return thongKeControl.TiLe(tuoi1, tuoi2);
	}

	@Override
	public double SoLuongTuoi(int tuoi1, int tuoi2) throws RemoteException {

		return thongKeControl.SoLuongTuoi(tuoi1, tuoi2);
	}

}
