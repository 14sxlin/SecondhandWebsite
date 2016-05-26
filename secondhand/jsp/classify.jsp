<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/mytag" prefix="mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen"/>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/LoadPage.js"></script>
<title> <mytag:typetrans type="${type}"></mytag:typetrans></title>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="page-header">
                <h1>
                   <mytag:typetrans type="${type}"></mytag:typetrans>
                </h1>
            </div>
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
                </div>
            </div>
            <ul  class="thumbnails  col-md-offset-2 ">
                        <c:forEach items="${result}" var="item">
                           <c:if test="${item!=null}">
                           <li class="span3">
                                      <div class="thumbnail ">
                                      <p>
                                          <c:if test="${item.hasPicture eq '1'}">
                                          <img alt="${item.shoppingname}" src="uploadpicture/${item.username}/${item.shoppingname}.jpg" height="100" width="200" />
                                        </c:if>
                                        <c:if test="${item.hasPicture eq '0'}">
                                          <img alt="400*300" src="pic/<mytag:pathChoose type="${item.type}"></mytag:pathChoose>" height="100" width="200" />
                                        </c:if>
                                      </p>
                                      <div class="caption">
                                          <h3>
                                             ${item.shoppingname}<br/>
                                             <small><mytag:typetrans type="${type}"></mytag:typetrans></small>
                                         </h3>
                                              <p style="color:red;font-size:20px;">￥${item.price}</p>
                                                 <c:out value="${item.username}"></c:out>
                                                 <c:out value="发布于 ">  </c:out> 
                                                 <mytag:datetrans dateString=" ${item.publishdate}"></mytag:datetrans>
                                          <p>
                                              <a class="btn btn-primary" 
                                                href="window.open('/SecondhandWebsite/shoppingquery.do?id= ${item.shopping_id}">详细</a>
                                            <a class="btn" href="#">联系TA</a>
                                            </p>
                                            </div>
                                            </div>
                                       </li>
                           </c:if>
                        </c:forEach>
                    </ul>
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
                                <a href="type?pageNum=${page.currentPage-1}&queryType=${type}">上一页</a>
                             </li>
                        </c:otherwise>
                      </c:choose>
                    
                    <li class="active disable">
                        <a href="type?pageNum=${page.currentPage}&queryType=${type}">${page.currentPage}</a>
                    </li>
                    <c:if test="${page.currentPage+1<=page.totalPage}">
                    <li>
                        <a href="type?pageNum=${page.currentPage+1}&queryType=${type}">${page.currentPage+1}</a>
                    </li>
                    </c:if>
                    <c:if test="${page.currentPage+2<=page.totalPage}">
                    <li>
                        <a href="type?pageNum=${page.currentPage+2}&queryType=${type}">${page.currentPage+2}</a>
                    </li>
                    </c:if>
                    <c:if test="${page.currentPage+3<=page.totalPage}">
                    <li>
                        <a href="type?pageNum=${page.currentPage+3}&queryType=${type}">${page.currentPage+3}</a>
                    </li>
                    </c:if>
                    <c:if test="${page.currentPage+4<=page.totalPage}">
                    <li>
                        <a href="type?pageNum=${page.currentPage+4}&queryType=${type}">${page.currentPage+4}</a>
                    </li>
                    </c:if>
                    <c:choose>
                    <c:when test="${page.currentPage+1<=page.totalPage}">
                    <li>
                        <a href="type?pageNum=${page.currentPage+1}&queryType=${type}">下一页</a>
                    </li>
                    </c:when>
                   <c:otherwise>
                    <li class="disable">
                         <a>已是最后一页</a>
                      </li>
                   </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>