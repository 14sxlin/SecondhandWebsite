package publish;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Shopping;
import database.DAOTool;

/**
 * Servlet implementation class PublishShopping
 */
@WebServlet(urlPatterns="/publishShopping.do")
public class PublishShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String shoppingname = request.getParameter("shoppingname");
		String shoppingtype = request.getParameter("shoppingtype");
		String newlevel = request.getParameter("newlevel");
		String price = request.getParameter("price");
		String ps = request.getParameter("ps");
		// TODO System Output Test Block
	//	System.out.println(shoppingname +"  "+shoppingtype+"  "+newlevel+" "+price);
	// С��  ͼ��  10 23
		
		//��װ����,���ǻ�ȱ���û�����Ϣ
		Shopping shopping = new Shopping();
		shopping.setShoppingname(shoppingname);
		shopping.setNewlevel(Integer.parseInt(newlevel));
		shopping.setPrice(Integer.parseInt(price));
		int typeid = 6;
		switch(shoppingtype)
		{
			case "ͼ��": typeid=1; break;
			case "��Ь��": typeid=2; break;
			case "�����豸": typeid=3; break;
			case "ʳƷ": typeid=4; break;
			case "�Ҿ���Ʒ": typeid=5; break;
			case "����": typeid=6; break;
		}
		shopping.setType(typeid);
		shopping.setState("displaying");
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		shopping.setPublishdate(sdf.format(new Date()));
		shopping.setPs(ps);
		try {
			for(Cookie c:request.getCookies()) {
				if(c.getName().equals("username") && c.getValue()!= null)
				{
					shopping.setUsername(c.getValue());
					break;
				}
			}
		} catch (NullPointerException e) {
			//������û�е�¼�����,�Ҳ����û���
			shopping.setUsername(null);
		}
		
		DAOTool.save(shopping);
		
		response.setContentType("text/charset=utf-8");
		request.getRequestDispatcher("outcome/pubsuccess.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
