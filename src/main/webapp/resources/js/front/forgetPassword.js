/*
 *	createTime:2016/11/21
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var app = {
			init:function(){
				this.initData();
				this.tableClick();
				this.sendMail();
				this.sendAgain();
			},
			initData:function(){
				
			},
			//切换
			tableClick:function(){
				$('.findWay>div').unbind().bind('click',function(){
					var tabClick = $(this).attr('data-id');
					$('.forgetPassword .way').hide();
					$('.forgetPassword .'+tabClick+'').show();
					$('.findWay>div').removeClass('on');
					$(this).addClass('on');
					app.initData();
				})
			},
			//邮箱
			//发送邮件
			sendMail:function(){
				$('.findWay2 .msg-error').hide();
				$('#sendMail').unbind().bind('click',function(){//发送邮件
					$('.findWay2 .msg-error').hide();
					var data = {
							'userName':$('.findWay2 .userName input').val(),
							'userEmail':$('.findWay2 .bindMailbox input').val()
					}
					if(T.isEmpty(data.userName)){
						$('.findWay2 .userName .msg-error').show();
						$('.findWay2 .userName .msg-con').html("请输入用户");
						return false;
					}
					if(T.isEmpty(data.userEmail)){
						$('.findWay2 .bindMailbox .msg-error').show();
						$('.findWay2 .bindMailbox .msg-con').html("请输入邮箱");
						return false;
					}else{
						T.post('/s/findPwd/emailFind',data,function(res){
							if(res.retCode=='10000'){
								console.log(res);
								alert("发送成功");
								app.goToEmail();
							}
						})
					}
				})
			},
			sendAgain:function(){
				$('#sendAgain').unbind().bind('click',function(){//重新发送
					var data = {
							'userName':$('.findWay2 .userName input').val(),
							'userEmail':$('.findWay2 .bindMailbox input').val()
					}
					T.post('/s/findPwd/resend',data,function(){
						if(res.retCode=='10000'){
							console.log(res);
							alert("重新发送成功");
							app.goToEmail();
						}
					})
				})
			},
			goToEmail:function(){
				$('#goMail').unbind().bind('click',function(){
					var urls = $('.findWay2 .bindMailbox input').val();
					console.log(urls);
					var arr = urls.split('@');
					url = arr[1];
					console.log(url);
					window.location.href="http://mail."+ url;
				})
			}
	}
	app.init();
})
