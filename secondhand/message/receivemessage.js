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
				append("<span id='message' style='align:center'>你有新消息</span>");
				$.each(data,function(index,message){
					console.log("index = "+index);
					console.log("mfrom = "+message.mfrom);
					console.log("mto= "+message.mto);
					console.log("content = "+message.content);
				});}
			else{
				
			}
		}
	});
}
