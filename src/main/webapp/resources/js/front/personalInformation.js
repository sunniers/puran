/*
 *	createTime:2016/10/31
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var errFlag=true;
	var dataInfo = {
					'userAlias':'',
					'talentEduExperience':{
						'experienceId':'',
						'finishDate':'',
						'isOpen':'1',
						'memo':'',
						'talentDegree':'',
						'talentProfession':'',
						'talentSchool':''
					},
					'talentWorkExperiences':[],
					'userCreativeTalent':{
						'isOpen':'1',
						'talentName':'',
						'workMode':'',
						'workTime':'',
						'nowAddress':'',
						'hopeSalary':'',
						'talentDescription':'',
						'talentWorkExperience':'',
						'creativeTalentId':'',
						'talentTechnologies':[]
					}
			}
	var app={
			init:function(){
				this.getBaseInfo();
				this.addEx();
				this.delExAnimate();
				this.save();
				this.pub();
			},
			getBaseInfo:function(){
				T.get('s/perfectInformation/selectUserInfo','',function(res){
					console.log(res)
					if(res.retCode=='10000'){
						var obj=res.retObject;
						app.initBaseData(obj);//个人基本信息初始化
						
						app.initEddata(obj.talentEduExperience);//个人教育信息初始化
						
						app.initWorkEx(obj.talentWorkExperiences);//工作经历初始化
						
						app.initOtherInfo(obj.userCreativeTalent);//人才信息初始化
					}
				})
			},
			initBaseData:function(obj){// 个人基本信息自动填充
				$('.userName .name').html(obj.userName);//用户名
				
				$('.nickname .box2 input').val(obj.userAlias);//昵称
				
				$('.realName .box2').html(obj.realName);//真实姓名
				
				$('.idNumber .box2').html(obj.code);//身份证号码
				
				$('.mailbox .box2 ').html(obj.userEmail);//邮箱
				
				$('.phoneNumber .box2 ').html(obj.userMobile);//手机号
			},
			initEddata:function(obj){//教育经历初始化
				
				$('.education select option').each(function(){//初始化学历
					if($(this).html()==obj.talentDegree) $(this).prop('selected',true);
				});
				
				$('.education select ').attr('data-id',obj.experienceId);//记录教育经历ID
				
				$('.school.box input').val(obj.talentSchool);//初始化学校
				
				$('.major.box input').val(obj.talentProfession);//初始化专业
				
				$('.graduation.box input').val(T.dateFormat(new Date(obj.finishDate),'yyyy-MM-dd'));//初始化毕业时间
				
				$('.remarks.box textarea').val(obj.memo);//初始化备注
			},
			initWorkEx:function(obj){//工作经历初始化
				if(obj.length>0){
					$.each(obj,function(index,o){
						obj[index].startDate=T.dateFormat(new Date(o.startDate),'yyyy-MM-dd');
						obj[index].endDate=T.dateFormat(new Date(o.endDate),'yyyy-MM-dd');
					});
					$('.workExperience .informationContent').empty();
					$('#per_workexper_template').tmpl(obj).appendTo($('.workExperience .informationContent'));
					app.delEx();
				}
			},
			addEx:function(){//增加工作经历
				$('.workExperience .add .addEx').bind('click',function(){
					$('#per_workexper_template').tmpl({}).appendTo($('.workExperience .informationContent'));
					app.delEx();
				});	
			},
			delExAnimate:function(){//删除工作经历按钮动画
				$('.workExperience .add .delEx').bind('click',function(){
					console.log('ok');
					if($(this).is('.undel')){
						$(this).removeClass('undel').addClass('deled');
						$(this).find('span').html('取消');
						$(".workExItem>.del").animate({  'right': "0px"}, 500);
					}else{
						$(this).removeClass('deled').addClass('undel');
						$(this).find('span').html('删除');
						$(".workExItem>.del").animate({  'right': "-70px"}, 500);
					}
					
				});
			},
			delEx:function(){//删除工作经历
				$('.workExItem .del').bind('click',function(){
					that=$(this);
					$(this).parent().animate({  'right': "260px",'height':'0px'}, 500,function(){
						console.log(that.parent());
						that.parent().remove();
					});
				});
			},
			initOtherInfo:function(obj){//初始化人才信息
				T.get('/s/perfectInformation/selectTalentTechnology','',function(res){//获取技术标签选项 并且初始化
					console.log(res);
					if(res.retCode=='10000'){
						$('.technologys .checkContent').empty();
						$('#person_check_template').tmpl(res.retObject).appendTo('.technologys .checkContent');
						$.each(obj.talentTechnologies,function(index,ele){
							$('.technologys .checkContent input').each(function(){
								if(ele.technologyId==$(this).attr('data-id')){
									$(this).prop('checked',true);
								}
							});
						})
					}	
				})
				
				dataInfo.userCreativeTalent.creativeTalentId=$('.addInformation .informationContent').attr('data-id',obj.creativeTalentId);//人才ID
				
				dataInfo.userCreativeTalent.talentName=$('.talentName input').val(obj.talentName);//人才名称
				
				dataInfo.userCreativeTalent.workMode=$('.workWay input').val(obj.workMode);//工作方式
				
				dataInfo.userCreativeTalent.workTime=$('.workTime input').val(obj.workTime);//工作时间
				
				dataInfo.userCreativeTalent.nowAddress=$('.liveAddress input').val(obj.nowAddress);//所在地址
				
				dataInfo.userCreativeTalent.hopeSalary=$('.expectedaSalary input').val(obj.hopeSalary);//期望薪资
				
				dataInfo.userCreativeTalent.talentDescription=$('.technology textarea').val(obj.talentDescription);//技术特长
				
				dataInfo.userCreativeTalent.talentWorkExperience=$('.projectExperience textarea').val(obj.talentWorkExperience);//项目经验
				
				
			},
			getPostData:function(){//获取页面数据
				errFlag=true;
				app.getInformation();
				app.getEduExper();
				app.getWorkExper();
				app.getAddExper();
				console.log(dataInfo);
			},
			getInformation:function(){//获取基本信息
				dataInfo.userAlias=$('.nickname .box2 input').val();
			},
			getEduExper:function(){//获取教育信息
				if($('#eduOpen').is(':checked')){
					dataInfo.talentEduExperience.isOpen='0'//是否公开
				}
				
				dataInfo.talentEduExperience.experienceId=$('.educationExperience select').attr('data-id');//获取教育经历ID
				
				dataInfo.talentEduExperience.talentDegree=$('.educationExperience select').val();//毕业学历
					
				dataInfo.talentEduExperience.talentSchool=$('.school input').val();//毕业学校
					
				dataInfo.talentEduExperience.talentProfession=$('.major input').val();//毕业专业
				
				dataInfo.talentEduExperience.finishDate=$('.graduation input').val();//毕业时间
				
				dataInfo.talentEduExperience.memo=$('.remarks textarea').val();//备注
				
				
			},
			getWorkExper:function(){//获取工作经验信息
				dataInfo.talentWorkExperiences=[];
				$('.informationContent .workExItem').each(function(){
					var o={
							'isOpen':'1',
							'experienceId':'',
							'workJob':'',
							'workCompany':'',
							'startDate':'',
							'endDate':'',
							'workDescription':''
							
						}
					if($('#workExOpen').is(':checked')){
						o.isOpen='0';//是否开放
					}
					o.experienceId=$(this).attr('data-id');//工作经验ID
					
					o.workJob=$(this).find('.position input').val();//职位
					
					o.workCompany=$(this).find('.company input').val();//公司
					
					o.startDate=$(this).find('.startDate').val();//开始时间
					
					o.endDate=$(this).find('.endDate').val();//结束时间
					
					o.workDescription=$(this).find('.mainCase textarea').val();//工作说明
					
					dataInfo.talentWorkExperiences.push(o);
				});
				
				
			},
			getAddExper:function(){//附件信息
				var arr=[];
				$('.technologys .checkContent input').each(function(index,ele){
					if($(this).is(':checked')){
						arr.push($(this).attr('data-val'))
					}
				});
				arr=arr.join(',');
				dataInfo.userCreativeTalent.technologys=arr;//技术标签
				
				dataInfo.userCreativeTalent.creativeTalentId=$('.addInformation .informationContent').attr('data-id');//人才ID
					
				dataInfo.userCreativeTalent.talentName=$('.talentName input').val();//人才名称
				
				dataInfo.userCreativeTalent.workMode=$('.workWay input').val();//工作方式
				
				dataInfo.userCreativeTalent.workTime=$('.workTime input').val();//工作时间
				
				dataInfo.userCreativeTalent.nowAddress=$('.liveAddress input').val();//所在地址
				
				dataInfo.userCreativeTalent.hopeSalary=$('.expectedaSalary input').val();//期望薪资
				
				dataInfo.userCreativeTalent.talentDescription=$('.technology textarea').val();//技术特长
				
				dataInfo.userCreativeTalent.talentWorkExperience=$('.projectExperience textarea').val();//项目经验
				
				if($('#otherOpen').is(':checked')){//附加信息公开
					dataInfo.userCreativeTalent.isOpen='0';
					$.each(dataInfo.userCreativeTalent,function(index,Ele){
						if(index!='creativeTalentId'){
							if(T.isEmpty(Ele)){
								$('#errModal').modal('show');
								errFlag=false;
								return false;
							}
						}
						
					})
				}
				
			},
			doAction:function(url){
				app.getPostData();
					if(errFlag){
						T.post(url,dataInfo,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								$.alert({'body':'操作成功',
									hidden:function(){$('.rightContentField')
									.load('../resources/html/front/myAccount.html')}
								})
							}else{
								$.alert(res.retMessage);
							}
						});
					}
			},
			save:function(){
				$('.save .preserve').bind('click',function(){
					app.doAction('/s/perfectInformation/updateUserInformation');
				});
			},
			pub:function(){
				$('.save .pub').bind('click',function(){
					app.doAction('/s/perfectInformation/putUserInformaton');
				});
			}
	}
	app.init();
})