/*
 *	createTime:2016/10/20
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var imageName='';
	var creativeResourceClassifierList=[];//存放资源类型字符串
	var inspectFlag=false;//必填项校验标志
	var total=0,
		size=5;
	$('.draftList').css('height',''+size*78+'px');
	var creativeResourceId='';
	var app={
			init:function(){
				$('.msg-error').hide();
				this.getResType();//初始化资源类型选项
				this.checkResType();
				this.upLoadImg();
				this.releaSave();
				this.releaSubMit();
				this.draftSave();
				this.draftSubmit();
				this.tab();
				this.draftDetail();
				this.draftDel();
			},
			
			
			
			getResType:function(){
				T.post('/s/creativeResource/selectCreativeResourceType','',function(res){
					if(res.retCode=='10000'){
						$('#res_restype_template').tmpl(res.retObject).appendTo('#resReleaseModal .modal-body');
						$('#res_restype_template').tmpl(res.retObject).appendTo('#draftDetailRestype .modal-body');
					}else{
						
					}
				});
			},
			
			
			
			checkResType:function(){
				//全选/取消全选  发布
				$('#resReleaseModal .checkAll').bind('click',function(res){
					if($(this).attr('data-stus')=='one'){
						$(this).attr('data-stus','all');
						$(this).html('取消全选');
						$('#resReleaseModal .checkItem input').prop("checked", true);
					}else{
						$(this).attr('data-stus','one');
						$(this).html('全选');
						$('#resReleaseModal .checkItem input').prop("checked", false)
					}
				});

			//全选/取消全选  修改草稿
			$('#draftDetailRestype .checkAll').bind('click',function(res){
					if($(this).attr('data-stus')=='one'){
						$(this).attr('data-stus','all');
						$(this).html('取消全选');
						$('#draftDetailRestype .checkItem input').prop("checked", true);
					}else{
						$(this).attr('data-stus','one');
						$(this).html('全选');
						$('#draftDetailRestype .checkItem input').prop("checked", false)
					}
				});	
			},
			
			
			
			upLoadImg:function(){
				$(document).off('click','.upLoadImg').on('click','.upLoadImg',function(){
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址
				        done: function (e, data) {//设置文件上传完毕事件的回调函数  
				        	var result=JSON.parse(data.result);
					        	imageName=result.name;
					        	path=result.path;
					        	$(this).siblings('.up').html('<img data-name="'+imageName+'" class="resourceIcon" style="width:auto;height:60px;margin-top:0;" src="'+path+'">');
					            console.log('文件上传成功-----name:'+data.result);
				        }
				    }) 
				});
			},
			relseAction:function(flag,con){
				creativeResourceClassifierList=[];
				$('#resReleaseModal .checkItem input').each(function(index,dom){
					if($(this).is(':checked')){
						creativeResourceClassifierList.push({'classifierValue':$(this).attr('data-id')});
					}
				});
				
				var obj={
						 "flg": flag,
						'creativeResourceClassifierList':creativeResourceClassifierList,
						"creativeResource":{
							 	"resourceName": $('.'+con+' .resourceName').val(),
							    "resourceImage": $('.'+con+' .resourceIcon').attr('src'),
							    "resourceImageName":$('.'+con+' .resourceIcon').attr('data-name'),
							    "resourceNumber": $('.'+con+' .resourceNumber').val(),
							    "resourceDescription": $('.'+con+' .resourceDescription').val(),
							    "showAddress": $('.'+con+' .showAddress').val(),
							    "resourcePrice": $('.'+con+' .resourcePrice').val()
							   

						}
						
					}
				
				$('.msg-error').hide();
				if(T.isEmpty(obj.creativeResource.resourceImage)){
					$('.'+con+' .upLoadImg').next('.msg-error').show();
					return false;
				}
				if(T.isEmpty(obj.creativeResource.resourceName)){
					$('.'+con+' .resourceName').next('.msg-error').show();
					return false;
				}if(obj.creativeResourceClassifierList.length<=0){
					$('.'+con+' .resourceType').next('.msg-error').show();
					return false;
				}if(T.isEmpty(obj.creativeResource.resourceNumber)){
					$('.'+con+' .resourceNumber').next('.msg-error').show();
					return false;
				}if(!/^\+?[1-9][0-9]*$/.test(obj.creativeResource.resourceNumber)){
					$('.'+con+' .resourceNumber').next('.msg-error').show();
					return false;
				}if(T.isEmpty(obj.creativeResource.resourcePrice)){
					$('.'+con+' .resourcePrice').next('.msg-error').show();
					return false;
				}if(!/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/.test(obj.creativeResource.resourcePrice)){
					$('.'+con+' .resourcePrice').next('.msg-error').show();
					return false;
				}if(T.isEmpty(obj.creativeResource.resourceDescription)){
					$('.'+con+' .resourceDescription').next('.msg-error').show();
					return false;
				}if(obj.creativeResource.resourceDescription.length>500){
					$('.'+con+' .resourceDescription').next('.msg-error').show();
					return false;
				}else{
					T.post('/s/creativeResource/insertCreativeResource',obj,function(res){
						if(res.retCode=='10000'){
							if(flag=='401201'){
								$('.resoureRelease .drafts').trigger('click');
							}else{
								$('.rightContentField').load('resources/html/front/resourceWarehouse.html',function(){
									$('.borderInves [data-attr="reviewIng"]').trigger('click');
								});
							}
							
						}else{
							$.alert(res.retMessage);
						}
					});
					
				}
			},
			
			
			
			releaSave:function(){//保存草稿
				$('.content1 .save').bind('click',function(){
					app.relseAction(401201,'content1');
				});
				
			},
			
			
			
			releaSubMit:function(){//发布
				$('.content1 .submit').bind('click',function(){
					app.relseAction(401202,'content1');
				});
				
			},
			
			draftAction:function(flag,con){
				creativeResourceClassifierList=[];
				$('#draftDetailRestype .checkItem input').each(function(index,dom){
					if($(this).is(':checked')){
						creativeResourceClassifierList.push({'classifierValue':$(this).attr('data-id')});
					}
				});
				
				var obj={
						 "flg": flag,
						'creativeResourceClassifierList':creativeResourceClassifierList,
						"creativeResource":{
							 	"resourceName": $('.'+con+' .resourceName').val(),
							    "resourceImage": $('.'+con+' .resourceIcon').attr('data-name'),
							    "resourceImageName": imageName,
							    "resourceNumber": $('.'+con+' .resourceNumber').val(),
							    "resourceDescription": $('.'+con+' .resourceDescription').val(),
							    "showAddress": $('.'+con+' .showAddress').val(),
							    "resourcePrice": $('.'+con+' .resourcePrice').val(),
							    "creativeResourceId":creativeResourceId

						}
						
					}
				console.log(obj);
				$('.msg-error').hide();
				if(T.isEmpty(obj.creativeResource.resourceImage)){
					$('.'+con+' .upLoadImg').next('.msg-error').show();
					return false;
				}
				if(T.isEmpty(obj.creativeResource.resourceName)){
					$('.'+con+' .resourceName').next('.msg-error').show();
					return false;
				}if(obj.creativeResourceClassifierList.length<=0){
					$('.'+con+' .resourceType').next('.msg-error').show();
					return false;
				}if(T.isEmpty(obj.creativeResource.resourceNumber)){
					$('.'+con+' .resourceNumber').next('.msg-error').show();
					return false;
				}if(!/^\+?[1-9][0-9]*$/.test(obj.creativeResource.resourceNumber)){
					$('.'+con+' .resourceNumber').next('.msg-error').show();
					return false;
				}if(T.isEmpty(obj.creativeResource.resourcePrice)){
					$('.'+con+' .resourcePrice').next('.msg-error').show();
					return false;
				}if(!/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/.test(obj.creativeResource.resourcePrice)){
					$('.'+con+' .resourcePrice').next('.msg-error').show();
					return false;
				}if(T.isEmpty(obj.creativeResource.resourceDescription)){
					$('.'+con+' .resourceDescription').next('.msg-error').show();
					return false;
				}if(obj.creativeResource.resourceDescription.length>500){
					$('.'+con+' .resourceDescription').next('.msg-error').show();
					return false;
				}else{
					T.post('/s/creativeResource/updateCreativeResource',obj,function(res){
						if(res.retCode=='10000'){
							T.post('/s/creativeResource/selectAllCreativeResource',
									{"resourceStatus":401201,page:1,pageSize:size},
									function(res){
								if(res.retCode=='10000'){
									app.appendDetailList(res);
									app.page();
									$('#draftDetail').modal('hide');
								}
							});
							
						}else{
							$.alert('保存失败');
						}
					});
				}
			},
			
			draftSave:function(){
				$('.content3 .save').bind('click',function(){
					app.draftAction(401201,'content3');
				});
			},
			
			draftSubmit:function(){
				$('.content3 .submit').bind('click',function(){
					app.draftAction(401202,'content3');
				});
			},
			
			tab:function(){//草稿箱 发布切换
				$('.content3').hide();

				$('.resoureRelease .header div').bind('click',function(){
					//页面填写信息初始化
					$('input').each(function(){
						if($(this).is(':checked')){
							$(this).prop('checked',false);
						}else{
							$(this).val('');
						}
					});
					$('label .up').html('');
					$('#resReleaseModal .checkItem input').prop("checked", false);
					$('#draftDetailRestype .checkItem input').prop("checked", false);
					$('#resReleaseModal .checkAll').attr('data-stus','one');
					$('#resReleaseModal .checkAll').html('全选');
					$('#draftDetailRestype .checkAll').attr('data-stus','one');
					$('#draftDetailRestype .checkAll').html('全选');
					
					if($(this).attr('class')=="drafts"){
						$(this).addClass('active');
						$('.refer').removeClass('active');
						$('.content1').hide();
						$('.content3').show();
						
						T.post('/s/creativeResource/selectAllCreativeResource',
								{"resourceStatus":401201,page:1,pageSize:size},
								function(res){
							if(res.retCode=='10000'){
								app.appendDetailList(res);
								app.page();
							}
						});
					}else{
						$(this).addClass('active');
						$('.drafts').removeClass('active');
						$('.content1').show();
						$('.content3').hide();
					}
				});
			},
			
			
			
			page:function(){
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
					T.post('/s/creativeResource/selectAllCreativeResource',
							{"resourceStatus":401201,page:newPage,pageSize:size},function(res){
						if(res.retCode=='10000'){
							app.appendDetailList(res);
						}
					});
					}
				});
			},
			
			
			appendDetailList:function(res){
				var obj=res.retObject.list;
				total=res.retObject.total;
				$('.draftList .draftItem').remove();
				var html='';
				for(var i=0;i<obj.length;i++){
					var o=obj[i];
					html+='<div class="draftItem">';
					html+='<div class="draftTitle">';
					html+='<div class="draftTime">'+T.dateFormat(new Date(o.publishDatetime),'yyyy-MM-dd hh:mm:ss')+'</div>';
					html+='<div class="draftClose"></div>';
					html+='</div>';
					html+='<div class="draftContent">';
					html+='<div class="name">'+o.resourceName+'</div>';
					html+='<div class="value">'+o.resourceDescription+'</div>';
					html+='<div class="handle" data-id="'+o.creativeResourceId+'"><span data-toggle="modal"  data-keyboard="false" class="edit">修改</span><span class="del">删除</span></div>';
					html+='</div>';
	        		html+='</div>';
				}
				$('.draftList').append(html);
				app.draftDetail();
				app.draftDel();
			},
			
			
			
			draftDetail:function(){//data-target="#draftDetail"
				$('.resoureRelease .draftList .edit').bind('click',function(){
					
					var o={
							'creativeResourceId':$(this).parent().attr('data-id')
					}
					creativeResourceId=o.creativeResourceId;
					T.post('/s/creativeResource/selectCreativeResource',o,function(res){
						if(res.retCode=='10000'){
							var obj=res.retObject;
							$('.content2 .resourceName').val(obj.resourceName);
							$('.content2 .upLoadImg').siblings('.up').html('<img data-name="'+obj.resourceImageName+'" class="resourceIcon" style="width:auto;height:60px;margin-top:0;" src="'+obj.resourceImage+'">');
						    $('.content2  .resourceNumber').val(obj.resourceNumber);
						    $('.content2  .resourceDescription').val(obj.resourceDescription);
						    $('.content2  .showAddress').val(obj.showAddress);
						    $('.content2  .resourcePrice').val(obj.resourcePrice);
							
						    T.post('/s/creativeResource/selectAllCreativeResourceClassifier',o,function(res){//查询用户 已选的资源类型 并且初始化
								console.log(res);
								if(res.retCode="10000"){
									var obj=res.retObject;
									for(var i=0;i<obj.length;i++){
										for(j in obj[i]["dictionarydataList"]){
											$('#draftDetailRestype .checkItem input[data-id="'+obj[i]["dictionarydataList"][j].dataId+'"]').prop("checked", true);
										}
									}
									$('#draftDetail').modal('show');
								}
							});
						}
					});
				});
				
			},
			draftDel:function(){
				$('.resoureRelease .draftList .del').bind('click',function(){
					T.post('/s/creativeResource/updateCreativeResourceFalseDel',{'creativeResourceId':$(this).parent().attr('data-id')},function(res){
						if(res.retCode=='10000'){
							T.post('/s/creativeResource/selectAllCreativeResource',
									{"resourceStatus":401201,page:1,pageSize:size},
									function(res){
								if(res.retCode=='10000'){
									app.appendDetailList(res);
									app.page();
									$('#draftDetail').modal('hide');
								}
							});
							
						}else{
							$.alert('删除失败');
						}
					});
				})
			}
	}
	app.init();
})