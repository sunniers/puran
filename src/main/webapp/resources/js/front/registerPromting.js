
/*
 *	createTime:2016/11/1
 * 	author	  :caichao
 *
 *
 */
$(function(){
	var app = {
			init:function(){
				this.work();
			},
			work:function(){
				var data = {
						'userName':sessionStorage.getItem

('userName'),
            			'userPwd':sessionStorage.getItem('userPwd'),
            			'userEmail':sessionStorage.getItem('userEmail')	
				}
				sessionStorage.clear();
				//进入邮箱
				$('.goMail').unbind().bind('click',function(){
					var arr = data.userEmail.split('@');
					url = arr[1];
					window.location.href="http://mail."+ url;
				})
				//重新发送
				$('#resend').unbind().bind('click',function(){
					T.post('/s/login/resend',{userName:data.userName},function(res){
						console.log(res);
	        			if(res.retCode=='10000'){
	        				$.alert({
							      body: "发送成功",
							      height: 100
							    });
	        			}else{
	        				$.alert({
							      body: "发送失败",
							      height: 100
							    });
	        			}
					})
				})
			},
	}
	app.init();
})