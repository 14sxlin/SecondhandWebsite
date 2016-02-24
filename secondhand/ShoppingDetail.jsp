<%@page import="bean.User"%>
<%@page import="bean.Shopping"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="mytag" uri="/mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品详情</title>
</head>
<body>
<%
  Shopping shopping = (Shopping)request.getAttribute("shopping");
%>
商品名称:${shopping.shoppingname }<br/>
发布日期:${shopping.publishdate }<br/>
发布用户:${shopping.username }<br/>
新旧程度:${shopping.newlevel }<br/>
类型:<mytag:typetrans type="${shopping.type}"></mytag:typetrans><br/>
价格:${shopping.price }<br/>
<%
User user = (User)request.getAttribute("user");
if(user!=null)
{
	if(user.getLongnum()!=null)
		   out.print("长号:"+user.getLongnum()+"<br/>");
	if(user.getShortnum()!=null)
		  out.print("短号:"+user.getShortnum()+"<br/>");
}
%>
<a href="/SecondhandWebsite/">返回首页</a>
</body>
</html>