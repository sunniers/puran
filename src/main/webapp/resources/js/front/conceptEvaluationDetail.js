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
							$('.conceptEvaluationDetail .assessmentDate').html(o.assessmentDate);
							$('.conceptEvaluationDetail .applyPerson').html(o.applyPerson);
							$('.conceptEvaluationDetail .projectDescribe').html(o.projectDescribe);
							$('.conceptEvaluationDetail .mobile').html(o.mobile);
							$('.conceptEvaluationDetail .projectName').html(o.projectName);
							if(o.assessmentStatus=='900002'){
								$('.conceptEvaluationDetail').append('<img alt="" src="resources/images/front/refusePass.png">');
							}
					}
				});
			}
		}
	app.init();
})