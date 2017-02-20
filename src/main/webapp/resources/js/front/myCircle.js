/*
 *	createTime:2016/10/31
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	
	var total=0,
		size=10,
		startPage=1;
	var app = {
			init:function(){
				this.initConfirData();
				this.page();
				
			},
			initConfirData:function(){
				T.post('/s/my/selectMyCommunity',{"pageSize":10,"page":1},function(res){
					console.log(res);
					if(res.retCode){
						total=res.retObject.total;
						$('#tableData tbody').remove();
						$('#mycirle_confirmed_template').tmpl(res.retObject.list).appendTo('#tableData');
						app.page();
						app.detail();
						app.del();
						app.initJoinTeam();
					}else{
						
					}
				});
			},
			page:function(){
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
						startPage=newPage;
						T.post('/s/my/selectMyCommunity',{"pageSize":size,"page":startPage},function(res){
							if(res.retCode){
								total=res.retObject.total;
								$('#tableData tbody').remove();
								$('#mycirle_confirmed_template').tmpl(res.retObject.list).appendTo('#tableData');
								app.detail();
								app.del();
								app.initJoinTeam();
							}else{
								
							}
						});
					}
				});
			},
			del:function(){
				$('.myCircle .del').bind('click',function(){
					T.post('/s/my/deleteMyCommunity',{
						"communityId":$(this).parent().attr('data-cuId')
					},function(res){
						console.log(res);
						if(res.retCode=="10000"){
							app.initConfirData();
						}
					});
				});
			},
			detail:function(){//详情
				$('.myCircle .detail').bind('click',function(){
					var userId=$(this).parent().attr('data-id');
					T.post('/s/detailedInformation/selectUserInformation',{'userId':userId},function(res){
						console.log(res);
						if(res.retCode=='10000'){
							app.showBaseInfo(res.retObject.user);//详情-展示基本信息
							app.showEduInfo(res.retObject.talentEduExperience);//详情-展示教育经历
							app.showWorkExInfo(res.retObject.talentWorkExperiences);//详情-展示工作经历
							app.showAdditionInfo(res.retObject.userCreativeTalent);//详情-附加信息
							$('#myCirclePersonModal').modal('show');
						}
					});
				});
			},
			showBaseInfo:function(obj){//详情-展示基本信息
				$('.baseInfo .userName').html(obj.userName);//用户名
				$('.baseInfo .userAlias').html(obj.userAlias);//昵称
				$('.baseInfo .userEmail').html(obj.userEmail);//邮箱
				$('.baseInfo .userMobile').html(obj.userMobile);//手机
			},
			showEduInfo:function(obj){//详情-展示教育经历
				if(T.isEmpty(obj)){
					$('.eduExInfo').hide();
					return false;
				}else{
				$('.eduExInfo .talentDegree').html(obj.talentDegree);//学历
				$('.eduExInfo .talentSchool').html(obj.talentSchool);//学校
				$('.eduExInfo .talentProfession').html(obj.talentProfession);//专业
				$('.eduExInfo .finishDate').html(obj.finishDate);//毕业时间
				$('.eduExInfo .memo').html(obj.memo);//备注
				}
			},
			showWorkExInfo:function(obj){//详情-展示工作经历
				if(obj.length>0){
					$.each(obj,function(index,ele){
						ele.startDate=T.dateFormat(new Date(ele.startDate),'yyyy-MM-dd');
						ele.endDate=T.dateFormat(new Date(ele.endDate),'yyyy-MM-dd');
					});
					
					$('.workExInfo .itemContent').empty();
					$('#mycirle_workEx_template').tmpl(obj).appendTo('.workExInfo .itemContent');
				}else{
					$('.workExInfo').hide();
					return false;
				}
			},
			showAdditionInfo:function(obj){//详情-附加信息
				if(T.isEmpty(obj)){
					$('.additionInfo').hide();
					return false;
				}else{
					$('.additionInfo .talentName').html(obj.talentName);//人才名称
					$('.additionInfo .workMode').html(obj.workMode);//工作方式
					$('.additionInfo .technologys').html(obj.technologys);//技术标签
					$('.additionInfo .workTime').html(obj.workTime);//工作时间
					$('.additionInfo .nowAddress').html(obj.nowAddress);//所在地
					$('.additionInfo .hopeSalary').html(obj.hopeSalary);//期望薪资
					$('.additionInfo .talentDescription').html(obj.talentDescription);//技术特长
					$('.additionInfo .talentWorkExperience').html(obj.talentWorkExperience);//项目经验
				}
				
			},
			initJoinTeam:function(){//加入团队
				$('.myCircle .joinTeam').bind('click',function(){
					app.initWorkPro();
				});
				
			},
			initWorkPro:function(){
				T.post('/s/my/selectProjectName',{"projFlowStatus":400103},function(res){
					if(res.retCode=="10000"){
						$('#joinMyCircle .workPro').empty();
						$('#mycirle_join_template').tmpl(res.retObject).appendTo('#joinMyCircle .workPro');//初始化工作项目
						$('#joinMyCircle').modal('show');
					}
				});
				app.jionTeam();
			},
			jionTeam:function(){
				$('#joinMyCircle .makeSure').bind('click',function(){
					var o={
							"projectDuty":"",
							"projectRequirements":[]
								}
					o.projectRequirements.push({"projId":$('.workPro').val()});
					o.projectDuty=$('.workJob').val();
					if(T.isEmpty($('.workPro').val())){
						$('.workPro').css('border','1px solid red');
						return false;
					}if(T.isEmpty($('.workJob').val())){
						$('.workJob').css('border','1px solid red');
						return false;
					}
					T.post('/s/my/insertTeam',o,function(res){
						console.log(res);
						if(res.retCode=='10000'){
							$.alert('修改成功');
							$('#joinMyCircle').modal('hide');
						}else{
							$.alert(res.retMessage);
						}
					});
				})
			}
	}
	app.init();
})