/*
 *	createTime:2016/10/13 
 * 	author	  :tangj
 * 	
 * 
 */
$(function() {
/* userName userDepartment 没有填写值为null
 * page:查询的起始页数 从1开始
 * pageSize:每页显示的条数
 */

var data = {
	userAlias : 'null',
	total:0,
	page : 1,
	pageSize :10},
	getUserUrl = '/s/user/selectAllBackUser';

var app= new Object();
	app={
		init:function(){
			this.editData(); // 初始化修改
			this.delData(); // 初始化删除
			//this.initDepartment(); // 初始化部门
			this.initAllUsers(); // 初始化用户数据
			
		},
		initAllUsers:function(){
			T.post(getUserUrl,data,function(res){//初始化页面数据
				if(res.retCode=="10000"){//请求成功判断
						console.log(res);
						var obj=res.retObject;
						$('#tableData tbody').remove();//先移除内容 防止重复添加
			        	$('#user_manage_template').tmpl(obj.list).appendTo('#tableData');// jquery模板
			        	
						   /* '#pagination1' jquery元素选择
							*  totalrecords 总条数
							*  recordsperpage 每页显示条数 
							*/
						      $('#paginator').smartpaginator({
									totalrecords : obj.total,
									recordsperpage : data.pageSize,
									onchange : function(newPage) {
										
										var currData = data;
										currData.page = newPage;// 修改起始页码 更新数据
										T.post(getUserUrl, currData, function(res) {
											console.log(res);
											var _obj = res.retObject;
											$('#tableData tbody').remove();
											$('#user_manage_template').tmpl(_obj.list).appendTo('#tableData');
										});
									}
								});
				}else{//请求失败
					//.....doSomething
				}
			})
		},
		queryData:function(){
			var postData = data;
				postData.userAlias = $('#userName').val();
				
			T.post(getUserUrl, postData, function(res) {
				if (res.retCode == "10000") {

					var obj = res.retObject;
						$('#tableData tbody').remove();// 先移除内容 防止重复添加
						$('#user_manage_template').tmpl(obj.list).appendTo('#tableData');// 挂载DOM
						
						 $('#paginator').smartpaginator({
								totalrecords : obj.total,
								recordsperpage : data.pageSize,
								onchange : function(newPage) {

									var currData = data;
									currData.page = newPage;// 修改起始页码 更新数据
									T.post(getUserUrl, currData, function(res) {
										
										var _obj = res.retObject;
										$('#tableData tbody').remove();
										$('#user_manage_template').tmpl(_obj.list).appendTo('#tableData');
									});
								}
							});
				} else {}
			})
		},
		delData:function(){
			$(document).off('click','.del').on('click','.del',function(){
				var _data={
						userId:$(this).parent().attr('data-value')
				};
				console.log(_data);
				T.post('/s/user/deleteBackUser',_data,function(res){
					
					if(res.retCode=="10000"){
						app.initAllUsers();
					}else{
						
					}
				});
			})
		},
		editData:function(){
			$(document).off('click','.update').on('click','.update',function(){
				var userId=$(this).parent().attr('data-value');
				sessionStorage.setItem("userId", userId);
				$('.rightContentField').load('userManageModify.html')
			})
		}
		
}

app.init();// 初始化页面数据

$('#query').unbind().bind('click',function() {app.queryData()}) // 条件查询数据			



$('.addNewUserWord')
	.unbind().bind('click',function(){
		$('.rightContentField').load('userManageAddUser.html')
})
	
})