<%@page import="java.util.Iterator"%>
<%@page import="bean.Shopping"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="mytag" uri="/mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-2.2.0.js" charset="utf-8"></script>
<script type="text/javascript" src="js/load.js" charset="utf-8"></script>
<link href="/SecondhandWebsite/css/welcome.css" type="text/css" rel="stylesheet" />
<link href="/SecondhandWebsite/css/popup.css" type="text/css" rel="stylesheet" />
<title>汕大二手市场</title>
</head>

<body>
    <div class="head">
        <%@include file="../process/processHomePageBar.jsp" %>
        <%@include file="../process/showMessage.jsp" %>
    </div>
    <div class="body">
        <div class="left">
         <div>
           <span style="text-align:center; text-indent:300em">交易市场</span>
           <a href="marketpage.html" style="float:right">进去看看</a>
         </div>
           <ul id="shopUL">
          </ul> 
         </div>
        
        <div class="right">
         <div>
           <span style="text-align:center; text-indent:300em">我要淘</span>
           <a href="" style="float:right">进去看看</a>
         </div>
           <ul id="wantbuyUL">
          </ul> 
        </div>
    </div>
    <div class="bottom" style="text-align:center">联系我们:sparrowxin@sina.cn</div>
     <div id="popupContact">  
        <a id="popupContactClose">[X]</a>  
        <h1>给TA留言</h1>  
         <input id="send_message" type="text" name="message"/><br />
         <input id="send" type="button" value="提交"><br/>
         <span style="color:red">小贴士:如果对方长时间没回复,发送短信给TA比较好</span>
     </div>  
   <div id="backgroundPopup"></div>  
    <script type="text/javascript" src="js/popup.js" charset="utf-8"></script>
    <script type="text/javascript" src="message/sendmessage.js" charset="utf-8"></script>
</body>
</html>