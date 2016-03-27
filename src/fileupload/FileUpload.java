package fileupload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/fileupload.do" })
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw =  response.getWriter();
		pw.println("�����ļ��ϴ�<br/>");
		//�������ù���
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//�����ļ��Ĺ�����
		ServletFileUpload file = new ServletFileUpload(factory);
		//�����ļ��Ĵ�С 4M �����Ļ��׳�fileuploadexception
		file.setFileSizeMax(4*1024*1024);
		
		//��ȡ�ϴ����ļ��б�
		try {
			List<FileItem> filelist = file.parseRequest(
						new ServletRequestContext(request));
			for(FileItem item:filelist)
			{
				if(!item.isFormField())//������ļ������Ǳ�����
				{
					ServletContext sc = this.getServletContext();
					String storePath = sc.getRealPath("/upload");
					File dir = new File(storePath);
					if(!dir.exists())
						dir.mkdir();
					String fullname  =item.getName();
					String filename =fullname.substring(fullname.lastIndexOf("\\")+1);
					File toSave = new File(dir.getPath()+"\\"+filename);
					try {
						item.write(toSave);
					} catch (Exception e) {
						pw.print(filename+"  �ϴ�ʧ�� ������<br/>");
					}
					
					pw.print(filename+"  �ϴ��ɹ�<br/>");
				}
				
			}
			
		} catch (FileUploadException e) {
			pw.println("�ļ�̫��<br/>");
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
