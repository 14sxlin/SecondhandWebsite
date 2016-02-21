<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% /*
 "<li target='_blank' "+
            "onclick=\"window.open('/SecondhandWebsite/shoppingquery.do?id="+id+"')\">"+
    "<div class=\"shoppingname\">"+shoppingname+"</div>"+
    "<div class=\"innerRight\">"+
      "<span class=\"date\">"+publishdate+"</span>"+
      "<span class=\"price\">￥"+price+"</span>"+
      "<span class=\"username\">"+name+"</span>"+
     "</div>"+
    "</li>"
*/%>
<c:if test="${wantbuylist!=null}">
<c:forEach items="${wantbuylist}" var="item">
    <c:out value="${item.username}">用户名</c:out>
    <c:out value="${item.shoppingname }">商品名</c:out>
    <c:out value="${item.price}">价格</c:out>
    <c:out value="${item.publishdate}"></c:out>
</c:forEach>
</c:if>