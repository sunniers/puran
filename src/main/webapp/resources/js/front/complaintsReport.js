/*
 *	createTime:2016/10/28
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var app = new Object();
	app = {
			init:function(){
				this.cptRep();
			},
			cptRep:function(){
				$('#cptRepBtn').unbind().bind('click',function(){
					var data = {
							complainObject : $('#cptRepObj').val(),
							complainContent : $('#cptRepCont').val()
					}
					if(T.isEmpty(data.complainObject)){
						return false;
					}
					if(T.isEmpty(data.complainContent)){
						return false;
					}else{
						T.post('/s/complain/insertUserComplain',data,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								$.confirm({
								      body: '请登录！',
								      height: 100
								    });
								
							}
						})
					}
				})
			}
	}
	app.init();
})
