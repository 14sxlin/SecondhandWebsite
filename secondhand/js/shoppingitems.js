//异步查询商品表
function loadShopping(){
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
	                       "<span class=\"date\">"+getDateDiff(shopping.publishdate)
	                       +"</span>"+
	                       "<span class=\"price\">￥"+shopping.price+"</span>"+
	                       "<span class=\"username\">"
	                       		+shopping.username+"</span>"+
	                      "</div>"+
	                     "</li>"
	                      + "<a href=\"javascript:getData('"+shopping.username+"')\">" +
	                      		"☝给TA留言</a>");
//	                     console.log(index);
	                })
//	                console.log(data);
	            }
	         }
	    });
}
    
