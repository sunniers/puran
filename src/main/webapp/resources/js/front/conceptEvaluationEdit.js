/*
 *	createTime:2016/11/17
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var assessmentId=sessionStorage.getItem('conceptId'); 
	var obj={
		      "projectId" :'',
		      "assessmentDate" : '',
		      "mobile" :'',
		      "projectDescribe" :'',
		      "assessmentId":assessmentId
			}
	var flag=true;
	var app={
			init:function(){
				this.getData();
				this.submit();
			},
			getData:function(){
				T.post('/s/evaluation/seek',{'assessmentId':assessmentId},function(res){
					console.log(res);
					if(res.retCode=='10000'){
						app.initData(res.retObject);
					}
				});
			},
			initData:function(o){
				$('.conceptEvaluationEdit .projectId select')
					.html('<option value="'+o.projectId+'">'+o.projectName+'</option>');
				$('.conceptEvaluationEdit .assessmentDate input').val(T.dateFormat(new Date(o.assessmentDate),'yyyy-MM-dd'));
				$('.conceptEvaluationEdit .applyPerson span').html(o.applyPerson);
				$('.conceptEvaluationEdit .mobile input').val(o.mobile);
				$('.conceptEvaluationEdit .projectDescribe textarea').val(o.projectDescribe);
			},
			examData:function(){
				$('.msg-error').hide();
				flag=true;
				obj.projectId=$('.conceptEvaluationEdit .projectId select').val();
				obj.assessmentDate=$('.conceptEvaluationEdit .assessmentDate input').val();
				obj.mobile=$('.conceptEvaluationEdit .mobile input').val();
				obj.projectDescribe=$('.conceptEvaluationEdit .projectDescribe textarea').val();
				$.each(obj,function(i,e){
					if(T.isEmpty(e)){
						console.log(e);
						$('.'+i).siblings('.msg-error').show();
						flag=false;
						return false;
					}
				})
			},
			submit:function(){
				$('.conceptEvaluationEdit .btn button').bind('click',function(){
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
			}
	}
	app.init();
})