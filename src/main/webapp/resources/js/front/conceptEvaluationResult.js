/*
 *	createTime:2016/11/17
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var assessmentId=sessionStorage.getItem('conceptId'); 
	var app={
			init:function(){
				this.showData();
			},
			showData:function(){
				T.post('/s/evaluation/seek',{'assessmentId':assessmentId},function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var o=res.retObject;
							o.assessmentDate=T.dateFormat(new Date(o.assessmentDate),'yyyy-MM-dd');
							$('.conceptEvaluationResult .assessmentDate').html(o.assessmentDate);
							$('.conceptEvaluationResult .applyPerson').html(o.applyPerson);
							$('.conceptEvaluationResult .projectDescribe').html(o.projectDescribe);
							$('.conceptEvaluationResult .mobile').html(o.mobile);
							$('.conceptEvaluationResult .projectName').html(o.projectName);
							$('.conceptEvaluationResult .professionalName').html(o.professionalName);
							$('.conceptEvaluationResult .evaluationDate').html(T.dateFormat(new Date(o.evaluationDate),'yyyy-MM-dd'));
							$('.conceptEvaluationResult .professionalName').html(o.professionalName);
							$('.conceptEvaluationResult .assessmentView').html(o.assessmentView);
							if(T.isEmpty(o.assessmentFile)){
								$('.conceptEvaluationResult .assessmentFile button').hide();
							}else{
								$('.conceptEvaluationResult .assessmentFile a').css('href',o.assessmentFile);
							}
					}
				});
			}
		}
	app.init();
})