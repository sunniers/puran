/*
 *	createTime:2016/11/10
 * 	author	  :caichao
 *
 *
 */
$(function(){
	var data = {
			total:0,
			page : 1,
			pageSize :10
	}
    var  app = {
        init: function() {
        	this.work();
        	this.points();
        	this.changes();
        	this.plans();
        	this.progress();
        	this.purchase();
        },
        work:function(){
        	T.post('/s/task/selectPrPlanTask',data,function(res){
        		if(res.retCode=='10000'){
        			console.log(res);
        			obj = res.retObject;
        			total = obj.total;
        			for(var i=0;i<obj.list.length;i++){
        				obj.list[i].projTaskStartDate=T.dateFormat(new Date(obj.list[i].projTaskStartDate),"yyyy-MM-dd");
    					obj.list[i].projTaskFinishDate=T.dateFormat(new Date(obj.list[i].projTaskFinishDate),"yyyy-MM-dd");
        			}
        			$('#tableData tbody').remove();
		        	$('#task_management_tmplate').tmpl(obj.list).appendTo('#tableData');
        			app.page();
        		}
        	})
				},
				page:function(){
					$('#paginator').smartpaginator({
						totalrecords : obj.total,
						recordsperpage : data.pageSize,
						onchange : function(newPage) { // 修改起始页码 更新数据
							var currData = data;
							currData.page = newPage;
							T.post('/s/task/selectPrPlanTask', currData, function(res) {
								console.log(res);
								var _obj = res.retObject;
								for(var i=0;i<obj.list.length;i++){
			        				_obj.list[i].projTaskStartDate=T.dateFormat(new Date(_obj.list[i].projTaskStartDate),"yyyy-MM-dd");
			    					_obj.list[i].projTaskFinishDate=T.dateFormat(new Date(_obj.list[i].projTaskFinishDate),"yyyy-MM-dd");
			        			}
								$('#tableData tbody').remove();
			        			$('#task_management_tmplate').tmpl(_obj.list).appendTo('#tableData');
							});
						}
					});
				},
				//详情
				points:function(){
					$(document).off('click','#points').on('click','#points',function(){
						var projTaskId=$(this).attr('data-id');
						sessionStorage.setItem('projTaskId',projTaskId);
						$('.rightContentField').load('resources/html/front/taskPoints.html');
					})
				},
				//变更
				changes:function(){
					$(document).off('click','#changes').on('click','#changes',function(){
						var projTaskId=$(this).attr('data-id');
						sessionStorage.setItem('projTaskId',projTaskId);
						$('.rightContentField').load('resources/html/front/taskChanges.html');
					})
				},
				//计划
				plans:function(){
					$(document).off('click','#plans').on('click','#plans',function(){
						var projTaskId=$(this).attr('data-id');
						sessionStorage.setItem('projTaskId',projTaskId);
						$('.rightContentField').load('resources/html/front/taskPlans.html');
					})
				},
				//进度
				progress:function(){
					$(document).off('click','#progress').on('click','#progress',function(){
						var projTaskId=$(this).attr('data-id');
						sessionStorage.setItem('projTaskId',projTaskId);
						$('.rightContentField').load('resources/html/front/taskProgress.html');
					})
				},
				//采购
				purchase:function(){
					$(document).off('click','#purchase').on('click','#purchase',function(){
						var projTaskId=$(this).attr('data-id');
						sessionStorage.setItem('projTaskId',projTaskId);
						$('.rightContentField').load('resources/html/front/taskPurchase.html');
					})
				}
	}
    app.init();
    })