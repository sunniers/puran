/*
 *	createTime:2016/11/21
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
				if(sessionStorage.getItem('requirementType')=="700001"){//创意需求
				T.post("/s/req_audit/findProj",
						{"projId":sessionStorage.getItem('projId')},
						function(res){
							if(res.retCode="10000"){
								console.log(res);
								var obj = res.retObject;
									obj.projStartDate=T.dateFormat(new Date(obj.projStartDate),"MM-dd");
									obj.projCloseDate=T.dateFormat(new Date(obj.projCloseDate),"MM-dd");
									obj.createDatetime=T.dateFormat(new Date(obj.createDatetime),"MM-dd");
									$(".needReRe>div").remove();
									$('#resources_reviewIng_tmplate').tmpl(obj).appendTo($(".needReRe"));
									$('.needReRe').show();
							}
				});
				}else if(sessionStorage.getItem('requirementType')=="700002"){//人才需求
					T.post("/s/req_audit/findTalent",
							{"projId":sessionStorage.getItem('projId')},
							function(res){
								if(res.retCode="10000"){
									console.log(res);
									var obj = res.retObject;
										obj.projStartDate=T.dateFormat(new Date(obj.projStartDate),"MM-dd");
										obj.projCloseDate=T.dateFormat(new Date(obj.projCloseDate),"MM-dd");
										obj.createDatetime=T.dateFormat(new Date(obj.createDatetime),"MM-dd");
										$(".needReRe>div").remove();
										$('#resources_personnel_tmplate').tmpl(res.retObject).appendTo($(".needReRe"));
										$('.needReRe').show();
								}
					});
				}else if(sessionStorage.getItem('requirementType')=="700003"){//融资需求
					T.post("/s/req_audit/findFancing",
							{"projId":sessionStorage.getItem('projId')},
							function(res){
								if(res.retCode="10000"){
									console.log(res);
									var obj = res.retObject;
										obj.projStartDate=T.dateFormat(new Date(obj.projStartDate),"MM-dd");
										obj.projCloseDate=T.dateFormat(new Date(obj.projCloseDate),"MM-dd");
										obj.createDatetime=T.dateFormat(new Date(obj.createDatetime),"MM-dd");
										$(".needReRe>div").remove();
										$('#resources_financing_tmplate').tmpl(res.retObject).appendTo($(".needReRe"));
										$('.needReRe').show();
								}
					});
				}
				//通过
				$(document).off('click','.neePass').on('click','.neePass',function(){
					T.post("/s/req_audit/insert",
							{"projId":sessionStorage.getItem('projId'),"auditStatusId":400702,
							"requirementType":sessionStorage.getItem('requirementType')},
							function(res){
								if(res.retCode="10000"){
									console.log(res);
									$('.rightContentField').load('needReview.html');
								}else{
									
								}
					});
				});
				//不通过
				$(document).off('click','.neeRefuse').on('click','.neeRefuse',function(){
					T.post("/s/req_audit/insert",
							{"projId":sessionStorage.getItem('projId'),"auditStatusId":400703,
							"requirementType":sessionStorage.getItem('requirementType')},
							function(res){
								if(res.retCode="10000"){
									console.log(res);
									$('.rightContentField').load('needReview.html');
								}else{
									
								}
					});
				})
			},



	}
	app.init();
})