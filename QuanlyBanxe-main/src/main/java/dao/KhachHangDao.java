package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.table.DefaultTableModel;

import entity.KhachHang;
import util.HibernateUtil;

public class KhachHangDao {
	private EntityManager em;

	public KhachHangDao() {

		em = HibernateUtil.getIntance().getEntityManager();
	}

	public boolean themKhachHang(KhachHang khachHang) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean xoaKhachHang(String makh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			KhachHang khachHang = em.find(KhachHang.class, makh);
			em.remove(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean capnhatKhachHang(KhachHang khachHang) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public KhachHang layKhachHangById(String makh) {

		return em.find(KhachHang.class, makh);
	}

	public int TongKhachHang() {
		int sl = 0;
		Object query = em.createNativeQuery("select count(maKhachHang) from KhachHang").getSingleResult();
		sl = (int) query;
		return sl;
	}

	public int TongKhachNam() {
		int sl = 0;
		Object query = em.createNativeQuery("select count(maKhachHang) from KhachHang where gioiTinh = N'Nam'")
				.getSingleResult();
		sl = (int) query;
		return sl;
	}

	public int TongKhachNu() {
		int sl = 0;
		Object query = em.createNativeQuery("select count(maKhachHang) from KhachHang where gioiTinh = N'Nữ'")
				.getSingleResult();
		sl = (int) query;
		return sl;
	}

	public DefaultTableModel timKiem(String id) throws SQLException {
		String[] header = { "Mã Khách Hàng", "Tên Khách Hàng", "CMND", "Giới Tính", "Ngày Sinh", "Ngày Gia Nhập",
				"Địa Chỉ", "Email", "Số Điện Thoại", "Ghi Chú" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em
				.createNativeQuery("select * from KhachHang where cmnd like '" + id + "' or maKhachHang like '" + id
						+ "' or tenKhachHang like '" + id + "' or soDienThoai like '" + id + "'")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[9], (String) rs[1], (String) rs[5], (Date) rs[6], (Date) rs[7],
					(String) rs[3], (String) rs[4], (String) rs[8], (String) rs[2] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAllKH() throws SQLException {
		String[] header = { "Mã Khách Hàng", "Tên Khách Hàng", "Chứng minh", "Giới Tính", "Ngày Sinh", "Ngày Gia Nhập",
				"Địa Chỉ", "Email", "Số Điện Thoại", "Ghi Chú" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("select * from KhachHang").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Date ngay = (Date) rs[6];
			Date ngayvaoLam = (Date) rs[7];
			Object[] o = { (String) rs[0], (String) rs[9], (String) rs[1], (String) rs[5], ngay, ngayvaoLam,
					(String) rs[3], (String) rs[4], (String) rs[8], (String) rs[2] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public KhachHang getKhachHangTail() {
		List<KhachHang> query = em
				.createNativeQuery("select top 1 * from KhachHang order by maKhachHang desc", KhachHang.class)
				.getResultList();
		if (query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	public ArrayList<String> getListCMND() {
		ArrayList<String> list_CMND = new ArrayList<String>();
		List<?> query = em.createNativeQuery("Select CMND,tenKhachHang from KhachHang").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String CMND = (String) rs[0];
			list_CMND.add(CMND);
		}
		return list_CMND;
	}

	public KhachHang getKhachHangById(String string, String text) {
		List<KhachHang> query = em
				.createNativeQuery("select * from KhachHang where " + string + " = ?", KhachHang.class)
				.setParameter(1, text).getResultList();
		if (query.size() > 0) {
			return query.get(0);
		}
		return null;
	}
}
