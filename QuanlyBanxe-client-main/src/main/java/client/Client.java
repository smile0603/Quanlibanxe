package client;

import java.rmi.Naming;

import businesslogic.facade.HangSanXuatFacade;
import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.HopDongFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.LoaiXeFacade;
import businesslogic.facade.NhaCungCapFacade;
import businesslogic.facade.NhanVienFacade;
import businesslogic.facade.ThongkeFacade;
import businesslogic.facade.XeFacade;

public class Client {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null)
		{
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			HangSanXuatFacade hangSanXuatFacade = (HangSanXuatFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hangSanXuatFacade");
			HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
			HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hopDongFacade");
			KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
			LoaiXeFacade loaiXeFacade = (LoaiXeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/loaiXeFacade");
			NhaCungCapFacade nhaCungCapFacade = (NhaCungCapFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhaCungCapFacade");
			NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
			XeFacade xeFacade = (XeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/xeFacade");
			ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
