/**
 * 发送站内信
 */
var mfrom;
var mto;
var message;

function getData(toname)
{
	mfrom = $("#myusername").html();
	mto = toname;
	if(mfrom==null)
    {
		alert("请先登录");
		return;
    }
	console.log("mfrom="+mfrom+"  mto="+mto);
	centerPopup();   
	loadPopup();   
}

function sendMessage(message){
	$.ajax({
		url:"sendMessage.do",
		data:"mfrom="+mfrom+"&mto="+mto+"&message="+message,
		dataType:"text",
		type:"post",
		success:function(){
			alert("发送成功");
		}
	});
}

$(document).ready(function(){
	$("#send").click(function(event){
		event=event||window.event;
		event.stopPropagation();
		var message = $("#send_message").val();
		if(message==""||message==null)
		{
			alert("留言不能为空");
			return;
		}
		sendMessage(message);
		console.log("message="+message);
		$("#send_message").val("");
		disablePopup();
	});
});
