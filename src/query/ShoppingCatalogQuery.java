package query;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Shopping;
import database.ShoppingDAO;

/**
 * Servlet implementation class ShoppingCatalogQuery
 * �����ѯ
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/shoppingcat.do" })
public class ShoppingCatalogQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 1.ͼ��
		2.��Ь��
		3.�����豸
		4.ʳƷ
		5.�Ҿ���Ʒ
		6.����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryType = request.getParameter("queryType").trim();
		List<Shopping> result = 
				ShoppingDAO.queryItems(10, " type="+queryType+" and state='displaying' order by publishdate desc ");
		if(result!=null)
		{
			// TODO System Output Test Block
			System.out.println(" length =  "+result.size());
			request.setAttribute("result", result);
			request.getRequestDispatcher("jsp/catalog.jsp").forward(request, response);
		}else
			response.sendRedirect("noinform.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
