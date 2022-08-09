package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.table.DefaultTableModel;

import entity.HoaDon;
import entity.LoaiXe;
import entity.NhaCungCap;
import util.HibernateUtil;

public class NhaCungCapDao {
	private EntityManager em;

	public NhaCungCapDao() {

		em = HibernateUtil.getIntance().getEntityManager();
	}

	public NhaCungCap getTenNhaCCById(String ID) {
		return em.find(NhaCungCap.class, ID);
	}

	public ArrayList<String> getListSuppilerName() {
		ArrayList<String> list = new ArrayList<String>();
		List<?> query = em.createNativeQuery("select maNhaCungCap, tenNhaCungCap from NhaCungCap order by maNhaCungCap")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String tenNhaCungCap = (String) rs[1];
			list.add(tenNhaCungCap);
		}
		return list;
	}

	public DefaultTableModel getAllNCC() throws SQLException {
		String[] header = { "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Email", "Số Điện Thoại", "Ghi Chú" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("select * from nhaCungCap").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[5], (String) rs[2], (String) rs[3], (String) rs[4],
					(String) rs[1] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel timKiem(String maNCC) throws SQLException {
		String[] header = { "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Email", "Số Điện Thoại", "Ghi Chú" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"select *from nhaCungCap where maNhaCungCap like'" + maNCC + "' or tenNhaCungCap like N'" + maNCC + "'")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[5], (String) rs[2], (String) rs[3], (String) rs[4],
					(String) rs[1] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public boolean themNCC(NhaCungCap ncc) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ncc);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public void xoaNCC(String maNCC) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			NhaCungCap nhaCungCap = em.find(NhaCungCap.class, maNCC);
			em.remove(nhaCungCap);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}

	public boolean update(NhaCungCap ncc) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ncc);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public int demNhaCungCap() {
		Object query = em.createNativeQuery("select count(maNhaCungCap) from NhaCungCap").getSingleResult();
		if (query != null) {
			return (int) query;
		}
		return 0;
	}

	public ArrayList<String> getListTenNhaCC() {
		ArrayList<String> list = new ArrayList<String>();
		List<?> query = em.createNativeQuery("Select tenNhaCungCap ,maNhaCungCap from NhaCungCap").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String ten = (String) rs[0];
			list.add(ten);
		}
		return list;
	}
}
