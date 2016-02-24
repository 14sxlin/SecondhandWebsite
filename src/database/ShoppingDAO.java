package database;

import java.util.List;

import org.hibernate.Query;

import bean.Shopping;

public class ShoppingDAO {

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
	public static List<Shopping> queryItems(int maxitems) 
	{
		Query query =  DAOTool.query("from Shopping where state='displaying' "
				+ "order by publishdate desc ");
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
}
