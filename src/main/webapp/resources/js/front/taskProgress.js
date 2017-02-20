/*
 *	createTime:2016/11/21
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var projTaskId = sessionStorage.getItem('projTaskId');
	var data = {
			"page":1,
			"pageSize":6,
			"projTaskId":projTaskId
	}
	var app = {
			init:function(){
				this.initData();
				this.upload();//上传
			},
			initData:function(){
				data.page=1;
				T.post('/s/task/selectTaskDetailplan',data,function(res){
					if(res.retCode=='10000'){
						console.log(res);
						var obj = res.retObject;
						for(var i=0;i<obj.list[0].projectTaskDetailplans.length;i++){
							obj.list[0].projectTaskDetailplans[i].index=i+1;
						}
						$('table tbody').children().remove();
						$('#taskProgress_table_tmplate').tmpl(obj.list[0].projectTaskDetailplans).appendTo('table tbody');
						app.lookAt();//查看
						app.begin();//开始
						app.over();//完成
						app.submit();//提交
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
											_obj.list[0].projectTaskDetailplans[i].index=i+1+(newPage-1)*data.pageSize;
										}
										$('table tbody').children().remove();
										$('#taskProgress_table_tmplate').tmpl(_obj.list[0].projectTaskDetailplans).appendTo('table tbody');
								        app.lookAt();//查看
								        app.begin();//开始
										app.over();//完成
										app.submit();//提交
									});
								}
							});
					}
				})
			},
			lookAt:function(){
				$('table tbody .lookAt').unbind().bind('click',function(){
					var subTaskId = $(this).parent().attr('data-id');
					T.post('/s/task/viewTaskDetailplan',{'subTaskId':subTaskId},function(res){
						if(res.retCode=='10000'){
							console.log(res);
							var obj = res.retObject;
							$('#taskProgress_lookAt .modal-body').children().remove();
							$('#taskProgress_lookAt_tmplate').tmpl(obj).appendTo('#taskProgress_lookAt .modal-body');
						}
					})
				})
			},
			begin:function(){
				$('table tbody .begin').unbind().bind('click',function(res){
					var subTaskId = $(this).parent().attr('data-id');
					console.log(subTaskId);
					T.post('/s/task/updateStart',{'subTaskId':subTaskId},function(){
						if(res.retCode=='10000'){
							console.log(res);
							$.alert({
							      body: '开始计划！',
							      height: 100
							    });
							app.initData();
						}
					})
				})
			},
			over:function(){
				$('table tbody .over').unbind().bind('click',function(res){
					var subTaskId = $(this).parent().attr('data-id');
					console.log(subTaskId);
					T.post('/s/task/updateFinish',{'subTaskId':subTaskId},function(res){
						if(res.retCode=='10000'){
							console.log(res);
							$.alert({
							      body: '完成计划！',
							      height: 100
							    });
							app.initData();
						}
					})
				})
			},
			submit:function(){
				$('table tbody .submit').unbind().bind('click',function(res){
					var subTaskId = $(this).parent().attr('data-id');
					$('#submitBtn').unbind().bind('click',function(){
						var submitData = {
								"projTaskId":data.projTaskId,
								"productValue":$('#taskProgress_submit textarea').val(),
								"fileName":$('#uploadSuccess').attr('data-name'),
								"filePath":$('#uploadSuccess').attr('src')
						}
						T.post('/s/task/insertTaskProduct',submitData,function(res){
							if(res.retCode=='10000'){
								console.log(res);
								$.alert({
								      body: '成功提交计划！',
								      height: 100
								    });
								app.initData();
							}
						})
					})
				})
			},
			upload:function(){
				$('#taskProgress_submit .upLoadImg').unbind().bind('click',function(){	
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址  
				        done: function (e, data) {//设置文件上传完毕事件的回调函数 
				        	var result=JSON.parse(data.result);
					        	imageName=result.name;
					        	path=result.path;
				        	$(this).siblings('.replace').html('<div id="uploadSuccess" src="'+path+'"  data-name="'+imageName+'" >上传成功</div>');
				            console.log('文件上传成功-----name:'+data.result);
				        }
				    }) 
				});
			}
	}
	app.init();
})
