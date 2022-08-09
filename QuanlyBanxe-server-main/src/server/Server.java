package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import businesslogic.facade.HangSanXuatFacade;
import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.HopDongFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.LoaiXeFacade;
import businesslogic.facade.NhaCungCapFacade;
import businesslogic.facade.NhanVienFacade;
import businesslogic.facade.ThongkeFacade;
import businesslogic.facade.XeFacade;
import businesslogic.facade.Impl.HangSanXuatFacadeImpl;
import businesslogic.facade.Impl.HoaDonFacadeImpl;
import businesslogic.facade.Impl.HopDongFacadeImpl;
import businesslogic.facade.Impl.KhachHangFacadeImpl;
import businesslogic.facade.Impl.LoaiXeFacadeImpl;
import businesslogic.facade.Impl.NhaCungCapFacadeImpl;
import businesslogic.facade.Impl.NhanVienFacadeImpl;
import businesslogic.facade.Impl.ThongKeFacadeImpl;
import businesslogic.facade.Impl.XeFacadeImpl;

public class Server {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null)
		{
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			LocateRegistry.createRegistry(9999);
			HangSanXuatFacade hangSanXuatFacade = new HangSanXuatFacadeImpl();
			HoaDonFacade hoaDonFacade = new HoaDonFacadeImpl();
			HopDongFacade hopDongFacade = new HopDongFacadeImpl();
			KhachHangFacade khachHangFacade = new KhachHangFacadeImpl();
			LoaiXeFacade loaiXeFacade = new LoaiXeFacadeImpl();
			NhaCungCapFacade nhaCungCapFacade = new NhaCungCapFacadeImpl();
			NhanVienFacade nhanVienFacade = new NhanVienFacadeImpl();
			XeFacade xeFacade = new XeFacadeImpl();
			ThongkeFacade thongkeFacade = new ThongKeFacadeImpl();
			Naming.bind("rmi://DESKTOP-1NNGN4I:9999/hangSanXuatFacade", hangSanXuatFacade);
			Naming.bind("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade", hoaDonFacade);
			Naming.bind("rmi://DESKTOP-1NNGN4I:9999/hopDongFacade", hopDongFacade);
			Naming.bind("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade", khachHangFacade);
			Naming.bind("rmi://DESKTOP-1NNGN4I:9999/loaiXeFacade", loaiXeFacade);
			Naming.bind("rmi://DESKTOP-1NNGN4I:9999/nhaCungCapFacade", nhaCungCapFacade);
			Naming.bind("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade", nhanVienFacade);
			Naming.bind("rmi://DESKTOP-1NNGN4I:9999/xeFacade", xeFacade);
			Naming.bind("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade", thongkeFacade);
			System.out.println("Server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
