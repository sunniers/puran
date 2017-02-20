/*
 *	createTime:2016/10/24 
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){

	
	var app={
			init:function(){
				this.switchover();
				this.firSecAdd();
				this.secUndo();
				this.upload();
				this.firSecSubmit();
				this.secSubmit();
			},
			switchover:function(){
				$('#addResDic select').change(function(){
					
					if($(this).val()=='1'){
						// 新增一级二级目录
						$('.firstRes').show();
						$('.secondRes').hide();
					}else{
						// 直接新增二级目录
						$('.firstRes').hide();
						$('.secondRes').show();
						T.post('/s/sys/selectFirstResource',{'resourceType':null},function(res){
							if(res.retCode=='10000'){
								$('#allFirMenu ul li:not(".group-title")').remove();
								$('#search_firRes_perception_template').tmpl(res.retObject).insertAfter('#allFirMenu ul .peception');
								$('#search_firRes_back_template').tmpl(res.retObject).insertAfter('#allFirMenu ul .back');
							}
						});
					}
					
				})
			},
			firSecAdd:function(){ //在一级目录下新增二级目录模板添加
				$('#firSecBtn').unbind().bind('click',function(){
					var tmpl=$("#addRes_template").html();
					$(tmpl).insertBefore($(this));
				});
			}
			,
			secUndo:function(){ //撤销新增二级目录
				$(document).off('click','.undo').on('click','.undo',function(){
					$(this).parents('.item').remove();
				});
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
			firSecSubmit:function(){//一级二级新增提交
				$('.firstRes .submitBtn').unbind().bind('click',function(){
					var flag=true;
					var obj={// 一级资源目录
							'resourceType':$('.resourceType :checked').val(),
							'sortedField' :$('.addFirRes .sortedField').val(),
							'resourceName' :$('.addFirRes .resourceName').val(),
							'resourceLink' :$('.addFirRes .resourceLink').val(),
							'resourceIcon' :$('.addFirRes .resourceIcon').attr('src'),
							'sysResources':[]
							
						}
					$('.msg-error').hide();
					if(T.isEmpty(obj.resourceName)){
						$('.addFirRes .resourceName').next('.msg-error').show();
						return false;
					}if(T.isEmpty(obj.resourceLink)){
						$('.addFirRes .resourceLink').next('.msg-error').show();
						return false;
					}if(T.isEmpty(obj.resourceIcon)){
						$('.addFirRes .upLoadImg').next('.msg-error').show();
						return false;
					}
					
					$('.addSecRes .item').each(function(index,ele){
						var item={
								'resourceType':$('.resourceType :checked').val(),
								'sortedField' :$(this).find('.sortedField').val(),
								'resourceName' :$(this).find('.resourceName').val(),
								'resourceLink' :$(this).find('.resourceLink').val(),
								'resourceIcon' :$(this).find('.resourceIcon').attr('src')
							}
						if(T.isEmpty(item.resourceName)){
							flag=false;
							$(this).find('.resourceName').next('.msg-error').show();
							return false;
						}
						if(T.isEmpty(item.resourceLink)){
							flag=false;
							$(this).find('.resourceLink').next('.msg-error').show();
							return false;
						}if(T.isEmpty(item.resourceIcon)){
							flag=false;
							$(this).find('.upLoadImg').next('.msg-error').show();
							return false;
						}else{
							flag=true;
							obj.sysResources.push(item);
						}
						
					});
					if(flag){
						T.post('/s/sys/insertSysResource',obj,function(res){
							if(res.retCode='10000'){
								$('.rightContentField').load('setResourceDirectory.html')
							}
						});
					}
					
					
				});
				
				
			},
			secSubmit:function(){//单独二级目录提交
				$('.secondRes .submitBtn').unbind().bind('click',function(){
					 var obj={// 一级资源目录
							'resourceId'  :$('.secondRes ul li.active').attr('data-id'),
							'sysResources':[]
							
						};
					 var item=
		                {
			                	'resourceType':$('.secondRes ul li.active').attr('data-type'),
								'sortedField' :$('.secondRes .sortedField').val(),
								'resourceName' :$('.secondRes .resourceName').val(),
								'resourceLink' :$('.secondRes .resourceLink').val(),
								'resourceIcon' :$('.secondRes .resourceIcon').attr('src')
			             };
					 
					 $('.secondRes .msg-error').hide();
					 if(T.isEmpty(obj.resourceId)){
						 $('.secondRes .select').next('.msg-error').show();
						 return false;
					 }
					 if(T.isEmpty(item.resourceName)){
						 $('.secondRes .resourceName').next('.msg-error').show();
						 return false;
					 }
					 if(T.isEmpty(item.resourceLink)){
						 $('.secondRes .resourceLink').next('.msg-error').show();
						 return false;
					 }
					 if(T.isEmpty(item.resourceIcon)){
						 $('.secondRes .upLoadImg').next('.msg-error').show();
						 return false;
					 }else{
						 obj.sysResources.push(item);
						 T.post('/s/sys/insertSysResource',obj,function(res){
								if(res.retCode='10000'){
									$('.rightContentField').load('setResourceDirectory.html')
								}
						});
					 }
				})
			}
			
	}
	app.init();
})