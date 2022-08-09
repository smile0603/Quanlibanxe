package app;

import java.rmi.RemoteException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import businesslogic.facade.NhanVienFacade;
import businesslogic.facade.ThongkeFacade;
import businesslogic.facade.Impl.NhanVienFacadeImpl;
import businesslogic.facade.Impl.ThongKeFacadeImpl;
import entity.ChucVu;
import entity.NhanVien;

public class App {
	public static void main(String[] args) {
		 EntityManager entityManager =
		 Persistence.createEntityManagerFactory("QuanLyBanXe").createEntityManager();

//		try {
//			NhanVienFacade nhanVienFacade = new NhanVienFacadeImpl();
//			ChucVu chucVu = nhanVienFacade.getMaChucVu("Nhân Viên");
//			System.out.println(chucVu);
//			NhanVien nhanVien = new NhanVien("NV_0005", "Nam", "123456789016", "Nam", new Date(2000, 10, 10), "Go Vap", "nam@gmail.com",chucVu , "0350043227", new Date(2020, 10, 10));
////			//NhanVien nhanVien1 = new NhanVien(null, null, null, null, null, null, null, null, null, null)
//			boolean kq =nhanVienFacade.themNhanVien(nhanVien);
//			System.out.println(kq);
////			double kq =  thongkeFacade.SoLuongTuoi(20, 25);
////			System.out.println(kq);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
