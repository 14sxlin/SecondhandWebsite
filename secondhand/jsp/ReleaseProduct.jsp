<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/ReleaseProduct.css">
<title>发布商品</title>
</head>
<body>
	<form action="../publishShopping.do" method="post" class="release" enctype="multipart/form-data">
    <h1>发布商品</h1>
    
    <label>
        <span>商品名称 :</span>
        <input id="productname" type="text" name="shoppingname" placeholder="请输入商品名称" />
    </label>
    <label>
    	<span>商品类型 :</span>
        <select name="shoppingtype">
				<option>图书</option>
				<option>衣鞋包</option>
				<option>电子设备</option>
				<option>食品</option>
				<option>家居用品</option>
				<option>其他</option>
		</select><br/>
    </label>
    <label>
    	<span>商品新旧程度:</span>
	    <select name="level">
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
        </select>成新<br/>
    </label>    
    <label>
    	<span>价格:</span>
    	<input id="price" type="text" name="price" />元<br/>
    </label>
    <label>
    	<span>备注:</span>
    	<textarea id="remark" rows="3" cols="50" name="ps"></textarea><br/><br/>
    </label>
   
    <h4>上传照片: </h4>
    
    <label>
          <input type="file" name="p1"/>
    </label>
    <label>
    	<span>&nbsp;</span><br/>
    	<span>&nbsp;</span><br/>
    	<input type="submit" value="提交" /><input type="reset" value="重置" /><br/>
    </label>	
  </form>
</body>
</html>