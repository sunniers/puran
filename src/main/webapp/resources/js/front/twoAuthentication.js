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
			$('.authentication1').unbind().bind('click',function(){
				$('.rightContentField').load('resources/html/front/enterpriseCertification.html');
			});
			$('.authentication2').unbind().bind('click',function(){
				$('.rightContentField').load('resources/html/front/identityAuthentication.html');
			});
		}
	}
	app.init();
})

