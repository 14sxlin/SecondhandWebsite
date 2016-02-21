package pagecontent;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Shopping;
import database.ShoppingDAO;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class LoadShoppingData
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/shoppingitems" })
public class ShoppingItemQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Shopping> shoppinglist = ShoppingDAO.queryItems(10);
		JSONArray jshopping = JSONArray.fromObject(shoppinglist);
		
		response.setContentType("text/html;cahrset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.addHeader( "Cache-Control", "no-cache" );
		System.out.println(jshopping.toString());
		response.getWriter().println(jshopping.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
