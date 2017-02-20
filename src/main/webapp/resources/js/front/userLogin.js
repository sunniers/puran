/*
 *	createTime:2016/10/27 
 * 	author	  :luyi
 * 	
 * 
 */
$(function(){
	var app = new Object();
	app = {
			init:function(){
				this.inituserLogin();
				this.goToRegist();
				this.forgetPassword();
			},
			inituserLogin:function(){
				$('.msg-error').hide();
				$('.sureBtn').unbind().bind('click',function(){
					$('.msg-error').hide();
					var data = {
							userName : $('.userName input').val(),
							userPwd : $('.passWord input').val()
					}
					if(T.isEmpty(data.userName)){
						$('.userName .msg-con').html("请输入用户名");
						$('.userName .msg-error').show();
						return false;
					}
					if(T.isEmpty(data.userPwd)){
						$('.passWord .msg-con').html("请输入密码");
						$('.passWord .msg-error').show();
						return false;
					}else{
						T.post('/s/login/userLogin',data,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								location.href="../../../index.html";
							}else{
								$('.passWord .msg-con').html(res.retMessage);
								$('.passWord .msg-error').show();
							}
							
						})
					}
					
				})
			},
			goToRegist:function(){
				$('.userContent .registers').bind('click',function(){
					$('.rightContentField').load('../resources/html/front/register.html');
				});
			},
			forgetPassword:function(){
				$('.userContent .forgetPsd').bind('click',function(){
					$('.rightContentField').load('../resources/html/front/forgetPassword.html');
				});
			}
	}
	app.init();
})
