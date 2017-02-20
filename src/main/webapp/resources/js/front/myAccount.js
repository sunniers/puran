/*
 *	createTime:2016/10/27 
 * 	author	  :tangj
 * 	
 */
$(function(){
	var isAudit='';
	var app={
			init:function(){
				this.getPsonInfo();
				this.getProject();
				this.approve();
			},
			getPsonInfo:function(){
				T.post('/s/getSession/getUser','',function(res){
					console.log(res)
					if(res.retCode=='10000'){
						var _obj=res.retObject;
						app.completeInfo();
						isAudit=_obj.isAudit;
						if(_obj.isAuthentication=='0'){
							if(_obj.userType=='100501'){//个人认证用户
								app.personalCon(_obj);
								$('.approve').hide();
							}else{//企业用户
								app.company(_obj);
								$('.approve').hide();
							}
						}else{//普通用户
							app.general(_obj);
							$('.comInfo a').unbind();
							$('.comInfo a').css({'color':'#cccccc','cursor':'default'});
						}
						
					}else {
						
					}
				})
			},
			personalCon:function(_obj){
				$('.identification .nickName').html(_obj.userAlias);
				$('.identification .consumer').html('个人用户');
				$('.comInfo a').attr('data-name','personal');
				var html='';
					html+=    '<img src="resources/images/front/identityAuthenticationSmall.png" alt="身份认证"/>';
					html+=    '<a href="#">身份认证</a>';
					if(T.isEmpty(_obj.userEmail)){
						html+=    '<img src="resources/images/front/emailAuthenticationGray.png" alt="邮箱认证"/>';
						html+=    '<a href="#" style="color:#666666;">邮箱认证</a>';
					}else{
						html+=    '<img src="resources/images/front/emailAuthenticationSmall.png" alt="邮箱认证"/>';
						html+=    '<a href="#">邮箱认证</a>';
					}
					if(T.isEmpty(_obj.userMobile)){
						html+=    '<img src="resources/images/front/phoneMakeSureGray.png" alt="手机认证"/>';
						html+=    '<a class="phoneApprove" href="#" style="color:#666666;">手机认证</a>';
					}else{
						html+=    '<img src="resources/images/front/phoneMakeSureSmall.png" alt="手机认证"/>';
						html+=    '<a href="#" >手机认证</a>';
					}
					$(html).insertAfter($('.identification .consumer'));
			},
			general:function(_obj){
				$('.identification .nickName').html(_obj.userAlias);
				$('.identification .consumer').html('普通用户');
				var html='';
					html+=    '<img src="resources/images/front/identityAuthenticationGray.png" alt="身份认证"/>';
					html+=    '<a class="identifyApprove" href="javascript:void(0)" style="color:#666666;">身份认证</a>';
					if(T.isEmpty(_obj.userEmail)){
						html+=    '<img src="resources/images/front/emailAuthenticationGray.png" alt="邮箱认证"/>';
						html+=    '<a href="#" style="color:#666666;">邮箱认证</a>';
					}else{
						html+=    '<img src="resources/images/front/emailAuthenticationSmall.png" alt="邮箱认证"/>';
						html+=    '<a href="#" style="cursor:default;">邮箱认证</a>';
					}
					if(T.isEmpty(_obj.userMobile)){
						html+=    '<img src="resources/images/front/phoneMakeSureGray.png" alt="手机认证"/>';
						html+=    '<a class="phoneApprove" href="javascript:void(0)" style="color:#666666;">手机认证</a>';
					}else{
						html+=    '<img src="resources/images/front/phoneMakeSureSmall.png" alt="手机认证"/>';
						html+=    '<a href="#" style="cursor:default;">手机认证</a>';
					}
					$(html).insertAfter($('.identification .consumer'));
			},
			company:function(_obj){
				$('.identification .nickName').html(_obj.userAlias);
				$('.identification .consumer').html('企业用户');
				$('.comInfo a').attr('data-name','company');
				var html='';
					html+=    '<img src="resources/images/front/identityAuthenticationSmall.png" alt="身份认证"/>';
					html+=    '<a href="javascript:void(0)" style="cursor:default;">企业认证</a>';
					if(T.isEmpty(_obj.userEmail)){
						html+=    '<img src="resources/images/front/emailAuthenticationGray.png" alt="邮箱认证"/>';
						html+=    '<a href="#" style="color:#666666;">邮箱认证</a>';
					}else{
						html+=    '<img src="resources/images/front/emailAuthenticationSmall.png" alt="邮箱认证"/>';
						html+=    '<a href="#" style="cursor:default;">邮箱认证</a>';
					}
					if(T.isEmpty(_obj.userMobile)){
						html+=    '<img src="resources/images/front/phoneMakeSureGray.png" alt="手机认证"/>';
						html+=    '<a class="phoneApprove" href="#" style="color:#666666;">手机认证</a>';
					}else{
						html+=    '<img src="resources/images/front/phoneMakeSureSmall.png" alt="手机认证"/>';
						html+=    '<a href="#" style="cursor:default;">手机认证</a>';
					}
					$(html).insertAfter($('.identification .consumer'));
			},
			getProject:function(){
				T.get('/s/myCodeController/selectProj','',function(res){
					if(res.retCode=='10000'){
						var _obj=res.retObject;
						$('.runPro').html(_obj.runningProj);//进行中的项目
						$('.relPro').html(_obj.releaseProj);//发布的项目
						$('.takePro').html(_obj.takeProj);//参与的项目
					}
				});
			},
			completeInfo:function(){//完善信息
				$('.comInfo a').css('color','#2d7ee2');
				$('.comInfo a').bind('click',function(){
					if($(this).attr('data-name')=='personal'){
						$('.rightContentField').load('resources/html/front/personalInformation.html');
					}else if($(this).attr('data-name')=='company'){
						$('.rightContentField').load('resources/html/front/enterpriseInformation.html');
					}
					
				});
			},
			approve:function(){//前往认证
				$(document).on('click','.identifyApprove',function(){
					if(isAudit!='0'){
						$('.rightContentField').load('resources/html/front/twoAuthentication.html');
					}else{
						$.alert('审核处理中 请等待');
					}
					
				});
				$(document).on('click','.phoneApprove',function(){
					$('.rightContentField').load('resources/html/front/mobileConfirm.html');
				});
			}
	}
	
	app.init();
})