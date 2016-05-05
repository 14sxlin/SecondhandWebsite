package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import database.MessageDAO;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class ReceiveMessage
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/receivemessage.do" })
public class MseeageReceive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toname=null;
		try {
			for(Cookie c:request.getCookies()) {
				if(c.getName().equals("username") && c.getValue()!= null)
				{
					toname = c.getValue();
					break;
				}
			}
			response.setCharacterEncoding("utf-8");
			List<Message> mlist = MessageDAO.findUnreadMessage(toname);
			
			if(mlist!=null)
			{
				JSONArray jsonlist = JSONArray.fromObject(mlist);
				// TODO Auto-generated catch block
				System.out.println(" list =  "+jsonlist.toString());
				response.getWriter().println(jsonlist.toString());
			}else {
				response.getWriter().println("ÎÞÐÅÏ¢");
			}
		} catch (NullPointerException e) {
			response.getWriter().println("Î´µÇÂ¼");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
