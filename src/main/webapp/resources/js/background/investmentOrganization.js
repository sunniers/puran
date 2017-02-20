/*
 *	createTime:2016/11/23
 * 	author	  :caichao
 * 	edit	  :
 * 
 */
$(function(){
	var total=0,
		page=1,
		pageSize=10;
	var data = {
			'page':page,
			'pageSize':pageSize
	}
	var app={
			init:function(){
				this.initData();
			},
			initData:function(){
				data.page=1;
				T.post('/s/invest/findBack',data,function(res){
					if(res.retCode=='10000'){
						console.log(res.retObject);
						var obj = res.retObject;
					}
				})
			}
	}
	app.init();
})