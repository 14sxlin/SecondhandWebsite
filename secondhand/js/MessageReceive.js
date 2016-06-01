var e = window.event; 
var goback = false;
var ids  = new String();
function receiveMessage()
{
	$.ajax(
	{
		url:"receivemessage.do",
		//data:"username="
		dataType:"json",
		type:"post",
		success:function(data){
			var count = 0;
			ids.length = 0;
			console.log(data);
			if(data!=null){
				$.each(data,function(index,message){
					count++;
					var id = message.id;
					ids+=(id+",");
//					console.log(ids);
					 var msg = $("#MsgBox").html()+"<br/>"+message.mfrom +" 对你说 :"+message.content
						+"<button class='btn pull-right' onclick='reply("+message.mfrom+")'>"
						+" <i class='icon-comment'></i>"
						+"</button>"
						+"<label style='right:0'>"+getDateDiff(message.publishdate)+"</label>"
						;
					 $("#MsgBox").html(msg);
			     })//each
			     if(count!=0)
			    	 $("#messageCount") .html(count);
			     else
			    	 $("#messageCount") .hide();
			 }//if
		}//success
		});//ajax
	
}

 function reply(mto){
	 	setDestination(mto);
	   $('#receiveMsg').modal('hide');
	   $('#myModal').modal('show');//myModal是发送消息的模态框
	  goback = true;
 }
 
 function setInfo(){//不能放在函数里面 不知道为什么..会提示说什么index类型错误
	 var msg = $("#MsgBox").html()+"<br/>"+message.mfrom +" 对你说 :"+message.content
		+getDateDiff(message.publishdate)
		+"<button id='reply' class='btn btn-primary' value='回复'  "
		+"onclick='reply("+message.mfrom+")'></input>"
		;
	 $("#MsgBox").html(msg);
 }
 



