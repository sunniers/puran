/*
 *	createTime:2016/11/9
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var app = new Object();
	var investCompanyId = sessionStorage.getItem('investCompanyId');
	app = {
			init:function(){
				this.work();
			},
			work:function(){
				T.post('/s/invest/seek',{'investCompanyId':investCompanyId},function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var obj=res.retObject;
						obj.buildDate=T.dateFormat(new Date(obj.buildDate),"yyyy-MM-dd hh:mm:ss.S");
						obj.createTime=T.dateFormat(new Date(obj.createTime),"yyyy-MM-dd hh:mm:ss.S");
						$('.agencyDetails').children().remove();
						$('#institutions_agencyDetails_template').tmpl(res.retObject).appendTo('.agencyDetails');
					}
				})
			}
	}
	app.init();
})

