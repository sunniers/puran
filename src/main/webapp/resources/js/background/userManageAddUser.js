/*
 *	createTime:2016/10/13 
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){

	var add={
			init:function(){
				this.initDepartment(); // 初始化部门
				this.initRoles(); // 初始化角色 
				this.submitData(); // 初始化数据提交事件绑定
				this.chooseRoles(); // 初始化角色选择事件绑定
				this.back();
			},
			initDepartment:function(){
				 T.get('/s/user/selectAllBackUserDepartment','',function (res) {
			            	console.log(res);
			                if(res.retCode=="10000"){
			                	var html='<option value="">请选择</option>';
			                		for(var i=0;i<res.retObject.length;i++){
			                			html+='<option value="'+res.retObject[i]+'">'+res.retObject[i]+'</option>';
			                		}
			                	$('#department').append(html);
			                }else{}  
			            })
			},
			initRoles:function(){ 
				 T.post('/s/role/selectBackRole',{'roleName':null}, function (res){
					 console.log(res);
			                if(res.retCode=="10000"){//请求成功
			                	$('#add_role_template').tmpl(res.retObject.list).appendTo("#roles");
			                	add.chooseRoles();
			                }else{}   
			          })
			},
			chooseRoles:function(){// 角色选择
				$('#roles input').unbind().bind('click',function(){
            		var arr='';
   					 $('#roles input').each(function(index, domEle){
   						 if($(this).is(':checked')){
   							 arr+=$(this).attr('data-value')+'，';
   						 }
   					 	});
   					 $('#role').val(arr.slice(0,length-1));
				 })
			},
			checkData:function(){
				var _obj={
						'userName'	:$('.addUserContent #userName').val(),
						'userAlias'	:$('#userAlias').val(),
						'department':$('#department option:selected').val(),
						'passWord' 	:$('#passWord').val(),
						'sureWord' :$('#sureWord').val()
				}
				console.log(_obj.userName);
				if(T.isEmpty(_obj['userName'])){
					$('.userNamePrompt .msg-con').html('请填写用户名');
					$('.userNamePrompt').show();
					return false;
				}if(T.isEmpty(_obj['userAlias'])){
					$('.userNamePrompt .msg-con').html('请填写用户昵称');
					$('.userNamePrompt').show();
					return false;
				}
				if(T.isEmpty(_obj['department'])){
					$('.userNamePrompt .msg-con').html('请选择部门');
					$('.userNamePrompt').show();
					return false;
				}
				if(T.isEmpty(_obj['passWord'])){
					$('.userNamePrompt .msg-con').html('请输入密码');
					$('.userNamePrompt').show();
					return false;
				}
				if(T.isEmpty(_obj['sureWord'])){
					$('.userNamePrompt .msg-con').html('请输入确认密码');
					$('.userNamePrompt').show();
					return false;
				}
				if (!/^((?=.*[0-9].*)(?=.*[A-Za-z].*))[_0-9A-Za-z]{6,50}$/g.test(_obj['userName'])) {
					$('.userNamePrompt .msg-con').html('用户名必须是6-50位数字和字母的组合');
					$('.userNamePrompt').show();
			        return false;
			    }if (!/^((?=.*[0-9].*)(?=.*[A-Za-z].*))[_0-9A-Za-z]{6,50}$/g.test(_obj['userAlias'])) {
					$('.userNamePrompt .msg-con').html('用户昵称必须是6-50位数字和字母的组合');
					$('.userNamePrompt').show();
			        return false;
			    }
				if(_obj['sureWord'] != _obj['passWord']){
					$('.userNamePrompt .msg-con').html('两次输入的密码不匹配');
					$('.userNamePrompt').show();
			        return false;
				}
				if(!/^((?=.*[0-9].*)(?=.*[A-Za-z].*))[_0-9A-Za-z]{6,50}$/g.test(_obj['passWord'])){
					$('.userNamePrompt .msg-con').html('密码名必须是6-50位数字和字母的组合');
					$('.userNamePrompt').show();
			        return false;
				}
				else{
					$('.userNamePrompt').hide();
					return true;
				}
			},
			submitData:function(){
				//事件绑定
				 $('#save').unbind().bind('click',function(){
					if(add.checkData()){
						var data={
								'userName'	 :$('#userName').val(),
								'userAlias'	 :$('#userAlias').val(),
								'userDepartment' :$('#department option:selected').val(),
								'userPwd' 	 :$('#passWord').val(),
								'userMobile':$('#phoneNumber').val(),
								'userEmail'	 :$('#mailbox').val(),
								'backUserRoles'		 :[]
						};
						$('#roles input').each(function(index, domEle){
	   						 if($(this).is(':checked')){
	   							data.backUserRoles[data.backUserRoles.length]={'roleId':$(this).val()};
	   						 }
	   					 });
						T.post('/s/user/insertBackUser',data,function(res){
							if(res.retCode=='10000'){
								$('.rightContentField')
								.load('userManage.html')
							}

						});
					}
				 });
			},
			back:function(){
				$('#back').unbind().bind('click',function(){
					$('.rightContentField')
					.load('userManage.html')
				});
			}
	}
	
	//初始化
	add.init();
	
	
})