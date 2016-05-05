package test;

import database.UserDAO;

public class QueryAll {

	public static void main(String[] args) {
//		String hql = "from Shopping s,Type t where s.type=t.type_id";
//		String hql = "from Shopping";
//		Configuration conf = new Configuration().configure();
//		SessionFactory fac = conf.buildSessionFactory();
//		Session session = fac.openSession();
//		Query query1 = session.createQuery(hql);
////		Query query1 = session.createSQLQuery(""
////				+ "select * from shopping join type on shopping.type=type.type_id ");
//		query1.setMaxResults(10);
//		@SuppressWarnings("unchecked")
//		List<Shopping> list = query1.list();
//		System.out.println("list length = "+list.size());
//		Iterator<Shopping> it = list.iterator();
//		while(it.hasNext())
//		{
//			Shopping shopping = it.next();
//			System.out.println(
//					shopping.getShoppingname()+"\t"
//					+shopping.getType()+"\t");
//		}
		
//		Query query2 = session.createQuery("from Type");
//		@SuppressWarnings("unchecked")
//		List<Type> list2 = query2.list();
//		Type type;
//		Iterator<Type> it2 = list2.iterator();
//		while(it2.hasNext())
//		{
//			type = it2.next();
//			System.out.println(
//					type.getTypeid()+"   "
//					+type.getTypename());
//		}
		
		System.out.println(UserDAO.queryUserByName("sparrow").getStuid());
	}

}
