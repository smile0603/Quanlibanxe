package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.table.DefaultTableModel;

import entity.ChiTietHoaDon;
import entity.HangSanXuat;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiXe;
import entity.Xe;
import util.HibernateUtil;

public class HoaDonDao {
	private EntityManager em;

	public HoaDonDao() {

		em = HibernateUtil.getIntance().getEntityManager();
	}

	public HoaDon getHoaDonByID(String ID) {
		return em.find(HoaDon.class, ID);
	}

	public String getMaHDTail(String properties, String table) {

		Object query = em
				.createNativeQuery(
						" select Top 1 " + properties + " from " + table + " order by " + properties + " desc")
				.getSingleResult();
		if (query != null) {
			String kq = (String) query;
			String[] parts = kq.split("_");
			int so = Integer.parseInt(parts[1]) + 1;
			return parts[0] + "_" + String.format("%04d", so);
		}

		return null;
	}

	public double getTotalMoneyHD(String maHD) {
		List<?> query = em.createNativeQuery("select tongTien ,maHoaDon from HoaDon where maHoaDon =?")
				.setParameter(1, maHD).getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			double tongTien = (double) rs[0];
			return tongTien;
		}
		return -1;
	}

	public KhachHang getKhachHangbyHDId(String maHD) {
		List<?> query = em.createNativeQuery("select khachHangID ,maHoaDon from HoaDon where maHoaDon = ?")
				.setParameter(1, maHD).getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String id = (String) rs[0];
			KhachHang khachHang = em.find(KhachHang.class, id);
			return khachHang;
		}
		return null;
	}

	public ArrayList<Xe> getListOrderDetails(String maHD) {
		ArrayList<Xe> list = new ArrayList<Xe>();
		List<?> query = em.createNativeQuery("select xeID ,hoaDonID from ChiTietHoaDon where hoaDonID =?")
				.setParameter(1, maHD).getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String id = (String) rs[0];
			Xe xe = em.find(Xe.class, id);
			list.add(xe);
		}
		return list;
	}

	public boolean createHD(HoaDon hd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hd);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean createCTHD(ChiTietHoaDon cthd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(cthd);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public DefaultTableModel getAllOrder() {
		String header[] = { "Mã Hóa Đơn", "Mã Khách Hàng", "Tên Khách Hàng", "CMND/TCC", "Mã Nhân Viên",
				"Tên Nhân viên", "Ngày LHD", "Tổng Tiền" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		List<?> query = em.createNativeQuery("select Top 50 hd.*, kh.tenKhachHang, kh.CMND, nv.tenNhanVien \r\n"
				+ "								from HoaDon hd, KhachHang kh, NhanVien nv \r\n"
				+ "								where hd.khachHangID = kh.maKhachHang and hd.nhanVienID = nv.maNhanVien \r\n"
				+ "								order by maHoaDon desc").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			double tien = (double) rs[2];
			Date ngaylap = (Date) rs[1];
			Object[] o = { (String) rs[0], (String) rs[3], (String) rs[5], (String) rs[6], (String) rs[4],
					(String) rs[7], ngaylap.toString(), df.format(tien) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllOrderById(String maHD, String maKH, String tenKH, String ngay) throws SQLException {
		String header[] = { "Mã Hóa Đơn", "Mã Khách Hàng", "Tên Khách Hàng", "CMND/TCC", "Mã Nhân Viên",
				"Tên Nhân viên", "Ngày LHD", "Tổng Tiền" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		List<?> query = em.createNativeQuery("select hd.*, kh.tenKhachHang, kh.CMND, nv.tenNhanVien \r\n"
				+ "	from HoaDon hd, KhachHang kh, NhanVien nv \r\n"
				+ "	where hd.khachHangID = kh.maKhachHang and hd.nhanVienID = nv.maNhanVien and \r\n"
				+ "	hd.maHoaDon like '%" + maHD + "%' and hd.khachHangID like '%" + maKH
				+ "%' and kh.tenKhachHang like N'%" + tenKH + "%' and hd.ngayLapHoaDon like '%" + ngay + "%'\r\n"
				+ "	order by hd.maHoaDon desc").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			double tien = (double) rs[2];
			Date ngay1 = (Date) rs[1];
			Object[] o = { (String) rs[0], (String) rs[3], (String) rs[5], (String) rs[6], (String) rs[4],
					(String) rs[7], ngay1.toString(), df.format(tien) };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getOrderDetails(String maHD) throws SQLException {
		String[] header2 = { "Mã Hóa Đơn", "Mã Xe", "Tên Xe", "Loại Xe", "Phiên Bản", "Màu xe", "Phân Khối",
				"Hãng Sản Xuất", "Số Khung", "Số Máy", "Đơn Giá", "Thuế VAT", "Thành tiền" };
		DefaultTableModel tableModel = new DefaultTableModel(header2, 0);
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		XeDao xeDao = new XeDao();
		LoaiXeDao loaiXeDao = new LoaiXeDao();
		HangSanXuatDao hangSanXuatDao = new HangSanXuatDao();
		List<ChiTietHoaDon> query = em
				.createNativeQuery("select * from ChiTietHoaDon where hoaDonID =?", ChiTietHoaDon.class)
				.setParameter(1, maHD).getResultList();
		for (ChiTietHoaDon chiTietHoaDon : query) {
			Xe xe = xeDao.getInfoXe("maXe", chiTietHoaDon.getXe().getMaXe().toString());
			LoaiXe lx = loaiXeDao.layLoaiXeById(xe.getLoaiXe().getMaLoaiXe().toString());
			HangSanXuat hsx = hangSanXuatDao.getHangSanXuatById(xe.getHangSanXuat().getMaHangSX());
			Object[] o = { chiTietHoaDon.getHoaDon().getMaHoaDon(), chiTietHoaDon.getXe().getMaXe(), xe.getTenXe(),
					lx.getTenLoaiXe(), xe.getPhienBan(), xe.getMauXe(), xe.getPhanKhoi(), hsx.getTenHangSX(),
					xe.getSoKhung(), xe.getSoMay(), df.format(chiTietHoaDon.getDonGia()),
					df.format(chiTietHoaDon.getThueVAT()), df.format(xe.getThanhTien()) };
			tableModel.addRow(o);
		}
		return tableModel;
	}
}
