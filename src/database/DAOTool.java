package database;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAOTool {


	public static void save(Object bean)
	{
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Transaction tran = session.beginTransaction();
		session.save(bean);
		tran.commit();
	}
	
	public static void deleteById(String tablename , int id)
	{
		deleteByCondition(tablename, "id="+id);
	}
	
	public static void deleteByCondition(String tablename,String condition)
	{
		String hql = "delete "+tablename+" where "+condition;
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Transaction tran = session.beginTransaction();
		session.createQuery(hql).executeUpdate();
		tran.commit();
	}
	
	public static Query query(String hql) {
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Query query = session.createQuery(hql);
		return query;
	}
	
	public static void update(String hql)
	{
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Transaction tran = session.beginTransaction();
		Query update = session.createQuery(hql);
		update.executeUpdate();
		tran.commit();
	}
	

}
