package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import entity.HopDong;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhanVien;
import entity.Xe;
import util.HibernateUtil;

public class HopDongDao {
	private EntityManager em;

	public HopDongDao() {

		em = HibernateUtil.getIntance().getEntityManager();
	}

	public HopDong getInfoHD(String properties) {
		XeDao dao_xe = new XeDao();
		KhachHangDao dao_kh = new KhachHangDao();
		NhanVienDao dao_nv = new NhanVienDao();
		LoaiXeDao dao_lx = new LoaiXeDao();
		List<HopDong> query = em.createNativeQuery("select * from HopDong  where " + properties + " ", HopDong.class)
				.getResultList();
		for (HopDong hopDong : query) {
			Xe xe = dao_xe.getInfoXe("maXe", hopDong.getXe().getMaXe());
			KhachHang kh = dao_kh.layKhachHangById(hopDong.getKhachHang().getMaKhachHang());
			NhanVien nv = dao_nv.layNhanVienById(hopDong.getNhanVien().getMaNhanVien());
			String maHD = hopDong.getMaHD();
			Date ngayLap = hopDong.getNgayLap();
			int tgbh = hopDong.getThoiGianBaoHanh();
			HopDong kq = new HopDong(maHD, kh, nv, xe, ngayLap, tgbh);
			return kq;
		}
		return null;
	}

	public HopDong getHopDongByVehicleNum(String maXe) {
		List<HopDong> query = em.createNativeQuery("select * from HopDong where xeID =?", HopDong.class)
				.setParameter(1, maXe).getResultList();
		if (query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	public DefaultTableModel getAllXe() throws SQLException {
		String[] header = { "Mã xe", "Tên xe", "Loại xe", "Phiên bản", "Màu xe", "Phân khối", "Số khung", "Số máy",
				"Đơn giá", "Thuế", "Trạng thái" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);

		List<?> query = em
				.createNativeQuery(
						"select maxe,tenxe,loaiXeID,phienban,mauxe,phankhoi,sokhung,somay,gianhap,trangthai from Xe")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			DecimalFormat df1 = new DecimalFormat("############");

			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4], (int) rs[5],
					(String) rs[6], (String) rs[7], (double) rs[8], "", (String) rs[9] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllHD() throws SQLException {
		String[] header1 = { "Mã hợp đồng", "CMND", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Mã nhân viên",
				"Tên nhân viên", "Mã xe", "Tên xe", "Loại xe", "Phiên bản", "Màu xe", "Phân khối", "Số khung", "Số máy",
				"Đơn giá", "Thuế", "Ngày lập hợp đồng", "Thời gian bảo hành" };
		DefaultTableModel tableModel = new DefaultTableModel(header1, 0);
		XeDao dao_xe = new XeDao();
		KhachHangDao dao_kh = new KhachHangDao();
		NhanVienDao dao_nv = new NhanVienDao();
		LoaiXeDao dao_lx = new LoaiXeDao();
		List<?> query = em.createNativeQuery("select Top 50 * from HopDong order by maHD desc").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Xe xe = dao_xe.getInfoXe("maXe", (String) rs[5]);
			System.out.println(xe);
			LoaiXe lx = dao_lx.layLoaiXeById(xe.getLoaiXe().getMaLoaiXe());
			KhachHang kh = dao_kh.layKhachHangById((String) rs[3]);
			NhanVien nv = dao_nv.layNhanVienById((String) rs[4]);
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			DecimalFormat df1 = new DecimalFormat("############");
			Object[] o = { (String) rs[0], kh.getCMND(), kh.getTenKhachHang(), kh.getSoDienThoai(), kh.getDiaChi(),
					nv.getMaNhanVien(), nv.getTenNhanVien(), xe.getMaXe(), xe.getTenXe(), lx.getTenLoaiXe(),
					xe.getPhienBan(), xe.getMauXe(), xe.getPhanKhoi(), xe.getSoKhung(), xe.getSoMay(),
					df.format(xe.getDonGia()), df.format(xe.getThueVAT()), (Date) rs[1], (Integer) rs[2] + "" };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public ArrayList<String> getListXeByCustomer(String maKH, String ngay) {
		ArrayList<String> listXe = new ArrayList<String>();
		List<?> query = em.createNativeQuery("select distinct xeID,maHoaDon from HoaDon hd, ChiTietHoaDon cthd\r\n"
				+ "where hd.maHoaDon = cthd.hoaDonID and khachHangID = '" + maKH + "' and ngayLapHoaDon like '%" + ngay
				+ "%'").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			listXe.add((String) rs[0]);
		}
		return listXe;
	}

	public boolean themHD(HopDong hd) {
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

	public DefaultTableModel timKiem(String cmnd) throws SQLException {
		String[] header = { "Mã hợp đồng", "CMND", "Tên khách hàng", "Số điện thoại", "Mã xe", "Tên xe", "Loại xe",
				"Phiên bản", "Phân khối", "Số khung", "Số máy", "Đơn giá", "Thuế", "Ngày lập", "Thời gian bảo hành" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"select maHD,CMND,tenKhachHang,soDienThoai,maXe,tenXe,loaiXeID,phienBan,phanKhoi,soKhung,soMay,giaNhap,ngayLap,thoiGianBaoHanh from HopDong inner join KhachHang ON HopDong.khachHangID = KhachHang.maKhachHang  "
						+ "inner join  Xe ON HopDong.xeID = Xe.maXe where CMND like '%" + cmnd
						+ "%' order by maHD desc")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			DecimalFormat df1 = new DecimalFormat("############");
			double donGia = (double) rs[11];
			Date ngaylap = (Date) rs[12];
			int phankhoi = (int) rs[8];
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4],
					(String) rs[5], (String) rs[6], (String) rs[7], phankhoi, (String) rs[9], (String) rs[10],
					df.format(donGia), "", ngaylap, (int) rs[13] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel timKiemXe(String tenXe) throws SQLException {
		String[] header = { "Mã xe", "Tên xe", "Loại xe", "Phiên bản", "Phân khối", "Số khung", "Số máy", "Đơn giá",
				"Thuế" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("select * from Xe inner join  HopDong ON Xe.maXe=HopDong.xeID inner join"
				+ " KhachHang ON HopDong.khachHangID=KhachHang.maKhachHang where Xe.tenXe like '%" + tenXe + "%'")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[10], (String) rs[13], (String) rs[7], (int) rs[6],
					(String) rs[8], (String) rs[9], (double) rs[2], "" };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel timKiemNgay(String ngayLap) throws SQLException {
		String[] header = { "Mã hợp đồng", "CMND", "Tên khách hàng", "Số điện thoại", "Mã xe", "Tên xe", "Loại xe",
				"Phiên bản", "Phân khối", "Số khung", "Số máy", "Đơn giá", "Thuế", "Ngày lập", "Thời gian bảo hành" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em
				.createNativeQuery(
						"select * from HopDong inner join KhachHang ON HopDong.khachHangID = KhachHang.maKhachHang "
								+ "inner join  Xe ON HopDong.xeID = Xe.maXe where HopDong.ngayLap=?")
				.setParameter(1, ngayLap).getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[7], (String) rs[15], (String) rs[14], (String) rs[5],
					(String) rs[26], (String) rs[29], (String) rs[23], (int) rs[22], (String) rs[24], (String) rs[25],
					(double) rs[18], "", (String) rs[1], (int) rs[2] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel locData(String cmnd, String ngayLap) throws SQLException {
		String[] header = { "Mã xe", "Tên xe", "Loại xe", "Phiên bản", "Phân khối", "Số khung", "Số máy", "Đơn giá",
				"Thuế" };
		DefaultTableModel tableModel1 = new DefaultTableModel(header, 0);
		XeDao dao_xe = new XeDao();
		List<?> query = em.createNativeQuery(
				"select chiTietHoaDon.* from chiTietHoaDon,HoaDon,HopDong,KhachHang where HoaDon.maHoaDon=chiTietHoaDon.hoaDonID"
						+ " and KhachHang.CMND =? and HoaDon.ngayLapHoaDon=?")
				.setParameter(1, cmnd).setParameter(2, ngayLap).getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Xe xe = em.find(Xe.class, (String) rs[2]);
			Object[] o = { xe.getMaXe(), xe.getTenXe(), xe.getLoaiXe().getTenLoaiXe(), xe.getPhienBan(),
					xe.getPhanKhoi(), xe.getSoKhung(), xe.getSoMay(), xe.getDonGia(), "" };
			tableModel1.addRow(o);
		}
		return tableModel1;
	}

	public void xoaHD(String maHD) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			HopDong hopDong = em.find(HopDong.class, maHD);
			em.remove(hopDong);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}

	public boolean update(HopDong hd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(hd);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public ArrayList<NhanVien> getAllNV() {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		List<NhanVien> query = em.createNativeQuery("select * from NhanVien", NhanVien.class).getResultList();
		for (NhanVien nhanVien : query) {
			dsNV.add(nhanVien);
		}
		return dsNV;
	}

	public ArrayList<KhachHang> getAllKH() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		List<KhachHang> query = em.createNativeQuery("select * from KhachHang", KhachHang.class).getResultList();
		for (KhachHang khachHang : query) {
			dsKH.add(khachHang);
		}
		return dsKH;
	}

	public ArrayList<Xe> getAllXes() {
		ArrayList<Xe> dsXe = new ArrayList<Xe>();
		List<Xe> query = em.createNativeQuery("select * from Xe", Xe.class).getResultList();
		for (Xe xe : query) {
			dsXe.add(xe);
		}
		return dsXe;
	}

	public ArrayList<LoaiXe> getAllLoai() {
		ArrayList<LoaiXe> dsXe = new ArrayList<LoaiXe>();
		List<LoaiXe> query = em.createNativeQuery("select * from LoaiXe", LoaiXe.class).getResultList();
		for (LoaiXe xe : query) {
			dsXe.add(xe);
		}
		return dsXe;
	}

	public void getList(String tenXe, JComboBox comboBox) {
		List<?> query = em
				.createNativeQuery("select DISTINCT HangSanXuat.tenHangSX ,HangSanXuat.quocGia from Xe, HangSanXuat"
						+ " where Xe.hangSanXuatID=HangSanXuat.maHangSX and tenXe =?")
				.setParameter(1, tenXe).getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			comboBox.addItem((String) rs[0]);
		}
	}

	public HopDong getInfoHDG(String properties, String id) {

		List<HopDong> query = em.createNativeQuery("select * from HopDong where " + properties + " = ?", HopDong.class)
				.setParameter(1, id).getResultList();
		if (query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	public String getMaHDGTail(String properties, String table) {
		List<?> query = em
				.createNativeQuery(
						"select Top 1 " + properties + " from " + table + " order by " + properties + " desc")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String ma = (String) rs[0];
			String[] parts = ma.split("_");
			int so = Integer.parseInt(parts[1]) + 1;
			return parts[0] + "_" + String.format("%04d", so);
		}
		return null;
	}

	public HopDong getAllHopDong(String ma) {

		List<HopDong> query = em.createNativeQuery("select * from HopDong where maHopDong='" + ma + "'", HopDong.class)
				.getResultList();
		if (query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	public DefaultTableModel getAllCTHD(int thang, int nam) throws SQLException {
		String header[] = { "Tên Xe", "Số Lượng", "Tổng tiền thu được" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("SELECT Xe.tenXe, soluong=count(xe.tenXe), tong=sum(HoaDon.tongTien)\r\n"
				+ "					FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "					               HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "					                 Xe ON chiTietHoaDon.xeID = Xe.maXe\r\n"
				+ "					where MONTH(ngayLapHoaDon)='" + thang + "' and YEAR(ngayLapHoaDon)='" + nam
				+ "'\r\n" + "					group by xe.tenXe\r\n"
				+ "					order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (int) rs[1], (double) rs[2] };
			tableModel.addRow(o);
		}

		return tableModel;
	}

	public DefaultTableModel getAllCTHD(int ngay, int thang, int nam) throws SQLException {
		String header[] = { "Tên Xe", "Số Lượng", "Tổng tiền thu được" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("SELECT Xe.tenXe, soluong=count(xe.tenXe), tong=sum(HoaDon.tongTien)\r\n"
				+ "					FROM     chiTietHoaDon INNER JOIN\r\n"
				+ "					               HoaDon ON chiTietHoaDon.hoaDonID = HoaDon.maHoaDon INNER JOIN\r\n"
				+ "					                 Xe ON chiTietHoaDon.xeID = Xe.maXe\r\n"
				+ "					where MONTH(ngayLapHoaDon)='" + thang + "' and YEAR(ngayLapHoaDon)='" + nam
				+ " and Day(ngayLapHoaDon)=" + ngay + "'\r\n" + "					group by xe.tenXe\r\n"
				+ "					order by count(xe.tenXe) desc ,sum(HoaDon.tongTien) desc").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (int) rs[1], (double) rs[2] };
			tableModel.addRow(o);
		}

		return tableModel;
	}

	public DefaultTableModel getAllKH(int thang, int nam) throws SQLException {
		String[] header = { "Tên Khách Hàng", "Giới tính", "Số điện thoại" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("select tenKhachHang,gioiTinh,sdt from khachhang where month(ngayGiaNhap)="
				+ thang + " and year(ngayGiaNhap)=" + nam + "").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllKH(int nam) throws SQLException {
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
}
