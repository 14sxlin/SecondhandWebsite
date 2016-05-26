<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="WantToBuy.css">
<title>求购信息</title>
</head>
<body>
	<form action="" method="post" class="wanttobuy">
    <h1>求购信息</h1>
    <label>
        <span>商品名 :</span>
        <input id="productname" type="text" name="productname" placeholder="请输入商品名" />
    </label>
    <label>
    	<span>商品类型 :</span>
        <select name="producttype">
				<option>图书</option>
				<option>衣鞋包</option>
				<option>电子设备</option>
				<option>食品</option>
				<option>家居用品</option>
				<option>其他</option>
		</select><br/>
    </label>
    <label>
        <span>报价 :</span>
        <input id="price" type="text" name="price" placeholder="请输入报价" />
    </label>
    <label>
        <span>备注 :</span>
        <textarea id="remark" rows="3" cols="50" name="remark"></textarea>
    </label>   
    <label>
    	<span>&nbsp;</span>
    	<input type="submit" value="提交" /><input type="reset" value="重置" /><br/>
    </label>   
	</form>
</body>
</html>