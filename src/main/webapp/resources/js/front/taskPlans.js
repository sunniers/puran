/*
 *	createTime:2016/11/20
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var projTaskId = sessionStorage.getItem('projTaskId');
	sessionStorage.clear();
	var data = {
			total:0,
			page : 1,
			pageSize :7,
			projTaskId:projTaskId
	}
	var app = {
			init:function(){
				this.initData();
				this.addTask();//增加任务
				this.parentTaskName();//初始化前置任务
			},
			initData:function(){
				data.page=1;
				T.post('/s/task/selectTaskDetailplan',data,function(res){
					if(res.retCode=='10000'){
						console.log(res);
						var obj = res.retObject;
						for(var i=0;i<obj.list[0].projectTaskDetailplans.length;i++){
							obj.list[0].projectTaskDetailplans[i].index=i+1;
							obj.list[0].projectTaskDetailplans[i].auditDatetime=T.dateFormat(new Date(obj.list[0].projectTaskDetailplans[i].auditDatetime),"yyyy-MM-dd");
							obj.list[0].projectTaskDetailplans[i].finishDate=T.dateFormat(new Date(obj.list[0].projectTaskDetailplans[i].finishDate),"yyyy-MM-dd");
						}
						$('table tbody').children().remove();
						$('#taskPlans_table_tmplate').tmpl(obj.list[0].projectTaskDetailplans).appendTo('table tbody');
						app.lookAt();//查看
				        app.modify();//删除
				        app.planDel();//删除
						$('#paginator').smartpaginator({
								totalrecords : obj.total,
								recordsperpage : data.pageSize,
								onchange : function(newPage) { // 修改起始页码 更新数据
										var currData = data;
										currData.page = newPage;
										T.post('/s/task/selectTaskDetailplan', currData, function(res) {
											console.log(res);
											var _obj = res.retObject;
											for(var i=0;i<_obj.list[0].projectTaskDetailplans.length;i++){
												_obj.list[0].projectTaskDetailplans[i].index=i+1+data.pageSize*(newPage-1);
												_obj.list[0].projectTaskDetailplans[i].auditDatetime=T.dateFormat(new Date(_obj.list[0].projectTaskDetailplans[i].auditDatetime),"yyyy-MM-dd");
												_obj.list[0].projectTaskDetailplans[i].finishDate=T.dateFormat(new Date(_obj.list[0].projectTaskDetailplans[i].finishDate),"yyyy-MM-dd");
											}
											$('table tbody').children().remove();
											$('#taskPlans_table_tmplate').tmpl(_obj.list[0].projectTaskDetailplans).appendTo('table tbody');
									        app.lookAt();//查看
									        app.modify();
									        app.planDel();
										});
									}
								});
					}
				})
			},
			parentTaskName:function(){//初始化前置任务
				T.post('/s/task/selectFrontPlan','',function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var html='<option value="">请选择</option>';
                		for(var i=0;i<res.retObject.length;i++){
                			html+='<option data-id="'+res.retObject[i].subTaskId+'">'+res.retObject[i].subPlanName+'</option>';
                		}
                		$('.modal-body .predecessors select').append(html);
					}
				})
			},
			addTask:function(){
				$('#taskPlans_addTask .msg-error').hide();
				$('#addTaskBtn').unbind().bind('click',function(){
					$('#taskPlans_addTask .msg-error').hide();
					var sendData = {
							'projTaskId':projTaskId,
							'projectTaskDetailplans':[{
								"subPlanName":$('#taskPlans_addTask .taskName input').val(),
								"startDate":$('#taskPlans_addTask .projTaskExpectStart input').val(),
								"finishDate":$('#taskPlans_addTask .projTaskExpectEnd input').val(),
								"parentTaskId":$('#addPredecessors option:selected').attr('data-id'),
								"taskDescription":$('#taskPlans_addTask .taskDescription textarea').val()
							}]
					}
					console.log(sendData.projectTaskDetailplans[0].subPlanName);
					if(T.isEmpty(sendData.projectTaskDetailplans[0].subPlanName)){
						$('#taskPlans_addTask .taskName .msg-error').show();
						$('#taskPlans_addTask .taskName .msg-con').html("任务名称不能为空");
						return false;
					}
					if(T.isEmpty(sendData.projectTaskDetailplans[0].startDate)){
						$('#taskPlans_addTask .projTaskExpectStart .msg-error').show();
						$('#taskPlans_addTask .projTaskExpectStart .msg-con').html("开始时间不能为空");
						return false;
					}
					if(T.isEmpty(sendData.projectTaskDetailplans[0].finishDate)){
						$('#taskPlans_addTask .projTaskExpectEnd .msg-error').show();
						$('#taskPlans_addTask .projTaskExpectEnd .msg-con').html("结束时间不能为空");
						return false;
					}
					if(T.isEmpty(sendData.projectTaskDetailplans[0].parentTaskId)){
						$('#taskPlans_addTask .predecessors .msg-error').show();
						$('#taskPlans_addTask .predecessors .msg-con').html("请选择前置任务");
						return false;
					}
					if(T.isEmpty(sendData.projectTaskDetailplans[0].taskDescription)){
						$('#taskPlans_addTask .taskDescription .msg-error').show();
						$('#taskPlans_addTask .taskDescription .msg-con').html("任务描述不能为空");
						return false;
					}else{
						T.post('/s/task/insertTaskDetailplan',sendData,function(res){
							if(res.retCode=='10000'){
								console.log(res);
								$.alert({
								      body: '任务添加成功！',
								      height: 100
								    });
								app.initData();
							}
						})
					}
				})
			},
			lookAt:function(){//查看
				$('table tbody .lookAt').unbind().bind('click',function(){
					var subTaskId = $(this).parent().attr('data-id');
					T.post('/s/task/viewTaskDetailplan',{'subTaskId':subTaskId},function(res){
						if(res.retCode=='10000'){
							console.log(res);
							var obj = res.retObject;
							$('#taskPlans_lookAt .modal-body').children().remove();
							$('#taskPlans_lookAt_tmplate').tmpl(obj).appendTo('#taskPlans_lookAt .modal-body');
						}
					})
				})
			},
			modify:function(){
				$('table tbody .modify').unbind().bind('click',function(){
					var subTaskId = $(this).parent().attr('data-id');
					$('#taskPlans_modify .msg-error').hide();
					$('#modifyBtn').unbind().bind('click',function(){
						$('#taskPlans_modify .msg-error').hide();
						var modifyData = {
								"subTaskId": subTaskId,
								"subPlanName":$('#taskPlans_modify .taskName input').val(),
								"taskDescription":$('#taskPlans_modify .taskDescription textarea').val(),
								"startDate":$('#taskPlans_modify .projTaskExpectStart input').val(),
								"finishDate":$('#taskPlans_modify .projTaskExpectEnd input').val(),
								"parentTaskId":$('#taskPlans_modify option:selected').attr('data-id'),
						}
						T.post('/s/task/updateTaskDetailplan',modifyData,function(res){
							if(res.retCode=='10000'){
								console.log(res);
								$.alert({
								      body: '计划修改成功！',
								      height: 100
								    });
								app.initData();
							}
						})
					})
				})
			},
			planDel:function(){//删除
				$('table tbody .planDel').unbind().bind('click',function(){
					var subTaskId = $(this).parent().attr('data-id');
					T.post('/s/task/deleteTaskDetailplan',{'subTaskId':subTaskId},function(res){
						if(res.retCode=='10000'){
							console.log(res);
							$.alert({
							      body: '删除成功！',
							      height: 100
							    });
							app.initData();
						}
					})
				})
			}
	}
	app.init();
})
