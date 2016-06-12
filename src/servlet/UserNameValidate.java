package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.UserDAO;

/**
 * Servlet implementation class UserNameValidate
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/UserNameValidate" })
public class UserNameValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNameValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		System.out.println("username = "+username);
		if(!username.equals("")&&UserDAO.queryUserByName(username)==null) {
			PrintWriter out = response.getWriter();
			out.print("OK");
			out.flush();
			out.close();
			System.out.println("OK");
		}else {
			PrintWriter out = response.getWriter();
			out.print("NO");
			out.flush();
			out.close();
			System.out.println("No");
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
