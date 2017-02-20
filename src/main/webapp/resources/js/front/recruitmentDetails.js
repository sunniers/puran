/*
 *	createTime:2016/11/16
 * 	author	  :Luyi
 * 	
 * 
 */
$(function() {
	var status = "";
	var obj = {};
	var app = new Object();
	var app = {
		init : function() {
			this.getId();
		},
		getId:function(){
			var talentRequirementId = sessionStorage.getItem('id');
			T.post('/s/detailedInformation/selectTalentRequirement',{'talentRequirementId':talentRequirementId},function(res){
				console.log(res);
				if(res.retCode=='10000'){
					obj = res.retObject;
					obj.createTime = T.dateFormat(new Date(obj.createTime),"yyyy-MM-dd");
					app.getIntroduce();//初始化基本信息
					app.getWorkNature();//初始化工作性质
					app.getDemandDescribe();//初始化需求描述
					app.getWorkDuty();//初始化工作职责
					app.getPeopleAsk();//初始化人员要求
					app.getEnclosure();//初始化初始化附件
					app.postCollection();//收藏
					app.postApply();//报名
				}
			})
		},
		getIntroduce:function(){//初始化基本信息
			
			$('.recruitingDetail #talentRequirementName').html(obj.talentRequirementName);
			$('.recruitingDetail #talentBuget').html(obj.talentBuget);
			$('.recruitingDetail #talentCount').html(obj.talentCount);
			$('.recruitingDetail #houseCount').html(obj.houseCount);
			$('.recruitingDetail #userName').html(obj.userName);
			$('.recruitingDetail #createTime').html(obj.createTime);
			//获取收藏按钮的值
			$('.recruitingDetail .twoButton .collect').attr('data-status',obj.isHouse);
			//获取报名按钮的值
			$('.recruitingDetail .twoButton .apply').attr('data-status',obj.isEnroll);

			if (obj.isAuthentication==0) {
				$('.recruitingDetail').find('.cer').attr('src','resources/images/front/certificationBlue.png');
			}else {
				$('.recruitingDetail').find('.cer').attr('src','resources/images/front/certificationGray.png');
			}
			
			if (obj.userEmail!=null) {
				$('.recruitingDetail').find('.pho').attr('src','resources/images/front/phoneMakeSureBlue.png');
			}else {
				$('.recruitingDetail').find('.pho').attr('src','resources/images/front/phoneMakeSureGray.png');
			}
			
			if (obj.userEmail!=null) {
				$('.recruitingDetail').find('.ema').attr('src','resources/images/front/emailAuthentication.png');
			}else {
				$('.recruitingDetail').find('.ema').attr('src','resources/images/front/emailAuthenticationGray.png');
			}
			
			status = $('.recruitingDetail .collect').attr('data-status');
			if (status==0) {
				$('.recruitingDetail .twoButton .collect').html("收藏");
			}else {
				$('.recruitingDetail .twoButton .collect').html("取消收藏");
			}
			
			applyStatus = $('.recruitingDetail .apply').attr('data-apply');
			if (applyStatus==0) {
				$('.recruitingDetail .twoButton .apply').html("报名");
			}else {
				$('.recruitingDetail .twoButton .apply').html("取消报名");
			}
		},
		getWorkNature:function(){//初始化工作性质
			$('.recruitingDetail #workMode').html(obj.workMode);
			$('.recruitingDetail #workSpace').html(obj.workSpace);
			$('.recruitingDetail #technologyRequirement').html(obj.technologyRequirement);
		},
		getDemandDescribe:function(){//初始化需求描述
			$('.recruitingDetail #requirementDescription').html(obj.requirementDescription);
		},
		getWorkDuty:function(){//初始化工作职责
			$('.recruitingDetail #workDuty').html(obj.workDuty);
		},
		getPeopleAsk:function(){//初始化人员要求
			$('.recruitingDetail #talentRequire').html(obj.talentRequire);
		},
		getEnclosure:function(){//初始化附件
			if (obj.talentAttachment!=null) {
				$('.recruitingDetail').find('.download').attr('herf',obj.talentAttachment);
			}else {
				$('.recruitingDetail .enclosure').hide();
				$('.recruitingDetail .attachment').hide();
			}
		},
		postCollection:function(){//收藏
			var demandId = sessionStorage.getItem('id');
			$('.recruitingDetail .twoButton .collect').bind('click',function(){
				status=$('.recruitingDetail .twoButton .collect').attr('data-status');
				colData = {
						"houseType":"700002",
						"houseResourceId":demandId
						}
				
				if (status==0) {
					T.post('/s/favorite/insertMyFavorite',colData,function(res){
						console.log(res);
						if(res.retCode=="10000"){
							$('.recruitingDetail .twoButton .collect').html("取消收藏");
							$('.recruitingDetail .twoButton .collect').attr('data-status',1);
						}
					})
				}else if (status==1) {
					T.post('/s/favorite/deleteUserHouse',colData,function(res){
						console.log(res);
						if(res.retCode=="10000"){
							$('.recruitingDetail .twoButton .collect').html("收藏");
							$('.recruitingDetail .twoButton .collect').attr('data-status',0);
						}
					})
				}
				console.log(status);
			})
		},
		postApply:function(){//报名
			var demandId = sessionStorage.getItem('id');
			$('.recruitingDetail .twoButton .apply').bind('click',function(){
				applyStatus = $('.recruitingDetail .apply').attr('data-apply');
				applyData = {
						"projectRequirementId":demandId
						}
				data-apply
				if (applyStatus==0) {
					T.post('/s/enroll/insertProjectEnroll',colData,function(res){
						console.log(res);
						if(res.retCode=="10000"){
							$('.recruitingDetail .twoButton .collect').html("取消报名");
							$('.recruitingDetail .twoButton .collect').attr('data-status',1);
						}
					})
				}else if (applyStatus==1) {
					T.post('/s/enroll/deleteProjectEnroll',colData,function(res){
						console.log(res);
						if(res.retCode=="10000"){
							$('.recruitingDetail .twoButton .collect').html("报名");
							$('.recruitingDetail .twoButton .collect').attr('data-status',0);
						}
					})
				}
				console.log(status);
			})
		}
	}
	app.init();
})