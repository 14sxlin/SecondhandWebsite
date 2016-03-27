<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>分类导航</title>
</head>
<body>
    <c:forEach items="${result}" var="item">
        商品名 : <c:out value="${item.shoppingname }"></c:out><br/>
        发布日期 : <c:out value="${item.publishdate }"></c:out><br/>
        价格:￥<c:out value="${item.price}"></c:out><br/>
        用户名: <c:out value=" ${item.username }"></c:out><br/>
       新旧程度: <c:out value="${item.newlevel}"></c:out>成新<br/>
       <c:out value="------------------------------------------------------"></c:out><br/><br/>
    </c:forEach>
    <a href="default.jsp">返回首页</a>
</body>
</html>