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
		pw.println("处理文件上传<br/>");
		//创建配置工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置文件的管理类
		ServletFileUpload file = new ServletFileUpload(factory);
		//设置文件的大小 4M 超过的话抛出fileuploadexception
		file.setFileSizeMax(4*1024*1024);
		
		//获取上传的文件列表
		try {
			List<FileItem> filelist = file.parseRequest(
						new ServletRequestContext(request));
			for(FileItem item:filelist)
			{
				if(!item.isFormField())//如果是文件而不是表单数据
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
						pw.print(filename+"  上传失败 请重试<br/>");
					}
					
					pw.print(filename+"  上传成功<br/>");
				}
				
			}
			
		} catch (FileUploadException e) {
			pw.println("文件太大<br/>");
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
