window.onload=function(){
	
	//异步查询商品表
    $.ajax({
    url:"shoppingitems",
    dataType:"json",
    type:"get",
    success:function(data){
    	console.log(data.length);
    		if(data.length!=1){
            	$("#shopUL").html("");
            	$.each(data,function(index,shopping)
                {
                     $("#shopUL").append(
                    "<li target='_blank' "+
                     "onclick=\"window.open('/SecondhandWebsite/shoppingquery.do?id="+shopping.shopping_id+"')\">"+
                     "<div class=\"shoppingname\">"+shopping.shoppingname+"</div>"+
                     "<div class=\"innerRight\">"+
                       "<span class=\"date\">"+shopping.publishdate+"</span>"+
                       "<span class=\"price\">￥"+shopping.price+"</span>"+
                       "<span class=\"username\">"+shopping.username+"</span>"+
                      "</div>"+
                     "</li>");
                     console.log(index);
                })
                console.log(data);
            }
         }
    });
    
    //异步查询求购表
    $.ajax({
        url:"wantbuyitems",
        dataType:"json",
        type:"get",
        success:function(data){
        	console.log(data.length);
                //  if(data.length!=1){
                	  $("#wantbuyUL").html("");
                	  $.each(data,function(index,wantbuy)
                              {
                                   $("#wantbuyUL").append(
                                  "<li target='_blank' "+
                                   "onclick=\"window.open('/SecondhandWebsite/wantbuyquery.do?id="+wantbuy.id+"')\">"+
                                   "<div class=\"shoppingname\">"+wantbuy.shoppingname+"</div>"+
                                   "<div class=\"innerRight\">"+
                                     "<span class=\"date\">"+wantbuy.publishdate+"</span>"+
                                     "<span class=\"price\">￥"+wantbuy.price+"</span>"+
                                     "<span class=\"username\">"+wantbuy.username+"</span>"+
                                    "</div>"+
                                   "</li>");
                                   console.log(index);
                              })
                              console.log(data);
                  }
            // }
        });
};