/*
 *	createTime:2016/10/24
 * 	author	  :tj
 */
$(function(){
	var total=0,
		startPage=1,
		size=10,
		roleName=null;
	var app={
			init:function(){
				this.initData();
				this.searchByName();
				this.add();
				this.edit();
				this.del();
			},
			initData:function(){
				T.post('/s/role/selectBackRole',
						{'roleName':roleName,'page':startPage,'pageSize':size},
						function(res){
						if(res.retCode=='10000'){
							console.log(res);
							total=res.retObject.total;
							app.page(roleName);
							$('#tableData tbody').remove();
							$('#character_manage_template').tmpl(res.retObject.list).appendTo('#tableData');
						}else{
							
						}
				});
			},
			searchByName:function(){
				$('#query').unbind().bind('click',function(){
					roleName=$('#roleName').val();
					app.initData();
				});
			},
			page:function(){
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
						console.log(roleName);
						T.post('/s/role/selectBackRole',
								{'roleName':roleName,'page':newPage,'pageSize':size},
								function(res){
									if(res.retCode=='10000'){
										$('#tableData tbody').remove();
										$('#character_manage_template').tmpl(res.retObject.list).appendTo('#tableData');
									}else{
										
									}
						});
					}
				});
			},
			add:function(){
				$('.addNewRoleLeft').unbind().bind('click',function(){
					$('.rightContentField')
					.load('characterManageAdd.html')
				});
			},
			edit:function(){
				$(document).off('click','.edit').on('click','.edit',function(){
					var roleId=$(this).parent().attr('data-id');
					sessionStorage.setItem("roleId", roleId);
					$('.rightContentField').load('characterManageUpdate.html')
				});
			},
			del:function(){
				$(document).off('click','.del').on('click','.del',function(){
					T.post('/s/role/deleteBackRole',
							{'roleId':$(this).parent().attr('data-id')},function(res){
								if(res.retCode=="10000"){
									app.initData();
								}
								
					});
				});
			}
			
	}
	app.init();
})