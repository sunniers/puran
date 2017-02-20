/*
 *	createTime:2016/11/10 
 * 	author	  :caichao
 * 	 
 */
$(function(){
	var projTaskId = sessionStorage.getItem('projTaskId');
	var objData = {
			'projTaskId':projTaskId,
			'total':0,
			'pageSize':4,
			'page':1
	}
	sessionStorage.clear();
	var app = {
			init:function(){
				this.initdata();//获取原先内容
				this.sendData();//发送更改内容
				this.tableSwitch();//切换
			},
			initdata:function(){
				T.post('/s/task/selectTaskDetails',{'projTaskId':projTaskId},function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var obj = res.retObject;
						obj.projTaskStartDate=T.dateFormat(new Date(obj.projTaskStartDate),"yyyy-MM-dd");
						obj.projTaskFinishDate=T.dateFormat(new Date(obj.projTaskFinishDate),"yyyy-MM-dd");
						$('.bodyContent .tableContent').children().remove();
	        			$('#taskChanges_taskContent_tmplate').tmpl(obj).appendTo('.bodyContent .tableContent');
					}
				})
				T.post('/s/task/selectChangeStatus',objData,function(res){//变更状态
					objData.page=1;
					console.log(res);
					if(res.retCode=='10000'){
						var obj = res.retObject;
						for(var i=0;i<obj.list.length;i++){
							obj.list[i].createTime=T.dateFormat(new Date(obj.list[i].createTime),"yyyy-MM-dd");
						}
						$('.changeStatus .tableContents').children().remove();
	        			$('#taskChanges_table_tmplate').tmpl(obj.list).appendTo('.changeStatus .tableContents');
	        			app.sure();
	        			app.lookAt();
						$('#paginator').smartpaginator({
							totalrecords :obj.total,
							recordsperpage :objData.pageSize,
							onchange : function(newPage) {
								var _objData=objData;
								_objData.page=newPage;
								T.post('/s/task/selectChangeStatus',_objData,function(res){
									console.log(res);
									if(res.retCode=='10000'){
										var _obj = res.retObject;
										for(var i=0;i<_obj.list.length;i++){
											_obj.list[i].createTime=T.dateFormat(new Date(_obj.list[i].createTime),"yyyy-MM-dd");
										}
										$('.changeStatus .tableContents').children().remove();
					        			$('#taskChanges_table_tmplate').tmpl(_obj.list).appendTo('.changeStatus .tableContents');
					        			app.sure();
					        			app.lookAt();
									}
								})
							}
						});
					}
				})
			},
			sendData:function(){
				$('.bodyContent .msg-error').hide();
				$('#changeBtn').unbind().bind('click',function(){
					$('.bodyContent .msg-error').hide();
					var data = {
							'projChangeContent':$('#changeContent').val(),
							'projTaskExpectStart':$('#projTaskExpectStart').val(),
							'projTaskExpectFinish':$('#projTaskExpectFinish').val(),
							'projectPlanTask':{
								'projTaskId':projTaskId
							}
						}
					if(T.isEmpty(data.projChangeContent)){
						$('.bodyContent .msg-error').show();
						$('.bodyContent .msg-error .msg-con').html("请输入变更内容");
						return false;
					}
					if(T.isEmpty(data.projTaskExpectStart)){
						$('.bodyContent .msg-error').show();
						$('.bodyContent .msg-error .msg-con').html("请输入开始时间");
						return false;
					}
					if(T.isEmpty(data.projTaskExpectFinish)){
						$('.bodyContent .msg-error').show();
						$('.bodyContent .msg-error .msg-con').html("请输入结束时间");
						return false;
					}else{
						T.post('/s/task/insertTaskChange',data,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								$.alert({
								      body: '变更完成！',
								      height: 100
								    });
							}
						})
					}
				})
			},
			tableSwitch:function(){
				$('.taskChanges .title>div').unbind().bind('click',function(){
					var table = $(this).attr('data-attr');
					_table = table;
					
					$(".taskChanges .title>div").removeClass('on');
					$(this).addClass("on");
					$(".taskChanges .tableSwitch").hide();
					$('.taskChanges .'+_table+'').show();
					app.initdata();
				})
			},
			sure:function(){//确认
				$('.tableContents .sure').unbind().bind('click',function(){
					var projectTaskChangeId = $(this).parent().attr('data-id');
					T.post('/s/task/updateProjectTaskChange',{'projectTaskChangeId':projectTaskChangeId},function(res){
						console.log(res);
						if(res.retCode=='10000'){
							$.alert({
							      body: '确认成功！',
							      height: 100
							    });
						}
					})
				})
			},
			lookAt:function(){//查看
				$('.tableContents .lookAt').unbind().bind('click',function(){
					$('#taskChanges_lookAt').modal('show');
					var projectTaskChangeId = $(this).parent().attr('data-id');
					T.post('/s/task/selectChange',{'projectTaskChangeId':projectTaskChangeId},function(res){
						console.log(res);
						if(res.retCode=='10000'){
							var obj = res.retObject;
							obj.auditDatetime=T.dateFormat(new Date(obj.auditDatetime),"yyyy-MM-dd");
							obj.projDevlierDate=T.dateFormat(new Date(obj.projDevlierDate),"yyyy-MM-dd");
							$('#taskChanges_lookAt .modal-body .boxs').children().remove();
		        			$('#taskChanges_changeDeail_tmplate').tmpl(obj).appendTo('#taskChanges_lookAt .modal-body .boxs');
		        			$('#taskChanges_lookAt .modal-body .changeContent').html(obj.projChangeContent);
						}
					})
				})
			}
			
	}
	app.init();
})
