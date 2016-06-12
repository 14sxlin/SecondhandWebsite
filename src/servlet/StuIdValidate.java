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
 * Servlet implementation class StuIdValidate
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/StuIdValidate" })
public class StuIdValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuIdValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuid = request.getParameter("stuid").trim();
		System.out.println("stuid = "+stuid);
		if(!stuid.equals("")&&UserDAO.queryUserByStuId(stuid)==null)
		{
			PrintWriter out = response.getWriter();
			out.print("OK");
			out.flush();
			out.close();
			System.out.println("OK stuid");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("NO");
			out.flush();
			out.close();
			System.out.println("NO stuid");
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
