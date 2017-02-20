/*
 *	createTime:2016/11/10
 * 	author	  :LUYI
 * 	
 * 
 */
$(function() {
	var start=1,
		size=5,
		total=0;
	
	$('#draftDataList').css('height',''+size*78+'px');
	
	var postData={//传回后台的参数
			page:start,
			pageSize:size
		}
	
	var projId = "";//修改页面Id
	
	var app = {
			init:function(){
				this.tab();//需求提交、草稿箱切换
				this.getDemType();//初始化需求分类选项
				this.upLoadAttachments();//附件上传
				this.saveDemand();//保存需求
				this.submitDemand();//提交需求
				this.updatedraftContent();//保存草稿箱
				this.submitdraftContent();//发布草稿箱
			},
			
			tab:function(){//需求提交、草稿箱切换
				$('.content2').hide();
				$('.demandSubmit .header div').bind('click',function(){
					if($(this).attr('class')=="drafts"){
						$(this).addClass('active');
						$('.submit').removeClass('active');
						$('.content1').hide();
						$('.content2').show();
						console.log(postData);
						app.getDraftData();
					}else{
						$('.content1 textarea').val("");
						$('.content1 input').each(function(){//清空附件上传
							if($(this).is(':checked')){
								$(this).prop('checked',false);
							}else{
								$(this).val('');
								$(this).siblings('.replace').html('<img src="resources/images/front/upload.png" alt=""> <span>上传</span>');
							}
						});
						$(this).addClass('active');
						$('.drafts').removeClass('active');
						$('.content1').show();
						$('.content2').hide();
					}
					});
				},
				
				getDraftData:function(){//获取草稿箱的数据
					T.post('/s/requirement/selectPrRequirement',postData,function(res){
						console.log(res);
						if (res.retCode=='10000') {
							total=res.retObject.total;
							var draftList=res.retObject.list;
							for(var i=0;i<draftList.length;i++){
								draftList[i].createDatetime=T.dateFormat(new Date(draftList[i].createDatetime),"yyyy-MM-dd");
		        			}
		        			$('#draftDataList').empty();
							$('#demand_draft_template').tmpl(draftList).appendTo('#draftDataList');
							app.draftContent();
							app.draftDel();
							app.page();
						}else {
							
						}
					});
				},
				
				getDemType:function(){//初始化需求分类选项
					T.post('/s/requirement/selectAllRequirementType','',function(res){
						console.log(res);
						if(res.retCode=='10000'){
							demTypeList = res.retObject[0];
//							var obj = res.retObject[0];
//							var html='<option value="" id="">请选择</option>';
//							for (var i = 0; i < obj.dictionarydatas.length; i++) {
//								html+='<option value="'+obj.dictionarydatas[i].dataValue+'"id="'+obj.dictionarydatas[i].dataId+'">'+obj.dictionarydatas[i].dataValue+'</option>';
//							}
							$('#demand_type_template').tmpl(demTypeList).appendTo('#demType');
							$('#demand_type_template').tmpl(demTypeList).appendTo('#draftDemandType');
							}
						})
					},
					
				upLoadAttachments:function(){//附件上传
					$('.upLoadAttachments').unbind().bind('click',function(){
						$(this).fileupload({  
							autoUpload: true,//是否自动上传  
							url: '/s/upload/file',//上传地址  
							done: function (e, data) {//设置文件上传完毕事件的回调函数 
								var result=JSON.parse(data.result);
				        			fileName=result.name;
				        			filePath=result.path;
				        			$(this).siblings('.replace').html('<img data-name="'+fileName+'" class="fileIcon" style="width:auto;height:60px;margin-top:0;" src="'+filePath+'">');
				        			console.log('文件上传成功-----name:'+data.result);
				        			
								}
							}) 
						});
					},
					
				relseAction:function(flag,con){//公共需求保存和提交
					projRequireClassValue = {};
					var arrList =[];
					$('.'+con+' .demandType input').each(function(index, domEle){
   						 if($(this).is(':checked')){
   							arrList.push({"projRequireClassValue" : $(this).attr('data-id')});
//   							projRequireClassValue = arr.join();
   						 }
   					 	});
					
					var provideTypeValue ="";
					var arr =[];
					$('.'+con+' .type1 input').each(function(index, domEle){
   						 if($(this).is(':checked')){
   							 arr.push($(this).attr('data-id'));
   							provideTypeValue = arr.join();
   						 }
   					 	});
					arr = [];
					var authenticationRequirement ="";
					$('.'+con+' .type2 input').each(function(index, domEle){
   						 if($(this).is(':checked')){
   							 arr.push($(this).attr('data-id'));
   							authenticationRequirement = arr.join();
   						 }
   					 	});
					var publishWay ="";
					arr = [];
					$('.'+con+' .type3 input').each(function(index, domEle){
   						 if($(this).is(':checked')){
   							 arr.push($(this).attr('data-id'));
   							publishWay = arr.join();
   						 }
   					 	});
					var data = {
							projAttachFile: $('.'+con+' .uploadBgLeft .replace img').attr('src'),//附件路径
							projFileName: $('.'+con+' .uploadBgLeft .replace img').attr('data-name'),//附件名
							flag: flag,
							projName: $('.'+con+' .demandName input').val(),//需求名称
							projServiceFee: $('.'+con+' .demandFee input').val(),//需求预算
							projCloseDate: $('.'+con+' .applyDate input').val(),//报名截止日期
							projDevlierDate: $('.'+con+' .subDate input').val(),//需求交付日期
							projEstimate: $('.'+con+' .assessTime input').val(),//评估周期
							providerType: provideTypeValue,//供方类型	
						    authenticationRequirement: authenticationRequirement,//认证要求
						    publishWay: publishWay,//发布方式
						    projectRequirementClasss: arrList,
						    projRequireDescriptions: [//需求概述
						                              {
						                            	  "projRequireDescriptionContent": $('.'+con+' .demandDetails textarea').val()
						                            	  }
						                             ]
					}
					console.log(data);
					$('.demandSubmit .promptWords').hide();
					
					if(T.isEmpty(data.projName)){
						$('.'+con+' .demandName .msg-con').html("需求名称不能为空");
						$('.'+con+' .demandName .promptWords').show();
						return false;
					}
					if(data.projName.length>20){
						$('.'+con+' .demandName .msg-con').html("需求名称必须在20字以内");
						$('.'+con+' .demandName .promptWords').show();
						return false;
					}
					if(data.projectRequirementClasss.length<=0){
						$('.'+con+' .demandType .msg-con').html("需求分类不能为空");
						$('.'+con+' .demandType .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projServiceFee)){
						$('.'+con+'  .demandFee .msg-con').html("需求预算不能为空");
						$('.'+con+' .demandFee .promptWords').show();
						return false;
					}
					if(!/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/.test(data.projServiceFee)){
						$('.'+con+' .demandFee .msg-con').html("请输入正确的格式");
						$('.'+con+' .demandFee .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projCloseDate)){
						$('.'+con+' .applyDate .msg-con').html("报名截止不能为空");
						$('.'+con+' .applyDate .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projDevlierDate)){
						$('.'+con+' .subDate .msg-con').html("需求交付日期不能为空");
						$('.'+con+' .subDate .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projEstimate)){
						$('.'+con+' .assessTime .msg-con').html("评估周期不能为空");
						$('.'+con+' .assessTime .promptWords').show();
						return false;
					}
					if(!/^\+?[1-9][0-9]*$/.test(data.projEstimate)){
						$('.'+con+' .assessTime .msg-con').html("请输入正确的格式");
						$('.'+con+' .assessTime .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projRequireDescriptions[0].projRequireDescriptionContent)){
						$('.'+con+' .demandDetails .msg-con').html("需求概述不能为空");
						$('.'+con+' .demandDetails .promptWords').show();
						return false;
					}
					if(data.projRequireDescriptions.length>500){
						$('.'+con+' .demandDetails .msg-con').html("需求名称必须在500字以内");
						$('.'+con+' .demandDetails .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.providerType)){
						$('.'+con+' .type1 .msg-con').html("供方类型不能为空");
						$('.'+con+' .type1 .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.authenticationRequirement)){
						$('.'+con+' .type2 .msg-con').html("认证要求不能为空");
						$('.'+con+' .type2 .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.publishWay)){
						$('.'+con+' .type3 .msg-con').html("发布方式不能为空");
						$('.'+con+' .type3 .promptWords').show();
						return false;
					}
					else{
						T.post('/s/requirement/insertPrRequirement',data,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								$('.demandSubmit .header .drafts').trigger('click',function(){
									app.getDraftData();
								});
							}else{
								$.alert({
								      body: res.retMessage,
								      height: 100
								    });
							}
						})
					}
				},
				
				saveDemand:function(){//保存需求
					$('.demandSubmit .promptWords').hide();
					$('.content1 .buttonType1').unbind().bind('click',function(){
						app.relseAction(0,'content1');
					})
				},
				
				submitDemand:function(){//提交需求
					$('.demandSubmit .promptWords').hide();
					$('.content1 .buttonType2').unbind().bind('click',function(){
						app.relseAction("",'content1');
					})
				},
				
				draftContent:function(){//初始化草稿箱修改页面
					$('.Con2drafts .edit').unbind().bind('click',function(){
						projId = "";
						var o={
								projId:$(this).parent().attr('data-id'),
								page:start,
								pageSize:size
						}
						projId = o.projId;
						T.post('/s/requirement/selectPrRequirementId',o,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								var obj=res.retObject;
								$('.content3 .demandName input').val(obj.projName);//需求名称
							    $('.content3 .demandFee input').val(obj.projServiceFee);//需求预算
							    $('.content3 .applyDate input').val(T.dateFormat(new Date(obj.projCloseDate),"yyyy-MM-dd"));//报名截止日期
							    $('.content3 .subDate input').val(T.dateFormat(new Date(obj.projDevlierDate),"yyyy-MM-dd"));//需求交付日期
							    $('.content3 .assessTime input').val(obj.projEstimate);//评估周期
							    $('.content3 .demandDetails textarea').val(obj.projRequireDescriptions[0].projRequireDescriptionContent);//需求概述
							    
							    var demandType = obj.projectRequirementClasss;
							    $.each(demandType,function(index,arr){
							    	$('.demandType input').each(function(index,ele){
								    	if(arr.projRequireClassValue==$(this).attr('data-id')){
								    		$(this).prop('checked',true);
								    	}
								    });
							    })
							    
							    var type1 = obj.providerType.split(",");
							    $.each(type1,function(index,arr){
							    	$('.type1 input').each(function(index,ele){
								    	if(arr==$(this).attr('data-id')){
								    		$(this).prop('checked',true);
								    	}
								    });
							    })
							    
							    var type2 = obj.authenticationRequirement.split(",");
							    $.each(type2,function(index,arr){
							    	$('.type2 input').each(function(index,ele){
								    	if(arr==$(this).attr('data-id')){
								    		$(this).prop('checked',true);
								    	}
								    });
							    })
							    
							    var type3 = obj.publishWay.split(",");
							    $.each(type3,function(index,arr){
							    	$('.type3 input').each(function(index,ele){
								    	if(arr==$(this).attr('data-id')){
								    		$(this).prop('checked',true);
								    	}
								    });
							    })
								$('#draftContent').modal('show');
							}
						});
					});
				},
				
				draftDel:function(){//删除草稿箱
					$('.del').unbind().bind('click',function(){
						var o={
								'projId':$(this).parent().attr('data-id'),
								page:start,
								pageSize:size
						}
						T.post('/s/requirement/deletePrRequirement',o,function(res){
							if(res.retCode=='10000'){
								app.getDraftData();
								$('#draftContent').modal('hide');
							}else{
								$.alert('删除失败');
							}
						});
					})
				},
				
				draftAction:function(flag,con){//公共草稿箱保存和提交
					projRequireClassValue = {};
					var arrList =[];
					$('.'+con+' .demandType input').each(function(index, domEle){
   						 if($(this).is(':checked')){
   							arrList.push({"projRequireClassValue" : $(this).attr('data-id')});
//   							projRequireClassValue = arr.join();
   						 }
   					 	});
					
					var provideTypeValue ="";
					var arr =[];
					$('.'+con+' .type1 input').each(function(index, domEle){
   						 if($(this).is(':checked')){
   							 arr.push($(this).attr('data-id'));
   							provideTypeValue = arr.join();
   						 }
   					 	});
					arr = [];
					var authenticationRequirement ="";
					$('.'+con+' .type2 input').each(function(index, domEle){
   						 if($(this).is(':checked')){
   							 arr.push($(this).attr('data-id'));
   							authenticationRequirement = arr.join();
   						 }
   					 	});
					var publishWay ="";
					arr = [];
					$('.'+con+' .type3 input').each(function(index, domEle){
   						 if($(this).is(':checked')){
   							 arr.push($(this).attr('data-id'));
   							publishWay = arr.join();
   						 }
   					 	});
					var data = {
							'projId':projId,
							"flag": flag,
							'projName' : $('.'+con+' .demandName input').val(),//需求名称
							'projServiceFee' : $('.'+con+' .demandFee input').val(),//需求预算
							'projCloseDate' :$('.'+con+' .applyDate input').val(),//报名截止日期
							'projDevlierDate' :$('.'+con+' .subDate input').val(),//需求交付日期
							'projEstimate' : $('.'+con+' .assessTime input').val(),//评估周期
							'providerType' : provideTypeValue,//供方类型	
						    "authenticationRequirement" :authenticationRequirement,//认证要求
						    "publishWay" :publishWay,//发布方式
						    "projectRequirementClasss": arrList,
						     "projRequireDescriptions": [//需求概述
						                                 {
//						                                     "projRequireId": 2,
						                                     "projRequireDescriptionContent": $('.'+con+' .demandDetails textarea').val()
						                                 }
						                             ]
					}
					console.log(data);
					$('.demandSubmit .promptWords').hide();
					
					if(T.isEmpty(data.projName)){
						$('.'+con+' .demandName .msg-con').html("需求名称不能为空");
						$('.'+con+' .demandName .promptWords').show();
						return false;
					}
					if(data.projName.length>20){
						$('.'+con+' .demandName .msg-con').html("需求名称必须在20字以内");
						$('.'+con+' .demandName .promptWords').show();
						return false;
					}
					if(data.projectRequirementClasss.length<=0){
						$('.'+con+' .demandType .msg-con').html("需求分类不能为空");
						$('.'+con+' .demandType .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projServiceFee)){
						$('.'+con+'  .demandFee .msg-con').html("需求预算不能为空");
						$('.'+con+' .demandFee .promptWords').show();
						return false;
					}
					if(!/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/.test(data.projServiceFee)){
						$('.'+con+' .demandFee .msg-con').html("请输入正确的格式");
						$('.'+con+' .demandFee .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projCloseDate)){
						$('.'+con+' .applyDate .msg-con').html("报名截止不能为空");
						$('.'+con+' .applyDate .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projDevlierDate)){
						$('.'+con+' .subDate .msg-con').html("需求交付日期不能为空");
						$('.'+con+' .subDate .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projEstimate)){
						$('.'+con+' .assessTime .msg-con').html("评估周期不能为空");
						$('.'+con+' .assessTime .promptWords').show();
						return false;
					}
					if(!/^\+?[1-9][0-9]*$/.test(data.projEstimate)){
						$('.'+con+' .assessTime .msg-con').html("请输入正确的格式");
						$('.'+con+' .assessTime .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.projRequireDescriptions[0].projRequireDescriptionContent)){
						$('.'+con+' .demandDetails .msg-con').html("需求概述不能为空");
						$('.'+con+' .demandDetails .promptWords').show();
						return false;
					}
					if(data.projRequireDescriptions.length>500){
						$('.'+con+' .demandDetails .msg-con').html("需求名称必须在500字以内");
						$('.'+con+' .demandDetails .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.providerType)){
						$('.'+con+' .type1 .msg-con').html("供方类型不能为空");
						$('.'+con+' .type1 .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.authenticationRequirement)){
						$('.'+con+' .type2 .msg-con').html("认证要求不能为空");
						$('.'+con+' .type2 .promptWords').show();
						return false;
					}
					if(T.isEmpty(data.publishWay)){
						$('.'+con+' .type3 .msg-con').html("发布方式不能为空");
						$('.'+con+' .type3 .promptWords').show();
						return false;
					}
					else{
						T.post('/s/requirement/insertPrRequirement',data,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								T.post('/s/requirement/selectPrRequirement',postData,function(res){
									app.getDraftData();
									$('#draftContent').modal('hide');});
							}else{
								$.alert({
								      body: res.retMessage,
								      height: 100
								    });
							}
						})
					}
				},
				
				updatedraftContent:function(){//保存草稿箱
					$('.demandSubmit .promptWords').hide();
					$('.draftUpdate .save').unbind().bind('click',function(){
						app.draftAction(0,'content3');
					})
				},
				
				submitdraftContent:function(){//发布草稿箱
					$('.demandSubmit .promptWords').hide();
					$('.draftUpdate .submit').unbind().bind('click',function(){
						app.draftAction("",'content3');
					})
				},
				
				page:function(){//分页器
					$('#paginator').smartpaginator({
						totalrecords :total,
						recordsperpage :size,
						onchange : function(newPage) {
						T.post('/s/requirement/selectPrRequirement',{page:newPage,pageSize:size},function(res){
							if(res.retCode=='10000'){
								var draftList=res.retObject.list;
								for(var i=0;i<draftList.length;i++){
									draftList[i].createDatetime=T.dateFormat(new Date(draftList[i].createDatetime),"yyyy-MM-dd");
			        			}
			        			$('#draftDataList').empty();
								$('#demand_draft_template').tmpl(draftList).appendTo('#draftDataList');
								app.draftContent();
								app.draftDel();
							}
						});
						}
					});
				}
			}
	app.init();
})