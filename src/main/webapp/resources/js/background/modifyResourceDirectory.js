/*
 *	createTime:2016/10/25 
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){

	var app={
			init:function(){
	            this.back();
	            this.upload();
	            this.judge();
	            this.submitFir();
	            this.submitSec();
			},
			judge:function(){
				var obj={
						'resourceId':sessionStorage.getItem("resourceId")
				}
				T.post('/s/sys/selectFirstAndSecondResource',obj,function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var _obj=res.retObject;
						if(_obj.sysResources.length>0){//判断修改类型
							
							$('.editSecRes').show();//修改二级目录
							$('.editFirRes').hide();

							$('.editSecRes .resourceName').val(_obj.sysResources[0].resourceName);//初始化二级目录填写信息
							$('.editSecRes .resourceName').attr('data-id',_obj.sysResources[0].resourceId);
							$('.editSecRes .sortedField').val(_obj.sysResources[0].sortedField);
							$('.editSecRes .resourceLink').val(_obj.sysResources[0].resourceLink);
							if(!T.isEmpty(_obj.sysResources[0].resourceIcon)){
								$('.editSecRes .upLoadImg').siblings('.uploadPhoto')
								.html('<img class="resourceIcon" style="width:auto;height:60px;margin-top:0;" src="'+_obj.sysResources[0].resourceIcon+'">');
							}
							
							T.post('/s/sys/selectFirstResource',{'resourceType':_obj.resourceType},function(res){//初始化二级目录可选的一级目录
								console.log(res);
								if(res.retCode=='10000'){
									$('#allFirMenu ul li:not(".group-title")').remove();
									$('#search_firRes_perception_template').tmpl(res.retObject).insertAfter('#allFirMenu ul .peception');
									$('#search_firRes_back_template').tmpl(res.retObject).insertAfter('#allFirMenu ul .back');
									$('.editSecRes ul li[data-id="'+_obj.resourceId+'"] ').attr('class','active');
									$('#select span').html(_obj.resourceName);
								}
							});

						}else{
							$('.editSecRes').hide();
							$('.editFirRes').show();//修改一级目录
							$('.editFirRes .resourceName').val(_obj.resourceName).attr('data-id',_obj.resourceId);
							$('.editFirRes .sortedField').val(_obj.sortedField);
							$('.editFirRes .resourceLink').val(_obj.resourceLink);
							if(!T.isEmpty(_obj.resourceIcon)){
								$('.editFirRes .upLoadImg').siblings('.uploadPhoto')
								.html('<img class="resourceIcon" style="width:auto;height:60px;margin-top:0;" src="'+_obj.resourceIcon+'">');
							}
							
						}
					}
				});
			},
			back:function(){
				$('button.back').unbind().bind('click',function(){
					$('.rightContentField').load('setResourceDirectory.html');	
				})
			},
			upload:function(){
				$(document).off('click','.upLoadImg').on('click','.upLoadImg',function(){
					
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址  
				        done: function (e, data) {//设置文件上传完毕事件的回调函数  
				        	$(this).siblings('.uploadPhoto').html('<img class="resourceIcon" style="width:auto;height:60px;margin-top:0;" src="test.jpg">');
				            console.log('文件上传成功-----name:'+data.result);
				        }/*,  
				        progressall: function (e, data) {//设置上传进度事件的回调函数  
				        	console.log(data);
				            var progress = parseInt(data.loaded / data.total * 100, 10);  
				            $('.sui-progress .bar').css(  
				                'width',  
				                progress + '%'  
				            ).html(progress + '%');
				        }*/  
				    }) 
				});
				 
				
			},
			submitFir:function(){
				$('.editFirRes .save').unbind().bind('click',function(){
					var _obj={
							'resourceName':$('.editFirRes .resourceName').val(),
							'resourceId':$('.editFirRes .resourceName').attr('data-id'),
							'resourceLink':$('.editFirRes .resourceLink').val(),
							'resourceIcon':$('.editFirRes .resourceIcon').attr('src'),
							'sysResources':[{}]
					}
					$('.msg-error').hide();
					if(T.isEmpty(_obj.resourceName)){
						$('.editFirRes .resourceName').next('.msg-error').show();
						return false;
					}if(T.isEmpty(_obj.resourceLink)){
						$('.editFirRes .resourceLink').next('.msg-error').show();
						return false;
					}if(T.isEmpty(_obj.resourceIcon)){
						$('.editFirRes .upLoadImg').next('.msg-error').show();
						return false;
					}else{
						T.post('/s/sys/updateSysResource',_obj,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								$('.rightContentField').load('setResourceDirectory.html');
							}
						});
					}
				});
			},
			submitSec:function(){
				$('.editSecRes .save').unbind().bind('click',function(){
					var _obj={
							'sysResources':[]
					}
					var item={
							'parentResourceId':$('.editSecRes li.active').attr('data-id'),
							'resourceId':$('.editSecRes .resourceName').attr('data-id'),
							'resourceName':$('.editSecRes .resourceName').val(),
							'resourceLink':$('.editSecRes .resourceLink').val(),
							'resourceIcon':$('.editSecRes .resourceIcon').attr('src')
					}
					_obj.sysResources.push(item);
					$('.msg-error').hide();
					if(T.isEmpty(item.resourceName)){
						$('.editSecRes .resourceName').next('.msg-error').show();
						return false;
					}if(T.isEmpty(item.resourceLink)){
						$('.editSecRes .resourceLink').next('.msg-error').show();
						return false;
					}if(T.isEmpty(item.resourceIcon)){
						$('.editSecRes .upLoadImg').next('.msg-error').show();
						return false;
					}else{
						T.post('/s/sys/updateSysResource',_obj,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								$('.rightContentField').load('setResourceDirectory.html');
							}
						});
					}
				})
			}
			}
	app.init();
})