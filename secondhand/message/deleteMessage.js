/**
 * 
 */
function changeMessageState(id){
	$.ajax({
		url:"changemessagestate.do",
		data:"id="+id,
		type:"post",
		dataType:"text",
		success:function(){console.log("更新成功");}
	});
}