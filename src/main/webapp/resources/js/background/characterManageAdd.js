/*
 *	createTime:2016/10/24 
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	
	var app={
			init:function(){
				this.initData();
				this.checkInput();
				this.submit();
				this.goBack();
				
			},
			initData:function(){
				T.get('/s/sys/selectBackSysResource','',function(res){
					//console.log(res);
					if(res.retCode=='10000'){
						$('#tableData tbody').remove();
						$('#character_add_template').tmpl(res.retObject).appendTo('#tableData');
					}else{
						
					}
				});
			},
			checkInput:function(){ //选项连动
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
			submit:function(){
				$('#save').unbind().bind('click',function(){
					app.postData();
				});
			},
			postData:function(){
				var obj={
						'roleName'		:'',
						'sysResource'	:[]
						};
				obj.roleName=$('#roleName').val();
				$("#tableData tbody input").each(function(index,elem){
					if($(this).is(':checked')){
						var _obj={
								'resourceId':$(this).attr('data-id')
						}
						obj.sysResource.push(_obj);
					}
				});
				console.log(obj.sysResource);
				if(T.isEmpty(obj['roleName'])){
					$('.addErrorTip .msg-con').html('请填角色名');
					$('.addErrorTip').css('opacity','1');
					return false;
				}if(obj.sysResource.length<=0){
					$('.addErrorTip .msg-con').html('请选择资源目录');
					$('.addErrorTip').css('opacity','1');
					return false;
				}if (!/(?!^\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{6,50}/g.test(obj['roleName'])){
					$('.addErrorTip .msg-con').html('角色名必须是6-50位数字和字母的组合');
					$('.addErrorTip').css('opacity','1');
			        return false;
			    }else{
			    	$('.addErrorTip').css('opacity','0');
			    	T.post('/s/role/insertBackRole',obj,function(res){
			    		if(res.retCode=='10000'){
			    			$('.rightContentField').load('characterManage.html')
			    		}else{
			    			
			    		}
			    	});
			    }
			},
			goBack:function(){
				$('#back').unbind().bind('click',function(){
					$('.rightContentField')
					.load('characterManage.html')
				});
			}
		}
	app.init();
})