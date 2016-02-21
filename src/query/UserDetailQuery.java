package query;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Shopping;
import bean.User;
import bean.WantBuy;
import database.ShoppingDAO;
import database.UserDAO;
import database.WantBuyDAO;

/**
 * Servlet implementation class UseDetailQuery
 */
@WebServlet("/userquery.do")
public class UserDetailQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = null;
		for(Cookie c:request.getCookies())
		{
			if(c.getName().equals("username"))
			{
				username = c.getValue();
				break;
			}
		}
		User user = UserDAO.queryUserByName(username);
		request.setAttribute("user", user);
		
		List<Shopping> shoppinglist = ShoppingDAO.queryShoppingByUsername(username);
		request.setAttribute("shoppinglist", shoppinglist);
		
		List<WantBuy> wantbuylist = WantBuyDAO.queryWantbuyByUsername(username);
		request.setAttribute("wantbuylist", wantbuylist);
		
		request.getRequestDispatcher("info/userinfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
