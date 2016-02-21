<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>发生错误</title>
</head>
<body>
    发生了一个错误:<br/>
    ${pageContext.exception}
    <a href='default.jsp'>返回首页</a>
</body>
</html>