/*
 *	createTime:2016/11/23
 * 	author	  :LUYI
 * 	
 */
$(function(){
	
	var obj = {};
	
	var app = new Object();
	
	var app = {
			
		init : function() {
			this.getId();
		},
		
		getId:function(){
			var talentRequirementId = sessionStorage.getItem('id');
			T.post('/s/detailedInformation/selectTalentRequirement2',{'talentRequirementId':talentRequirementId},function(res){
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
				}
			})
		},
		
		getIntroduce:function(){//初始化基本信息
			
			$('.talentDetails #talentRequirementName').html(obj.talentRequirementName);
			$('.talentDetails #talentBuget').html(obj.talentBuget);
			$('.talentDetails #talentCount').html(obj.talentCount);
			$('.talentDetails #houseCount').html(obj.houseCount);
			$('.talentDetails #userName').html(obj.userName);
			$('.talentDetails #createTime').html(obj.createTime);

			if (obj.isAuthentication==0) {
				$('.talentDetails').find('.cer').attr('src','../../images/front/certificationBlue.png');
			}else {
				$('.talentDetails').find('.cer').attr('src','../../images/front/certificationGray.png');
			}
			
			if (obj.userEmail!=null) {
				$('.talentDetails').find('.pho').attr('src','../../images/front/phoneMakeSureBlue.png');
			}else {
				$('.talentDetails').find('.pho').attr('src','../../images/front/phoneMakeSureGray.png');
			}
			
			if (obj.userEmail!=null) {
				$('.talentDetails').find('.ema').attr('src','../../images/front/emailAuthentication.png');
			}else {
				$('.talentDetails').find('.ema').attr('src','../../images/front/emailAuthenticationGray.png');
			}
		},
		
		getWorkNature:function(){//初始化工作性质
			$('.talentDetails #workMode').html(obj.workMode);
			$('.talentDetails #workSpace').html(obj.workSpace);
			$('.talentDetails #technologyRequirement').html(obj.technologyRequirement);
		},
		
		getDemandDescribe:function(){//初始化需求描述
			$('.talentDetails #requirementDescription').html(obj.requirementDescription);
		},
		
		getWorkDuty:function(){//初始化工作职责
			$('.talentDetails #workDuty').html(obj.workDuty);
		},
		
		getPeopleAsk:function(){//初始化人员要求
			$('.talentDetails #talentRequire').html(obj.talentRequire);
		},
		
		getEnclosure:function(){//初始化附件
			$('.enclosure').children().remove();
	        $('#talentDetail_enclosure_tmplate').tmpl(obj).appendTo('.enclosure');
		}
	}
	app.init();
})
