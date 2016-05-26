<%@page import="bean.User"%>
<%@page import="bean.Shopping"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="mytag" uri="/mytag"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品详情</title>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen"/>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"></link>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid" id="LG">
	<div class="row-fluid">
		<div class="span12">
			<div class="page-header">
				<h1>
					<strong>商品详细信息</strong>
				</h1>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span6">
			<div class="carousel slide" id="carousel-403001">
				<ol class="carousel-indicators">
					<li class="active" data-target="#carousel-403001" data-slide-to="0">
					</li>
					<li data-target="#carousel-403001" data-slide-to="1">
					</li>
					<li data-target="#carousel-403001" data-slide-to="2">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						 <c:if test="${item.hasPicture eq '1'}">
                                <img alt="${shopping.shoppingname}" src="uploadpicture/${shopping.username}/${shopping.shoppingname}.jpg" height="100" />
                        </c:if>
                       <c:if test="${shopping.hasPicture eq '0'}">
                                 <img alt="400*300" src="pic/<mytag:pathChoose type="${shopping.type}"></mytag:pathChoose>" height="100" />
                                 <div class="carousel-caption">
                                    用户没有上传图片
                                </div>
                        </c:if>
					</div>
	<!--  				<div class="item">
						<img alt="" src="../pic/b.jpg" height="500px" width="500px"/>
						<div class="carousel-caption">
						</div>
					</div>
					<div class="item">
						<img alt="" src="../pic/c.jpg" height="500px" width="500px"/>
						<div class="carousel-caption">
						</div>
					</div>-->
				</div> <a class="left carousel-control" href="#carousel-403001" data-slide="prev">‹</a> <a class="right carousel-control" href="#carousel-403001" data-slide="next">›</a>
			</div>
			<div class="row-fluid">
				<div class="span12">
					 <button class="btn btn-primary" type="button" onclick="location='welcome'">返回首页</button>
				</div>
			</div>
		</div>
		<div class="span6">
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>
						</th>
						<th>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							商品名称：
						</td>
						<td>
						${shopping.shoppingname }
						</td>
					</tr>
					<tr class="success">
						<td>
							发布时间：
						</td>
						<td>
						${shopping.publishdate }
						</td>
					</tr>
					<tr class="error">
						<td>
							发布用户：
						</td>
						<td>
					           ${shopping.username }
						</td>
					</tr>
					<tr class="warning">
						<td>
							新旧程度：
						</td>
						<td>
						${shopping.newlevel }成新
						</td>
					</tr>
					<tr class="info">
						<td>
							类型：
						</td>
						<td>
						  <mytag:typetrans type="${shopping.type}"></mytag:typetrans>
						</td>
					</tr>
					<tr class="error">
						<td>
							价格：
						</td>
						<td>
						  ${shopping.price }
						</td>
					</tr>
	<!--  				<tr class="info2">
						<td>
							长号：
						</td>
						<td>
						//长号
						</td>
					</tr>
					<tr class="info">
						<td>
							短号：
						</td>
						<td>
						//短号
						</td>
					</tr>-->
				</tbody>
			</table>
			<p class="table-hover table-striped">
			</p>
		</div>
	</div>
</div>
</body>
</html>