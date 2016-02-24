// JavaScript Document
//使用Jquery加载弹窗 
var popupStatus=0;
function loadPopup(){   
//仅在开启标志popupStatus为0的情况下加载  
if(popupStatus==0){   
$("#backgroundPopup").css({   
"opacity": "0.7"  
});   
$("#backgroundPopup").fadeIn("slow");   
$("#popupContact").fadeIn("slow");   
popupStatus = 1;   
}   
}  

//使用Jquery去除弹窗效果 
function disablePopup(){   
//仅在开启标志popupStatus为1的情况下去除
if(popupStatus==1){   
$("#backgroundPopup").fadeOut("slow");   
$("#popupContact").fadeOut("slow");   
popupStatus = 0;   
}   
}  

//将弹出窗口定位在屏幕的中央
function centerPopup(){   
//获取系统变量
var windowWidth = document.documentElement.clientWidth;   
var windowHeight = document.documentElement.clientHeight;   
var popupHeight = $("#popupContact").height();   
var popupWidth = $("#popupContact").width();   
//居中设置   
$("#popupContact").css({   
"position": "absolute",   
"top": $(document).scrollTop()+windowHeight/2-popupHeight/2,   
"left": windowWidth/2-popupWidth/2   
});   
//以下代码仅在IE6下有效  
$("#backgroundPopup").css({   
"height": windowHeight   
});   
}

/*好了，有了这些基本函数，我们就可以通过jQuery对事件的触发控制来组合这些基本函数以实现弹出DIV效果了。比如，当用户触发点击按钮事件时，我们依次执行居中函数（centerPopup）和窗口加载函数（loadPopup）即可。当用户点击弹出窗口右上方的"X"形关闭按钮时，触发一个事件执行：关闭弹窗函数。
需要注意的是，所有这些事件触发过程都必须包含在以下代码中：
*/

/*
$(document).ready(function(){   
//执行触发事件的代码区域  
});
*/


//打开弹出窗口   
//按钮点击事件!
//$("input").click(function(){   
////调用函数居中窗口
//centerPopup();   
////调用函数加载窗口
//loadPopup();   
//});

//关闭弹出窗口   
//点击"X"所触发的事件
$("#popupContactClose").click(function(){   
disablePopup();   
});   
//点击窗口以外背景所触发的关闭窗口事件!
$("#backgroundPopup").click(function(){   
disablePopup();   
});   
//键盘按下ESC时关闭窗口!
$(document).keypress(function(e){   
if(e.keyCode==27&&popupStatus==1){   
disablePopup();   
}   
});  
