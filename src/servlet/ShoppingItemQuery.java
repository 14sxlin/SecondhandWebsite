package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAOTool;
import database.Page;
import database.PageUtil;
import database.ShoppingDAO;

/**
 * Servlet implementation class LoadShoppingData
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/shoppingitems","/welcome","/page"})
public class ShoppingItemQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	“Ï≤Ω∑Ω Ω
//		JSONArray jshopping = JSONArray.fromObject(shoppinglist);
//		response.setContentType("text/html;cahrset=utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.addHeader( "Cache-Control", "no-cache" );
////		System.out.println(jshopping.toString());
//		response.getWriter().println(jshopping.toString());
		String pagenum = request.getParameter("pageNum");
		int num = 1;
		if(pagenum!=null)
			num = Integer.parseInt(pagenum);
		Page page = PageUtil.createPage(10, 200, num);
		List<Object> shoppinglist  = DAOTool.queryByPage(ShoppingDAO.hql+
				"where state='displaying' order by publishdate desc ", page);
		request.setAttribute("page", page);
		request.setAttribute("ShoppingItems", shoppinglist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
