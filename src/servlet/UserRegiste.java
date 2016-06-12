package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.User;

/**
 * Servlet implementation class Registe
 */
@WebServlet("/registe.do")
public class UserRegiste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuid = request.getParameter("stuid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String longnum = request.getParameter("longnum");
		String shortnum = request.getParameter("shortnum");
		User user = new User();
		user.setStuid(stuid);
		user.setUsername(username);
		user.setPassword(password);
		user.setLongnum(longnum);
		user.setShortnum(shortnum);
		
		Configuration conf = new Configuration().configure();
		SessionFactory fac = conf.buildSessionFactory();
		Session session = fac.openSession();
		Transaction tran = session.beginTransaction();
		session.save(user);
		tran.commit();
		
		request.setAttribute("message", "×¢²á³É¹¦,ÇëµÇÂ¼");
		request.getRequestDispatcher("welcome").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
