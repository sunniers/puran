/*
 *	createTime:2016/11/1
 * 	author	  :luyi
 * 	
 * 
 */
$(function() {
	var companyId = '';
	var invest={
			'investCompanyId':'',
			'investCompanyName':'',
			'createTime':'',
			'investDomains':[],
			'investPreferences':[],
			'investCase':''
		};
	
	var app = new Object();
		app = {
		init : function() {
			this.getUserData();
			this.submit();
			this.getFieldPreferData();
		},
		getUserData:function(){
			T.get('s/perfectInformation/selectUserInfo','',function(res){
				if(res.retCode=='10000'){
					companyId = res.retObject.companyId
					$('.enterpriseInformation .userName').html(res.retObject.userName);
					$('#companyName').html(res.retObject.companyName);
					$('#legalPerson').html(res.retObject.companyCorporation);
					$('#organizatioCode').html(res.retObject.organizationalInstitutionCode);
					$('#companyType').val(res.retObject.companyType);
					$('#companyIndustry').val(res.retObject.companyTrade);
					$('#companyTel').val(res.retObject.companyPhone);
					$('#companyAddress').val(res.retObject.companyAddress);
					$('#companyIntroduce').val(res.retObject.companyIntroduce);
				}
			})
		},
		submit:function(){
			$('#save').unbind().bind('click',function(){
					var data={
							'companyId' :companyId,
							'companyType' :$('#companyType').val(),
							'companyTrade' :$('#companyIndustry').val(),
							'companyPhone' :$('#companyTel').val(),
							'companyAddress' :$('#companyAddress').val(),
							'companyIntroduce' :$('#companyIntroduce').val()
					};
					T.post('/s/perfectInformation/updateCompanyInfo',data,function(res){
						if(res.retCode=='10000'){
							var con = confirm('修改成功！'); //弹出框
							 if (con) {
								 $('.rightContentField')
									.load('../resources/html/front/myAccount.html')
							 }
						}
					});
			});
		},
		getFieldPreferData:function(){//生成投资机构-领域 偏好 选项
			T.get('/s/perfectInformation/selectInvestPreferences','',function(res){
				if(res.retCode=='10000'){
					var obj=res.retObject;
					$('.prefer .preferContent').empty();
					$('#enterprise_prefer_template').tmpl(obj[0].dictionarydatas).appendTo('.prefer .preferContent');
					$('.filed .filedContent').empty();
					$('#enterprise_filed_template').tmpl(obj[1].dictionarydatas).appendTo('.filed .filedContent');
					app.getPubData();
				}else{
					
				}
			});
		},
		getPubData:function(){//获取投资机构数据
			T.get('/s/perfectInformation/selectInvestCompanys','',function(res){
				console.log(res);
				if(res.retCode=='10000'){
					app.initPubData(res.retObject);
				}else{
					
				}
			});
		},
		initPubData:function(obj){//初始化投资机构
			invest.investCompanyId=obj.investCompanyId;
			
			$('.pubBody .name input').val(obj.investCompanyName);//初始化投资机构名称
			
			$('.pubBody .creatTime input').val(T.dateFormat(new Date(obj.createTime),'yyyy-MM-dd'));//初始化成立日期
			
			$('.pubBody .synopsis textarea').val(obj.investCase);//初始化简介
			
			$.each(obj.investDomains,function(num,obj){//初始化投资领域
				$('.filed .filedContent input').each(function(index,dom){
					if(obj.investDomainValue==$(this).attr('data-id')){
						$(this).prop('checked',true);
					}
				});
			});
			
			$.each(obj.investPreferences,function(num,obj){//初始化投资偏好
				$('.prefer .preferContent input').each(function(index,dom){
					if(obj.investPreferenceValueId==$(this).attr('data-id')){
						$(this).prop('checked',true);
					}
				});
			});
			app.publish();
		},
		publish:function(){
			$('.pubBody .save').bind('click',function(){
				var flag=true;
				invest.investCompanyName=$('.pubBody .name input').val();
				invest.createTime=$('.pubBody .creatTime input').val();
				invest.investCase=$('.pubBody .synopsis textarea').val();
				$('.prefer .preferContent input').each(function(){
					if($(this).is(':checked')){
						invest.investPreferences.push({'investPreferenceValueId':$(this).attr('data-id')});
					}
				});
				$('.filed .filedContent input').each(function(){
					if($(this).is(':checked')){
						invest.investDomains.push({'investDomainValue':$(this).attr('data-id')});
					}
				});
				$.each(invest,function(index,ele){
					if(T.isEmpty(ele)){
						$.alert('请完善投资机构信息');
						flag=false;
						return false;
					}
				})
				if(flag){
					T.post('/s/perfectInformation/insertInvestCompany',invest,function(res){
						console.log(res);
					});
				}
				
			});
		}
	}
	app.init();
})
