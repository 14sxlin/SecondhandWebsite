<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
  Cookie cookies[] = request.getCookies();
  boolean isLogin = false;
  Cookie username = null;
  if(cookies!=null)
	  for(Cookie temp:cookies)
	  {
		  if(temp.getName().equals("username"))
		  { 
			 if(temp.getValue() != null)
			 {   isLogin = true;
		        username = temp;
		      }
		      break;
		  }
	  }
  if(isLogin)
	  out.println("<div align=\"right\">"+
			   "<a id=\"myusername\" href=\"userquery.do\">"+username.getValue()+"</a></div>");
  else
  {
	  out.println("<div align=\"right\"><input type=\"button\" value=\"登录\" onclick=\"location='login.jsp'\"/>"); 
	  out.println("<input type=\"button\" value=\"注册\" onclick=\"location='register.html'\"/></div>");
  }
%>