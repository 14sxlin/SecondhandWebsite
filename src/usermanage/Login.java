package usermanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import database.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
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
			Cookie usernameCookie = new Cookie("username", user.getUsername());
			usernameCookie.setMaxAge(30*60);//��Чʱ����Сʱ
			response.addCookie(usernameCookie);
			response.sendRedirect("default.jsp");
			
		}else {
			//�û������������
			request.setAttribute("message", "�û������������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
