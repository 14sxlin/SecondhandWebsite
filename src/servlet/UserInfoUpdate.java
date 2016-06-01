package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import database.ShoppingDAO;
import database.UserDAO;

/**
 * Servlet implementation class UserInfoUpdate
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/updateInfo" })
public class UserInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateType= request.getParameter("type");
		String id = request.getParameter("id");
		User user = (User) request.getSession().getAttribute("user");
		if (updateType.equals("info")) {//修改信息
			String name = request.getParameter("username").trim();
			String shortnum = request.getParameter("shortnum").trim();
			String longnum = request.getParameter("longnum").trim();
			UserDAO.updateUserInfoById(id, name, longnum, shortnum);
			String oldName = user.getUsername();
			if (!oldName.equals(name))
				ShoppingDAO.updateUserByName(oldName, name);
			request.setAttribute("message", "修改成功,请重新登录");
		}else {//修改密码
			String oldPassword = request.getParameter("oldpassword");
			if(oldPassword.equals(user.getPassword()))
			{ 	
				String password = request.getParameter("password");
				UserDAO.updatePasswordById(id, password);
				request.setAttribute("message", "修改成功,请重新登录");
			}else {
				request.setAttribute("message", "密码验证失败");
			}
		}
		request.getSession().invalidate();
		request.getRequestDispatcher("welcome").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
