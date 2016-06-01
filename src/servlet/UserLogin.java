package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import database.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuid = request.getParameter("stuid");
		String password = request.getParameter("password");
		User user = UserDAO.queryUserByStuId(stuid);
		if(user!= null && user.getPassword().equals(password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.addCookie(new Cookie("username", user.getUsername()));
			response.sendRedirect("welcome");
		}else {
			//用户名或密码错误
			request.setAttribute("message", "用户名或密码错误");
			request.getRequestDispatcher("welcome").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
