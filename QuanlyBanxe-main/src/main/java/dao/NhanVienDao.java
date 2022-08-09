package dao;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.table.DefaultTableModel;

import entity.ChucVu;
import entity.HoaDon;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Xe;
import util.HibernateUtil;

public class NhanVienDao {
	private EntityManager em;

	public NhanVienDao() {

		em = HibernateUtil.getIntance().getEntityManager();
	}

	public boolean themNhanVien(NhanVien nhanVien) {
		EntityTransaction tr = em.getTransaction();

		try {
			tr.begin();
			em.persist(nhanVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean xoaNhanVien(String manv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			NhanVien nhanVien = em.find(NhanVien.class, manv);
			em.remove(nhanVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean capnhatNhanVien(NhanVien nhanVien) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(nhanVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public NhanVien layNhanVienById(String manv) {
		return em.find(NhanVien.class, manv);
	}

	public String getTenNhanVienById(String ID) {
		List<?> query = em.createNativeQuery("select tenNhanVien,maNhanVien from NhanVien where maNhanVien = ?")
				.setParameter(1, ID).getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			return (String) rs[0];
		}
		return null;
	}

	public DefaultTableModel getAllNV() throws SQLException {
		String[] header = { "Mã Nhân Viên", "Tên Nhân Viên", "CMND", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Email",
				"Số Điện Thoại", "Ngày Vào Làm", "Chức vụ", };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.CMND, NhanVien.ngaySinh,NhanVien.gioiTinh, NhanVien.diaChi, NhanVien.email, NhanVien.sdt, NhanVien.ngayVaoLam,  ChucVu.tenChucVu\r\n"
						+ "	FROM     NhanVien INNER JOIN\r\n" + "	ChucVu ON NhanVien.chucVuID = ChucVu.maChucVu")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Timestamp ngay1 = (Timestamp) rs[3];
			Timestamp ngay2 = (Timestamp) rs[8];
			Date ngaysinh = new Date(ngay1.getTime());
			Date ngayVaoLam = new Date(ngay2.getTime());
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], ngaysinh, (String) rs[4], (String) rs[5],
					(String) rs[6], (String) rs[7], ngayVaoLam, (String) rs[9] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel timKiem(String id, String sdt) throws SQLException {
		String[] header = { "Mã Nhân Viên", "Tên Nhân Viên", "CMND", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Email",
				"Số Điện Thoại", "Chức vụ", "Ngày Vào Làm" };
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		List<?> query = em.createNativeQuery(
				"SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.CMND, NhanVien.ngaySinh,NhanVien.gioiTinh, NhanVien.diaChi, NhanVien.email, NhanVien.sdt,ChucVu.tenChucVu,NhanVien.ngayVaoLam\r\n"
						+ "				FROM  NhanVien INNER JOIN\r\n"
						+ "				ChucVu ON NhanVien.chucVuID = ChucVu.maChucVu  where CMND like '" + id
						+ "' or sdt like '" + sdt + "'")
				.getResultList();
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Timestamp ngay1 = (Timestamp) rs[3];

			Date ngaysinh = new Date(ngay1.getTime());
			Object[] o = { (String) rs[0], (String) rs[1], (String) rs[2], ngaysinh.toString(), (String) rs[4],
					(String) rs[5], (String) rs[6], (String) rs[7], (String) rs[8], (String) rs[8] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public String getMaHDTail(String properties, String table) {
		Object query = em
				.createNativeQuery(
						"select Top 1 " + properties + " from " + table + " order by " + properties + " desc")
				.getSingleResult();
		if (query != null) {
			return (String) query;
		}
		return null;
	}

	public NhanVien Login(String username, String password) {

		List<NhanVien> query = em
				.createNativeQuery("select * from NhanVien where tenTaiKhoan = ? and matKhau = ?", NhanVien.class)
				.setParameter(1, username).setParameter(2, password).getResultList();
		if (query.size()>0) {
			return query.get(0);
		}
		return null;
	}

	public NhanVien getNhanVienById(String properties, String ID) {

		List<NhanVien> query = em
				.createNativeQuery("select * from NhanVien where " + properties + " = ?", NhanVien.class)
				.setParameter(1, ID).getResultList();
		if (query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	public ArrayList<ChucVu> getAllChucVus() {
		ArrayList<ChucVu> list = new ArrayList<ChucVu>();
		List<ChucVu> query = em.createNativeQuery("select * from ChucVu", ChucVu.class).getResultList();
		for (ChucVu chucVu : query) {
			list.add(chucVu);
		}
		return list;
	}

	public ChucVu getMaChucVu(String selectedItem) {
		List<ChucVu> query = em
				.createNativeQuery("select * from ChucVu where tenChucVu=N'" + selectedItem + "'", ChucVu.class)
				.getResultList();
		if (query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	public List<String> getListMaNV() {
		List<String> list = new ArrayList<String>();
		List<NhanVien> query = em.createNativeQuery("select * from NhanVien", NhanVien.class).getResultList();
		for (NhanVien nhanVien : query) {
			list.add(nhanVien.getMaNhanVien());
		}
		return list;
	}

	public DefaultTableModel getAllAccount(String[] header, DefaultTableModel tableModel) {

		List<?> query = em.createNativeQuery("select maNhanVien,tenNhanVien,matKhau,quyen,chuThich from NhanVien")
				.getResultList();
		int i = 1;
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { i, (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4] };
			tableModel.addRow(o);
			i++;
		}
		return tableModel;
	}

	public DefaultTableModel getAccountById(String[] header, DefaultTableModel tableModel, String id) {
		List<?> query = em
				.createNativeQuery(
						"select maNhanVien,tenNhanVien,matKhau,quyen,chuThich from NhanVien where maNhanVien =?")
				.setParameter(1, id).getResultList();
		int i = 1;
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { i, (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

	public DefaultTableModel getAccountByName(String[] header, DefaultTableModel tableModel, String name) {
		List<?> query = em
				.createNativeQuery(
						"select maNhanVien,tenNhanVien,matKhau,quyen,chuThich from NhanVien where tenNhanVien=?")
				.setParameter(0, name).getResultList();
		int i = 1;
		for (Object object : query) {
			Object[] rs = (Object[]) object;
			Object[] o = { i, (String) rs[0], (String) rs[1], (String) rs[2], (String) rs[3], (String) rs[4] };
			tableModel.addRow(o);
		}
		return tableModel;
	}

}
