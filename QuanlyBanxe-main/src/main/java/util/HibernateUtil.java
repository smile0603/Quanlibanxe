package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static HibernateUtil intance =null;
	private EntityManager entityManager;
	public HibernateUtil() {
		// TODO Auto-generated constructor stub
		entityManager = Persistence.createEntityManagerFactory("QuanLyBanXe").createEntityManager();
	}
	public synchronized static HibernateUtil getIntance() {
		if(intance ==null)
			intance = new HibernateUtil();
		return intance;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
