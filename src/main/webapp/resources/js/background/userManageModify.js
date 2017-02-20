/*
 *	createTime:2016/10/20 
 * 	author	  :tangj
 * 	
 * 
 */
$(function(){
	var app={
			init:function(){
				this.initData();
				this.submit();
				this.back();
			},
			initData:function(){
				T.post('/s/user/selectBackUser',{'userId':sessionStorage.getItem("userId")},function(res){
					if(res.retCode=='10000'){
						app.initInput(res);
						app.initRole(res);
						app.initSelect(res);
					}else{
						
					}
				});
			},
			initInput:function(res){
				var _obj=res.retObject;
				$('#userAlias').val(_obj.userAlias);
				$('#phoneNumber').val(_obj.userMobile);
				$('#mailbox').val(_obj.userEmail);
			},
			initSelect:function(res){
				var _obj=res.retObject;
					T.get('/s/user/selectAllBackUserDepartment','', function(res) {// 初始化部门
						if (res.retCode == "10000") {
							$('#department option').remove();
							var html='';
							for(var i=0;i<res.retObject.length;i++){
								if(_obj.userDepartment == res.retObject[i]){
									html+='<option selected = "selected">'+res.retObject[i]+'</option>';
								}
								html+='<option>'+res.retObject[i]+'</option>';
							};
							$('#department').append(html);
						}
					})
					
			},
			initRole:function(res){
				var _obj= res.retObject;
				console.log(_obj);
				T.post('/s/role/selectBackRole',{'roleName':null}, function (res){
			                if(res.retCode=="10000"){//请求成功
			                	console.log(res);
			                	$('#roles div').remove();
			                	var html='';
			                	for(var i=0;i<res.retObject.list.length;i++){
			                		html+='<div class="administrators"><input value="'+res.retObject.list[i].roleId+'" data-value="'+res.retObject.list[i].roleName+'"  type="checkbox">'+res.retObject.list[i].roleName+'</div>';
			                	}
			                	$('#roles').append(html);
			                	var _str='';
			                	$('#roles input').each(function(i,ele){
			                		for(var j=0;j<_obj.backUserRoles.length;j++){
			                			if($(this).val()==_obj.backUserRoles[j].roleId){
				                			$(this).prop("checked", true);
				                			_str+=_obj.backUserRoles[j].roleName+',';
				                		}
			                		}
			                		
			                	});
			                	$('#role').val(_str);
			                	app.chooseRoles();
			                }else{}   
			          })
			},
			checkData:function(){
				var _obj={
						'userAlias'	:$('#userAlias').val(),
						'department':$('#department option:selected').val()
				}
				if(T.isEmpty(_obj['userAlias'])){
					$('.userNamePrompt .msg-con').html('请填写用户昵称');
					$('.userNamePrompt').show();
					return false;
				}
				if(T.isEmpty(_obj['department'])){
					$('.userNamePrompt .msg-con').html('请选择部门');
					$('.userNamePrompt').show();
					return false;
				}if (!/(?!^\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{6,50}/g.test(_obj['userName'])) {
					$('.userNamePrompt .msg-con').html('用户名必须是6-50位数字和字母的组合');
					$('.userNamePrompt').show();
			        return false;
			    }else{
			    	$('.userNamePrompt').hide();
			    	return true;
			    }
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
			submit:function(){
				$('#save').unbind().bind('click',function(){
					if(app.checkData()){
						var data={
								'userId':sessionStorage.getItem("userId"),
								'userAlias'	 :$('#userAlias').val(),
								'userDepartment' :$('#department option:selected').val(),
								'userMobile':$('#phoneNumber').val(),
								'userEmail'	 :$('#mailbox').val(),
								'backUserRoles'		 :[]
						};
						$('#roles input').each(function(index, domEle){
	   						 if($(this).is(':checked')){
	   							 data.backUserRoles[data.backUserRoles.length]={'roleId':$(this).val()};
	   						 }
	   					 });
						T.post('/s/user/updateBackUser',data,function(res){
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
					$('.rightContentField').load('userManage.html')
				});
			}
	}
	
	app.init();
})