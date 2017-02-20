/*
 *	createTime:2016/10/20 
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var app = new Object();
	app = {
			init:function(){
				this.initlogin();
				
			},
			initlogin:function(){
				$('.sureBtn').unbind().bind('click',function(){
					var data = {
							userName : $('.admin input').val(),
							userPwd : $('.passWord input').val()
					}
					if(T.isEmpty(data.userName)){
						$('.msg-con').html("请输入用户名");
						$('.msg-error').css('opacity','1');
						return false;
					}
					if(T.isEmpty(data.userPwd)){
						$('.msg-con').html("请输入密码");
						$('.msg-error').css('opacity','1');
						return false;
					}else{
						$('.msg-error').css('opacity','0');
						T.post('/s/login/backUserLogin',data,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								location.href="../resources/html/background/index.html";
							}else{
								$('.msg-con').html(res.retMessage);
								$('.msg-error').css('opacity','1');
							}
							
						})
					}
					
				})
			}
	}
	app.init();
})
