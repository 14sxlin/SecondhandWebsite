package servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import bean.Shopping;
import database.DAOTool;

/**
 * Servlet implementation class PublishShopping
 */
@WebServlet(urlPatterns="/publishShopping.do")
public class PublishShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean hasPic = false;
		String shoppingname = request.getParameter("shoppingname");
		String shoppingtype = request.getParameter("shoppingtype");
		String newlevel = request.getParameter("level");
		String price = request.getParameter("price");
		String ps = request.getParameter("ps");
		Shopping shopping = new Shopping();
		String username = null;
		try {
			for(Cookie c:request.getCookies()) {
				if(c.getName().equals("username") && c.getValue()!= null)
				{
					shopping.setUsername(c.getValue());
					username = c.getValue();
					break;
				}
			}
		} catch (NullPointerException e) {
			//这里是没有登录的情况,找不到用户名
			shopping.setUsername(null);
		}
		
		//创建配置工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置文件的管理类
		ServletFileUpload file = new ServletFileUpload(factory);
		//设置文件的大小 4M 超过的话抛出fileuploadexception
		file.setFileSizeMax(4*1024*1024);
		
		//检查上传的目录
		ServletContext sc = this.getServletContext();
		String storePath = sc.getRealPath("/uploadpicture");
		File storeDir = new File(storePath);
		if(!storeDir.exists())
			storeDir.mkdirs();
		
		
		//获取上传的文件列表
		try {
			List<FileItem> filelist = file.parseRequest(
						new ServletRequestContext(request));
			for(FileItem item:filelist)
			{
				// TODO System Output Test Block
				System.out.println(" item =  "+item.isFormField());
				System.out.println(" item =  "+item.getFieldName());
				if(item!=null&&item.isFormField()&&item.getFieldName()!=null)//如果是文件而不是表单数据
				{
					if(item.getFieldName().equals("shoppingname")){
						shoppingname = item.getString("utf-8");
					}
					if(item.getFieldName().equals("shoppingtype")){
						shoppingtype =  item.getString("utf-8");
					}
					}
					if(item.getFieldName().equals("level")){
						newlevel = item.getString("utf-8");
					}
					if(item.getFieldName().equals("price")){
						price  = item.getString("utf-8");
					}
					if(item.getFieldName().equals("ps")){
						ps = item.getString("utf-8");
				}else if(item.getSize()>0)
				{
					hasPic  =true;
					if (item!=null&&item.getName()!=null) {
						//用  用户名_商品名 来建立文件夹,里面的图片就是该商品的图片
						File dir = new File(storePath + "\\" + username);
						if (!dir.exists())
							dir.mkdir();
						File toSave = new File(dir.getPath() + "\\" + shoppingname+".jpg");
						System.out.println(" toSave =  " + toSave.getPath());
						System.out.println(" size  =  " + item.getSize());
						try {
							item.write(toSave);
						} catch (Exception e) {
							//TODO Auto-generated catch block
							e.printStackTrace();
						} 
					} 
				}
					
			}
			
		} catch (FileUploadException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//组装对象,但是还缺少用户的信息
		shopping.setShoppingname(shoppingname);
		shopping.setNewlevel(Integer.parseInt(newlevel));
		shopping.setPrice(Integer.parseInt(price));
		// TODO System Output Test Block
		System.out.println(" hasPicture  = "+hasPic);
		if(hasPic) 
			shopping.setHasPicture("1");
		else shopping.setHasPicture("0");
		
		int typeid = 6;
		switch(shoppingtype)
		{
			case "图书": typeid=1; break;
			case "衣鞋包": typeid=2; break;
			case "电子设备": typeid=3; break;
			case "食品": typeid=4; break;
			case "家居用品": typeid=5; break;
			case "其他": typeid=6; break;
		}
		shopping.setType(typeid);
		shopping.setState("displaying");
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		shopping.setPublishdate(sdf.format(new Date()));
		shopping.setPs(ps);
		
		
		DAOTool.save(shopping);
		response.setContentType("text/charset=utf-8");
		request.getRequestDispatcher("outcome/pubsuccess.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
