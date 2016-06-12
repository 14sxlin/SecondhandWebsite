var stuidValidate = false;
var usernameValidate = false;

$().ready(function(){
	$("#stuid").blur(function(){
		//console.log("ask stuid"+$("#stuid").val());
		$.ajax({
			url:"StuIdValidate",
			type:"post",
			dataType : "text",
			data : "stuid="+$("#stuid").val(),
			success:function(result){
//				console.log(result);
//				alert("success");
				if(result!="OK"){
					$("#stuid").attr("title","该学号已注册");
					stuidValidate = false;
					if($("#stuid").val()!="")
						$("#stuid").popover('show'); 
					$("#stuid").focus();
				}else{
					$("#stuid").attr("title","");
					stuidValidate = true;
					$("#stuid").popover('hide'); 
				}
			}//sucess
		})//ajax
	})//stuid blur
	$("#username").blur(function(){
		$.ajax({
			url:"UserNameValidate",
			type:"post",
			dataType : "text",
			data : "username="+$("#username").val(),
			success:function(result){
		//		console.log(result);
			//	alert("success");
				if(result!="OK"){
					$("#username").attr("title","该用户名已存在");
					usernameValidate = false;
					if($("#username").val()!="")
						$("#username").popover('show'); 
					if(stuidValidate)
						$("#username").focus();
				}else{
					$("#username").attr("title","");
					usernameValidate = true;
					$("#username").popover('hide'); 
				}
			}//sucess
		})//ajax
	})//stuid blur
});

$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#RegistForm").validate({
    rules: {
      stuid:{
    	  digits : true,
    	  required:true,
    	  minlength:10,
    	  maxlength:10
      },
      username: {
        required: true,
        minlength: 2
      },
      password: {
        required: true,
        minlength: 6
      },
      confirm_password: {
        required: true,
        minlength: 6,
        equalTo: "#password"
      },
      longnum:{
    	  required:function(){
    		  console.log($("#shortnum").val());
    		  console.log($("#longnum").val());
    		  return !($("#shortnum").val()!=""||$("#longnum").val()!="");
    	  }
      },
      shortnum:{
    	  required:function(){
    		  console.log($("#shortnum").val());
    		  console.log($("#longnum").val());
    		  return !($("#shortnum").val()!=""||$("#longnum").val()!="");
    	  }
      }
    },//rules
    messages: {
    	stuid: {
    		digits:"学号只能有数字",
    		required:"请输入您的学号",
    		minlength:"请输入10位学号",
    		maxlength:"请输入10位学号"
    	 },
       username: {
          required: "请输入用户名",
          minlength: "用户名至少要2个字母"
       },
       password: {
          required: "请输入密码",
          minlength: "密码长度不能小于 6 个字母"
       },
      confirm_password: {
        required: "请输入密码",
        minlength: "密码长度不能小于 6 个字母",
        equalTo: "两次密码输入不一致"
      },
      shortnum:{
    	  required:"长号或短号至少填一个"
      },
      longnum:{
    	  required:"长号或短号至少填一个"
      }
    }//message
  })//validate
});//ready
