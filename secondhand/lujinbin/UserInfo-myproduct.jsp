<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="UserInfo.css">
<title>个人信息</title>
</head>
<body>
	<div class="userinfo">
		用户名 :<br/>
		长号 :<br/>
		短号 :<br/>
	</div>
	<div class="Button">
		<input type="button" value="发布商品" onclick="location='ReleaseProduct.jsp'">
<!-- 		<input type="button" value="我要求购" onclick="location='WantToBuy.jsp'"> -->
		<input type="button" value="退出登录" onclick=/>
		<input type="button" value="修改信息" onclick="location='ModifyInfo.jsp'"/>		
	</div>
		
	<div class="nav">
		<ul>
   		<li><a href="UserInfo-myproduct.jsp">我的商品</a></li>
  <!--  		<li><a href="UserInfo-wanttobuy.jsp">我的求购</a></li>  -->
   		</ul>
	</div>
	
	<div id="container">   
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
            	<td>阿阿斯顿开发济南的飞</td>
                <td>8成新</td>
                <td>家居用品</td>
                <td>500</td>
                <td>2016-12-27 13:50:05</td>
                <td>displaying	</td>
                <td>阿阿斯</td>
                <td>取消</td>
            </tr>
            <tr>
            	<td>键盘</td>
                <td>8成新</td>
                <td>家居用品</td>
                <td>500</td>
                <td>2016-12-27 13:50:05</td>
                <td>displaying	</td>
                <td>阿阿斯</td>
                <td>取消</td>
            </tr>
        </tbody>
	</table>
</div>
	
</body>
</html>