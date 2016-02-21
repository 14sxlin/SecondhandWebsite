package database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Shopping;
import bean.WantBuy;

public class WantBuyDAO {
		
	public static void save(WantBuy wantbuy)
	{
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Transaction tran = session.beginTransaction();
		session.save(wantbuy);
		tran.commit();
	}
	
	@SuppressWarnings("unchecked")
	public static List<WantBuy> queryItems(int maxitems)
	{
		Query query = QueryTool.query("from WantBuy order by publishdate desc");
		query.setMaxResults(maxitems);
		if(!query.list().isEmpty())
			return (List<WantBuy>)query.list();
		else return null;
	}
	
	public static Shopping queryWantBuyById(String id)
	{
		Query query = QueryTool.query("from WantBuy where id="+id);
		return (Shopping) query.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public static List<WantBuy> queryWantbuyByUsername(String username)
	{
		Query query = QueryTool.query("from WantBuy where username='"+username+"'");
		if(!query.list().isEmpty())
			return (List<WantBuy>)query.list();
		else return null;
	}
}
