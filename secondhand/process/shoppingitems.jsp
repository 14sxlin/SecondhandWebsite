<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-2.2.0.js"></script>
</head>
<body>
<ul id="shopUL">
<!--<li>
    <div class="shoppingname"></div>
    <div class="innerRight">
      <span class="date"></span>
      <span class="price"></span>
      <span class="username"></span>
    </div>
</li>  -->
</ul>
<script type="text/javascript">
function query(){
    $.ajax({
    url:"shoppingitems",
    dataType:"json",
    type:"get",
    success:function(data){
               $("#shopUL").html("");
               $.each(data,function(index,shopping)
                {
                     $("#shopUL").append(
                    "<li target='_blank' "+
                     "onclick=\"window.open('/SecondhandWebsite/shoppingquery.do?id="+shopping.id+"')\">"+
                     "<div class=\"shoppingname\">"+shopping.shoppingname+"</div>"+
                     "<div class=\"innerRight\">"+
                       "<span class=\"date\">"+shopping.publishdate+"</span>"+
                       "<span class=\"price\">￥"+shopping.price+"</span>"+
                       "<span class=\"username\">"+shopping.name+"</span>"+
                      "</div>"+
                     "</li>");
                     console.log(index);
                })
        console.log(data);
         }
    });
};
</script>
</body>
</html>