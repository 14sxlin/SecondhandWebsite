///**
// * 
// */
//function loadShopping(){
//    $.ajax({
//    url:"shoppingitems",
//    dataType:"json",
//    type:"get",
//    success:function(data){
//               $("#ShoppingDisplay").html("");
//               $.each(data,function(index,shopping)
//                {
//                     $("#ShoppingDisplay").append(
//                    		 " <li class=\"span4\">"+
//                             "<div class=\"thumbnail\">"+
//                             "<p>"+
//                                 "<img alt=\"300x200\" src=\"img/people.jpg\" />"+
//                             "</p>"+
//                             "<div class=\"caption\">"+
//                                 "<h3>"+
//                                    shopping.shoppingname+
//                                 "</h3>"+
//                                 "<p>"+
//                                     "<span class=\"warning\">￥shopping.price<br/>"+
//                                     shopping.name +"发布于" +
//                                     shopping.publishdate +
//                                 "</p>"+
//                                 "<p>"+
//                                     "<a class=\"btn btn-primary\" "+
//                                       "  href=\"window.open('/SecondhandWebsite/shoppingquery.do?id="
//                                             +shopping.id+"')\">详细</a>"+ 
//                                     "<a class=\"btn\" href=\"#\">联系TA</a>"+
//                                 "</p>"+
//                             "</div>"+
//                         "</div>"+
//                     "</li>"
//                    );
//                     console.log(index);
//                })
//        console.log(data);
//         }
//    });
//};