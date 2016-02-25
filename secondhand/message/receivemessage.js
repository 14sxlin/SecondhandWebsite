document.write("<script type=\"text/javascript\" src=\"message/deleteMessage.js\" " +
		"charset=\"utf-8\"></script>");
var e = window.event; 
function receiveMessage()
{
	$.ajax(
	{
		url:"receivemessage.do",
		//data:"username="
		dataType:"json",
		type:"post",
		success:function(data){
			console.log(data);
			if(data!=null){
				$(".head").
				append("<span id='message' " +
						"style='postion:relative;;right:0px;'>你有新消息</span>");
				$('.head').bind( 
				        'mouseover', 
				        function(e) { 
				            if(checkHover(e,this)){ 
				            	$("#mymessage").fadeIn("slow");
				                }
				        }); 
				 //鼠标移除层区域后，触发mouseout事件，把整个层隐藏 
				 $('.head').bind('mouseout', function(e) { 
				     if(checkHover(e,this)){ 
				    		$("#mymessage").fadeOut("slow");
				     } 
				 }); 
				$("#mymessage").html();
				$.each(data,function(index,message){
					var id = message.id;
$("#mymessage").append(
		"<span id='mfrom'>"+message.mfrom +" 对你说 :</span>");
$("#mymessage").append(
		"<span id='content'>"+message.content+"</span>");
$("#mymessage").append(
		"<span id='date'>"+getDateDiff(message.publishdate)+"</span>");
$("#mymessage").append(
"<input id='replay' type='button' value='回复'  " +
"onclick=\"getData('"+message.mfrom+"')\"></input>");
$("#mymessage").append(
		"<input id='"+message.id+"' type='checkbox' name='read'>删除</input>");
$("#mymessage").append("<br/>");
$("#"+message.id).change(function(){
	if($("#"+message.id).prop("checked")){
		changeMessageState(message.id);
	}
})
				});
			}else{}
			
		}
	});
}

 /**
  * 下面是一些基础函数，解决mouseover与mouserout事件不停切换的问题（问题不是由冒泡产生的）
  */ 
 function checkHover(e, target) { 
     if (getEvent(e).type == "mouseover") { 
         return !contains(target, getEvent(e).relatedTarget 
                 || getEvent(e).fromElement) 
                 && !((getEvent(e).relatedTarget || getEvent(e).fromElement) === target); 
     } else { 
         return !contains(target, getEvent(e).relatedTarget 
                 || getEvent(e).toElement) 
                 && !((getEvent(e).relatedTarget || getEvent(e).toElement) === target); 
     } 
 } 

 function contains(parentNode, childNode) { 
     if (parentNode.contains) { 
         return parentNode != childNode && parentNode.contains(childNode); 
     } else { 
         return (parentNode.compareDocumentPosition(childNode) & 16); 
     } 
 } 
 //取得当前window对象的事件 
 function getEvent(e) { 
     return e || window.event; 
 } 




