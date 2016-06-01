/**
 * 发送站内信
 */
var mfrom;
var mto;
var message = new String();

function setDestination(name)
{
	mto = name;
}

function sendMessage(){
	mfrom = $("#username").html();
	if(mfrom==null||mto==null)
    {
		alert("请先登录");
		$('#mymessage').val("");
		 $('#myModal').modal('hide');
		return;
    }
	if(mfrom==mto)
	{
		alert("不要给自己发信息");
		 $('#myModal').modal('hide');
		 $('#mymessage').val("")
		 return;
	}
	
	//console.log("mfrom="+mfrom+"  mto="+mto);
	message = $('#mymessage').val();
	//console.log("message ="+message);
	$.ajax({
		url:"sendMessage.do",
		data:"mfrom="+mfrom+"&mto="+mto+"&message="+message,
		dataType:"text",
		type:"post",
		success:function(){
			alert("发送成功");
			 $('#myModal').modal('hide')
		}
	});
}