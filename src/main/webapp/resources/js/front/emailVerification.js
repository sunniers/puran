/*
 *	createTime:2016/11/2
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
				console.log(T.getUrlParam('sid'));
				var data = {
						'sid':'sid='+T.getUrlParam('sid')	
							}
				$.get('/s/login/emailVerification',data.sid,function(res){
					console.log(res);
					var str = res.slice(18,23)
					console.log(str);
					if(str=='10000'){
						window.location.href="http://localhost:8080/index.html";
					}else{
						$.alert({
						      body: '注册失败 ',
						      height: 100
						    });
					}
				})
			}
	}
	app.init();
})
