/*
 *	createTime:2016/11/16
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){

	var start=1,
		size=10,
		total=0;
	
	
	var app={
			init:function(){
				this.initData();
			},
			initData:function(){
				T.post('/s/evaluation/list',{'page':start,'pageSize':size},function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var o=res.retObject.list;
							total=res.retObject.total;
							app.formatDate(o);
							app.showList(o);
							app.page();
					}
				});
			},
			updateData:function(){
				T.post('/s/evaluation/list',{'page':start,'pageSize':size},function(res){
					if(res.retCode=='10000'){
						var o=res.retObject.list;
							app.formatDate(o);
							app.showList(o);
					}
				});
			},
			formatDate:function(o){
				$.each(o,function(index,ele){
					ele.assessmentDate=T.dateFormat(new Date(ele.assessmentDate),'yyyy/MM/dd');
				});
			},
			showList:function(o){
				$('.conceptEvaluation tbody').empty();
				$('#coneva_list_template').tmpl(o).appendTo('.conceptEvaluation tbody');
				app.handle();
			},
			page:function(){
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
						start=newPage;
						app.updateData();
					}
				});
			},
			handle:function(){
				$('.conceptEvaluation .apply button').bind('click',function(){//申请
					T.post('/s/evaluation/perMessage','',function(res){
						if(res.retCode=='10000'){
							if(res.retObject.projectList.length>0){
								$('.rightContentField').load('../resources/html/front/conceptEvaluationApply.html');
							}else{
								$.alert('没有可申请项目');
							}
						}
					});
					
				});
				
				$('.conceptEvaluation .edit').bind('click',function(){//修改
					var conceptId=$(this).attr('data-id');
						sessionStorage.setItem('conceptId',conceptId);
					$('.rightContentField').load('../resources/html/front/conceptEvaluationEdit.html');
				});
				
				$('.conceptEvaluation  .detail').bind('click',function(){//详情
					var conceptId=$(this).attr('data-id');
						sessionStorage.setItem('conceptId',conceptId);
					$('.rightContentField').load('../resources/html/front/conceptEvaluationDetail.html');
				});
				
				$('.conceptEvaluation  .result').bind('click',function(){//结果
					var conceptId=$(this).attr('data-id');
						sessionStorage.setItem('conceptId',conceptId);
					$('.rightContentField').load('../resources/html/front/conceptEvaluationResult.html');
				});
			}
	}
	app.init();
})