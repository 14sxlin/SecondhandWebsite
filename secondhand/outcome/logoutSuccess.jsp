<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>退出成功</title>
<script type="text/javascript"> 
var t=3;//设定跳转的时间 
setInterval("refer()",3000); //启动1秒定时 
function refer(){  
    if(t==0){ 
        location="../default.jsp"; //#设定跳转的链接地址 
    } 
    document.getElementById('show').innerHTML=""+t+"秒后返回首页"; // 显示倒计时 
    t--; // 计数器递减 
} 
</script> 
</head>
<body>
    <div style="margin: 0 auto;">退出成功</div>
    <div id="show"></div>
    <a href="../default.jsp">返回首页</a>
</body>
</html>