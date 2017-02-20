/*
 *	createTime:2016/11/10 
 * 	author	  :caichao
 * 	 
 */
$(function(){
	var app = {
			init:function(){
				this.work();
				this.backBtn();//返回
			},
			work:function(){
				var projTaskId = sessionStorage.getItem('projTaskId');
				T.post('/s/task/selectTaskDetails',{'projTaskId':projTaskId},function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var obj = res.retObject;
						obj.projTaskStartDate=T.dateFormat(new Date(obj.projTaskStartDate),"yyyy-MM-dd");
						obj.projTaskFinishDate=T.dateFormat(new Date(obj.projTaskFinishDate),"yyyy-MM-dd");
						$('.tableContent').children().remove();
	        			$('#taskPoints_task_tmplate').tmpl(obj).appendTo('.tableContent');
					}
				})
			},
			backBtn:function(){
				$('#backBtn').unbind().bind('click',function(){
					$('.rightContentField').load('../resources/html/front/taskManagement.html');
				})	
			}
	}
	app.init();
})
