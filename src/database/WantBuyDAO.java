package database;

import java.util.List;

import org.hibernate.Query;

import bean.Shopping;
import bean.WantBuy;

public class WantBuyDAO {
		
	@SuppressWarnings("unchecked")
	public static List<WantBuy> queryItems(int maxitems)
	{
		Query query = DAOTool.query("from WantBuy order by publishdate desc");
		query.setMaxResults(maxitems);
		if(!query.list().isEmpty())
			return (List<WantBuy>)query.list();
		else return null;
	}
	
	public static Shopping queryWantBuyById(String id)
	{
		Query query = DAOTool.query("from WantBuy where id="+id);
		return (Shopping) query.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public static List<WantBuy> queryWantbuyByUsername(String username)
	{
		Query query = DAOTool.query("from WantBuy where username='"+username+"'");
		if(!query.list().isEmpty())
			return (List<WantBuy>)query.list();
		else return null;
	}
	
	public static boolean updateStateById(int id,String state)
	{
		DAOTool.update("update WantBuy wb set wb.state='"+state+"' "+"where wb.id="+id);
		return true;
	}
}
