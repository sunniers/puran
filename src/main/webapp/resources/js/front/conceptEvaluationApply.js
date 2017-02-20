/*
 *	createTime:2016/11/16
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var obj={
		      "projectId" :'',
		      "assessmentDate" : '',
		      "mobile" :'',
		      "projectDescribe" :''
			}
	var flag=true;
	var app={
			
			init:function(){
				this.initData();
				this.submit()
			},
			initData:function(){
				T.post('/s/evaluation/perMessage','',function(res){
					console.log(res);
					if(res.retCode=='10000'){
						$('#coneva_apply_template').tmpl(res.retObject.projectList).appendTo('.conceptEvaluationApply .projectId select');
						$('.conceptEvaluationApply .applyPerson span').html(res.retObject.applyPerson);
					}
				});
			},
			submit:function(){
				$('.conceptEvaluationApply .btn button').bind('click',function(){
					app.examData();
					if(flag){
						T.post('/s/evaluation/insert',obj,function(res){
							if(res.retCode=='10000'){
								$.alert({body:'申请成功',hide:function(){
									$('.rightContentField').load('../resources/html/front/conceptEvaluation.html');
								}})
							}else{
								$.alert({body:res.retMssage,hide:function(){
									$('.rightContentField').load('../resources/html/front/conceptEvaluation.html');
								}})
							}
						});
					}
				});
			},
			examData:function(){
				$('.msg-error').hide();
				flag=true;
				obj.projectId=$('.conceptEvaluationApply .projectId select').val();
				obj.assessmentDate=$('.conceptEvaluationApply .assessmentDate input').val();
				obj.mobile=$('.conceptEvaluationApply .mobile input').val();
				obj.projectDescribe=$('.conceptEvaluationApply .projectDescribe textarea').val();
				$.each(obj,function(i,e){
					if(T.isEmpty(e)){
						console.log(e);
						$('.'+i).siblings('.msg-error').show();
						flag=false;
						return false;
					}
				})
			}
	}
	app.init();
})