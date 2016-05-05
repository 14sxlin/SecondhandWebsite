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
 * Servlet implementation class ShoppingCatalogQuery
 * 分类查询
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/type" })
public class ShoppingCatalogQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 1.图书
		2.衣鞋包
		3.电子设备
		4.食品
		5.家居用品
		6.其他
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryType =  request.getParameter("queryType").trim();
		String pNum = (String)request.getParameter("page");
		int pageNum = 1;
		if(pNum!=null&&!pNum.equals(""))
			pageNum = Integer.parseInt(pNum);
		Page page = PageUtil.createPage(10, 200, pageNum);
		List<Object> result = 
				DAOTool.queryByPage(ShoppingDAO.hql+
						" where type="+queryType
						+" and state='displaying' order by publishdate desc "
						, page);
		if(result!=null)
		{
			// TODO System Output Test Block
			System.out.println(" length =  "+result.size());
			request.setAttribute("page", page);
			request.setAttribute("result", result);
			request.setAttribute("type", queryType);
			request.getRequestDispatcher("jsp/classify.jsp").forward(request, response);
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
