/*
 *	createTime:2016/11/23
 * 	author	  :Chenxl
 * 	
 * 
 */
$(function(){
	

	var app={
			init:function(){
				this.getBaseInfo();
			},
			getBaseInfo:function(){
				T.post("/s/resource_audit/findReq",
						{"resourceId":sessionStorage.getItem('resourceId')},
						function(res){
							if(res.retCode="10000"){
								console.log(res);
								var obj = res.retObject;
									obj.publishDatetime=T.dateFormat(new Date(obj.publishDatetime),"MM-dd");
									$(".needReRe>div").remove();
									$('#resources_resource_tmplate').tmpl(obj).appendTo($(".needReRe"));
									$('.needReRe').show();
								
							}
				});
				//通过
				$(document).off('click','.resPass').on('click','.resPass',function(){
					T.post("/s/resource_audit/insert",
							{"resourceId":sessionStorage.getItem('resourceId'),"auditStatusId":400702,},
							function(res){
								if(res.retCode="10000"){
									console.log(res);
									$('.rightContentField').load('resourceReview.html');
								}else{
									
								}
					});
				});
				//不通过
				$(document).off('click','.resRefuse').on('click','.resRefuse',function(){
					T.post("/s/resource_audit/insert",
							{"resourceId":sessionStorage.getItem('resourceId'),"auditStatusId":400703,},
							function(res){
								if(res.retCode="10000"){
									console.log(res);
									$('.rightContentField').load('resourceReview.html');
								}else{
									
								}
					});
				})
			},



	}
	app.init();
})
