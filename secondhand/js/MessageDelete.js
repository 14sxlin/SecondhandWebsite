/**
 * 
 */
function changeMessageState(idArray){
	$.ajax({
		url:"changemessagestate.do",
		data:"ids="+idArray,
		type:"post",
		dataType:"text",
		success:function(data){
			console.log(data);
			if($.trim(""+data)=="OK")
			{
				console.log("更新成功");
				$('#receiveMsg').modal('hide');
				 $("#messageCount") .hide();
			}else alert("信息状态更新失败");
		}
	});
}

function readAll(){
	changeMessageState(ids);
}
