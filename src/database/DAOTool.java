package database;

import java.util.List;

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
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "delete "+tablename+" where "+condition;
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
	
	public static void update(String hql,String ...params)
	{
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Transaction tran = session.beginTransaction();
		Query update = session.createQuery(hql);
		for(int i=0;i<params.length;i++)
		{
			update.setParameter(i, params[i]);
		}
		update.executeUpdate();
		tran.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public static  List<Object> queryByPage(String hql, final Page page) {  
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Query query = session.createQuery(hql);  
        //设置每页显示多少个，设置多大结果。  
        query.setMaxResults(page.getEveryPage());  
        //设置起点  
        query.setFirstResult(page.getBeginIndex());  
        return query.list();        
	}
}
