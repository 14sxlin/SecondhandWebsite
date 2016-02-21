window.onload=function(){
    $.ajax({
    url:"wantbuyitems",
    dataType:"json",
    type:"get",
    success:function(data){
    	console.log(data.length);
              if(data.length!=1){
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
         }
    });
};