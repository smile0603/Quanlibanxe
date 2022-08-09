package dao;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.swing.table.DefaultTableModel;

import entity.Xe;
import util.HibernateUtil;

public class ThongKeDao {

	private EntityManager em;

	public ThongKeDao() {

		em = HibernateUtil.getIntance().getEntityManager();
	}

	public DefaultTableModel getAllCTHD(int thang, int nam) {
		String header[] = { "Tên Xe", "Số Lượng", "Tổng tiền thu được" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("SELECT Xe.tenXe, soluong=count(xe.tenXe), tong=sum(HoaDon.tongTien)\r\n"
				+ "					FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "					                  HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "					                Xe ON chiTietHoaDon.xeID = Xe.maXe\r\n"
				+ "					where MONTH(ngayLapHoaDon)=" + thang + " and YEAR(ngayLapHoaDon)=" + nam + "\r\n"
				+ "					group by xe.tenXe\r\n"
				+ "					order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
			int soluong = (int) rs[1];
			Object[] o = { (String) rs[0], soluong, df.format((double) rs[2]) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllCTHD(int ngay, int thang, int nam) {
		String header[] = { "Tên Xe", "Số Lượng", "Tổng tiền thu được" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("SELECT Xe.tenXe, soluong=count(xe.tenXe), tong=sum(HoaDon.tongTien)\r\n"
				+ "				FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "				                HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "				              Xe ON chiTietHoaDon.xeID = Xe.maXe\r\n"
				+ "			where MONTH(ngayLapHoaDon)=01 and YEAR(ngayLapHoaDon)=2020 and Day(ngayLapHoaDon)=03\r\n"
				+ "				group by xe.tenXe\r\n"
				+ "				order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
			int soluong = (int) rs[1];
			Object[] o = { (String) rs[0], soluong, df.format((double) rs[2]) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllKH(int thang, int nam) {
		String[] header = { "Tên Khách Hàng", "Giới tính", "Số điện thoại" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em
				.createNativeQuery("select tenKhachHang,gioiTinh,soDienThoai from khachhang where month(ngayGiaNhap)="
						+ thang + " and year(ngayGiaNhap)=" + nam + "")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllKH(int nam) {
		String[] header = { "Tên Khách Hàng", "Giới tính", "Số điện thoại" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em
				.createNativeQuery(
						"select tenKhachHang,gioiTinh,soDienThoai from khachhang where year(ngayGiaNhap)=" + nam + "")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllKH(int ngay, int thang, int nam) {
		String[] header = { "Tên Khách Hàng", "Giới tính", "Số điện thoại" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em
				.createNativeQuery("select tenKhachHang,gioiTinh,soDienThoai from khachhang where day(ngayGiaNhap)="
						+ ngay + " and month(ngayGiaNhap)=" + thang + " and  year(ngayGiaNhap)=" + nam + "")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllNV(int ngay, int thang, int nam) {
		String header[] = { "Tên cửa hàng", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Số lượng", "Doanh thu" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT  NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.gioiTinh, soluong=count(chiTietHoaDon.xeID), tong=sum(HoaDon.tongTien)\r\n"
						+ "				FROM     chiTietHoaDon INNER JOIN\r\n"
						+ "				                HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
						+ "				               NhanVien ON HoaDon.nhanVienID = NhanVien.maNhanVien\r\n"
						+ "				where day(ngayLapHoaDon)=" + ngay + " and month(ngayLapHoaDon)=" + thang
						+ " and year(ngayLapHoaDon)=" + nam + "\r\n"
						+ "				group by  NhanVien.tenNhanVien, NhanVien.maNhanVien, NhanVien.gioiTinh\r\n"
						+ "				order by count(chiTietHoaDon.xeID) desc ,sum(HoaDon.tongTien) desc")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			double tt = (double) rs[4];
			int soluong = (int) rs[3];
			Object[] o = { "Cửa Hàng Xe Máy Thành Nam", (String) rs[0], (String) rs[1], (String) rs[2], soluong,
					df.format(tt) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllCTNV(int ngay, int thang, int nam, String ma) {
		String header[] = { "Tên Xe", "Số Lượng", "Phiên Bản", "Phân Khối", "Doanh thu" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT NhanVien.maNhanVien, Xe.tenXe ,soluong=count(xe.tenXe), Xe.phienBan, Xe.phanKhoi, tong=sum(HoaDon.tongTien)\r\n"
						+ "				FROM     chiTietHoaDon INNER JOIN\r\n"
						+ "				                HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
						+ "				               Xe ON chiTietHoaDon.xeID = Xe.maXe INNER JOIN\r\n"
						+ "				                 NhanVien ON HoaDon.nhanVienID = NhanVien.maNhanVien\r\n"
						+ "				where day(ngayLapHoaDon)=" + ngay + " and month(ngayLapHoaDon)=" + thang
						+ " and year(ngayLapHoaDon)=" + nam + " and NhanVien.maNhanVien='" + ma + "'\r\n"
						+ "				group by  NhanVien.maNhanVien, Xe.tenXe, Xe.phienBan, Xe.phanKhoi")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			double tt = (double) rs[5];
			int soluong = (int) rs[2];
			int phankhoi = (int) rs[4];
			Object[] o = { (String) rs[1], soluong, (String) rs[3], phankhoi, df.format(tt) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllNV(int nam) {
		String header[] = { "Tên cửa hàng", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Số lượng", "Doanh thu" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT  NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.gioiTinh, soluong=count(chiTietHoaDon.xeID), tong=sum(HoaDon.tongTien)\r\n"
						+ "				FROM     chiTietHoaDon INNER JOIN\r\n"
						+ "				                HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
						+ "				              NhanVien ON HoaDon.nhanVienID = NhanVien.maNhanVien\r\n"
						+ "				where year(ngayLapHoaDon)=" + nam + "\r\n"
						+ "				group by  NhanVien.tenNhanVien, NhanVien.maNhanVien, NhanVien.gioiTinh\r\n"
						+ "				order by count(chiTietHoaDon.xeID) desc ,sum(HoaDon.tongTien) desc")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			double tt = (double) rs[4];
			int soluong = (int) rs[3];
			Object[] o = { "Cửa Hàng Xe Máy Thành Nam", (String) rs[0], (String) rs[1], (String) rs[2], soluong,
					df.format(tt) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllCTNV(int nam, String ma) {
		String header[] = { "Tên Xe", "Số Lượng", "Phiên Bản", "Phân Khối", "Doanh thu" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT NhanVien.maNhanVien, Xe.tenXe ,soluong=count(xe.tenXe), Xe.phienBan, Xe.phanKhoi, tong=sum(HoaDon.tongTien)\r\n"
						+ "				FROM     chiTietHoaDon INNER JOIN\r\n"
						+ "				                 HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
						+ "				                Xe ON chiTietHoaDon.xeID = Xe.maXe INNER JOIN\r\n"
						+ "				               NhanVien ON HoaDon.nhanVienID = NhanVien.maNhanVien\r\n"
						+ "				where year(ngayLapHoaDon)=" + nam + " and NhanVien.maNhanVien='" + ma + "'\r\n"
						+ "				group by  NhanVien.maNhanVien, Xe.tenXe, Xe.phienBan, Xe.phanKhoi")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			double tt = (double) rs[5];
			int soluong = (int) rs[2];
			int phankhoi = (int) rs[4];
			Object[] o = { (String) rs[1], soluong, (String) rs[3], phankhoi, df.format(tt) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllNV(int thang, int nam) {
		String header[] = { "Tên cửa hàng", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Số lượng", "Doanh thu" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT  NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.gioiTinh, soluong=count(chiTietHoaDon.xeID), tong=sum(HoaDon.tongTien)\r\n"
						+ "				FROM     chiTietHoaDon INNER JOIN\r\n"
						+ "				                 HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
						+ "				                 NhanVien ON HoaDon.nhanVienID = NhanVien.maNhanVien\r\n"
						+ "				where month(ngayLapHoaDon)=" + thang + " and year(ngayLapHoaDon)=" + nam
						+ "\r\n"
						+ "				group by  NhanVien.tenNhanVien, NhanVien.maNhanVien, NhanVien.gioiTinh\r\n"
						+ "				order by count(chiTietHoaDon.xeID) desc ,sum(HoaDon.tongTien) desc")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			double tt = (double) rs[4];
			int soluong = (int) rs[3];
			Object[] o = { "Cửa Hàng Xe Máy Thành Nam", (String) rs[0], (String) rs[1], (String) rs[2], soluong,
					df.format(tt) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllCTNV(int thang, int nam, String ma) {
		String header[] = { "Tên Xe", "Số Lượng", "Phiên Bản", "Phân Khối", "Doanh thu" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT NhanVien.maNhanVien, Xe.tenXe ,soluong=count(xe.tenXe), Xe.phienBan, Xe.phanKhoi, tong=sum(HoaDon.tongTien)\r\n"
						+ "				FROM     chiTietHoaDon INNER JOIN\r\n"
						+ "			                HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
						+ "				                Xe ON chiTietHoaDon.xeID = Xe.maXe INNER JOIN\r\n"
						+ "				                  NhanVien ON HoaDon.nhanVienID = NhanVien.maNhanVien\r\n"
						+ "				where month(ngayLapHoaDon)=" + thang + " and year(ngayLapHoaDon)=" + nam
						+ " and NhanVien.maNhanVien='" + ma + "'\r\n"
						+ "				group by  NhanVien.maNhanVien, Xe.tenXe, Xe.phienBan, Xe.phanKhoi")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			double tt = (double) rs[5];
			int soluong = (Integer) rs[2];
			int phankhoi = (int) rs[4];
			Object[] o = { (String) rs[1], soluong, (String) rs[3], phankhoi, df.format(tt) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllYear(int nam) {
		String header[] = { "Tên Xe", "Số Lượng", "Tổng tiền thu được" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("SELECT Xe.tenXe, soluong=count(xe.tenXe), tong=sum(HoaDon.tongTien)\r\n"
				+ "				FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "				                HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "			               Xe ON chiTietHoaDon.xeID = Xe.maXe\r\n"
				+ "				where YEAR(ngayLapHoaDon)=" + nam + "\r\n" + "				group by xe.tenXe\r\n"
				+ "				order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
			double tt = (double) rs[2];
			int soluong = (int) rs[1];
			Object[] o = { (String) rs[0], soluong, df.format(tt) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public int BieuDoXeNhap(int thang, int nam) {
		int count = 0;
		Object query = em.createNativeQuery("select soluong=count(maXe) from Xe where YEAR(ngaynhap)=" + nam
				+ " and  Month(ngaynhap)=" + thang + "").getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int BieuDoXeBan(int thang, int nam) {
		int count = 0;
		Object query = em.createNativeQuery("SELECT soluong=count(xe.maXe)\r\n"
				+ "					FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "					          HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "					               Xe ON chiTietHoaDon.xeID = Xe.maXe\r\n"
				+ "					where MONTH(ngayLapHoaDon)=" + thang + " and YEAR(ngayLapHoaDon)=" + nam + "")
				.getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int SoLuongKhachHangTrongThang(int thang, int nam) {
		int count = 0;
		Object query = em.createNativeQuery("select soluong=count(maKhachHang) from KhachHang where YEAR(ngayGiaNhap)="
				+ nam + " and  Month(ngayGiaNhap)=" + thang + "").getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int TongTienTheoThang(int thang, int nam) {
		int count = 0;
		Object query = em.createNativeQuery("select tong=sum(tongTien) from HoaDon where YEAR(ngayLapHoaDon)=" + nam
				+ " and Month(ngayLapHoaDon)=" + thang + "").getSingleResult();
		if (query != null) {
			double kq = (double) query;
			return (int) kq;
		}
		return count;
	}

	public int BieuDoXeNhap(int ngay, int thang, int nam) {
		int count = 0;
		Object query = em.createNativeQuery("select soluong=count(maXe) from Xe where day(ngaynhap)=" + ngay
				+ " and YEAR(ngaynhap)=" + nam + " and  Month(ngaynhap)=" + thang + "").getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int BieuDoXeBan(int ngay, int thang, int nam) {
		int count = 0;
		Object query = em.createNativeQuery("SELECT soluong=count(xe.maXe)\r\n"
				+ "					FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "					              HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "					             Xe ON chiTietHoaDon.xeID = Xe.maXe\r\n"
				+ "					where DAY(ngayLapHoaDon)=" + ngay + " and MONTH(ngayLapHoaDon)=" + thang
				+ " and YEAR(ngayLapHoaDon)=" + nam + "").getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int BieuDoKhachHangTheoNgay(int ngay, int thang, int nam) {
		int count = 0;
		Object query = em.createNativeQuery("select soluong=count(maKhachHang) from KhachHang where day(ngayGiaNhap)="
				+ ngay + " and YEAR(ngayGiaNhap)=" + nam + " and  Month(ngayGiaNhap)=" + thang + "").getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int TongTienTheoNgay(int ngay, int thang, int nam) {
		int count = 0;
		Object query = em
				.createNativeQuery("select tong=sum(tongTien) from HoaDon where day(ngayLapHoaDon)=" + ngay
						+ " and YEAR(ngayLapHoaDon)=" + nam + " and Month(ngayLapHoaDon)=" + thang + "")
				.getSingleResult();
		if (query != null) {
			double kq = (double) query;
			return (int) kq;
		}
		return count;
	}

	public int SoLuongXeNhapTrongNam(int nam) {
		int count = 0;
		Object query = em.createNativeQuery("select soluong=count(maXe) from Xe where YEAR(ngaynhap)=" + nam + "")
				.getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int SoLuongXeBanTrongNam(int nam) {
		int count = 0;
		Object query = em.createNativeQuery("SELECT soluong=count(xe.maXe)\r\n"
				+ "					FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "					                  HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "					            Xe ON chiTietHoaDon.xeID = Xe.maXe\r\n"
				+ "					where YEAR(ngayLapHoaDon)=" + nam + "").getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int SoLuongKhachHangTrongNam(int nam) {
		int count = 0;
		Object query = em
				.createNativeQuery(
						"select soluong=count(maKhachHang) from khachhang where YEAR([ngayGiaNhap])=" + nam + "")
				.getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int TongTienTheoNam(int nam) {
		int count = 0;
		Object query = em
				.createNativeQuery("select tong=sum(tongTien) from HoaDon where YEAR(ngayLapHoaDon)=" + nam + "")
				.getSingleResult();
		if (query != null) {
			double kq = (double) query;
			return (int) kq;
		}
		return count;
	}

	public Xe XeNhieuNhat() {
		List<?> query = em
				.createNativeQuery("SELECT top 1 Xe.tenXe, soluong=count(xe.tenXe), tong=sum(HoaDon.tongTien)\r\n"
						+ "						FROM     chiTietHoaDon INNER JOIN\r\n"
						+ "					                  HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
						+ "						                 Xe ON chiTietHoaDon.xeID = Xe.maXe\r\n"
						+ "						group by xe.tenXe\r\n"
						+ "						order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String count = (String) rs[0];
			List<Xe> query1 = em.createNativeQuery("select * from Xe where tenXe=?", Xe.class).setParameter(1, count)
					.getResultList();
			for (Xe xe : query1) {
				return xe;
			}
		}
		return null;
	}

	public String XeItNhat() {
		String count = "";
		List<?> query = em
				.createNativeQuery(
						"select aaa=(ROW_NUMBER() over (order by tenXe)),  tenXe, soluong =count(xe.tenXe)  from Xe\r\n"
								+ "						where maXe not in (select maXe from ChiTietHoaDon)\r\n"
								+ "						group by xe.tenXe\r\n"
								+ "						order by ROW_NUMBER() over (order by tenXe) desc")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			count = (String) rs[0];
		}
		return count;
	}

	public int TuoiTrungBinh() {
		int count = 0;
		Object query = em.createNativeQuery("SELECT sum(DATEDIFF(year, ngaySinh,GETDATE()))/count(maKhachHang)\r\n"
				+ "						FROM KhachHang").getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return count;
	}

	public int TiLe(int tuoi1, int tuoi2) {
		int count = 0;
		List<?> query = em
				.createNativeQuery("SELECT DATEDIFF(year, ngaySinh,GETDATE()) AS AgeTB, maKhachHang\\r\\n\"\r\n"
						+ "						+ \"    FROM KhachHang\\r\\n\"\r\n"
						+ "						+ \"	where DATEDIFF(year, ngaySinh,GETDATE())>" + tuoi1
						+ "  and DATEDIFF(year, ngaySinh,GETDATE())<=" + tuoi2 + "")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			count = (int) rs[0];
		}
		return count;
	}

	public double SoLuongTuoi(int tuoi1, int tuoi2) {
		double count = 0;
		try {
			Object[] query = (Object[]) em.createNativeQuery(
					"SELECT top 1 aaa=(ROW_NUMBER() over (order by DATEDIFF(year, ngaySinh,GETDATE()))) ,maKhachHang\r\n"
							+ "							    from KhachHang\r\n"
							+ "						where DATEDIFF(year, ngaySinh,GETDATE())>" + tuoi1
							+ "  and DATEDIFF(year, ngaySinh,GETDATE())<=" + tuoi2 + "\r\n"
							+ "					order by DATEDIFF(year, ngaySinh,GETDATE()) desc")
					.getSingleResult();
			if (query != null) {
				count = ((BigInteger) query[0]).doubleValue();
			}
		} catch (NoResultException e) {
			return count = 2;
		}
		return count;
	}
}
