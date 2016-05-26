<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <%@taglib uri="/mytag" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>汕大二手</title>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen"/>
<link href="css/masonry.css" rel="stylesheet"/>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/LoadPage.js"></script>
<script>
    $(function() {
     
        var masonryNode = $('#masonry');
        masonryNode.imagesLoaded(function(){
            masonryNode.masonry({
                itemSelector: '.thumbnail',
                isFitWidth: true
            });
        });
         
         
    });
    // 首先将新元素添加到页面容器中
     
    masonryNode.append(newItems);
    // 等待新元素中的图片加载完毕
    newItems.imagesLoaded(function(){
     
    // 调用瀑布流布局的appended方法
        masonryNode.masonry('appended',  newItems);
    });
    
</script>
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
            <div  class="row">
                <div id="masonry" class="span8 container-fluid"><!-- 宽度 -->
                    <ul id="ShoppingDisplay" class="thumbnails  col-md-offset-2 ">
                        <c:forEach items="${ShoppingItems}" var="item">
                           <c:if test="${item!=null}">
                           <li class="span3">
                                      <div class="thumbnail ">
                                      <p>
                                        <c:if test="${item.hasPicture eq '1'}">
                                          <img alt="${item.shoppingname}" src="uploadpicture/${item.username}/${item.shoppingname}.jpg" height="100" />
                                        </c:if>
                                        <c:if test="${item.hasPicture eq '0'}">
                                          <img alt="400*300" src="pic/<mytag:pathChoose type="${item.type}"></mytag:pathChoose>" height="100" />
                                        </c:if>
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
            <div class="span3">
                    <div class="hero-unit well">
                    <c:choose>
                        <c:when test="${sessionScope.user!=null}">
                        <div class="panel panel-info">
						   <div class="panel-heading">
						      <h3 class="panel-title">  ${sessionScope.user.username}</h3>
						   </div>
						   <div class="panel-body">
						   <a href="jsp/ReleaseProduct.jsp" class="btn btn-default btn-lg btn-block">发布商品</a>
						  <a class="pager" style="position:relative;left:80%;"
                                href="userquery.do?username=${sessionScope.user.username}">更多 »</a>
						   </div>
						   <div class="panel-footer">
						           <small><a class="btn btn-info btn-small btn-block" href="logout.do">退出</a></small>
						   </div>
						</div>
	<!--   <h4>
	                            ${sessionScope.user.username}
	                           
	                        </h4>
	                        <p>
	                         
	                        </p>
	                        <p style="position: relative;left: 80%">
	                           
	                        </p>-->   
                        </c:when>
                        <c:otherwise>
                          <ul id="myTab" class="nav nav-tabs">
							   <li class="active">
							      <a href="#login" data-toggle="tab">
							         登录
							      </a>
							   </li>
							   <li><a href="#register" data-toggle="tab">注册</a></li>
						 </ul>
						 <div id="myTabContent" class="tab-content">
						   <div class="tab-pane fade in active" id="login">
						             <% 
                                    String message =(String) session.getAttribute("message");
                                    boolean yes = false;
                                    if(message!=null&&!message.equals(""))
                                        yes = true;
                              %>
                              <c:if test="${!empty message}">
                                <div class="alert alert-danger  alert-dismissable">
								   <button type="button" class="close" data-dismiss="alert" 
								      aria-hidden="true">
								      &times;
								   </button>
								     ${message}
								</div>
                             </c:if>
                              <c:if test="${!empty messageOut}">
                                <div class="alert alert-success  alert-dismissable">
                                   <button type="button" class="close" data-dismiss="alert" 
                                      aria-hidden="true">
                                      &times;
                                   </button>
                                     ${messageOut}
                                </div>
                            </c:if>
                                <form action="/SecondhandWebsite/login.do" method="post">
                                    学号:<input type="text" name="stuid"><br/>
                                    密码:<input type="password" name="password"><br/>
                                          <input class='btn btn-default'
                                          type="submit" value="登录"/>
                                 </form>
						   </div>
						   <div class="tab-pane fade" id="register">
						       <form role="form" action="/SecondhandWebsite/registe.do" method="post">
								       <div class="form-group">
								          <label for="name">学号</label>
								          <input type="text" class="form-control" id="name" name="stuid">
								       </div>
								       <div class="form-group">
								          <label for="name">用户名</label>
								          <input type="text" class="form-control" id="name" name="username" >
								       </div>
								       <div class="form-group">
								          <label for="name">密码</label>
								          <input type="password" class="form-control" id="name" name="password" >
								       </div>
								       <div class="form-group">
								          <label for="name">长号</label>
								          <input type="text" class="form-control" id="name" name="longnum" >
								       </div>
								       <div class="form-group">
								          <label for="name">短号</label>
								          <input type="text" class="form-control" id="name" name="shortnum">
								       </div>
								   
								   <button type="submit" class="btn btn-default">提交</button>
								   <button type="reset" class="btn btn-default">重置</button>
								</form>
						   </div>
						  </div>
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
                    <c:if test="${page.currentPage+1<=page.totalPage}">
                    <li>
                        <a href="page?pageNum=${page.currentPage+1}">${page.currentPage+1}</a>
                    </li>
                    </c:if>
                    <c:if test="${page.currentPage+2<=page.totalPage}">
                    <li>
                        <a href="page?pageNum=${page.currentPage+2}">${page.currentPage+2}</a>
                    </li>
                    </c:if>
                    <c:if test="${page.currentPage+3<=page.totalPage}">
                    <li>
                        <a href="page?pageNum=${page.currentPage+3}">${page.currentPage+3}</a>
                    </li>
                    </c:if>
                    <c:if test="${page.currentPage+4<=page.totalPage}">
                    <li>
                        <a href="page?pageNum=${page.currentPage+4}">${page.currentPage+4}</a>
                    </li>
                    </c:if>
                    <c:choose>
                    <c:when test="${page.currentPage+1<=page.totalPage}">
                    <li>
                        <a href="page?pageNum=${page.currentPage+1}">下一页</a>
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
            <script type="text/javascript">
            var ghostNode = $('#masonry_ghost').find('.thumbnail'), i, ghostIndexArray = [];
            var ghostCount = ghostNode.length;
            for(i=0; i<ghostCount; i++){
                ghostIndexArray[i] = i;
            }
            ghostIndexArray.sort(function(a, b) {
                if(Math.random() > 0.5) {
                    return a - b;
                } else {
                    return b - a;
                }
            });
            </script>
</body>
</html>