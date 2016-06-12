<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mytag" uri="/mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/UserInfo.css">
<title>个人信息</title>
</head>
<body>
	<div class="userinfo">
		用户名 :${user.username}<br/>
		<c:if test="${not empty user.longnum}">长号 :${user.longnum}<br/></c:if>
		<c:if test="${not empty user.shortnum}">短号 :${user.shortnum}<br/></c:if>
	</div>
	<div class="Button">
		<input type="button" value="发布商品" onclick="location='jsp/ReleaseProduct.jsp'">
<!-- 		<input type="button" value="我要求购" onclick="location='WantToBuy.jsp'"> -->
		<input type="button" value="退出登录" onclick="location='logout.do'"/>
		<input type="button" value="修改信息" onclick="location='jsp/ModifyInfo.jsp'"/>		
		<input type="button" value="返回首页" onclick="location='welcome'"/>		
	</div>
		
	<div class="nav">
		<ul>
   		<li><a href="#">我的商品</a></li>
  <!--  		<li><a href="UserInfo-wanttobuy.jsp">我的求购</a></li>  -->
   		</ul>
	</div>
	
	<div id="container">   
	<c:if test="${not empty shoppinglist }">
	<table class="myproduct">
		<thead>
        	<tr>
				<th>商品名</th>
				<th>新旧程度</th>
				<th>商品类型</th>
				<th>价格</th>
				<th>发布日期</th>
				<th>状态</th>
				<th>备注</th>
				<th>管理</th>
            </tr>
		</thead>
        <tbody>
        	<tr>
        	<c:forEach var="shopping" items="${shoppinglist}">
			    <tr>
			    <td><c:out value="${shopping.shoppingname}"></c:out></td>
			    <td><c:out value="${shopping.newlevel}成新"></c:out></td>
			    <td><mytag:typetrans type="${shopping.type}"></mytag:typetrans></td>
			    <td><c:out value="${shopping.price}"></c:out></td>
			    <fmt:parseDate var="thisdate" pattern="YYYY-MM-dd HH:mm:ss.S" 
			                        value="${shopping.publishdate}"></fmt:parseDate>
			    <fmt:formatDate var="mydate" value="${thisdate}" pattern="YYYY-MM-dd HH:mm:ss"/>
			   <td><c:out value="${mydate}"></c:out></td>
			    <td><c:out value="${shopping.state}"></c:out></td>
			    <td><c:out value="${shopping.ps }"></c:out><c:if test="${empty shopping.ps}">无</c:if></td>
			    <c:if test="${shopping.state=='displaying'}">
			    <td>
			         <a href="/SecondhandWebsite/updateshoppingstate.do?id=${shopping.shopping_id}
			                            &newstate=finish">已完成</a>
			          <a href="/SecondhandWebsite/updateshoppingstate.do?id=${shopping.shopping_id}
			                            &newstate=cancel">取消</a></td>
			    </c:if>
			    </tr>
			</c:forEach>
            </tr>
        </tbody>
	</table>
	</c:if>
</div>
	
</body>
</html>