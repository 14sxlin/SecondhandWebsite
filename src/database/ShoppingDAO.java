package database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bean.Shopping;

public class ShoppingDAO {

	public static final  String  hql = "from Shopping ";
	@SuppressWarnings("unchecked")
	public static List<Shopping> queryShoppingByUsername(String username)
	{
		Query query = DAOTool.query("from Shopping where username='"+username+"'");
		if(!query.list().isEmpty())
			return (List<Shopping>)query.list();
		else return null;
	}
	
	public static Shopping queryShoppingById(String id)
	{
		Query query = DAOTool.query(
				"from Shopping where id="+id);
		return (Shopping) query.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Shopping> queryItems(int maxitems,String condition) 
	{
		Query query =  DAOTool.query("from Shopping where "+condition);
		query.setMaxResults(maxitems);
		if(!query.list().isEmpty())
			return (List<Shopping>)query.list();
		else return null;
	}
	
	public static boolean updateStateById(int id,String state)
	{
		DAOTool.update("update Shopping s set s.state='"+state+"' "+"where s.id="+id);
		return true;
	}
	
	public static int getTotalCount()
	{
		String Hql  = "select count(*) "+hql;
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		int total = ((Long) session.createQuery(Hql).uniqueResult()).intValue();
		return total;
	}
	public static int getTotalCount(String type)
	{
		String Hql  = "select count(*) "+hql+
				"  where type="+type
				+" and state='displaying'";
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		int total = ((Long) session.createQuery(Hql).uniqueResult()).intValue();
		return total;
	}
}
