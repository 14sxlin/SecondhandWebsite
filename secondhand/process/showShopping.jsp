<%@page import="java.util.Iterator"%>
<%@page import="bean.Shopping"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%!
public String decorate(String name,String shoppingname,int price,String publishdate,String id)
{
	return "<li target='_blank' "+
			"onclick=\"window.open('/SecondhandWebsite/shoppingquery.do?id="+id+"')\">"+
    "<div class=\"shoppingname\">"+shoppingname+"</div>"+
    "<div class=\"innerRight\">"+
      "<span class=\"date\">"+publishdate+"</span>"+
      "<span class=\"price\">￥"+price+"</span>"+
      "<span class=\"username\">"+name+"</span>"+
     "</div>"+
    "</li>";
}
%>

<%

 @SuppressWarnings("unchecked")
  List<Shopping> requestShoppings=(List<Shopping>)request.getAttribute("shoppinglist");
  Iterator<Shopping> it = requestShoppings.iterator();
  while(it.hasNext())
  {
	  Shopping temp = it.next();
	  String name = 
			  (temp.getUsername()==null||temp.getUsername().equals("unknown"))?"匿名":temp.getUsername();
	  out.println(decorate(name,
			 temp.getShoppingname(),
			 temp.getPrice(),
			 temp.getPublishdate().substring(0,19),
			 ""+ temp.getShopping_id())); 
  }
%>