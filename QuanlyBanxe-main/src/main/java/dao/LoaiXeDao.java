package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.table.DefaultTableModel;

import entity.LoaiXe;
import util.HibernateUtil;

public class LoaiXeDao {
	private EntityManager em;

	public LoaiXeDao() {

		em = HibernateUtil.getIntance().getEntityManager();
	}

	public boolean themLoaiXe(LoaiXe loaiXe) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(loaiXe);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean xoaLoaiXe(String makh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			LoaiXe khachHang = em.find(LoaiXe.class, makh);
			em.remove(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean capnhatLoaiXe(LoaiXe loaiXe) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(loaiXe);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public LoaiXe layLoaiXeById(String makh) {
		return em.find(LoaiXe.class, makh);
	}

	public DefaultTableModel getAllLX() throws SQLException {
		String[] header = { "Mã Loại Xe", "Tên Loại Xe" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery("select *from LoaiXe").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[1] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel timKiem(String id) throws SQLException {
		String[] header = { "Mã Loại Xe", "Tên Loại Xe" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em
				.createNativeQuery("select *from LoaiXe where maLoaixe like'" + id + "' or tenLoaixe like'" + id + "'")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { (String) rs[0], (String) rs[1] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public String getLoaiXeTail() {
		Object query = em.createNativeQuery("select Top 1 maLoaiXe from LoaiXe order by maLoaiXe desc")
				.getSingleResult();
		if (query != null) {
			String ma = (String) query;
			String[] parts = ma.split("_");
			int so = Integer.parseInt(parts[1]) + 1;
			return parts[0] + "_" + String.format("%04d", so);
		}
		return null;
	}

	public ArrayList<String> getListTenLoaiXe() {
		ArrayList<String> list = new ArrayList<String>();
		List<?> query = em.createNativeQuery("Select tenLoaiXe,maLoaiXe from LoaiXe").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String kq = (String) rs[0];
			list.add(kq);
		}
		return list;
	}

	public ArrayList<String> getListMaLoaiXe() {
		ArrayList<String> list = new ArrayList<String>();
		List<?> query = em.createNativeQuery("Select maLoaiXe,tenLoaiXe from LoaiXe").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String kq = (String) rs[0];
			list.add(kq);
		}
		return list;
	}
}
