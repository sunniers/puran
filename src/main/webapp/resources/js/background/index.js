/*
 *	createTime:2016/10/13 
 * 	author	  :tangj
 * 	edit	  :
 * 
 */

$(function() {
	var app= {
			init:function(){
				this.getUser();//初始化用户名
				this.getMenu();//初始化菜单
			},
			getUser:function(){
				T.post('/s/getSession/getBackUser','',function(res){
					console.log(res)
					if(res.retCode=='10000'){
						$('#userName').html(res.retObject.userName);
					}
				})
			},
			getMenu:function(){
				T.post('http://127.0.0.1:8080/s/showFrontIndex/selectSysResources',{'resourceType':'back'},function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var menuList=res.retObject;
						$('#leftMenu').children().remove();
						$('#index_menu_template').tmpl(menuList).appendTo('#leftMenu');
						app.menuToPage();
					}else{
						
					}
				});
			},
			menuToPage:function(){//左侧菜单跳转
				$('.leftMenuField .parentDirectory').bind('click',function(){
					var url=$(this).attr('data-url');
					$('.rightContentField').load(url,function(response,status,xhr){	
						if(xhr.getResponseHeader('urlType')=='back'){
							window.location.href="/login.html";
						}
					});
				});
				$('.leftMenuField .childDirectory').bind('click',function(){
					var url=$(this).attr('data-url');
					$('.rightContentField').load(url,function(response,status,xhr){	
						if(xhr.getResponseHeader('urlType')=='back'){
							window.location.href="/login.html";
						}
					})
				});
			}
	}
	app.init();// 初始化页面数据

	
	
// 用户管理
$('#userManage')
	.unbind().bind('click',function(){
		$('.rightContentField').load('userManage.html')
})
	
// 角色管理
$('#roleManage')
	.unbind().bind('click',function(){$('.rightContentField')
		.load('characterManage.html')
})

//资源目录管理
$('#resourecsEdit')
	.unbind().bind('click',function(){$('.rightContentField')
		.load('setResourceDirectory.html')
})

//密码修改
$('#modifyPassword')
	.unbind().bind('click',function(){$('.rightContentField')
		.load('modifyPassword.html')
})

//推出登录
$('#logout')
	.unbind().bind('click',function(){
		T.post('/s/getSession/outBackUser','',function(res){
			console.log(res);
			if(res.retCode=='10000'){
				location.href="../../../login.html";
			}
		})
})

})

