package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import entity.HangSanXuat;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Xe;
import util.HibernateUtil;

public class XeDao {

	private EntityManager em;

	public XeDao() {

		em = HibernateUtil.getIntance().getEntityManager();
	}

	public boolean themXe(Xe xe) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(xe);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean xoaXe(String maxe) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			Xe xe = em.find(Xe.class, maxe);
			em.remove(xe);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean capnhatXe(Xe xe) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(xe);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public Xe layXeById(String maxe) {
		return em.find(Xe.class, maxe);
	}

	public int getAmountByVehicleID(String maXe) {
		Object query = em.createNativeQuery("select soLuong from Xe where maXe = ?").getSingleResult();
		return 0;
	}

	public void getListTenXe(JComboBox comboBox) {
		List<String> query = em.createNativeQuery("SELECT DISTINCT tenXe FROM Xe order by tenXe asc").getResultList();
		for (String string : query) {
			comboBox.addItem(string);
		}
	}

	public String getMaXeTail() {
		Object query = em.createNativeQuery("select Top 1 maXe from Xe order by maXe desc").getSingleResult();
		if (query != null) {
			String ma;
			ma = (String) query;
			String[] parts = ma.split("_");
			int so = Integer.parseInt(parts[1]) + 1;
			return parts[0] + "_" + String.format("%04d", so);
		}
		return null;
	}

	public String getHangXeTail() {
		Object query = em.createNativeQuery("select Top 1 maHangSX from HangSanXuat order by maHangSX desc")
				.getSingleResult();
		if (query != null) {
			String ma;
			ma = (String) query;
			String[] parts = ma.split("_");
			int so = Integer.parseInt(parts[1]) + 1;
			return parts[0] + "_" + String.format("%04d", so);
		}
		return null;
	}

	public ArrayList<String> getListVersion(String tenXe) {
		ArrayList<String> list = new ArrayList<String>();
		List<String> query = em
				.createNativeQuery(
						"SELECT DISTINCT phienBan FROM Xe WHERE tenXe = '" + tenXe + "' and trangThai = N'Còn hàng'")
				.getResultList();
		for (String string : query) {
			list.add(string);
		}
		return list;
	}

	public ArrayList<String> getListChassisNumber(String tenXe, String version, String mauXe) {
		ArrayList<String> list = new ArrayList<String>();
		List<String> query = em.createNativeQuery("SELECT DISTINCT soKhung FROM Xe WHERE tenXe = '" + tenXe
				+ "' and phienBan = N'" + version + "' " + "and mauXe = N'" + mauXe + "' and trangThai = N'Còn hàng'")
				.getResultList();
		for (String string : query) {
			list.add(string);
		}
		return list;
	}

	public ArrayList<String> getListColor(String tenXe, String version) {
		ArrayList<String> list = new ArrayList<String>();
		List<String> query = em.createNativeQuery("SELECT DISTINCT mauXe FROM Xe where tenXe = '" + tenXe
				+ "' and phienBan = N'" + version + "' and trangThai = N'Còn hàng'").getResultList();
		for (String string : query) {
			list.add(string);
		}
		return list;
	}

	public ArrayList<NhaCungCap> getAllNCC() {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		List<NhaCungCap> query = em.createNativeQuery("select * from nhaCungCap", NhaCungCap.class).getResultList();
		for (NhaCungCap nhaCungCap : query) {
			dsNCC.add(nhaCungCap);
		}
		return dsNCC;
	}

	public ArrayList<NhaCungCap> getAllNCC(String id) {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		List<NhaCungCap> query = em
				.createNativeQuery("select * from nhaCungCap where maNhaCungCap='" + id + "'", NhaCungCap.class)
				.getResultList();
		for (NhaCungCap nhaCungCap : query) {
			dsNCC.add(nhaCungCap);
		}
		return dsNCC;
	}

	public ArrayList<HangSanXuat> getAllHangSX() {
		ArrayList<HangSanXuat> dsHSX = new ArrayList<HangSanXuat>();
		List<HangSanXuat> query = em.createNativeQuery("select * from HangSanXuat", HangSanXuat.class).getResultList();
		for (HangSanXuat nhaCungCap : query) {
			dsHSX.add(nhaCungCap);
		}
		return dsHSX;
	}

	public ArrayList<HangSanXuat> getAllHangSX(String id) {
		ArrayList<HangSanXuat> dsNCC = new ArrayList<HangSanXuat>();
		List<HangSanXuat> query = em
				.createNativeQuery("select * from HangSanXuat where maHangSanXuat='" + id + "'", HangSanXuat.class)
				.getResultList();
		for (HangSanXuat nhaCungCap : query) {
			dsNCC.add(nhaCungCap);
		}
		return dsNCC;
	}

	public ArrayList<LoaiXe> getAllLoaiXe() {
		ArrayList<LoaiXe> dsHSX = new ArrayList<LoaiXe>();
		List<LoaiXe> query = em.createNativeQuery("select * from LoaiXe", LoaiXe.class).getResultList();
		for (LoaiXe nhaCungCap : query) {
			dsHSX.add(nhaCungCap);
		}
		return dsHSX;
	}

	public ArrayList<LoaiXe> getAllLoaiXe(String id) {
		ArrayList<LoaiXe> dsHSX = new ArrayList<LoaiXe>();
		List<LoaiXe> query = em.createNativeQuery("select * from LoaiXe where maLoaiXe=?", LoaiXe.class)
				.setParameter(1, id).getResultList();
		for (LoaiXe nhaCungCap : query) {
			dsHSX.add(nhaCungCap);
		}
		return dsHSX;
	}

	public Xe getInfoXe(String properties, String id) {
		List<Xe> query = em
				.createNativeQuery("select * from Xe where " + properties + " ='" + id + "'",
						Xe.class)
				.getResultList();
		for (Xe xe : query) {
			return xe;
		}
		return null;
	}
	public Xe getInfoXe22(String properties, String id) {
		List<Xe> query = em
				.createNativeQuery("select * from Xe where " + properties + " ='" + id + "' and trangThai =N'Còn hàng'",
						Xe.class)
				.getResultList();
		for (Xe xe : query) {
			return xe;
		}
		return null;
	}
	public DefaultTableModel getAllXe() throws SQLException {
		String[] header = { "Mã Xe", "Tên Xe", "Màu xe", "Loại xe", "Hãng sản xuất", "Nhà cung cấp", "Quốc gia",
				"Phân khối", "Giá nhập", "Ngày nhập", "Trạng thái", "Phiên Bản", "Số khung", "Số máy", "Chú thích",
				"Tổng tiền", "Ảnh" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSX, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai,Xe.PhienBan,xe.soKhung,xe.soMay, Xe.chuThich,Xe.img1\r\n"
						+ "				FROM     Xe INNER JOIN\r\n"
						+ "			            NhaCungCap ON Xe.nhaCungCapID = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
						+ "				            LoaiXe ON Xe.loaiXeID = LoaiXe.maLoaiXe INNER JOIN\r\n"
						+ "			             HangSanXuat ON Xe.hangSanXuatID = HangSanXuat.maHangSX order by xe.maxe DESC")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			NumberFormat num = NumberFormat.getNumberInstance();
			int phankhoi = (int) rs[7];
			double gia = (double) rs[8];
			Date ngay = (Date) rs[9];
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4],
					(String) rs[5], (String) rs[6], phankhoi, df.format(gia), ngay, (String) rs[10], (String) rs[11],
					(String) rs[12], (String) rs[13], (String) rs[14], df.format(gia), (String) rs[15] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel SapXepTangDanTen() throws SQLException {
		String[] header = { "Mã Xe", "Tên Xe", "Màu xe", "Loại xe", "Hãng sản xuất", "Nhà cung cấp", "Quốc gia",
				"Phân khối", "Giá nhập", "Ngày nhập", "Trạng thái", "Phiên Bản", "Số khung", "Số máy", "Chú thích",
				"Tổng tiền", "Ảnh" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSX, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai,Xe.PhienBan,xe.soKhung,xe.soMay, Xe.chuThich,Xe.img1\r\n"
						+ "				FROM     Xe INNER JOIN\r\n"
						+ "				              NhaCungCap ON Xe.nhaCungCapID = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
						+ "				             LoaiXe ON Xe.loaiXeID = LoaiXe.maLoaiXe INNER JOIN\r\n"
						+ "			            HangSanXuat ON Xe.hangSanXuatID = HangSanXuat.maHangSX order by xe.tenXe ASC")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			NumberFormat num = NumberFormat.getNumberInstance();

			double donGia = (double) rs[8];
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4],
					(String) rs[5], (String) rs[6], (int) rs[7], num.format(donGia), (Date) rs[9], (String) rs[10],
					(String) rs[11], (String) rs[12], (String) rs[13], (String) rs[14], df.format(donGia),
					(String) rs[15] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel SapXepGiamDanTen() throws SQLException {
		String[] header = { "Mã Xe", "Tên Xe", "Màu xe", "Loại xe", "Hãng sản xuất", "Nhà cung cấp", "Quốc gia",
				"Phân khối", "Giá nhập", "Ngày nhập", "Trạng thái", "Phiên Bản", "Số khung", "Số máy", "Chú thích",
				"Tổng tiền", "Ảnh" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSX, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai,Xe.PhienBan,xe.soKhung,xe.soMay, Xe.chuThich,Xe.img1\r\n"
						+ "				FROM     Xe INNER JOIN\r\n"
						+ "				              NhaCungCap ON Xe.nhaCungCapID = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
						+ "				             LoaiXe ON Xe.loaiXeID = LoaiXe.maLoaiXe INNER JOIN\r\n"
						+ "			            HangSanXuat ON Xe.hangSanXuatID = HangSanXuat.maHangSX order by xe.tenXe DESC")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			NumberFormat num = NumberFormat.getNumberInstance();
			double donGia = (double) rs[8];
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4],
					(String) rs[5], (String) rs[6], (int) rs[7], num.format(donGia), (Date) rs[9], (String) rs[10],
					(String) rs[11], (String) rs[12], (String) rs[13], (String) rs[14], df.format(donGia),
					(String) rs[15] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel SapXepTangDanGia() throws SQLException {
		String[] header = { "Mã Xe", "Tên Xe", "Màu xe", "Loại xe", "Hãng sản xuất", "Nhà cung cấp", "Quốc gia",
				"Phân khối", "Giá nhập", "Ngày nhập", "Trạng thái", "Phiên Bản", "Số khung", "Số máy", "Chú thích",
				"Tổng tiền", "Ảnh" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSX, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai,Xe.PhienBan,xe.soKhung,xe.soMay, Xe.chuThich,Xe.img1\r\n"
						+ "				FROM     Xe INNER JOIN\r\n"
						+ "				              NhaCungCap ON Xe.nhaCungCapID = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
						+ "				             LoaiXe ON Xe.loaiXeID = LoaiXe.maLoaiXe INNER JOIN\r\n"
						+ "			            HangSanXuat ON Xe.hangSanXuatID = HangSanXuat.maHangSX order by xe.giaNhap ASC")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			NumberFormat num = NumberFormat.getNumberInstance();
			double donGia = (double) rs[8];
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4],
					(String) rs[5], (String) rs[6], (int) rs[7], num.format(donGia), (Date) rs[9], (String) rs[10],
					(String) rs[11], (String) rs[12], (String) rs[13], (String) rs[14], df.format(donGia),
					(String) rs[15] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel SapXepGiamDanGia() throws SQLException {
		String[] header = { "Mã Xe", "Tên Xe", "Màu xe", "Loại xe", "Hãng sản xuất", "Nhà cung cấp", "Quốc gia",
				"Phân khối", "Giá nhập", "Ngày nhập", "Trạng thái", "Phiên Bản", "Số khung", "Số máy", "Chú thích",
				"Tổng tiền", "Ảnh" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSX, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai,Xe.PhienBan,xe.soKhung,xe.soMay, Xe.chuThich,Xe.img1\r\n"
						+ "				FROM     Xe INNER JOIN\r\n"
						+ "				              NhaCungCap ON Xe.nhaCungCapID = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
						+ "				             LoaiXe ON Xe.loaiXeID = LoaiXe.maLoaiXe INNER JOIN\r\n"
						+ "			            HangSanXuat ON Xe.hangSanXuatID = HangSanXuat.maHangSX order by xe.giaNhap DESC")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			NumberFormat num = NumberFormat.getNumberInstance();
			double donGia = (double) rs[8];
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4],
					(String) rs[5], (String) rs[6], (int) rs[7], num.format(donGia), (Date) rs[9], (String) rs[10],
					(String) rs[11], (String) rs[12], (String) rs[13], (String) rs[14], df.format(donGia),
					(String) rs[15] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel timKiem(String search) throws SQLException {
		String[] header = { "Mã Xe", "Tên Xe", "Màu xe", "Loại xe", "Hãng sản xuất", "Nhà cung cấp", "Quốc gia",
				"Phân khối", "Giá nhập", "Ngày nhập", "Trạng thái", "Phiên Bản", "Số khung", "Số máy", "Chú thích",
				"Tổng tiền", "Ảnh" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT Xe.maXe, Xe.tenXe, Xe.mauXe, LoaiXe.tenLoaiXe, HangSanXuat.tenHangSX, NhaCungCap.tenNhaCungCap, HangSanXuat.quocGia, Xe.phanKhoi, Xe.giaNhap, Xe.ngayNhap, Xe.trangThai,Xe.PhienBan,xe.soKhung,xe.soMay, Xe.chuThich,Xe.img1\r\n"
						+ "					FROM     Xe INNER JOIN\r\n"
						+ "					          NhaCungCap ON Xe.nhaCungCapID = NhaCungCap.maNhaCungCap INNER JOIN\r\n"
						+ "					               LoaiXe ON Xe.loaiXeID = LoaiXe.maLoaiXe INNER JOIN\r\n"
						+ "					               HangSanXuat ON Xe.hangSanXuatID = HangSanXuat.maHangSX where tenxe like '"
						+ search + "' or maxe like '" + search + "'")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			NumberFormat num = NumberFormat.getNumberInstance();
			double donGia = (double) rs[8];
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4],
					(String) rs[5], (String) rs[6], (int) rs[7], num.format(donGia), (Date) rs[9], (String) rs[10],
					(String) rs[11], (String) rs[12], (String) rs[13], (String) rs[14], df.format(donGia),
					(String) rs[15] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public ArrayList<Xe> getSoKhung() {
		ArrayList<Xe> list = new ArrayList<Xe>();
		List<Xe> query = em.createNativeQuery("Select * from Xe", Xe.class).getResultList();
		for (Xe xe : query) {
			list.add(xe);
		}
		return list;
	}

	public int XeDaBan() {
		int count = 0;
		List<?> query = em.createNativeQuery("select a=count(maXe), trangThai  from Xe\r\n"
				+ "						where trangThai = N'Hết hàng'\r\n" + "						group by trangThai")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			int kq = (int) rs[0];
			count = kq;
		}
		return count;
	}

	public int XeConLai() {
		List<?> query = em.createNativeQuery("select a=count(maXe), trangThai  from Xe\r\n"
				+ "						where trangThai = 'còn hàng'\r\n" + "						group by trangThai")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			int kq = (int) rs[0];
			return kq;
		}
		return 0;
	}

	public boolean updateTrangThai(String maXe, String string) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			Xe xe = em.find(Xe.class, maXe);
			xe.setTrangThai(string);
			em.merge(xe);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public ArrayList<String> getXeByTrangThai(String string, String string2) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		List<String> query = em.createNativeQuery(string).getResultList();
		for (String object : query) {
			list.add(object);
		}
		return list;
	}

	public void getSoKhungByTrangThai(String string, JComboBox cbbChasisNumber) {
		try {
			List<?> query = em.createNativeQuery(string).getResultList();
			cbbChasisNumber.removeAllItems();
			for (Object object : query) {
				Object[] rs = (Object[]) object;
				cbbChasisNumber.addItem((String) rs[0]);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public ArrayList<String> getAllTenXe(String ten) {
		ArrayList<String> aaa = new ArrayList<String>();
		List<String> query = em
				.createNativeQuery(
						" select DISTINCT " + ten + " from Xe where trangThai =N'Còn hàng' order by " + ten + "")
				.getResultList();
		for (String string : query) {
			aaa.add(string);
		}
		return aaa;
	}
}
