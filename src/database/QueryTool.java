package database;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryTool {


	static Query query(String hql) {
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Query query = session.createQuery(hql);
		return query;
	}
	

}
