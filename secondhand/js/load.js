document.write("<script type=\"text/javascript\" " +
		"src=\"js/datetrans.js\" charset=\"utf-8\"></script>");
document.write("<script type=\"text/javascript\" " +
		"src=\"js/shoppingitems.js\" charset=\"utf-8\"></script>");
document.write("<script type=\"text/javascript\" " +
		"src=\"js/wantbuyitems.js\" charset=\"utf-8\"></script>");
document.write("<script type=\"text/javascript\" " +
		"src=\"message/receivemessage.js\" charset=\"utf-8\"></script>");
$(document).ready(
		function(){
			loadShopping();
			loadWantbuy();
			receiveMessage();
		});