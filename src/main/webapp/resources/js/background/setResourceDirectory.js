/*
 *	createTime:2016/10/24 
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var total=0,
		startPage=1,
		size=10;
	var app={
			init:function(){
				this.initData();
				this.add();
				this.del();
				this.edit();
			},
			initData:function(){
				var url='/s/sys/selectAllSysResource',
					data={
							'resourceType':$('#resType :checked').val(),
							'resourceName'  :$('#parentRes').val(),
							'parentName'	 :$('#childRes').val(),
							'page'		  :startPage,
							'pageSize'    :size
						};
				T.post(url,	data,function(res){
					console.log(res);
					if(res.retCode=='10000'){
						$("#resData tbody").remove();
						$("#resources_directory_template")
							.tmpl(res.retObject.list)
								.appendTo('#resData');
								total=res.retObject.total;
								app.page();
								app.bindClick();
					}else{
						
					}
				})
			},
			postData:function(url,data){
				T.post(url,	data,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								$("#resData tbody").remove();
								$("#resources_directory_template")
									.tmpl(res.retObject.list)
										.appendTo('#resData');
										total=res.retObject.total;
							}else{
								
							}
				})
			},
			page:function(){
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
					var	data={
								'resourceType':$('#resType :checked').val(),
								'resourceName'  :$('#parentRes').val(),
								'parentName'	  :$('#childRes').val(),
								'page'		  :newPage,
								'pageSize'    :size
						},
						url='/s/sys/selectAllSysResource';
						app.postData(url,data);
					}
				});
			},
			search:function(){
				var url='/s/sys/selectAllSysResource',
					_obj={
						'resourceType':$('#resType :checked').val(),
						'resourceName'  :$('#parentRes').val(),
						'parentName'	  :$('#childRes').val(),
						'page'		  :startPage,
						'pageSize' 	  :size
				};
				T.post(url,	_obj,function(res){
					console.log(res);
					if(res.retCode=='10000'){
						$("#resData tbody").remove();
						$("#resources_directory_template")
							.tmpl(res.retObject.list)
								.appendTo('#resData');
								total=res.retObject.total;
								app.page();
					}else{
						
					}
		})
				
			},
			edit:function(){
				$(document).off('click','.edit').on('click','.edit',function(){
					var resourceId=$(this).parent().attr('data-id');
					sessionStorage.setItem("resourceId", resourceId);
					$('.rightContentField').load('modifyResourceDirectory.html');
				});
				
			},
			del:function(){
				$(document).off('click','.del').on('click','.del',function(){
					var delItem=$(this).parent().attr('data-id');
					console.log('正在删除.......');
					T.post('/s/sys/deleteSysResource',{'resourceId':delItem},function(res){
						console.log(res);
						if(res.retCode='10000'){
							app.initData();
						}
					});
				})
			},
			bindClick:function(){
				$('.query').unbind().bind('click',function(){
					app.search();
				});
				
			},
			add:function(){
				$('#addRes').unbind().bind('click',function(){
					console.log('ok');
					$('.rightContentField').load('addResourceDirectory.html');
				});
			}
			
	}
	app.init();
})