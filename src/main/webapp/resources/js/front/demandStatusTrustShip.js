/*
 *	createTime:2016/11/20
 * 	author	  :Tangj
 * 	
 * 
 */
$(function(){
	
	var app={
			init:function(){
				
			},
			initData:function(){
				T.post('','',function(res){
					console.log(res);
					if(res.retCode=="10000"){
						
					}
				});
			}
	}
	
	app.init();
})