package picture;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PictureUpload
 */
@WebServlet(asyncSupported = true, 
	urlPatterns = { "/pictureupload" })
public class PictureUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String filePath;//�ļ�����Ŀ¼
	private String tempPath;//��ʱ�ļ�Ŀ¼
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);  
        // �������ļ��л�ó�ʼ������  
        filePath = config.getInitParameter("filepath");  
        tempPath = config.getInitParameter("temppath");  
 
        ServletContext context = getServletContext();  
 
        filePath = context.getRealPath(filePath);  
        tempPath = context.getRealPath(tempPath);  
        System.out.println("�ļ����Ŀ¼����ʱ�ļ�Ŀ¼׼����� ...");  
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
