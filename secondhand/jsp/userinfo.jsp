<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="mytag" uri="/mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>
</head>

<body>
用户名 :${user.username}<br/>
长号    :${user.longnum}<br/>
短号    :${user.shortnum} <br/>

<input type="button" value="发布商品" onclick="location='publishshopping.html'">
<input type="button" value="发布求购" onclick="location='wantbuy.html'"><br/>

我的商品:<br/>
<table>
        <tr><th>商品名</th><th>新旧程度</th><th>商品类型</th>
                  <th>价格</th><th>发布日期</th><th>状态</th><th>备注</th>
                  <th>管理</th></tr>
<c:if test="${shoppinglist!=null}">
<c:forEach var="shopping" items="${shoppinglist}">
    <tr>
    <td><c:out value="${shopping.shoppingname}"></c:out></td>
    <td><c:out value="${shopping.newlevel}成新"></c:out></td>
    <td><mytag:typetrans type="${shopping.type }"></mytag:typetrans></td>
    <td><c:out value="${shopping.price}"></c:out></td>
    <fmt:parseDate var="thisdate" pattern="YYYY-MM-dd HH:mm:ss.S" 
                        value="${shopping.publishdate}"></fmt:parseDate>
    <fmt:formatDate var="mydate" value="${thisdate}" pattern="YYYY-MM-dd HH:mm:ss"/>
   <td><c:out value="${mydate}"></c:out></td>
    <td><c:out value="${shopping.state}"></c:out></td>
    <td><c:out value="${shopping.ps }"></c:out></td>
    <c:if test="${shopping.state=='displaying'}">
    <td>
         <a href="/SecondhandWebsite/updateshoppingstate.do?id=${shopping.shopping_id}
                            &newstate=finish">已完成</a>
          <a href="/SecondhandWebsite/updateshoppingstate.do?id=${shopping.shopping_id}
                            &newstate=cancel">取消</a></td>
    </c:if>
    </tr>
</c:forEach>
</c:if>
</table>

我的求购:<br/>
<table>
        <tr><th>商品名</th><th>报价</th><th>发布日期</th>
        <th>状态</th><th>备注</th><th>管理</th></tr>
        <c:if test="${wantbuylist!=null }">
        <c:forEach var="wantbuy" items="${wantbuylist}">
        <tr>
        <td><c:out value="${wantbuy.shoppingname }"></c:out></td>
        <td><c:out value="${wantbuy.price }"></c:out></td>
        <fmt:parseDate var="wantbuydate" pattern="YYYY-MM-dd HH:mm:ss.S" 
                        value="${wantbuy.publishdate}"></fmt:parseDate>
    <fmt:formatDate var="mydate1" value="${wantbuydate}" pattern="YYYY-MM-dd HH:mm:ss"/>
   <td><c:out value="${mydate1}"></c:out></td>
        <td><c:out value="${wantbuy.state }"></c:out></td>
        <td><c:out value="${wantbuy.ps }"></c:out></td>
         <c:if test="${wantbuy.state=='displaying'}">
             <td>
                <a href="/SecondhandWebsite/updatewantbuystate.do?id=${wantbuy.id}
                            &newstate=finish">已完成</a>
                <a href="/SecondhandWebsite/updatewantbuystate.do?id=${wantbuy.id}
                            &newstate=cancel">取消</a></td>
        </c:if>
        </tr>
        </c:forEach>
        </c:if>
</table>                  
<input type="button" value="退出登录" onclick="location='logout.do'"/>
</body>
</html>