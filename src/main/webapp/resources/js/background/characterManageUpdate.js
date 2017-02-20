/*
 *	createTime:2016/10/26
 * 	author	  :tj
 */
$(function(){
	
	var app={
			init:function(){
				this.getAllRes();
				this.checkInput();
				this.submit();
				this.back();
			},
			getCheckData:function(){
				T.post('/s/role/selectBackRoleById',
						{'roleId':sessionStorage.getItem('roleId')},
						function(res){
							console.log(res)
							if(res.retCode=='10000'){
								$('#roleName').val(res.retObject.roleName);
								app.initResChoose(res);
							}
				});
			},
			getAllRes:function(){
				T.get('/s/sys/selectBackSysResource','',function(res){
					//console.log(res);
					if(res.retCode=='10000'){
						$('#tableData tbody').remove();
						$('#character_update_template').tmpl(res.retObject).appendTo('#tableData');
						app.getCheckData();// 初始化选项
						
					}else{
						
					}
				});
			},
			initResChoose:function(res){
				var _objList=res.retObject.sysResource;
				for(var i=0;i<_objList.length;i++){
					var _obj=_objList[i];
					if(_obj.sysResources.length>0){
						for(var j=0;j<_obj.sysResources.length;j++){
							$('#'+_obj.sysResources[j].resourceId+'').prop('checked',true);
						}
					}else{
						//console.log($('#'+_obj.resourceId+''));
						$('#'+_obj.resourceId+'').prop('checked',true);
					}
				}
				
				$('.childCheck input').each(function(index,elem){
					var flag=false;
					$ele=$($(elem).parent().parent().children().find('input'));
					for(var i=0;i<$ele.length;i++){
						if(!$($ele[i]).is(':checked')){
							flag=false;
							break;
						}else{
							flag=true;
						}
					}
					if(flag){
						$(this).parent().parent()
							.prev().children().find('input')
								.prop("checked", true);
					}else{
						$(this).parent().parent()
						.prev().children().find('input')
							.prop("checked", false);
					}
				});
				
			},
			checkInput:function(){
				$(document).off('click','.parentCheck input').on('click','.parentCheck input',function(){
					if($(this).is(':checked')){
						$(this).parent().parent()
							.next(".childCheck").children()
								.find('input').prop("checked", true);
					}else{
						$(this).parent().parent()
						.next(".childCheck").children()
							.find('input').prop("checked", false);
					}
				});
				$(document).off('click','.childCheck input').on('click','.childCheck input',function(){
					var flag=false;
						$ele=$($(this).parent().parent().children().find('input'));
						for(var i=0;i<$ele.length;i++){
							if(!$($ele[i]).is(':checked')){
								flag=false;
								break;
							}else{
								flag=true;
							}
						}
						if(flag){
							$(this).parent().parent()
								.prev().children().find('input')
									.prop("checked", true);
						}else{
							$(this).parent().parent()
							.prev().children().find('input')
								.prop("checked", false);
						}	
						
				});
			},
			postData:function(){
				var obj={
						'roleId'		:'',
						'roleName'		:'',
						'sysResource'	:[]
						};
				obj.roleName=$('#roleName').val();
				obj.roleId=sessionStorage.getItem('roleId');
				if(T.isEmpty(obj['roleName'])){
					$('.characterNamePrompt .msg-con').html('请填角色名');
					$('.characterNamePrompt').css('opacity','1');
					return false;
				}if (!/(?!^\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{6,50}/g.test(obj['roleName'])){
					$('.characterNamePrompt .msg-con').html('角色名必须是6-50位数字和字母的组合');
					$('.characterNamePrompt').css('opacity','1');
			        return false;
			    }
				
				$("#tableData tbody tr").each(function(index,elem){

					var chObj=$(elem).find('.childCheck').find('input');
					if(chObj.length>0){
						var _flag=false;
						for(var i=0;i<chObj.length;i++){
							if($(chObj[i]).is(':checked')){
								_flag=true;
								obj.sysResource.push({'resourceId':$(chObj[i]).attr('id')});
							}
						}
						if(_flag){
							var paVal=$(elem).find('.parentCheck').find('input').attr('id');
							obj.sysResource.push({'resourceId':paVal});
						}
					}else{
						var pObj=$(elem).find('.parentCheck').find('input');
						if($(pObj).is(':checked')){
							obj.sysResource.push({'resourceId':$(pObj).attr('id')});
						}
					}
				});
				
				if(obj.sysResource.length<=0){
					$('.characterNamePrompt .msg-con').html('请选择资源目录');
					$('.characterNamePrompt').css('opacity','1');
					return false;
				}else{
			    	$('.characterNamePrompt').css('opacity','0');
			    	T.post('/s/role/updateBackRole',obj,function(res){
			    		if(res.retCode=='10000'){
			    			$('.rightContentField').load('characterManage.html');
			    		}else{
			    			
			    		}
			    	});
			    }
			},
			submit:function(){
				$('#save').unbind().bind('click',function(){
					app.postData();
				});
			},
			back:function(){
				$('#back').unbind().bind('click',function(){
					$('.rightContentField').load('characterManage.html')
				});
			}
	}
	app.init();
})