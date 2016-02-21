package publish;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.WantBuy;
import database.WantBuyDAO;

/**
 * Servlet implementation class WantBuy
 */
@WebServlet("/wantbuy.do")
public class PublishWantBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String shoppingname = request.getParameter("shoppingname");
		String price = request.getParameter("price");
		String ps = request.getParameter("ps");
		String username = null;
		
		try {
			for(Cookie c:request.getCookies())
			{
				if(c.getName().equals("username"))
				{
					username = c.getValue();
					break;
				}
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		
		WantBuy wantbuy = new WantBuy();
		wantbuy.setShoppingname(shoppingname);
		wantbuy.setUsername(username);
		wantbuy.setPs(price);
		wantbuy.setPs(ps);
		WantBuyDAO.save(wantbuy);
		response.sendRedirect("outcome/wantbuysuccess.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
