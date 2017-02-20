/*
 *	createTime:2016/11/18
 * 	author	  :Tangj
 * 	
 * 
 */
$(function(){
	
	var app={
			
			init:function(){
				this.initDemandType();
				this.upload();
				this.refer();
				this.save();
			},
			initDemandType:function(){//获取所有需求类型
				T.post('/s/requirement/selectAllRequirementType','',function(res){
					console.log(res);
					if(res.retCode=='10000'){
						$('.demandStatusEdit .dictionarydatas').empty();
						$('#status_edit_tmplate')
							.tmpl(res.retObject[0].dictionarydatas)
								.appendTo('.demandStatusEdit .dictionarydatas');
								app.getChooseData();
					}
				})
			},
			getChooseData:function(){//获取已经选择的复选框
				T.post('/s/requirement/selectPrRequirementId',
						{'projId':sessionStorage.getItem('id')},function(res){
					console.log(res);
					if(res.retCode="10000"){
						var obj=res.retObject;
						//需求类型已选
						$.each(obj.projectRequirementClasss,function(i,o){
							$('.demandStatusEdit .dictionarydatas input').each(function(j,k){
								if(o.projRequireClassValue==$(this).val()){
									$(this).prop('checked',true);
								}
							});
						})
						//认证 发布已选
						if(obj.providerType.indexOf('1')>-1){
							$('.demandStatusEdit .providerType [data-id="1"]').prop('checked',true)
						}if(obj.providerType.indexOf('2')>-1){
							$('.demandStatusEdit .providerType [data-id="2"]').prop('checked',true)
						}if(obj.authenticationRequirement.indexOf('1')>-1){
							$('.demandStatusEdit .authenticationRequirement [data-id="1"]').prop('checked',true)
						}if(obj.authenticationRequirement.indexOf('2')>-1){
							$('.demandStatusEdit .authenticationRequirement [data-id="2"]').prop('checked',true)
						}if(obj.authenticationRequirement.indexOf('3')>-1){
							$('.demandStatusEdit .authenticationRequirement [data-id="3"]').prop('checked',true)
						}if(obj.publishWay.indexOf('1')>-1){
							$('.demandStatusEdit .publishWay [data-id="1"]').prop('checked',true)
						}if(obj.publishWay.indexOf('2')>-1){
							$('.demandStatusEdit .publishWay [data-id="2"]').prop('checked',true)
						}if(obj.publishWay.indexOf('3')>-1){
							$('.demandStatusEdit .publishWay [data-id="3"]').prop('checked',true)
						}
						
						
						//可填数据初始化
						obj.projRequireDescriptionContent=obj.projRequireDescriptions[0].projRequireDescriptionContent;
						obj.projCloseDate	=	T.dateFormat(new Date(obj.projCloseDate),'yyyy-MM-dd');
						obj.projDevlierDate	=	T.dateFormat(new Date(obj.projDevlierDate),'yyyy-MM-dd');
						obj.projServiceFee	=	T.fmtNumber(obj.projServiceFee,'#,###.##');
						
						$('.demandStatusEdit .projName input').val(obj.projName);
						$('.demandStatusEdit .projServiceFee input').val(obj.projServiceFee);
						$('.demandStatusEdit .projCloseDate input').val(obj.projCloseDate);
						$('.demandStatusEdit .projDevlierDate input').val(obj.projDevlierDate);
						$('.demandStatusEdit .projEstimate input').val(obj.projEstimate);
						$('.demandStatusEdit .projRequireDescriptionContent textarea').val(obj.projRequireDescriptionContent);
					}
				})
			},
			upload:function(){
				$('.uploadAgain').unbind().bind('click',function(){
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址  
				        done: function (e, data) {//设置文件上传完毕事件的回调函数 
				        	var result=JSON.parse(data.result);
				        	imageName=result.name;
				        	path=result.path;
				        	$('.uploadAgain img').attr({'src':path,'data-name':imageName});
				            console.log('文件上传成功-----name:'+data.result);
				           
				        }
				    }) 
				});
				
			},
			refer:function(){//需求提交
				$('.demandStatusEdit .refer').bind('click',function(){
					app.postData('');
				});
			},
			save:function(){//需求保存
				$('.demandStatusEdit .save').bind('click',function(){
					app.postData(0);
				});
			},
			postData:function(flag){
				var projectRequirementClasss='',//需求分类
					providerType='',//供方类型
					authenticationRequirement='',//认证要求
					publishWay='',//发布方式
					arr=[];//中间变量
					
					//需求分类
					$('.demandStatusEdit  .dictionarydatas input').each(function(i,o){
						if($(this).is(':checked')){
							arr.push({'projRequireClassValue':$(this).val()});
						}
					});
					projectRequirementClasss=arr;
					//供方类型
					arr=[]
					$('.demandStatusEdit  .providerType input').each(function(i,o){
						if($(this).is(':checked')){
							arr.push($(this).attr('data-id'));
						}
					});
					providerType=arr.join()
					
					//认证要求
					arr=[]
					$('.demandStatusEdit  .authenticationRequirement input').each(function(i,o){
						if($(this).is(':checked')){
							arr.push($(this).attr('data-id'));
						}
					});
					authenticationRequirement=arr.join()
					
					//发布方式
					arr=[]
					$('.demandStatusEdit  .publishWay input').each(function(i,o){
						if($(this).is(':checked')){
							arr.push($(this).attr('data-id'));
						}
					});
					publishWay=arr.join()
				var errMsg='';
				var errHtm1='<div class="sui-msg msg-error promptWords"><div class="msg-con">';
				var errHtm2='</div><s class="msg-icon"></s></div>';
				var errHtml='';
				var data = {
							"flag": flag,
							"projAttachFile": $('.demandStatusEdit  .uploadAgain img').attr('src'),
						    "projFileName":$('.demandStatusEdit  .uploadAgain img').attr('data-name'),
							'projName' : $('.demandStatusEdit .projName input').val(),//需求名称
							'projServiceFee' : $('.demandStatusEdit .projServiceFee input').val(),//需求预算
							'projCloseDate' :$('.demandStatusEdit .projCloseDate input').val(),//报名截止日期
							'projDevlierDate' :$('.demandStatusEdit .projDevlierDate input').val(),//需求交付日期
							'projEstimate' : $('.demandStatusEdit .projEstimate input').val(),//评估周期
							'providerType' : providerType,//供方类型	
						    "authenticationRequirement" :authenticationRequirement,//认证要求
						    "publishWay" :publishWay,//发布方式
						    "projectRequirementClasss": projectRequirementClasss,//需求分类
						     "projRequireDescriptions": [//需求概述
						                                 {
						                                     "projRequireDescriptionContent": $('.demandStatusEdit .projRequireDescriptionContent textarea').val()
						                                 }
						                             ]
							}
						
						$('.demandStatusEdit .sui-msg').remove();
					if(T.isEmpty(data.projName)){
						errMsg='请填写需求名称';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .projName');
						return false;
					}if(T.isEmpty(data.projectRequirementClasss)){
						errMsg='请选择需求分类';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .projectRequirementClasss');
						return false;
					}if(T.isEmpty(data.projServiceFee)){
						errMsg='请填写需求预算';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .projServiceFee');
						return false;
					}if(!/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/.test(data.projServiceFee)){
						errMsg='需求预算格式填写不正确';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .projServiceFee');
						return false;
					}if(T.isEmpty(data.projCloseDate)){
						errMsg='请填写报名截止日期';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .projCloseDate');
						return false;
					}if(T.isEmpty(data.projDevlierDate)){
						errMsg='请填写需求交付日期';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .projDevlierDate');
						return false;
					}if(T.isEmpty(data.projEstimate)){
						errMsg='请填写评估周期';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .projEstimate');
						return false;
					}if(T.isEmpty(data.projRequireDescriptions[0].projRequireDescriptionContent)){
						errMsg='请填写需求概述';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .projRequireDescriptionContent');
						return false;
					}if(T.isEmpty(data.providerType)){
						errMsg='请选择供方类型';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .providerType');
						return false;
					}if(T.isEmpty(data.authenticationRequirement)){
						errMsg='请选择认证要求';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .authenticationRequirement');
						return false;
					}if(T.isEmpty(data.publishWay)){
						errMsg='请选择选择发布方式';
						errHtml=errHtm1+errMsg+errHtm2;
						$(errHtml).insertAfter('.demandStatusEdit .publishWay');
						return false;
					}else{
						T.post('/s/requirement/insertPrRequirement',data,function(res){
								if(res.retCode=='10000'){
									$('.rightContentField').load('resources/html/front/demandStatus.html');
								}
						})
					}
			}
			
			
	}
	app.init();
})