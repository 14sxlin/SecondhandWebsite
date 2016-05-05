<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
 <%@taglib uri="/mytag" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>汕大二手</title>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen"/>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/LoadPage.js"></script>
</head>
<body>
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="container-fluid">
                         <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> 
                         <a href="welcome" class="brand">汕大二手</a>
	                    <div class="nav-collapse collapse navbar-responsive-collapse">
	                    <ol class="nav">
	                        <li>
	                            <a href="type?queryType=1">图书</a>
	                        </li>
	                        <li>
	                            <a href="type?queryType=4">食品</a>
	                        </li>
	                        <li>
	                            <a href="type?queryType=2">衣鞋包</a>
	                        </li>
	                        <li>
	                            <a href="type?queryType=3">电子设备</a>
	                        </li>
	                        <li>
	                            <a href="type?queryType=5">家居用品</a>
	                        </li>
	                        <li>
	                            <a href="type?queryType=6">其他</a>
	                        </li>
	                    </ol>
                </div>
            </div>
         </div></div>   
            <div class="row">
                <div class="span8"><!-- 宽度 -->
                    <ul id="ShoppingDisplay" class="thumbnails  col-md-offset-2 ">
                        <c:forEach items="${ShoppingItems}" var="item">
                           <c:if test="${item!=null}">
                           <li class="span3">
                                      <div class="thumbnail ">
                                      <p>
                                          <img alt="400x300" src="img/people.jpg" />
                                      </p>
                                      <div class="caption">
                                          <h3>
                                             ${item.shoppingname}<br/>
                                             <small><mytag:typetrans type="${item.type}"></mytag:typetrans></small>
                                         </h3>
                                              <p id="info" style="color:red;font-size:20px;">￥${item.price}</p>
			                                     <c:out value="${item.username}"></c:out>
			                                    <script>
			                                       document.write(getDateDiff("${item.publishdate}"));
			                                    </script>
                                          <p>
                                              <a class="btn btn-primary" 
                                                href="/SecondhandWebsite/shoppingquery.do?id=${item.shopping_id}">详细</a>
                                            <a class="btn" href="#">联系TA</a>
                                            </p>
                                            </div>
                                            </div>
                                       </li>
                           </c:if>
                        </c:forEach>
                    </ul>
            </div>
            <div class="span4">
                    <div class="hero-unit well">
                    <c:choose>
                        <c:when test="${sessionScope.user!=null}">
                        <div class="panel panel-info">
						   <div class="panel-heading">
						      <h3 class="panel-title">  ${sessionScope.user.username}</h3>
						   </div>
						   <div class="panel-body">
						   <button type="button" class="btn btn-default btn-lg btn-block">发布商品</button>
						  <a class="pager" style="position:relative;left:80%;"
                                href="userquery.do?username=${sessionScope.user.username}">更多 »</a>
						   </div>
						   <div class="panel-footer">
						           <small><a class="btn btn-info btn-small btn-block" href="logout.do">退出</a></small>
						   </div>
						</div>
	<!--                 <h4>
	                            ${sessionScope.user.username}
	                           
	                        </h4>
	                        <p>
	                         
	                        </p>
	                        <p style="position: relative;left: 80%">
	                           
	                        </p>-->   
                        </c:when>
                        <c:otherwise>
                            <h3>
                              登录
                            </h3>
                            <% 
                            	    String message =(String) session.getAttribute("message");
                                    boolean yes = false;
                                    if(message!=null&&!message.equals(""))
                                    	yes = true;
                              %>
                              <c:if test="${!empty message}">
                                <div class='alert alert-danger'>${message}</div>
                             </c:if>
                              <c:if test="${!empty messageOut}">
                                <div class='alert alert-sucess'>${messageOut}</div>
                            </c:if>
                             <form action="/SecondhandWebsite/login.do" method="post">
							        学号:<input type="text" name="stuid"><br/>
							        密码:<input type="password" name="password"><br/>
							        <input type="submit" value="提交"/>
							        <input type="reset" value="重填"/>
                            </form>
                        </c:otherwise>
                        </c:choose>
                    </div>
            </div>
            </div>
              <div class="pagination pagination-centered">
                <ul>
                    <c:choose>
                        <c:when test="${page.currentPage==1 }">
                             <li class="disable">
                                <a href="#">上一页</a>
                             </li>
                        </c:when>
                        <c:otherwise>
                             <li>
                                <a href="page?pageNum=${page.currentPage-1}">上一页</a>
                             </li>
                        </c:otherwise>
                      </c:choose>
                    
                    <li class="active disable">
                        <a href="page?pageNum=${page.currentPage}" >${page.currentPage}</a>
                    </li>
                    <li>
                        <a href="page?pageNum=${page.currentPage+1}">${page.currentPage+1}</a>
                    </li>
                    <li>
                        <a href="page?pageNum=${page.currentPage+2}">${page.currentPage+2}</a>
                    </li>
                    <li>
                        <a href="page?pageNum=${page.currentPage+3}">${page.currentPage+3}</a>
                    </li>
                    <li>
                        <a href="page?pageNum=${page.currentPage+4}">${page.currentPage+4}</a>
                    </li>
                    <li>
                        <a href="page?pageNum=${page.currentPage+1}">下一页</a>
                    </li>
                </ul>
            </div>
</body>
</html>