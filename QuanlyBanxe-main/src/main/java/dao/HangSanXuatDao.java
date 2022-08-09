package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import entity.HangSanXuat;
import entity.KhachHang;
import util.HibernateUtil;

public class HangSanXuatDao {

	private EntityManager em;

	public HangSanXuatDao() {

		em = HibernateUtil.getIntance().getEntityManager();
	}

	public void getListHSX(String tenXe, JComboBox comboBox) {
		List<?> query = em
				.createNativeQuery("select DISTINCT HangSanXuat.tenHangSX ,HangSanXuat.quocGia from Xe, "
						+ "HangSanXuat where Xe.hangSanXuatID=HangSanXuat.maHangSX and tenXe =?")
				.setParameter(1, tenXe).getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String tenHangSX = (String) rs[0];
			comboBox.addItem(tenHangSX);
		}
	}

	public HangSanXuat getHangSanXuatById(String id) {
		return em.find(HangSanXuat.class, id);
	}

	// select * from HangSanXuat

	public DefaultTableModel getAllHSX() throws SQLException {
		String[] header = { "Mã Hãng Sản Xuất", "Tên Hãng Sản Xuất", "Quốc Gia" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<HangSanXuat> query = em.createNativeQuery("select * from HangSanXuat", HangSanXuat.class).getResultList();
		for (HangSanXuat hangSanXuat : query) {
			Object[] o = { hangSanXuat.getMaHangSX(), hangSanXuat.getTenHangSX(), hangSanXuat.getQuocGia() };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel timKiem(String mahSX) throws SQLException {
		String[] header = { "Mã Hãng Sản Xuất", "Tên Hãng Sản Xuất", "Quốc Gia" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<HangSanXuat> query = em.createNativeQuery(
				"select * from HangSanXuat where maHangSX like '" + mahSX + "' or tenHangSX like '" + mahSX + "'",
				HangSanXuat.class).getResultList();
		for (HangSanXuat hangSanXuat : query) {
			Object[] o = { hangSanXuat.getMaHangSX(), hangSanXuat.getTenHangSX(), hangSanXuat.getQuocGia() };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public boolean themHSX(HangSanXuat hsx) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hsx);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean xoaHSX(String mahsx) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			HangSanXuat hangSanXuat = em.find(HangSanXuat.class, mahsx);
			em.remove(hangSanXuat);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean update(HangSanXuat hsx) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(hsx);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public ArrayList<String> getListTenHangSX() {
		ArrayList<String> list = new ArrayList<String>();
		List<?> query = em.createNativeQuery("Select tenHangSX,maHangSX from HangSanXuat").getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			String kq = (String) rs[0];
			list.add(kq);
		}
		return list;
	}
}
