package database;

import java.util.List;

import org.hibernate.Query;

import bean.Message;

public class MessageDAO {

	public static void updateStateById(int id,String newstate)
	{
		String hql = "update Message m set m.state='"
					+newstate+"' where m.id="+id;
		DAOTool.update(hql);
	}
	
	public static void deleteReadMessage()
	{
		DAOTool.deleteByCondition("Message", "state='read'");
	}
	
	@SuppressWarnings("unchecked")
	public static List<Message> findUnreadMessage(String toname)
	{
		String hql = "from Message  m where m.mto='"+toname+"' and m.state='unread'";
		Query query = DAOTool.query(hql);
		if(query.list().size()!=0)
			return query.list();
		else return null;
	}
}
