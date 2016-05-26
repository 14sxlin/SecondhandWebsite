package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Shopping;
import bean.User;
import database.ShoppingDAO;
import database.UserDAO;

/**
 * Servlet implementation class DatabaseQuery
 */
@WebServlet("/shoppingquery.do")
public class ShoppingDetailQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//传输商品
		Shopping shopping = ShoppingDAO.queryShoppingById(request.getParameter("id"));
		request.setAttribute("shopping", shopping);
		
		//传输用户
		User user = null;
		String username = shopping.getUsername();
		if(username!=null)
		{	 user= UserDAO.queryUserByName(username);
			request.setAttribute("user", user);
		}
		request.getRequestDispatcher("jsp/detail.jsp")
		   .forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
