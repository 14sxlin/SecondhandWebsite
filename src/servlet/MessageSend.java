package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import database.DAOTool;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/sendMessage.do" })
public class MessageSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mfrom = request.getParameter("mfrom");
		String mto = request.getParameter("mto");
		String message = request.getParameter("message");
		// TODO System Output Test Block
		System.out.println(
				" mfrom ;  mto ; message =  "+mfrom+"  ;  "+mto+"  ;  "+message);
		Message mesageBean = new Message();
		mesageBean.setContent(message);
		mesageBean.setMfrom(mfrom);
		mesageBean.setMto(mto);
		mesageBean.setState("unread");
		DAOTool.save(mesageBean);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
