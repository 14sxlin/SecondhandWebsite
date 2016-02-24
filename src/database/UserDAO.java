package database;

import org.hibernate.Query;

import bean.User;

public class UserDAO {

	public static User queryUserByName(String username)
	{
		Query query = DAOTool.query("from User where username='"+username+"'");
		//记得要加上单引号,不能是双引号
		if(!query.list().isEmpty())
			return (User) query.list().get(0);
		else return null;
	}
	
	public static User queryUserByStuId(String stuid)
	{
		Query query = DAOTool.query("from User where stuid='"+stuid+"'");
		if(!query.list().isEmpty())
			return (User)query.list().get(0);
		else return null;
	}
}
