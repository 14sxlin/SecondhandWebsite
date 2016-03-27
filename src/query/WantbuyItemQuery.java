package query;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.WantBuy;
import database.WantBuyDAO;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class WantbuyItemQuery
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/wantbuyitems"})
public class WantbuyItemQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<WantBuy> wantbuylist =WantBuyDAO.queryItems(10);
		JSONArray jwantbuy = JSONArray.fromObject(wantbuylist);
		response.setContentType("text/html;cahrset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.addHeader( "Cache-Control", "no-cache" );
//		System.out.println("wantbuylist = "+jwantbuy.toString());
		response.getWriter().println(jwantbuy.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
