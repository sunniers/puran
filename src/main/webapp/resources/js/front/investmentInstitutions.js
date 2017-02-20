/*
 *	createTime:2016/11/3
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var data = {
			investCompanyName : 'null',
			investPreferenceValue : 'null',
			total:0,
			page : 1,
			pageSize :4}
	var app = {
			init:function(){
				this.initData();//初始化页面
				this.initPreference();//初始化投资偏好
				this.queryData();//查询
				this.lookAt();//查看
			},
			initData:function(){
				T.post('/s/invest/findALL',{"page":1,"pageSize":4},function(res){					
					if(res.retCode=='10000'){
						console.log(res);
						var obj=res.retObject;
						$('#tableData tbody').remove();//先移除内容 防止重复添加
			        	$('#investment_institutions_template').tmpl(obj.list).appendTo('#tableData');// jquery模板
			        	
			        	/* 
						*  totalrecords 总条数
						*  recordsperpage 每页显示条数 
						*/
					      $('#paginator').smartpaginator({
								totalrecords : obj.total,
								recordsperpage : data.pageSize,
								onchange : function(newPage) {
		
									currpage = newPage;// 修改起始页码 更新数据
									T.post('/s/invest/findALL', {"page":currpage,"pageSize":data.pageSize}, function(res) {
										console.log(res);
										var _obj = res.retObject;
										$('#tableData tbody').remove();
										$('#investment_institutions_template').tmpl(_obj.list).appendTo('#tableData');
									});
								}
							});

					}
				})
			},
			initPreference:function(){
				T.get('/s/invest/preference','',function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var html='<option value="">请选择</option>';
                		for(var i=0;i<res.retObject.length;i++){
                			html+='<option value="'+res.retObject[i].investPreferenceValue+'">'+res.retObject[i].preferenceValue+'</option>';
                		}
                	$('#preference').append(html);
					}
				})
			},
			queryData:function(){
				$('#query').unbind().bind('click',function() {
					
					var postData = data;
					postData.investCompanyName = $('#organizationName').val();
					console.log($('#organizationName').val());
					postData.investPreferenceValue = $('#preference option:selected').val();
					
					T.post('/s/invest/findALL',postData,function(res){
						console.log(res);
						if(res.retCode=='10000'){
							var obj=res.retObject;
							$('#tableData tbody').remove();//先移除内容 防止重复添加
				        	$('#investment_institutions_template').tmpl(obj.list).appendTo('#tableData');
				        	
				        	$('#paginator').smartpaginator({
								totalrecords : obj.total,
								recordsperpage : data.pageSize,
								onchange : function(newPage) {
									
									var currData = data;
									currData.page = newPage;// 修改起始页码 更新数据
									T.post('/s/invest/findALL', currData, function(res) {
										console.log(res);
										var _obj = res.retObject;
										$('#tableData tbody').remove();
										$('#investment_institutions_template').tmpl(_obj.list).appendTo('#tableData');
									});
								}
							});
						}
					})
				}) 
			},
			lookAt:function(){
				$(document).off('click','tbody button').on('click','tbody button',function(){
					var investCompanyId=$(this).attr('data-id');
					sessionStorage.setItem('investCompanyId',investCompanyId);
					$('.rightContentField').load('resources/html/front/agencyDetails.html');
				})
			}
	}
	app.init();
})
